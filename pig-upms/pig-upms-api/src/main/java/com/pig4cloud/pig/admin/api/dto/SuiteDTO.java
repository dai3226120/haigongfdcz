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

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.pig4cloud.pig.admin.api.vo.EstatefileVO;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dw
 * @date 2023/12/13
 */
@Data
@Schema(description = "房屋传输对象")
@EqualsAndHashCode(callSuper = true)
public class SuiteDTO extends AppSuiteEntity {


	/**
	 * 房屋ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@Schema(description="房屋ID")
	private Long suiteId;

	/**
	 * 所属建筑_关联ID
	 */
	@Schema(description="所属建筑_关联ID")
	private Long estateId;

	/**
	 * 所在楼层
	 */
	@Schema(description="所在楼层")
	private Integer suiteFloor;

	/**
	 * 房间号
	 */
	@Schema(description="房间号")
	private String suiteCode;

	/**
	 * 是否自用
	 */
	@Schema(description="是否自用")
	private Integer suiteIsselfuse;

	/**
	 * 实际租赁面积
	 */
	@Schema(description="实际租赁面积")
	private Double suiteArea;

	/**
	 * 配套面积
	 */
	@Schema(description="配套面积")
	private Double suiteSupportingarea;

	/**
	 * 参考日租金
	 */
	@Schema(description="参考日租金")
	private Double suiteReferdailyrent;

	/**
	 * 参考年租金
	 */
	@Schema(description="参考年租金")
	private Double suiteReferyearlyrent;

	/**
	 * 备注
	 */
	@Schema(description="备注")
	private String suiteRemark;

	/**
	 * 房屋状态
	 */
	@Schema(description="房屋状态")
	private String suiteStatus;

	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	@Schema(description="创建人")
	private String createBy;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	@Schema(description="创建时间")
	private LocalDateTime createTime;

	/**
	 * 修改人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@Schema(description="修改人")
	private String updateBy;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@Schema(description="修改时间")
	private LocalDateTime updateTime;

	/**
	 * 房屋图片列表
	 */
	@Schema(description = "房屋图片列表")
	private List<EstatefileVO> suitefileImageList;

	/**
	 * 房屋视频列表
	 */
	@Schema(description = "房屋视频列表")
	private List<EstatefileVO> suitefileVideoList;
}
