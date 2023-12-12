package com.pig4cloud.pig.admin.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * 房屋类型
 *
 * @author dw
 * @date 2023-12-12 16:27:35
 */
@Data
@TableName("app_estatetype")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "房屋类型")
public class AppEstatetypeEntity extends Model<AppEstatetypeEntity> {


	/**
	* 房屋类型ID
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="房屋类型ID")
    private Integer estatetypeId;

	/**
	* 房屋类型名称
	*/
    @Schema(description="房屋类型名称")
    private String estatetypeName;

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