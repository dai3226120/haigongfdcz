package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 土地性质
 *
 * @author dw
 * @date 2023-12-12 15:00:34
 */
@Data
@TableName("app_landstatus")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "土地性质")
public class AppLandstatusEntity extends Model<AppLandstatusEntity> {


	/**
	* 土地性质ID
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="土地性质ID")
    private Integer landstatusId;

	/**
	* 土地性质名称
	*/
    @Schema(description="土地性质名称")
    private String landstatusName;

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