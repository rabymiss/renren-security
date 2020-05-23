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

import io.renren.modules.sys.entity.OfficesendEntity;
import io.renren.modules.sys.service.OfficesendService;
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
@RequestMapping("sys/officesend")
public class OfficesendController {
    @Autowired
    private OfficesendService officesendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:officesend:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = officesendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:officesend:info")
    public R info(@PathVariable("id") Integer id){
        OfficesendEntity officesend = officesendService.getById(id);

        return R.ok().put("officesend", officesend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:officesend:save")
    public R save(@RequestBody OfficesendEntity officesend){
        officesendService.save(officesend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:officesend:update")
    public R update(@RequestBody OfficesendEntity officesend){
        ValidatorUtils.validateEntity(officesend);
        officesendService.updateById(officesend);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:officesend:delete")
    public R delete(@RequestBody Integer[] ids){
        officesendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
