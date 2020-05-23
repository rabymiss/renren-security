package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.JobregisterDao;
import io.renren.modules.sys.entity.JobregisterEntity;
import io.renren.modules.sys.service.JobregisterService;


@Service("jobregisterService")
public class JobregisterServiceImpl extends ServiceImpl<JobregisterDao, JobregisterEntity> implements JobregisterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JobregisterEntity> page = this.page(
                new Query<JobregisterEntity>().getPage(params),
                new QueryWrapper<JobregisterEntity>()
        );

        return new PageUtils(page);
    }

}
