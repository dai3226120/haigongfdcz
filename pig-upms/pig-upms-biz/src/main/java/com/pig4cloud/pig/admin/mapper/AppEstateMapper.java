package com.pig4cloud.pig.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteContractVO;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteVO;
import com.pig4cloud.pig.admin.api.vo.EstateVO;
import com.pig4cloud.pig.admin.api.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppEstateMapper extends BaseMapper<AppEstateEntity> {

	/**
	 * 分页查询建筑信息（含所有）
	 * @param page 分页
	 * @param estateDTO 查询参数
	 * @param dataScope
	 * @return list
	 */
	IPage<EstateVO> getEstateVosPage(Page page, @Param("query") EstateDTO estateDTO);


	/**
	 * 分页查询建筑-房屋信息
	 * @param page 分页
	 * @param estateDTO 查询参数
	 * @param dataScope
	 * @return list
	 */
	IPage<EstateSuiteVO> getEstateSuiteVosPage(Page page, @Param("query")  EstateDTO estateDTO);

	/**
	 * 分页查询建筑-房屋-合同信息
	 * @param page 分页
	 * @param estateDTO 查询参数
	 * @param dataScope
	 * @return list
	 */
	IPage<EstateSuiteContractVO> getEstateSuiteContractVosPage(Page page, @Param("query")  EstateDTO estateDTO);

}