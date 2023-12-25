package com.pig4cloud.pig.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.api.vo.ContractVO;
import com.pig4cloud.pig.admin.mapper.AppContractMapper;
import com.pig4cloud.pig.admin.service.AppContractService;
import org.springframework.stereotype.Service;
/**
 * 合同管理
 *
 * @author dw
 * @date 2023-12-13 10:22:43
 */
@Service
public class AppContractServiceImpl extends ServiceImpl<AppContractMapper, AppContractEntity> implements AppContractService {


	/**
	 * 分页查询合同信息
	 * @param page 分页对象
	 * @param contractVO 参数列表
	 * @return
	 */
	@Override
	public IPage getContractAllPage(Page page, ContractVO contractVO) {
		return baseMapper.getContractVosPage(page, contractVO);
	}

	/**
	 * 分页查询合同历史信息
	 * @param page 分页对象
	 * @param contractVO 参数列表
	 * @return
	 */
	@Override
	public IPage getContractAllHistoryPage(Page page, ContractVO contractVO) {
		return baseMapper.getContractVosHistoryPage(page, contractVO);
	}
}