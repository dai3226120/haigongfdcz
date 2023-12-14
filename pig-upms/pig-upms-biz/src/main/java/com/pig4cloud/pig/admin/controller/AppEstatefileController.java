package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.EstateFileDTO;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.service.AppEstatefileService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * 资产文件
 *
 * @author dw
 * @date 2023-12-14 16:33:03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appEstatefile" )
@Tag(description = "appEstatefile" , name = "资产文件管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppEstatefileController {

    private final  AppEstatefileService appEstatefileService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appEstatefile 资产文件
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_view')" )
    public R getAppEstatefilePage(@ParameterObject Page page, @ParameterObject AppEstatefileEntity appEstatefile) {
        LambdaQueryWrapper<AppEstatefileEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appEstatefileService.page(page, wrapper));
    }


    /**
     * 通过id查询资产文件
     * @param estatefileId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{estatefileId}" )
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_view')" )
    public R getById(@PathVariable("estatefileId" ) Long estatefileId) {
        return R.ok(appEstatefileService.getById(estatefileId));
    }

    /**
     * 新增资产文件
     * @param appEstatefile 资产文件
     * @return R
     */
    @Operation(summary = "新增资产文件" , description = "新增资产文件" )
    @SysLog("新增资产文件" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_add')" )
    public R save(@RequestBody AppEstatefileEntity appEstatefile) {
        return R.ok(appEstatefileService.save(appEstatefile));
    }

    /**
     * 修改资产文件
     * @param appEstatefile 资产文件
     * @return R
     */
    @Operation(summary = "修改资产文件" , description = "修改资产文件" )
    @SysLog("修改资产文件" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_edit')" )
    public R updateById(@RequestBody AppEstatefileEntity appEstatefile) {
        return R.ok(appEstatefileService.updateById(appEstatefile));
    }

    /**
     * 通过id删除资产文件
     * @param ids estatefileId列表
     * @return R
     */
    @Operation(summary = "通过id删除资产文件" , description = "通过id删除资产文件" )
    @SysLog("通过id删除资产文件" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_del')" )
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(appEstatefileService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appEstatefile 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appEstatefile_export')" )
    public List<AppEstatefileEntity> export(AppEstatefileEntity appEstatefile,Long[] ids) {
        return appEstatefileService.list(Wrappers.lambdaQuery(appEstatefile).in(ArrayUtil.isNotEmpty(ids), AppEstatefileEntity::getEstatefileId, ids));
    }

	/**
	 * 上传文件 文件名采用uuid,避免原始文件名中带"-"符号导致下载的时候解析出现异常
	 * @param file 资源
	 * @param estateFileDTO 关联资源
	 * @return R(/ admin / bucketName / filename)
	 */
	@PostMapping(value = "/upload")
	public R upload(@RequestPart("file") MultipartFile file, @ParameterObject EstateFileDTO estateFileDTO) {
		return appEstatefileService.uploadFile(file,estateFileDTO);
	}
}