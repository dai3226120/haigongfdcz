/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.pig4cloud.pig.admin.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.entity.AppDistrict;
import com.pig4cloud.pig.admin.api.entity.SysDept;
import com.pig4cloud.pig.admin.api.vo.DeptExcelVo;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p>
 * 地区 服务类
 * </p>
 *
 * @author dw
 * @since 2023-12-11
 */
public interface AppDistrictService extends IService<AppDistrict> {

	/**
	 * 查询地区树菜单
	 * @param districtName 地区名称
	 * @return 树
	 */
	List<Tree<Long>> selectTree(String districtName);

	/**
	 * 获取地区的所有后代地区列表
	 * @param districtCode 地区编码
	 * @return 后代地区列表
	 */
	List<AppDistrict> listDescendant(Long districtCode);

}
