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

package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 地区管理
 * </p>
 *
 * @author dw
 * @since 2023-12-11
 */
@Data
@Schema(description = "地区")
@EqualsAndHashCode(callSuper = true)
public class AppDistrict extends Model<AppDistrict> {

	private static final long serialVersionUID = 1L;

	@Schema(description = "地区代码")
	private Long districtCode;

	/**
	 * 地区名称
	 */
	@NotBlank(message = "地区名称不能为空")
	@Schema(description = "地区名称")
	private String districtName;

	/**
	 * 排序
	 */

	@Schema(description = "排序值")
	private Integer districtSortorder;

	/**
	 * 父级地区代码
	 */
	@Schema(description = "父级地区代码")
	private Long districtParentcode;

}
