package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 提现订单对象 t_withdraw
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_withdraw")
public class Withdraw extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    /** 0:待审核 1:审核通过 2:拒绝提现 */
    @Excel(name = "审核结果", readConverterExp = "0=待审核,1=审核通过,2=拒绝提现")
    private Long status;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

    /** 1:银行卡 2:微信 3:支付宝 4:虚拟货币 */
    @Excel(name = "提现方式", readConverterExp = "1=银行卡,2=微信,3=支付宝,4=虚拟货币")
    private Long accountType;

    /** 用户收款信息详情 */
    @Excel(name = "用户收款信息详情")
    private String accountDetail;

}
