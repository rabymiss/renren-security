package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.MessageuserDao;
import io.renren.modules.sys.entity.MessageuserEntity;
import io.renren.modules.sys.service.MessageuserService;


@Service("messageuserService")
public class MessageuserServiceImpl extends ServiceImpl<MessageuserDao, MessageuserEntity> implements MessageuserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MessageuserEntity> page = this.page(
                new Query<MessageuserEntity>().getPage(params),
                new QueryWrapper<MessageuserEntity>()
        );

        return new PageUtils(page);
    }

}
