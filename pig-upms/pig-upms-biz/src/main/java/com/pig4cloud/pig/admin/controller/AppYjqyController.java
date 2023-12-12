package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppYjqyEntity;
import com.pig4cloud.pig.admin.service.AppYjqyService;
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
 * 一级企业
 *
 * @author dw
 * @date 2023-12-12 16:40:57
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appYjqy" )
@Tag(description = "appYjqy" , name = "一级企业管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppYjqyController {

    private final  AppYjqyService appYjqyService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appYjqy 一级企业
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_view')" )
    public R getAppYjqyPage(@ParameterObject Page page, @ParameterObject AppYjqyEntity appYjqy) {
        LambdaQueryWrapper<AppYjqyEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appYjqyService.page(page, wrapper));
    }


    /**
     * 通过id查询一级企业
     * @param yjqyId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{yjqyId}" )
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_view')" )
    public R getById(@PathVariable("yjqyId" ) Integer yjqyId) {
        return R.ok(appYjqyService.getById(yjqyId));
    }

    /**
     * 新增一级企业
     * @param appYjqy 一级企业
     * @return R
     */
    @Operation(summary = "新增一级企业" , description = "新增一级企业" )
    @SysLog("新增一级企业" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_add')" )
    public R save(@RequestBody AppYjqyEntity appYjqy) {
        return R.ok(appYjqyService.save(appYjqy));
    }

    /**
     * 修改一级企业
     * @param appYjqy 一级企业
     * @return R
     */
    @Operation(summary = "修改一级企业" , description = "修改一级企业" )
    @SysLog("修改一级企业" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_edit')" )
    public R updateById(@RequestBody AppYjqyEntity appYjqy) {
        return R.ok(appYjqyService.updateById(appYjqy));
    }

    /**
     * 通过id删除一级企业
     * @param ids yjqyId列表
     * @return R
     */
    @Operation(summary = "通过id删除一级企业" , description = "通过id删除一级企业" )
    @SysLog("通过id删除一级企业" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appYjqyService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appYjqy 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appYjqy_export')" )
    public List<AppYjqyEntity> export(AppYjqyEntity appYjqy,Integer[] ids) {
        return appYjqyService.list(Wrappers.lambdaQuery(appYjqy).in(ArrayUtil.isNotEmpty(ids), AppYjqyEntity::getYjqyId, ids));
    }
}