package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MessageuserEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-23 20:32:36
 */
public interface MessageuserService extends IService<MessageuserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

