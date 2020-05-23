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

import io.renren.modules.sys.entity.TUserEntity;
import io.renren.modules.sys.service.TUserService;
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
@RequestMapping("sys/tuser")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tuser:info")
    public R info(@PathVariable("id") Integer id){
        TUserEntity tUser = tUserService.getById(id);

        return R.ok().put("tUser", tUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tuser:save")
    public R save(@RequestBody TUserEntity tUser){
        tUserService.save(tUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tuser:update")
    public R update(@RequestBody TUserEntity tUser){
        ValidatorUtils.validateEntity(tUser);
        tUserService.updateById(tUser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tuser:delete")
    public R delete(@RequestBody Integer[] ids){
        tUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
