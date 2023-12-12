package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 一级企业
 *
 * @author dw
 * @date 2023-12-12 16:40:57
 */
@Data
@TableName("app_yjqy")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "一级企业")
public class AppYjqyEntity extends Model<AppYjqyEntity> {


	/**
	* 一级企业ID
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="一级企业ID")
    private Integer yjqyId;

	/**
	* 一级企业名称
	*/
    @Schema(description="一级企业名称")
    private String yjqyName;

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