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
 * 公司U地址对象 t_company_virtual
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_company_virtual")
public class CompanyVirtual extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String channelName;

    /** 1:trc20 2:erc20 */
    @Excel(name = "1:trc20 2:erc20")
    private Long channelType;

    /** 收款账户 */
    @Excel(name = "收款账户")
    private String accountNo;

    /** 汇率 */
    @Excel(name = "汇率")
    private BigDecimal exchangeRate;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

    /** 排序号(值越大越靠前) */
    @Excel(name = "排序号(值越大越靠前)")
    private Long pxh;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 最小金额 */
    @Excel(name = "最小金额")
    private BigDecimal minAmount;

    /** 最大金额 */
    @Excel(name = "最大金额")
    private BigDecimal maxAmount;

}
