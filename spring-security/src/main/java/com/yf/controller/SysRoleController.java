package com.yf.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yf.annotation.SysLog;
import com.yf.entity.SysRole;
import com.yf.service.SysRoleService;
import com.yf.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (SysRole)表控制层
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@RestController
@Api(tags="管理")
@RequestMapping("/sysRole")
public class SysRoleController {
    
    @Resource
    private SysRoleService sysRoleService;

    
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R selectAll(Page<SysRole> page, SysRole sysRole) {
        return R.ok(sysRoleService.page(page, new QueryWrapper<>(sysRole)));
    }

    
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}")
    public R selectOne(@PathVariable String id) {
        return R.ok(sysRoleService.getById(id));
    }

   
    @PostMapping
    @SysLog("新增${tableInfo.comment}" )
    @ApiOperation(value = "新增${tableInfo.comment}", notes = "新增${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysRole_add')" )
    public R insert(@RequestBody @Validated SysRole sysRole) {
        sysRoleService.save(sysRole);
        return R.ok();
    }

   
    @PutMapping
    @SysLog("修改${tableInfo.comment}" )
    @ApiOperation(value = "修改${tableInfo.comment}", notes = "修改${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysRole_edit')" )
    public R update(@RequestBody @Validated SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return R.ok();
    }

    
    @DeleteMapping("{id}")
    @SysLog("通过id删除${tableInfo.comment}" )
    @ApiOperation(value = "通过ID删除${tableInfo.comment}", notes = "通过ID删除${tableInfo.comment}")
    @PreAuthorize("@pms.hasPermission('spring-security_SysRole_del')" )
    public R delete(@PathVariable String id) {
        sysRoleService.removeById(id);
        return R.ok();
    }
}
