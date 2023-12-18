package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.service.AppContractService;
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
 * 合同管理
 *
 * @author dw
 * @date 2023-12-13 10:22:43
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appContract" )
@Tag(description = "appContract" , name = "合同管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@CrossOrigin(origins = "*")
public class AppContractController {

    private final  AppContractService appContractService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appContract 合同管理
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appContract_view')" )
    public R getAppContractPage(@ParameterObject Page page, @ParameterObject AppContractEntity appContract) {
        LambdaQueryWrapper<AppContractEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appContractService.page(page, wrapper));
    }


    /**
     * 通过id查询合同管理
     * @param contractId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{contractId}" )
    @PreAuthorize("@pms.hasPermission('admin_appContract_view')" )
    public R getById(@PathVariable("contractId" ) Integer contractId) {
        return R.ok(appContractService.getById(contractId));
    }

    /**
     * 新增合同
     * @param appContract 合同管理
     * @return R
     */
    @Operation(summary = "新增合同" , description = "新增合同" )
    @SysLog("新增合同" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appContract_add')" )
    public R save(@RequestBody AppContractEntity appContract) {
        return R.ok(appContractService.save(appContract));
    }

    /**
     * 修改合同
     * @param appContract 合同管理
     * @return R
     */
    @Operation(summary = "修改合同" , description = "修改合同" )
    @SysLog("修改合同" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appContract_edit')" )
    public R updateById(@RequestBody AppContractEntity appContract) {
        return R.ok(appContractService.updateById(appContract));
    }

    /**
     * 通过id删除合同
     * @param ids contractId列表
     * @return R
     */
    @Operation(summary = "通过id删除合同" , description = "通过id删除合同" )
    @SysLog("通过id删除合同" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appContract_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appContractService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appContract 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appContract_export')" )
    public List<AppContractEntity> export(AppContractEntity appContract,Integer[] ids) {
        return appContractService.list(Wrappers.lambdaQuery(appContract).in(ArrayUtil.isNotEmpty(ids), AppContractEntity::getContractId, ids));
    }
}