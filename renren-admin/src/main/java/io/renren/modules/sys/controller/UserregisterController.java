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

import io.renren.modules.sys.entity.UserregisterEntity;
import io.renren.modules.sys.service.UserregisterService;
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
@RequestMapping("sys/userregister")
public class UserregisterController {
    @Autowired
    private UserregisterService userregisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:userregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:userregister:info")
    public R info(@PathVariable("id") Integer id){
        UserregisterEntity userregister = userregisterService.getById(id);

        return R.ok().put("userregister", userregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:userregister:save")
    public R save(@RequestBody UserregisterEntity userregister){
        userregisterService.save(userregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:userregister:update")
    public R update(@RequestBody UserregisterEntity userregister){
        ValidatorUtils.validateEntity(userregister);
        userregisterService.updateById(userregister);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:userregister:delete")
    public R delete(@RequestBody Integer[] ids){
        userregisterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
