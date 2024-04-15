package com.ruoyi.lottery.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 渠道管理对象 t_pay_channel
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_pay_channel")
public class PayChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 通道代码 */
    @Excel(name = "通道代码")
    private String channelCode;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String channelName;

    /** 商户代码 */
    @Excel(name = "商户代码")
    private String merchantCode;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String merchantName;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 最小金额 */
    @Excel(name = "最小金额")
    private BigDecimal minAmount;

    /** 最大金额 */
    @Excel(name = "最大金额")
    private BigDecimal maxAmount;

    /** 1:钱包 2:微信 3:支付宝 4:QQ 5:数字人民币 6:银联 7:手机银行 8:云闪付 */
    @Excel(name = "1:钱包 2:微信 3:支付宝 4:QQ 5:数字人民币 6:银联 7:手机银行 8:云闪付")
    private Long type;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

}
