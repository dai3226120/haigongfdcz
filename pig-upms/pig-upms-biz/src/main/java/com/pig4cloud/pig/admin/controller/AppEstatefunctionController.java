package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppEstatefunctionEntity;
import com.pig4cloud.pig.admin.service.AppEstatefunctionService;
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
 * 建筑使用性质
 *
 * @author dw
 * @date 2023-12-12 16:33:09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appEstatefunction" )
@Tag(description = "appEstatefunction" , name = "建筑使用性质管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppEstatefunctionController {

    private final  AppEstatefunctionService appEstatefunctionService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appEstatefunction 建筑使用性质
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_view')" )
    public R getAppEstatefunctionPage(@ParameterObject Page page, @ParameterObject AppEstatefunctionEntity appEstatefunction) {
        LambdaQueryWrapper<AppEstatefunctionEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appEstatefunctionService.page(page, wrapper));
    }


    /**
     * 通过id查询建筑使用性质
     * @param estatefunctionId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{estatefunctionId}" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_view')" )
    public R getById(@PathVariable("estatefunctionId" ) Integer estatefunctionId) {
        return R.ok(appEstatefunctionService.getById(estatefunctionId));
    }

    /**
     * 新增建筑使用性质
     * @param appEstatefunction 建筑使用性质
     * @return R
     */
    @Operation(summary = "新增建筑使用性质" , description = "新增建筑使用性质" )
    @SysLog("新增建筑使用性质" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_add')" )
    public R save(@RequestBody AppEstatefunctionEntity appEstatefunction) {
        return R.ok(appEstatefunctionService.save(appEstatefunction));
    }

    /**
     * 修改建筑使用性质
     * @param appEstatefunction 建筑使用性质
     * @return R
     */
    @Operation(summary = "修改建筑使用性质" , description = "修改建筑使用性质" )
    @SysLog("修改建筑使用性质" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_edit')" )
    public R updateById(@RequestBody AppEstatefunctionEntity appEstatefunction) {
        return R.ok(appEstatefunctionService.updateById(appEstatefunction));
    }

    /**
     * 通过id删除建筑使用性质
     * @param ids estatefunctionId列表
     * @return R
     */
    @Operation(summary = "通过id删除建筑使用性质" , description = "通过id删除建筑使用性质" )
    @SysLog("通过id删除建筑使用性质" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appEstatefunctionService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appEstatefunction 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appEstatefunction_export')" )
    public List<AppEstatefunctionEntity> export(AppEstatefunctionEntity appEstatefunction,Integer[] ids) {
        return appEstatefunctionService.list(Wrappers.lambdaQuery(appEstatefunction).in(ArrayUtil.isNotEmpty(ids), AppEstatefunctionEntity::getEstatefunctionId, ids));
    }
}