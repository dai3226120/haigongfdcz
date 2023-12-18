package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppQsdwEntity;
import com.pig4cloud.pig.admin.service.AppQsdwService;
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
 * 权属单位
 *
 * @author dw
 * @date 2023-12-12 16:48:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appQsdw" )
@Tag(description = "appQsdw" , name = "权属单位管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@CrossOrigin(origins = "*")
public class AppQsdwController {

    private final  AppQsdwService appQsdwService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appQsdw 权属单位
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_view')" )
    public R getAppQsdwPage(@ParameterObject Page page, @ParameterObject AppQsdwEntity appQsdw) {
        LambdaQueryWrapper<AppQsdwEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appQsdwService.page(page, wrapper));
    }


    /**
     * 通过id查询权属单位
     * @param qsdwId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{qsdwId}" )
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_view')" )
    public R getById(@PathVariable("qsdwId" ) Integer qsdwId) {
        return R.ok(appQsdwService.getById(qsdwId));
    }

    /**
     * 新增权属单位
     * @param appQsdw 权属单位
     * @return R
     */
    @Operation(summary = "新增权属单位" , description = "新增权属单位" )
    @SysLog("新增权属单位" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_add')" )
    public R save(@RequestBody AppQsdwEntity appQsdw) {
        return R.ok(appQsdwService.save(appQsdw));
    }

    /**
     * 修改权属单位
     * @param appQsdw 权属单位
     * @return R
     */
    @Operation(summary = "修改权属单位" , description = "修改权属单位" )
    @SysLog("修改权属单位" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_edit')" )
    public R updateById(@RequestBody AppQsdwEntity appQsdw) {
        return R.ok(appQsdwService.updateById(appQsdw));
    }

    /**
     * 通过id删除权属单位
     * @param ids qsdwId列表
     * @return R
     */
    @Operation(summary = "通过id删除权属单位" , description = "通过id删除权属单位" )
    @SysLog("通过id删除权属单位" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appQsdwService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appQsdw 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appQsdw_export')" )
    public List<AppQsdwEntity> export(AppQsdwEntity appQsdw,Integer[] ids) {
        return appQsdwService.list(Wrappers.lambdaQuery(appQsdw).in(ArrayUtil.isNotEmpty(ids), AppQsdwEntity::getQsdwId, ids));
    }
}