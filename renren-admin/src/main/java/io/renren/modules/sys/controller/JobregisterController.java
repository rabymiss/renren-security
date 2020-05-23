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

import io.renren.modules.sys.entity.JobregisterEntity;
import io.renren.modules.sys.service.JobregisterService;
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
@RequestMapping("sys/jobregister")
public class JobregisterController {
    @Autowired
    private JobregisterService jobregisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jobregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jobregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jobregister:info")
    public R info(@PathVariable("id") Integer id){
        JobregisterEntity jobregister = jobregisterService.getById(id);

        return R.ok().put("jobregister", jobregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jobregister:save")
    public R save(@RequestBody JobregisterEntity jobregister){
        jobregisterService.save(jobregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jobregister:update")
    public R update(@RequestBody JobregisterEntity jobregister){
        ValidatorUtils.validateEntity(jobregister);
        jobregisterService.updateById(jobregister);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jobregister:delete")
    public R delete(@RequestBody Integer[] ids){
        jobregisterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
