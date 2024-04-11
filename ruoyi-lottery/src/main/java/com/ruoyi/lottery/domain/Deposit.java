package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 充值订单对象 t_deposit
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_deposit")
public class Deposit extends BaseEntity
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

    /** 充值金额 */
    @Excel(name = "充值金额")
    private BigDecimal amount;

    /** 1:银行卡 2:微信 3:支付宝 4:虚拟货币 5:在线支付 */
    @Excel(name = "1:银行卡 2:微信 3:支付宝 4:虚拟货币 5:在线支付")
    private Long depositType;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

    /** 充值账户详情 */
    @Excel(name = "充值账户详情")
    private String accountDetail;

    /** 用户充值信息详情 */
    @Excel(name = "用户充值信息详情")
    private String depositDetail;

    /** 0:待审核 1:审核成功 2:审核失败 */
    @Excel(name = "0:待审核 1:审核成功 2:审核失败")
    private Long status;

}
