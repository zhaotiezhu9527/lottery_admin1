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
 * 三方注单(BBIN)对象 t_bbin_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_bbin_record")
public class BbinRecord extends BaseEntity
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

    /** 注单号码WagersID */
    @Excel(name = "注单号码WagersID")
    private String orderNo;

    /** 游戏ID  GameType */
    @Excel(name = "游戏ID  GameType")
    private String gameId;

    /** 游戏名称GameType */
    @Excel(name = "游戏名称GameType")
    private String gameName;

    /** 有效投注Commissionable */
    @Excel(name = "有效投注Commissionable")
    private BigDecimal effectiveBet;

    /** 总投注额BetAmount */
    @Excel(name = "总投注额BetAmount")
    private BigDecimal allBet;

    /** Payoff派彩金额(不包含本金) */
    @Excel(name = "Payoff派彩金额(不包含本金)")
    private BigDecimal profit;

    /** 下注时间WagersDate */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间WagersDate", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date betTime;

    /** 下注时间美东 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间美东", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date wagersDate;

    /** 结算时间ModifiedDate */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间ModifiedDate", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    /** 注单变更时间 美东 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "注单变更时间 美东", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;

    /** 注单结果(C:注销,W:赢,L:输) */
    @Excel(name = "注单结果(C:注销,W:赢,L:输)")
    private String resultStatus;

    /** 开牌结果 */
    @Excel(name = "开牌结果")
    private String openResult;

    /** 结果牌 */
    @Excel(name = "结果牌")
    private String card;

    /** 局号 */
    @Excel(name = "局号")
    private String serialId;

    /** 场次 */
    @Excel(name = "场次")
    private String roundNo;

    /** 玩法 */
    @Excel(name = "玩法")
    private String wagerDetail;

    /** 1:视讯 2:电子 3:捕鱼 */
    @Excel(name = "1:视讯 2:电子 3:捕鱼")
    private Long gameType;

}
