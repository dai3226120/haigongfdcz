package com.pig4cloud.pig.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;

public interface AppEstateService extends IService<AppEstateEntity> {

	/**
	 * 分页查询建筑信息（含有所有信息）
	 * @param page 分页对象
	 * @param estateDTO 参数列表
	 * @return
	 */
	IPage getEstatesAllPage(Page page, EstateDTO estateDTO);


	/**
	 * 分页查询建筑-房屋信息
	 * @param page 分页对象
	 * @param estateDTO 参数列表
	 * @return
	 */
	IPage getEstateSuiteAllPage(Page page, EstateDTO estateDTO);


	/**
	 * 分页查询建筑-房屋-合同信息
	 * @param page 分页对象
	 * @param estateDTO 参数列表
	 * @return
	 */
	IPage getEstateSuiteContractAllPage(Page page, EstateDTO estateDTO);

}