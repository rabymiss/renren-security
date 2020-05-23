package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.OfficesendDao;
import io.renren.modules.sys.entity.OfficesendEntity;
import io.renren.modules.sys.service.OfficesendService;


@Service("officesendService")
public class OfficesendServiceImpl extends ServiceImpl<OfficesendDao, OfficesendEntity> implements OfficesendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OfficesendEntity> page = this.page(
                new Query<OfficesendEntity>().getPage(params),
                new QueryWrapper<OfficesendEntity>()
        );

        return new PageUtils(page);
    }

}
