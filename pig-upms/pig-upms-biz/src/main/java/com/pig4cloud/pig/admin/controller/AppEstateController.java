package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.service.AppEstateService;
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

/**
 * 建筑管理
 *
 * @author dw
 * @date 2023-12-11 18:32:52
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appEstate" )
@Tag(description = "appEstate" , name = "建筑管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@CrossOrigin(origins = "*")
public class AppEstateController {

    private final  AppEstateService appEstateService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appEstate 建筑管理
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('pig_appEstate_view')" )
    public R getAppEstatePage(@ParameterObject Page page, @ParameterObject AppEstateEntity appEstate) {
        LambdaQueryWrapper<AppEstateEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appEstateService.page(page, wrapper));
    }


    /**
     * 通过id查询建筑管理
     * @param estateId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{estateId}" )
    @PreAuthorize("@pms.hasPermission('pig_appEstate_view')" )
    public R getById(@PathVariable("estateId" ) Integer estateId) {
        return R.ok(appEstateService.getById(estateId));
    }

    /**
     * 新增建筑管理
     * @param appEstate 建筑管理
     * @return R
     */
    @Operation(summary = "新增建筑管理" , description = "新增建筑管理" )
    @SysLog("新增建筑管理" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('pig_appEstate_add')" )
    public R save(@RequestBody AppEstateEntity appEstate) {
        return R.ok(appEstateService.save(appEstate));
    }

    /**
     * 修改建筑管理
     * @param appEstate 建筑管理
     * @return R
     */
    @Operation(summary = "修改建筑管理" , description = "修改建筑管理" )
    @SysLog("修改建筑管理" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('pig_appEstate_edit')" )
    public R updateById(@RequestBody AppEstateEntity appEstate) {
        return R.ok(appEstateService.updateById(appEstate));
    }

    /**
     * 通过id删除建筑管理
     * @param ids estateId列表
     * @return R
     */
    @Operation(summary = "通过id删除建筑管理" , description = "通过id删除建筑管理" )
    @SysLog("通过id删除建筑管理" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('pig_appEstate_del')" )
    public R removeById(@RequestBody Integer[] ids) {
        return R.ok(appEstateService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appEstate 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('pig_appEstate_export')" )
    public List<AppEstateEntity> export(AppEstateEntity appEstate,Integer[] ids) {
        return appEstateService.list(Wrappers.lambdaQuery(appEstate).in(ArrayUtil.isNotEmpty(ids), AppEstateEntity::getEstateId, ids));
    }

	/**
	 * 分页查询建筑信息
	 * @param page 参数集
	 * @param estateDTO 查询参数列表
	 * @return 建筑信息集合
	 */

	@Operation(summary = "分页查询建筑信息" , description = "分页查询建筑信息" )
	@GetMapping("/vopage" )
	@PreAuthorize("@pms.hasPermission('pig_appEstate_view')" )
	public R getEstateVoPage(@ParameterObject Page page, @ParameterObject EstateDTO estateDTO) {
		return R.ok(appEstateService.getEstatesAllPage(page, estateDTO));
	}

	/**
	 * 分页查询建筑-房屋信息
	 * @param page 参数集
	 * @param estateDTO 查询参数列表
	 * @return 用户集合
	 */
	@Operation(summary = "分页查询建筑-房屋信息" , description = "分页查询建筑-房屋信息" )
	@GetMapping("/estatesuitevopage")
	@PreAuthorize("@pms.hasPermission('pig_appEstate_view')" )
	public R getUserPage(@ParameterObject Page page, @ParameterObject EstateDTO estateDTO) {
		return R.ok(appEstateService.getEstateSuiteAllPage(page, estateDTO));
	}
}