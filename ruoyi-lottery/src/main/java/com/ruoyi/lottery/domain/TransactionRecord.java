package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 账变记录对象 t_transaction_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_transaction_record")
public class TransactionRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 流水号 */
    @Excel(name = "流水号")
    private String trxId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 操作前余额 */
    @Excel(name = "操作前余额")
    private BigDecimal beforeAmount;

    /** 操作后余额 */
    @Excel(name = "操作后余额")
    private BigDecimal afterAmount;

    /** 0:收入 1:支出 */
    @Excel(name = "账变类型", readConverterExp = "0=收入,1=支出")
    private Long payType;

    /** 0:充值 1:提现 2:下注 3:彩票奖金 4:彩票撤单 5:三方上分 6:三方下分 7:返水 8:优惠活动 9:后台入款 10:后台扣款 11:彩票和局退还 */
    @Excel(readConverterExp = "0=充值,1=提现,2=下注,3=彩票奖金,4=彩票撤单,5=三方上分,6=三方下分,7=返水,8=优惠活动,9=后台入款,10=后台扣款,11=彩票和局退还", name = "业务类型")
    private Long businessType;

    /** 业务订单号 */
    @Excel(name = "业务订单号")
    private String businessOrder;

    /** 操作人(前台业务可以不写) */
    @Excel(name = "操作人(前台业务可以不写)")
    private String operName;

}
