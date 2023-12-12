package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 建筑使用性质
 *
 * @author dw
 * @date 2023-12-12 16:33:09
 */
@Data
@TableName("app_estatefunction")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "建筑使用性质")
public class AppEstatefunctionEntity extends Model<AppEstatefunctionEntity> {


	/**
	* 使用性质ID
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="使用性质ID")
    private Integer estatefunctionId;

	/**
	* 使用性质名称
	*/
    @Schema(description="使用性质名称")
    private String estatefunctionName;

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