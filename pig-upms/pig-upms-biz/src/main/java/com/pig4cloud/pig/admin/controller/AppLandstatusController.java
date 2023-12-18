package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppLandstatusEntity;
import com.pig4cloud.pig.admin.service.AppLandstatusService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 土地性质
 *
 * @author dw
 * @date 2023-12-12 15:00:34
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appLandstatus" )
@Tag(description = "appLandstatus" , name = "土地性质管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@CrossOrigin(origins = "*")
public class AppLandstatusController {

    private final  AppLandstatusService appLandstatusService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appLandstatus 土地性质
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_view')" )
    public R getAppLandstatusPage(@ParameterObject Page page, @ParameterObject AppLandstatusEntity appLandstatus) {
        LambdaQueryWrapper<AppLandstatusEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appLandstatusService.page(page, wrapper));
    }


    /**
     * 通过id查询土地性质
     * @param landstatusId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{landstatusId}" )
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_view')" )
    public R getById(@PathVariable("landstatusId" ) Integer landstatusId) {
        return R.ok(appLandstatusService.getById(landstatusId));
    }

    /**
     * 新增土地性质
     * @param appLandstatus 土地性质
     * @return R
     */
    @Operation(summary = "新增土地性质" , description = "新增土地性质" )
    @SysLog("新增土地性质" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_add')" )
    public R save(@RequestBody AppLandstatusEntity appLandstatus) {
        return R.ok(appLandstatusService.save(appLandstatus));
    }

    /**
     * 修改土地性质
     * @param appLandstatus 土地性质
     * @return R
     */
    @Operation(summary = "修改土地性质" , description = "修改土地性质" )
    @SysLog("修改土地性质" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_edit')" )
    public R updateById(@RequestBody AppLandstatusEntity appLandstatus) {
        return R.ok(appLandstatusService.updateById(appLandstatus));
    }

    /**
     * 通过id删除土地性质
     * @param ids landstatusId列表
     * @return R
     */
    @Operation(summary = "通过id删除土地性质" , description = "通过id删除土地性质" )
    @SysLog("通过id删除土地性质" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appLandstatusService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appLandstatus 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appLandstatus_export')" )
    public List<AppLandstatusEntity> export(AppLandstatusEntity appLandstatus,Integer[] ids) {
        return appLandstatusService.list(Wrappers.lambdaQuery(appLandstatus).in(ArrayUtil.isNotEmpty(ids), AppLandstatusEntity::getLandstatusId, ids));
    }
}