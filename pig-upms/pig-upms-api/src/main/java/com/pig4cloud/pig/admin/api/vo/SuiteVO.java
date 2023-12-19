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
import com.pig4cloud.pig.admin.api.entity.SysPost;
import com.pig4cloud.pig.admin.api.entity.SysRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/29
 */
@Data
@Schema(description = "前端房屋展示对象")
public class SuiteVO implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 建筑ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@Schema(description="建筑ID")
	private Integer estateId;

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
	 * 房屋ID
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@Schema(description="房屋ID")
	private Integer suiteId;

	/**
	 * 所属建筑_关联ID
	 */
	@Schema(description="所属建筑_关联ID")
	private Integer suiteEstateId;

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

}
