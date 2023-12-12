package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 建筑管理
 *
 * @author dw
 * @date 2023-12-11 18:32:52
 */
@Data
@TableName("app_estate")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "建筑管理")
public class AppEstateEntity extends Model<AppEstateEntity> {


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
    private String estateDistrictCode;

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
	* 创建用户
	*/
	@TableField(fill = FieldFill.INSERT)
    @Schema(description="创建用户")
    private String createBy;

	/**
	* 创建时间
	*/
	@TableField(fill = FieldFill.INSERT)
    @Schema(description="创建时间")
    private LocalDateTime createTime;

	/**
	* 修改用户
	*/
	@TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(description="修改用户")
    private String updateBy;

	/**
	* 修改时间
	*/
	@TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(description="修改时间")
    private LocalDateTime updateTime;
}