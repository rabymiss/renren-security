package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.UserregisterDao;
import io.renren.modules.sys.entity.UserregisterEntity;
import io.renren.modules.sys.service.UserregisterService;


@Service("userregisterService")
public class UserregisterServiceImpl extends ServiceImpl<UserregisterDao, UserregisterEntity> implements UserregisterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserregisterEntity> page = this.page(
                new Query<UserregisterEntity>().getPage(params),
                new QueryWrapper<UserregisterEntity>()
        );

        return new PageUtils(page);
    }

}
