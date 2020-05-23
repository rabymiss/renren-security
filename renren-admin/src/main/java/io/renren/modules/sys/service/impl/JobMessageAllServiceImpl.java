package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.JobMessageAllDao;
import io.renren.modules.sys.entity.JobMessageAllEntity;
import io.renren.modules.sys.service.JobMessageAllService;


@Service("jobMessageAllService")
public class JobMessageAllServiceImpl extends ServiceImpl<JobMessageAllDao, JobMessageAllEntity> implements JobMessageAllService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JobMessageAllEntity> page = this.page(
                new Query<JobMessageAllEntity>().getPage(params),
                new QueryWrapper<JobMessageAllEntity>()
        );

        return new PageUtils(page);
    }

}
