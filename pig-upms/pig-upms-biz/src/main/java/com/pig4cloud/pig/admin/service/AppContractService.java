package com.pig4cloud.pig.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.api.vo.ContractVO;

public interface AppContractService extends IService<AppContractEntity> {

	/**
	 * 分页查询合同信息
	 * @param page 分页对象
	 * @param contractVO 参数列表
	 * @return
	 */
	IPage getContractAllPage(Page page, ContractVO contractVO);

	/**
	 * 分页查询合同历史信息
	 * @param page 分页对象
	 * @param contractVO 参数列表
	 * @return
	 */
	IPage getContractAllHistoryPage(Page page, ContractVO contractVO);

}