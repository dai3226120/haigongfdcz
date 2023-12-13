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

package com.pig4cloud.pig.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.AppDistrict;
import com.pig4cloud.pig.admin.api.entity.SysDept;
import com.pig4cloud.pig.admin.api.vo.DeptExcelVo;
import com.pig4cloud.pig.admin.mapper.AppDistrictMapper;
import com.pig4cloud.pig.admin.mapper.SysDeptMapper;
import com.pig4cloud.pig.admin.service.AppDistrictService;
import com.pig4cloud.pig.admin.service.SysDeptService;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.plugin.excel.vo.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 地区 服务实现类
 * </p>
 *
 * @author dw
 * @since 2023-12-11
 */
@Service
@AllArgsConstructor
public class AppDistrictServiceImpl extends ServiceImpl<AppDistrictMapper, AppDistrict> implements AppDistrictService {

	private final AppDistrictMapper districtMapper;

	/**
	 * 查询全部地区树
	 * @param districtName
	 * @return 树 地区名称
	 */
	@Override
	public List<Tree<Long>> selectTree(String districtName) {
		// 查询全部地区
		List<AppDistrict> districtsAllList = districtMapper
			.selectList(Wrappers.<AppDistrict>lambdaQuery().like(StrUtil.isNotBlank(districtName), AppDistrict::getDistrictName, districtName));

		// 权限内地区
		List<TreeNode<Long>> collect = districtsAllList.stream()
			.filter(district -> district.getDistrictCode().equals(district.getDistrictParentcode()) == false)
			.sorted(Comparator.comparingInt(AppDistrict::getDistrictSortorder))
			.map(district -> {
				TreeNode<Long> treeNode = new TreeNode();
				treeNode.setId(district.getDistrictCode());
				treeNode.setParentId(district.getDistrictParentcode());
				treeNode.setName(district.getDistrictName());
				treeNode.setWeight(district.getDistrictSortorder());
				return treeNode;
			})
			.collect(Collectors.toList());

		// 模糊查询 不组装树结构 直接返回 表格方便编辑
		if (StrUtil.isNotBlank(districtName)) {
			return collect.stream().map(node -> {
				Tree<Long> tree = new Tree<>();
				BeanUtils.copyProperties(node, tree);
				return tree;
			}).collect(Collectors.toList());
		}

		return TreeUtil.build(collect, 0L);
	}

	/**
	 * 查询所有子节点 （包含当前节点）
	 * @param districtCode 地区编码 目标地区编码
	 * @return 地区编码
	 */
	@Override
	public List<AppDistrict> listDescendant(Long districtCode) {
		// 查询全部地区
		List<AppDistrict> alldistrictList = baseMapper.selectList(Wrappers.emptyWrapper());

		// 递归查询所有子节点
		List<AppDistrict> resDistrictList = new ArrayList<>();
		recursiveDistrict(alldistrictList, districtCode, resDistrictList);

		// 添加当前节点
		resDistrictList.addAll(alldistrictList.stream()
			.filter(appDistrict -> districtCode.equals(appDistrict.getDistrictCode()))
			.collect(Collectors.toList()));
		return resDistrictList;
	}

	/**
	 * 递归查询所有子节点。
	 * @param allDistrictList 所有地区列表
	 * @param parentId 父地区编码
	 * @param resDistrictList 结果集合
	 */
	private void recursiveDistrict(List<AppDistrict> allDistrictList, Long parentId, List<AppDistrict> resDistrictList) {
		// 使用 Stream API 进行筛选和遍历
		allDistrictList.stream().filter(appDistrict -> appDistrict.getDistrictParentcode().equals(parentId)).forEach(appDistrict -> {
			resDistrictList.add(appDistrict);
			recursiveDistrict(allDistrictList, appDistrict.getDistrictCode(), resDistrictList);
		});
	}

}
