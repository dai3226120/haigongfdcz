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

import com.pig4cloud.pig.admin.api.entity.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/11/11
 */
@Data
@Schema(description = "建筑信息")
public class EstateInfo implements Serializable {

	/**
	 * 建筑基本信息
	 */
	@Schema(description = "建筑基本信息")
	private AppEstateEntity appEstate;

	/**
	 * 地区信息
	 */
	@Schema(description = "地区信息")
	private List<AppDistrict> appDistrict;

	/**
	 * 一级企业信息
	 */
	@Schema(description = "一级企业信息")
	private AppYjqyEntity appYjqy;

	/**
	 * 权属单位信息
	 */
	@Schema(description = "权属单位信息")
	private AppQsdwEntity appQsdw;

	/**
	 * 建筑使用性质信息
	 */
	@Schema(description = "建筑使用性质信息")
	private AppEstatefunctionEntity appEstatefunction;

	/**
	 * 房屋类型信息
	 */
	@Schema(description = "房屋类型信息")
	private AppEstatetypeEntity appEstatetype;

	/**
	 * 土地性质信息
	 */
	@Schema(description = "土地性质信息")
	private AppLandstatusEntity appLandstatus;

}
