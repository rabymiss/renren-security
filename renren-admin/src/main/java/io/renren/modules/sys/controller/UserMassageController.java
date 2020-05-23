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

import io.renren.modules.sys.entity.UserMassageEntity;
import io.renren.modules.sys.service.UserMassageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-23 20:32:35
 */
@RestController
@RequestMapping("sys/usermassage")
public class UserMassageController {
    @Autowired
    private UserMassageService userMassageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:usermassage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userMassageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:usermassage:info")
    public R info(@PathVariable("id") Integer id){
        UserMassageEntity userMassage = userMassageService.getById(id);

        return R.ok().put("userMassage", userMassage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:usermassage:save")
    public R save(@RequestBody UserMassageEntity userMassage){
        userMassageService.save(userMassage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:usermassage:update")
    public R update(@RequestBody UserMassageEntity userMassage){
        ValidatorUtils.validateEntity(userMassage);
        userMassageService.updateById(userMassage);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:usermassage:delete")
    public R delete(@RequestBody Integer[] ids){
        userMassageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
