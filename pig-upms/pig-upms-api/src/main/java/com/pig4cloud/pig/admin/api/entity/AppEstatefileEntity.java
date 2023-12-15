package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 资产文件
 *
 * @author dw
 * @date 2023-12-14 16:33:03
 */
@Data
@TableName("app_estatefile")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "资产文件")
public class AppEstatefileEntity extends Model<AppEstatefileEntity> {


	/**
	* 资产文件ID
	*/
    @Schema(description="资产文件ID")
    private Long estatefileId;

	/**
	* 资产文件名
	*/
    @Schema(description="资产文件名")
    private String estatefileName;

	/**
	* 文件存储桶名称
	*/
    @Schema(description="文件存储桶名称")
    private String bucketName;

	/**
	* 原始文件名
	*/
    @Schema(description="原始文件名")
    private String original;

	/**
	* 文件类型
	*/
    @Schema(description="文件类型")
    private String type;

	/**
	* 文件大小
	*/
    @Schema(description="文件大小")
    private Long fileSize;

	/**
	* 关联的建筑ID
	*/
    @Schema(description="关联的建筑ID")
    private Integer estateId;

	/**
	* 关联的房屋ID
	*/
    @Schema(description="关联的房屋ID")
    private Integer suiteId;

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
}