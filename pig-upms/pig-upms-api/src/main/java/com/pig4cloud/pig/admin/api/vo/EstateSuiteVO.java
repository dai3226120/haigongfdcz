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

package com.pig4cloud.pig.admin.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pig4cloud.pig.admin.api.dto.SuiteDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/29
 */
@Data
@Schema(description = "前端用户展示对象")
public class EstateSuiteVO implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 建筑ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@Schema(description="建筑ID")
	private Long estateId;

	/**
	 * 建筑名称
	 */
	@Schema(description="建筑名称")
	private String estateName;

	/**
	 * 总楼层
	 */
	@Schema(description="总楼层")
	private Integer estateFloor;

	/**
	 * 建筑编码
	 */
	@Schema(description="建筑编码")
	private String estateCode;

	/**
	 * 地区编号
	 */
	@Schema(description="地区编号")
	private Long districtCode;

	/**
	 * 地区名称
	 */
	@Schema(description = "地区名称")
	private String districtName;

	/**
	 * 详细地址
	 */
	@Schema(description="详细地址")
	private String estateAddress;

	/**
	 * 土地面积
	 */
	@Schema(description="土地面积")
	private Double estateAreaLand;

	/**
	 * 土地证面积
	 */
	@Schema(description="土地证面积")
	private Double estateAreaLandcertificate;

	/**
	 * 房屋面积
	 */
	@Schema(description="房屋面积")
	private Double estateAreaEstate;

	/**
	 * 房产证面积
	 */
	@Schema(description="房产证面积")
	private Double estateAreaEstatecertificate;

	/**
	 * 一级企业_关联ID
	 */
	@Schema(description="一级企业_关联ID")
	private Integer yjqyId;

	/**
	 * 一级企业名称
	 */
	@Schema(description="一级企业名称")
	private String yjqyName;

	/**
	 * 权属单位_关联ID
	 */
	@Schema(description="权属单位_关联ID")
	private Integer qsdwId;

	/**
	 * 权属单位名称
	 */
	@Schema(description="权属单位名称")
	private String qsdwName;

	/**
	 * 土地性质_关联ID
	 */
	@Schema(description="土地性质_关联ID")
	private Integer landstatusId;

	/**
	 * 土地性质名称
	 */
	@Schema(description="土地性质名称")
	private String landstatusName;

	/**
	 * 房屋类型_关联ID
	 */
	@Schema(description="房屋类型_关联ID")
	private Integer estatetypeId;

	/**
	 * 房屋类型名称
	 */
	@Schema(description="房屋类型名称")
	private String estatetypeName;

	/**
	 * 使用性质_关联ID
	 */
	@Schema(description="使用性质_关联ID")
	private Integer estatefunctionId;

	/**
	 * 使用性质名称
	 */
	@Schema(description="使用性质名称")
	private String estatefunctionName;

	/**
	 * 租赁面积
	 */
	@Schema(description="租赁面积")
	private Double rentArea;

	/**
	 * 自用面积
	 */
	@Schema(description="自用面积")
	private Double selfuseArea;

	/**
	 * 空置面积
	 */
	@Schema(description="空置面积")
	private Double vacantArea;

	/**
	 * 房屋总数
	 */
	@Schema(description="房屋总数")
	private Integer suiteNum;

	/**
	 * 建筑图片列表
	 */
	@Schema(description = "建筑图片列表")
	private List<EstatefileVO> estatefileImageList;

	/**
	 * 建筑视频列表
	 */
	@Schema(description = "建筑视频列表")
	private List<EstatefileVO> estatefileVideoList;

	/**
	 * 房屋列表
	 */
	@Schema(description = "拥有的房屋列表")
	private List<SuiteDTO> suiteDTOList;

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
	 * 房屋性质
	 */
	@Schema(description="房屋性质")
	private String suiteProperty;



}
