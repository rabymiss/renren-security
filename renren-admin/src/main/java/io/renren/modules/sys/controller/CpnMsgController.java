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

import io.renren.modules.sys.entity.CpnMsgEntity;
import io.renren.modules.sys.service.CpnMsgService;
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
@RequestMapping("sys/cpnmsg")
public class CpnMsgController {
    @Autowired
    private CpnMsgService cpnMsgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:cpnmsg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cpnMsgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:cpnmsg:info")
    public R info(@PathVariable("id") Integer id){
        CpnMsgEntity cpnMsg = cpnMsgService.getById(id);

        return R.ok().put("cpnMsg", cpnMsg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:cpnmsg:save")
    public R save(@RequestBody CpnMsgEntity cpnMsg){
        cpnMsgService.save(cpnMsg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:cpnmsg:update")
    public R update(@RequestBody CpnMsgEntity cpnMsg){
        ValidatorUtils.validateEntity(cpnMsg);
        cpnMsgService.updateById(cpnMsg);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:cpnmsg:delete")
    public R delete(@RequestBody Integer[] ids){
        cpnMsgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
