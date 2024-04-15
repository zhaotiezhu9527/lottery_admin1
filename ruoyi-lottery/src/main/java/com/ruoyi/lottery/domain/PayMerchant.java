package com.ruoyi.lottery.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 商家配置对象 t_pay_merchant
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_pay_merchant")
public class PayMerchant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 商户代码 */
    @Excel(name = "商户代码")
    private String merchantCode;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String merchantName;

    /** 商户信息详情 */
    @Excel(name = "商户信息详情")
    private String merchantDetail;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 回调地址 */
    @Excel(name = "回调地址")
    private String callbackUrl;

    /** 回调IP */
    @Excel(name = "回调IP")
    private String callbackIp;

    /** 支付网关地址 */
    @Excel(name = "支付网关地址")
    private String payUrl;

}
