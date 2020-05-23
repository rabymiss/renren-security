package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.PersonresumeEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-23 20:32:35
 */
public interface PersonresumeService extends IService<PersonresumeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

