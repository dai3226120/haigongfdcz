package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppEstatetypeEntity;
import com.pig4cloud.pig.admin.service.AppEstatetypeService;
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
 * 房屋类型
 *
 * @author dw
 * @date 2023-12-12 16:27:35
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appEstatetype" )
@Tag(description = "appEstatetype" , name = "房屋类型管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppEstatetypeController {

    private final  AppEstatetypeService appEstatetypeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appEstatetype 房屋类型
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_view')" )
    public R getAppEstatetypePage(@ParameterObject Page page, @ParameterObject AppEstatetypeEntity appEstatetype) {
        LambdaQueryWrapper<AppEstatetypeEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appEstatetypeService.page(page, wrapper));
    }


    /**
     * 通过id查询房屋类型
     * @param estatetypeId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{estatetypeId}" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_view')" )
    public R getById(@PathVariable("estatetypeId" ) Integer estatetypeId) {
        return R.ok(appEstatetypeService.getById(estatetypeId));
    }

    /**
     * 新增房屋类型
     * @param appEstatetype 房屋类型
     * @return R
     */
    @Operation(summary = "新增房屋类型" , description = "新增房屋类型" )
    @SysLog("新增房屋类型" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_add')" )
    public R save(@RequestBody AppEstatetypeEntity appEstatetype) {
        return R.ok(appEstatetypeService.save(appEstatetype));
    }

    /**
     * 修改房屋类型
     * @param appEstatetype 房屋类型
     * @return R
     */
    @Operation(summary = "修改房屋类型" , description = "修改房屋类型" )
    @SysLog("修改房屋类型" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_edit')" )
    public R updateById(@RequestBody AppEstatetypeEntity appEstatetype) {
        return R.ok(appEstatetypeService.updateById(appEstatetype));
    }

    /**
     * 通过id删除房屋类型
     * @param ids estatetypeId列表
     * @return R
     */
    @Operation(summary = "通过id删除房屋类型" , description = "通过id删除房屋类型" )
    @SysLog("通过id删除房屋类型" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appEstatetypeService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appEstatetype 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appEstatetype_export')" )
    public List<AppEstatetypeEntity> export(AppEstatetypeEntity appEstatetype,Integer[] ids) {
        return appEstatetypeService.list(Wrappers.lambdaQuery(appEstatetype).in(ArrayUtil.isNotEmpty(ids), AppEstatetypeEntity::getEstatetypeId, ids));
    }
}