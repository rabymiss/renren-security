package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.UserMassageDao;
import io.renren.modules.sys.entity.UserMassageEntity;
import io.renren.modules.sys.service.UserMassageService;


@Service("userMassageService")
public class UserMassageServiceImpl extends ServiceImpl<UserMassageDao, UserMassageEntity> implements UserMassageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserMassageEntity> page = this.page(
                new Query<UserMassageEntity>().getPage(params),
                new QueryWrapper<UserMassageEntity>()
        );

        return new PageUtils(page);
    }

}
