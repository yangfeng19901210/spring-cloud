package com.yf.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yf.annotation.SysLog;
import com.yf.entity.SysUserRole;
import com.yf.service.SysUserRoleService;
import com.yf.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (SysUserRole)表控制层
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@RestController
@Api(tags="管理")
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    
    @Resource
    private SysUserRoleService sysUserRoleService;

    
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R selectAll(Page<SysUserRole> page, SysUserRole sysUserRole) {
        return R.ok(sysUserRoleService.page(page, new QueryWrapper<>(sysUserRole)));
    }

    
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R selectOne(@PathVariable String id) {
        return R.ok(sysUserRoleService.getById(id));
    }

   
    @PostMapping
    @SysLog("新增${tableInfo.comment}" )
    @ApiOperation(value = "新增${tableInfo.comment}", notes = "新增${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysUserRole_add')" )
    public R insert(@RequestBody @Validated SysUserRole sysUserRole) {
        sysUserRoleService.save(sysUserRole);
        return R.ok();
    }

   
    @PutMapping
    @SysLog("修改${tableInfo.comment}" )
    @ApiOperation(value = "修改${tableInfo.comment}", notes = "修改${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysUserRole_edit')" )
    public R update(@RequestBody @Validated SysUserRole sysUserRole) {
        sysUserRoleService.updateById(sysUserRole);
        return R.ok();
    }

    
    @DeleteMapping("{id}")
    @SysLog("通过id删除${tableInfo.comment}" )
    @ApiOperation(value = "通过ID删除${tableInfo.comment}", notes = "通过ID删除${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysUserRole_del')" )
    public R delete(@PathVariable String id) {
        sysUserRoleService.removeById(id);
        return R.ok();
    }
}
