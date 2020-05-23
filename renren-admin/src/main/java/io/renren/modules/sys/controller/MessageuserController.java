package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.MessageuserEntity;
import io.renren.modules.sys.service.MessageuserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-23 20:32:36
 */
@RestController
@RequestMapping("sys/messageuser")
public class MessageuserController {
    @Autowired
    private MessageuserService messageuserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:messageuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageuserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:messageuser:info")
    public R info(@PathVariable("id") Integer id){
        MessageuserEntity messageuser = messageuserService.getById(id);

        return R.ok().put("messageuser", messageuser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:messageuser:save")
    public R save(@RequestBody MessageuserEntity messageuser){
        messageuserService.save(messageuser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:messageuser:update")
    public R update(@RequestBody MessageuserEntity messageuser){
        ValidatorUtils.validateEntity(messageuser);
        messageuserService.updateById(messageuser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:messageuser:delete")
    public R delete(@RequestBody Integer[] ids){
        messageuserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
