package com.pig4cloud.pig.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.api.vo.ContractVO;
import com.pig4cloud.pig.admin.api.vo.EstateVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppContractMapper extends BaseMapper<AppContractEntity> {

	/**
	 * 通过房屋ID，查询合同信息
	 * @param suiteId
	 * @return
	 */
	List<AppSuiteMapper> listContractsBySuiteId(Long suiteId);

	/**
	 * 分页查询合同信息（含所有）
	 * @param page 分页
	 * @param contractVO 查询参数
	 * @param dataScope
	 * @return list
	 */
	IPage<EstateVO> getContractVosPage(Page page, @Param("query") ContractVO contractVO);

}