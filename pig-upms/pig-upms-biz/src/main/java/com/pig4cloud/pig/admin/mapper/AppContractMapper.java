package com.pig4cloud.pig.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppContractMapper extends BaseMapper<AppContractEntity> {

	/**
	 * 通过建筑ID，查询房屋信息
	 * @param suiteId
	 * @return
	 */
	List<AppSuiteMapper> listContractsBySuiteId(Long suiteId);

}