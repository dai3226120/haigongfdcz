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

import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dw
 * @date 2023/12/13
 */
@Data
@Schema(description = "资产文件传输对象")
@EqualsAndHashCode(callSuper = true)
public class EstateFileDTO extends AppEstatefileEntity {

	/**
	 * 所属建筑_关联ID
	 */
	@Schema(description="所属建筑_关联ID")
	private Long estateId;

	/**
	 * 所属房屋_关联ID
	 */
	@Schema(description="所属房屋_关联ID")
	private Long suiteId;

	/**
	 * 所属合同_关联ID
	 */
	@Schema(description="所属合同_关联ID")
	private Long contractId;


}
