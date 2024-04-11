package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 额度转换对象 t_edu_order
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_edu_order")
public class EduOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 订单号(自己平台) */
    @Excel(name = "订单号(自己平台)")
    private String orderNo;

    /** 三方订单号 */
    @Excel(name = "三方订单号")
    private String platOrderNo;

    /** 转换金额 */
    @Excel(name = "转换金额")
    private BigDecimal amount;

    /** 0:转入 1:转出 */
    @Excel(name = "0:转入 1:转出")
    private Long eduType;

    /** 平台代码 */
    @Excel(name = "平台代码")
    private String platCode;

    /** -1:异常 0:成功 1:失败 */
    @Excel(name = "-1:异常 0:成功 1:失败")
    private Long status;

}
