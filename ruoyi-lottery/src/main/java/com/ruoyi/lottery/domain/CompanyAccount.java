package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 公司入款账号对象 t_company_account
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_company_account")
public class CompanyAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String accountName;

    /** 收款人 */
    @Excel(name = "收款人")
    private String payeeName;

    /** 收款账号 */
    @Excel(name = "收款账号")
    private String accountNo;

    /** 开户网点 */
    @Excel(name = "开户网点")
    private String address;

    /** 最小金额 */
    @Excel(name = "最小金额")
    private BigDecimal minAmount;

    /** 最大金额 */
    @Excel(name = "最大金额")
    private BigDecimal maxAmount;

    /** 1:银行卡 2:微信 3:支付宝 */
    @Excel(name = "1:银行卡 2:微信 3:支付宝")
    private Long type;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 值越大越靠前 */
    @Excel(name = "值越大越靠前")
    private Long pxh;

}
