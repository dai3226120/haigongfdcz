package com.pig4cloud.pig.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.admin.api.entity.*;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteContractVO;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteVO;
import com.pig4cloud.pig.admin.mapper.AppEstateMapper;
import com.pig4cloud.pig.admin.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 建筑管理
 *
 * @author dw
 * @date 2023-12-11 18:32:52
 */
@Slf4j
@Service
@AllArgsConstructor
public class AppEstateServiceImpl extends ServiceImpl<AppEstateMapper, AppEstateEntity> implements AppEstateService {

	/**
	 * 分页查询建筑信息（含有所有信息）
	 * @param page 分页对象
	 * @param estateDTO 参数列表
	 * @return
	 */
	@Override
	public IPage getEstatesAllPage(Page page, EstateDTO estateDTO) {
		return baseMapper.getEstateVosPage(page, estateDTO);
	}

	/**
	 * 分页查询建筑-房屋信息
	 * @param page 分页对象
	 * @param estateSuiteVO 参数列表
	 * @return
	 */
	@Override
	public IPage getEstateSuiteAllPage(Page page, EstateSuiteVO estateSuiteVO) {
		return baseMapper.getEstateSuiteVosPage(page, estateSuiteVO);
	}

	/**
	 * 分页查询建筑-房屋-合同信息
	 * @param page 分页对象
	 * @param estateSuiteContractVO 参数列表
	 * @return
	 */
	@Override
	public IPage getEstateSuiteContractAllPage(Page page, EstateSuiteContractVO estateSuiteContractVO) {
		return baseMapper.getEstateSuiteContractVosPage(page, estateSuiteContractVO);
	}

}