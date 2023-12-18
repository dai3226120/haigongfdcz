package com.pig4cloud.pig.admin.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.dto.SuiteDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteVO;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;

import java.util.List;

public interface AppSuiteService extends IService<AppSuiteEntity> {

	/**
	 * 分页查询房屋信息（含有所有信息）
	 * @param page 分页对象
	 * @param suiteVO 参数列表
	 * @return
	 */
	IPage getSuitesAllPage(Page page, SuiteVO suiteVO);

	/**
	 * 分页查询房屋-合同信息（含有所有信息）
	 * @param page 分页对象
	 * @param suiteEntity 参数列表
	 * @return
	 */
	IPage getSuiteContractAllPage(Page page, AppSuiteEntity suiteEntity);


}