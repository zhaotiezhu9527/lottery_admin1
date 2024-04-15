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
 * 投注记录对象 t_lottery_order
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_lottery_order")
public class LotteryOrder extends BaseEntity
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

    /** 彩种代码 */
    @Excel(name = "彩种代码")
    private String lotteryCode;

    /** 彩种名称 */
    @Excel(name = "彩种名称")
    private String lotteryName;

    /** 盘口代码 */
    @Excel(name = "盘口代码")
    private String handicapCode;

    /** 玩法代码 */
    @Excel(name = "玩法代码")
    private String playCode;

    /** 玩法名称 */
    @Excel(name = "玩法名称")
    private String playName;

    /** 投注内容 */
    @Excel(name = "投注内容")
    private String betContent;

    /** 赔率 */
    @Excel(name = "赔率")
    private BigDecimal odds;

    /** 期号 */
    @Excel(name = "期号")
    private String qs;

    /** 投注金额 */
    @Excel(name = "投注金额")
    private BigDecimal betAmount;

    /** 中奖金额(未中奖为0) */
    @Excel(name = "中奖金额(未中奖为0)")
    private BigDecimal bonusAmount;

    /** 盈利金额 */
    @Excel(name = "盈利金额")
    private BigDecimal profitAmount;

    /** 投注时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "投注时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date betTime;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    /** 0:待结算 1:结算中(未使用) 2:已结算 3:已撤单 4:结算异常 */
    @Excel(name = "0:待结算 1:结算中(未使用) 2:已结算 3:已撤单 4:结算异常", readConverterExp = "0=待结算,1=结算中,2=已结算,3=已撤单,4=结算异常")
    private Long settleStatus;

    /** 0:待结算 1:已中奖 2:未中奖 3:已撤单 4:和局 */
    @Excel(name = "订单状态", readConverterExp = "0=待结算,1=已中奖,2=未中奖,3=已撤单,4=和局")
    private Long orderStatus;

    /** 开奖结果 */
    @Excel(name = "开奖结果")
    private String openResult;

    /** 预计开奖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预计开奖时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date openResultTime;

    /** 随机分组,结算用 */
    @Excel(name = "随机分组,结算用")
    private Long settleGroup;

}
