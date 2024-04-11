package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 支付订单对象 t_pay_order
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_pay_order")
public class PayOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 三方订单号 */
    @Excel(name = "三方订单号")
    private String payOrderNo;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 0:未支付 1:成功 2:失败 */
    @Excel(name = "0:未支付 1:成功 2:失败")
    private Long status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String errorMsg;

    /** 商户代码 */
    @Excel(name = "商户代码")
    private String merchantCode;

    /** 通道代码 */
    @Excel(name = "通道代码")
    private String channelCode;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String merchantName;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String channelName;

    /** 签名 */
    @Excel(name = "签名")
    private String sign;

}
