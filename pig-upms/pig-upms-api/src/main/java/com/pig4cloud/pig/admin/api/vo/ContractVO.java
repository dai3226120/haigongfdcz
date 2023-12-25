package com.pig4cloud.pig.admin.api.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 合同管理
 *
 * @author dw
 * @date 2023-12-13 10:22:43
 */
@Data
@TableName("app_contract")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "合同")
public class ContractVO extends Model<ContractVO> {



	/**
	 * 地区名称
	 */
	@Schema(description = "地区名称")
	private String districtName;

	/**
	 * 建筑名称
	 */
	@Schema(description="建筑名称")
	private String estateName;

	/**
	 * 建筑编码
	 */
	@Schema(description="建筑编码")
	private String estateCode;

	/**
	 * 房间号
	 */
	@Schema(description="房间号")
	private String suiteCode;

	/**
	* 合同ID
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="合同ID")
    private Long contractId;

	/**
	* 所属房屋_关联ID
	*/
    @Schema(description="所属房屋_关联ID")
    private Long suiteId;

	/**
	 * 承租人
	 */
	@Schema(description="承租人")
	private String contractTenant;

	/**
	 * 合同联系人
	 */
	@Schema(description="合同联系人")
	private String contactName;

	/**
	 * 合同联系方式
	 */
	@Schema(description="合同联系方式")
	private String contactPhone;

	/**
	 * 合同金额
	 */
	@Schema(description="合同金额")
	private Double contractAmount;

	/**
	 * 合同支付方式
	 */
	@Schema(description="合同支付方式")
	private String contractPayment;

	/**
	* 是否上传合同
	*/
    @Schema(description="是否上传合同")
    private Integer contractIsupdatecontract;

	/**
	* 合同编号
	*/
    @Schema(description="合同编号")
    private String contractContractnumber;

	/**
	* 经营业态
	*/
    @Schema(description="经营业态")
    private String contractBusinessmode;

	/**
	* 承租性质
	*/
    @Schema(description="承租性质")
    private String contractRenttype;

	/**
	* 合同开始时间
	*/
    @Schema(description="合同开始时间")
    private LocalDateTime contractStartdate;

	/**
	* 合同结束时间
	*/
    @Schema(description="合同结束时间")
    private LocalDateTime contractEnddate;

	/**
	* 日租金
	*/
    @Schema(description="日租金")
    private Double contractDailyrent;

	/**
	* 年租金
	*/
    @Schema(description="年租金")
    private Double contractYearlyrent;

	/**
	 * 合同状态
	 */
	@Schema(description="合同状态")
	private String contractStatus;

	/**
	 * 执行状态
	 */
	@Schema(description="执行状态")
	private String executeStatus;

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