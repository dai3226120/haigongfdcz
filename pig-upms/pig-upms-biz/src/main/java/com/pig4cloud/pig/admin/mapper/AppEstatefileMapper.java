package com.pig4cloud.pig.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pig.admin.api.dto.SuiteDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.vo.EstatefileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppEstatefileMapper extends BaseMapper<AppEstatefileEntity> {

	/**
	 * 通过建筑ID，查询图片信息
	 * @param estateId
	 * @return
	 */
	List<AppEstatefileEntity> listImageByEstateId(Long estateId);

	/**
	 * 通过建筑ID，查询视频信息
	 * @param estateId
	 * @return
	 */
	List<EstatefileVO> listVideoByEstateId(Long estateId);

	/**
	 * 通过房屋ID，查询图片信息
	 * @param SuiteId
	 * @return
	 */
	List<EstatefileVO> listImageBySuiteId(Long SuiteId);

	/**
	 * 通过建筑ID，查询视频信息
	 * @param SuiteId
	 * @return
	 */
	List<EstatefileVO> listVideoBySuiteId(Long SuiteId);

}