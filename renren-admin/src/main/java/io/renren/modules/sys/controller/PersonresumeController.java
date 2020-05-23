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

import io.renren.modules.sys.entity.PersonresumeEntity;
import io.renren.modules.sys.service.PersonresumeService;
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
@RequestMapping("sys/personresume")
public class PersonresumeController {
    @Autowired
    private PersonresumeService personresumeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:personresume:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = personresumeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:personresume:info")
    public R info(@PathVariable("id") Integer id){
        PersonresumeEntity personresume = personresumeService.getById(id);

        return R.ok().put("personresume", personresume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:personresume:save")
    public R save(@RequestBody PersonresumeEntity personresume){
        personresumeService.save(personresume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:personresume:update")
    public R update(@RequestBody PersonresumeEntity personresume){
        ValidatorUtils.validateEntity(personresume);
        personresumeService.updateById(personresume);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:personresume:delete")
    public R delete(@RequestBody Integer[] ids){
        personresumeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
