package com.pig4cloud.pig.admin.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.service.AppSuiteService;
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
 * 房屋管理
 *
 * @author dw
 * @date 2023-12-13 10:13:09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appSuite" )
@Tag(description = "appSuite" , name = "房屋管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
@CrossOrigin(origins = "*")
public class AppSuiteController {

    private final  AppSuiteService appSuiteService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appSuite 房屋管理
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_appSuite_view')" )
    public R getAppSuitePage(@ParameterObject Page page, @ParameterObject AppSuiteEntity appSuite) {
        LambdaQueryWrapper<AppSuiteEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(appSuiteService.page(page, wrapper));
    }


    /**
     * 通过id查询房屋
     * @param suiteId id
     * @return R
     */
    @Operation(summary = "通过id查询" , description = "通过id查询" )
    @GetMapping("/{suiteId}" )
    @PreAuthorize("@pms.hasPermission('admin_appSuite_view')" )
    public R getById(@PathVariable("suiteId" ) Long suiteId) {
        return R.ok(appSuiteService.getById(suiteId));
    }

    /**
     * 新增房屋
     * @param appSuite 房屋管理
     * @return R
     */
    @Operation(summary = "新增房屋" , description = "新增房屋" )
    @SysLog("新增房屋" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_appSuite_add')" )
    public R save(@RequestBody AppSuiteEntity appSuite) {
        return R.ok(appSuiteService.save(appSuite));
    }

    /**
     * 修改房屋
     * @param appSuite 房屋管理
     * @return R
     */
    @Operation(summary = "修改房屋" , description = "修改房屋" )
    @SysLog("修改房屋" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_appSuite_edit')" )
    public R updateById(@RequestBody AppSuiteEntity appSuite) {
        return R.ok(appSuiteService.updateById(appSuite));
    }

    /**
     * 通过id删除房屋
     * @param ids suiteId列表
     * @return R
     */
    @Operation(summary = "通过id删除房屋" , description = "通过id删除房屋" )
    @SysLog("通过id删除房屋" )
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('admin_appSuite_del')" )
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(appSuiteService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param appSuite 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @PreAuthorize("@pms.hasPermission('admin_appSuite_export')" )
    public List<AppSuiteEntity> export(AppSuiteEntity appSuite,Long[] ids) {
        return appSuiteService.list(Wrappers.lambdaQuery(appSuite).in(ArrayUtil.isNotEmpty(ids), AppSuiteEntity::getSuiteId, ids));
    }

	/**
	 * 分页查询建筑-房屋信息
	 * @param page 参数集
	 * @param suiteVO 查询参数列表
	 * @return 建筑信息集合
	 */

	@Operation(summary = "分页查询建筑-房屋信息" , description = "分页查询建筑-房屋信息" )
	@GetMapping("/vopage" )
	@PreAuthorize("@pms.hasPermission('admin_appSuite_view')" )
	public R getEstateVoPage(@ParameterObject Page page, @ParameterObject SuiteVO suiteVO) {
		return R.ok(appSuiteService.getSuitesAllPage(page, suiteVO));
	}

	/**
	 * 分页查询房屋-合同信息
	 * @param page 参数集
	 * @param suiteEntity 查询参数列表
	 * @return 建筑信息集合
	 */

	@Operation(summary = "分页查询房屋-合同信息" , description = "分页查询房屋-合同信息" )
	@GetMapping("/suiteconstractvopage" )
	@PreAuthorize("@pms.hasPermission('admin_appSuite_view')" )
	public R getSuiteContractVosPage(@ParameterObject Page page, @ParameterObject AppSuiteEntity suiteEntity) {
		return R.ok(appSuiteService.getSuiteContractAllPage(page, suiteEntity));
	}

}