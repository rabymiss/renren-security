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

import io.renren.modules.sys.entity.JobMessageAllEntity;
import io.renren.modules.sys.service.JobMessageAllService;
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
@RequestMapping("sys/jobmessageall")
public class JobMessageAllController {
    @Autowired
    private JobMessageAllService jobMessageAllService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:jobmessageall:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jobMessageAllService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:jobmessageall:info")
    public R info(@PathVariable("id") Integer id){
        JobMessageAllEntity jobMessageAll = jobMessageAllService.getById(id);

        return R.ok().put("jobMessageAll", jobMessageAll);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:jobmessageall:save")
    public R save(@RequestBody JobMessageAllEntity jobMessageAll){
        jobMessageAllService.save(jobMessageAll);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:jobmessageall:update")
    public R update(@RequestBody JobMessageAllEntity jobMessageAll){
        ValidatorUtils.validateEntity(jobMessageAll);
        jobMessageAllService.updateById(jobMessageAll);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:jobmessageall:delete")
    public R delete(@RequestBody Integer[] ids){
        jobMessageAllService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
