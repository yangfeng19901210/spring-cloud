package com.yf.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yf.annotation.SysLog;
import com.yf.entity.SysPermission;
import com.yf.service.SysPermissionService;
import com.yf.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (SysPermission)表控制层
 *
 * @author makejava
 * @since 2022-06-09 14:17:45
 */
@RestController
@Api(tags="管理")
@RequestMapping("/sysPermission")
public class SysPermissionController {
    
    @Resource
    private SysPermissionService sysPermissionService;

    
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R selectAll(Page<SysPermission> page, SysPermission sysPermission) {
        return R.ok(sysPermissionService.page(page, new QueryWrapper<>(sysPermission)));
    }

    
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R selectOne(@PathVariable String id) {
        return R.ok(sysPermissionService.getById(id));
    }

   
    @PostMapping
    @SysLog("新增${tableInfo.comment}" )
    @ApiOperation(value = "新增${tableInfo.comment}", notes = "新增${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysPermission_add')" )
    public R insert(@RequestBody @Validated SysPermission sysPermission) {
        sysPermissionService.save(sysPermission);
        return R.ok();
    }

   
    @PutMapping
    @SysLog("修改${tableInfo.comment}" )
    @ApiOperation(value = "修改${tableInfo.comment}", notes = "修改${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysPermission_edit')" )
    public R update(@RequestBody @Validated SysPermission sysPermission) {
        sysPermissionService.updateById(sysPermission);
        return R.ok();
    }

    
    @DeleteMapping("{id}")
    @SysLog("通过id删除${tableInfo.comment}" )
    @ApiOperation(value = "通过ID删除${tableInfo.comment}", notes = "通过ID删除${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysPermission_del')" )
    public R delete(@PathVariable String id) {
        sysPermissionService.removeById(id);
        return R.ok();
    }
}
