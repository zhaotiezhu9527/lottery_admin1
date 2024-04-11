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
 * 开元注单对象 t_ky_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_ky_record")
public class KyRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 平台用户名 */
    @Excel(name = "平台用户名")
    private String platUserName;

    /** 游戏局号 */
    @Excel(name = "游戏局号")
    private String orderNo;

    /** 游戏ID */
    @Excel(name = "游戏ID")
    private String gameId;

    /** 游戏名称 */
    @Excel(name = "游戏名称")
    private String gameName;

    /** 有效投注 */
    @Excel(name = "有效投注")
    private BigDecimal effectiveBet;

    /** 总投注额 */
    @Excel(name = "总投注额")
    private BigDecimal allBet;

    /** 输赢金额(纯盈利,不包含本金) */
    @Excel(name = "输赢金额(纯盈利,不包含本金)")
    private BigDecimal profit;

    /** 游戏开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "游戏开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date gameStartTime;

    /** 游戏结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "游戏结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date gameEndTime;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

}
