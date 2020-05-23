package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.PersonresumeDao;
import io.renren.modules.sys.entity.PersonresumeEntity;
import io.renren.modules.sys.service.PersonresumeService;


@Service("personresumeService")
public class PersonresumeServiceImpl extends ServiceImpl<PersonresumeDao, PersonresumeEntity> implements PersonresumeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PersonresumeEntity> page = this.page(
                new Query<PersonresumeEntity>().getPage(params),
                new QueryWrapper<PersonresumeEntity>()
        );

        return new PageUtils(page);
    }

}
