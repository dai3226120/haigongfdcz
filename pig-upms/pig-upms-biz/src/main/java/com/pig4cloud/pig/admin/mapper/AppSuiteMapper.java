package com.pig4cloud.pig.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.EstateDTO;
import com.pig4cloud.pig.admin.api.dto.SuiteDTO;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.api.entity.SysRole;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteVO;
import com.pig4cloud.pig.admin.api.vo.EstateVO;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;
import com.pig4cloud.pig.admin.api.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppSuiteMapper extends BaseMapper<AppSuiteEntity> {

	/**
	 * 分页查询房屋信息（含所有）
	 * @param page 分页
	 * @param suiteVO 查询参数
	 * @param dataScope
	 * @return list
	 */
	IPage<SuiteVO> getSuiteVosPage(Page page, @Param("query") SuiteVO suiteVO);


	/**
	 * 通过建筑ID，查询房屋信息
	 * @param estateId
	 * @return
	 */
	List<AppSuiteMapper> listSuitesByEstateId(Integer estateId);


}