package com.pig4cloud.pig.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;
import com.pig4cloud.pig.admin.mapper.AppSuiteMapper;
import com.pig4cloud.pig.admin.service.AppSuiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 房屋管理
 *
 * @author dw
 * @date 2023-12-13 10:13:09
 */
@Service
@AllArgsConstructor
public class AppSuiteServiceImpl extends ServiceImpl<AppSuiteMapper, AppSuiteEntity> implements AppSuiteService {

	private final AppSuiteMapper suiteMapper;


	@Override
	public IPage getSuitesAllPage(Page page, SuiteVO suiteVO) {
		return baseMapper.getSuiteVosPage(page, suiteVO);
	}

	@Override
	public IPage getSuiteContractAllPage(Page page, AppSuiteEntity suiteEntity) {
		return baseMapper.getSuiteContractVosPage(page, suiteEntity);
	}



}