package com.pig4cloud.pig.admin.api.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 房屋管理
 *
 * @author dw
 * @date 2023-12-13 10:13:09
 */
@Data
@TableName("app_suite")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "房屋管理")
public class SuiteContractVo extends Model<SuiteContractVo> {


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
	 * 房屋性质
	 */
	@Schema(description="房屋性质")
	private String suiteProperty;

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

	/**
	 * 合同列表
	 */
	@Schema(description = "对应的合同列表")
	private List<AppContractEntity> contractEntityList;

	/**
	 * 合同状态
	 */
	@Schema(description="合同状态")
	private String contractStatus;
}