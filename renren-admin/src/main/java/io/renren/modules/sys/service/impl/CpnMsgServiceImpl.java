package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.CpnMsgDao;
import io.renren.modules.sys.entity.CpnMsgEntity;
import io.renren.modules.sys.service.CpnMsgService;


@Service("cpnMsgService")
public class CpnMsgServiceImpl extends ServiceImpl<CpnMsgDao, CpnMsgEntity> implements CpnMsgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CpnMsgEntity> page = this.page(
                new Query<CpnMsgEntity>().getPage(params),
                new QueryWrapper<CpnMsgEntity>()
        );

        return new PageUtils(page);
    }

}
