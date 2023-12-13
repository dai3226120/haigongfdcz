/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.pig4cloud.pig.admin.api.dto;

import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author dw
 * @date 2023/12/13
 */
@Data
@Schema(description = "建筑传输对象")
@EqualsAndHashCode(callSuper = true)
public class EstateDTO extends AppEstateEntity {

	/**
	 * 地区编号
	 */
	@Schema(description="地区编号")
	private Long estateDistrictCode;

	/**
	 * 一级企业_关联ID
	 */
	@Schema(description="一级企业_关联ID")
	private Integer yjqyId;

	/**
	 * 权属单位_关联ID
	 */
	@Schema(description="权属单位_关联ID")
	private Integer qsdwId;

	/**
	 * 土地性质_关联ID
	 */
	@Schema(description="土地性质_关联ID")
	private Integer estateLandstatusId;

	/**
	 * 房屋类型_关联ID
	 */
	@Schema(description="房屋类型_关联ID")
	private Integer estateEstatetypeId;

	/**
	 * 使用性质_关联ID
	 */
	@Schema(description="使用性质_关联ID")
	private Integer estateEstatefunctionId;

	/**
	 * 所属建筑_关联ID
	 */
	@Schema(description="所属建筑_关联ID集合")
	private List<Integer> estateIds;

	/**
	 * 地区名称
	 */
	@Schema(description = "地区名称")
	private String districtName;

	/**
	 * 一级企业名称
	 */
	@Schema(description="一级企业名称")
	private String yjqyName;

	/**
	 * 权属单位名称
	 */
	@Schema(description="权属单位名称")
	private String qsdwName;

	/**
	 * 土地性质名称
	 */
	@Schema(description="土地性质名称")
	private String landstatusName;

	/**
	 * 房屋类型名称
	 */
	@Schema(description="房屋类型名称")
	private String estatetypeName;

	/**
	 * 使用性质名称
	 */
	@Schema(description="使用性质名称")
	private String estatefunctionName;

}
