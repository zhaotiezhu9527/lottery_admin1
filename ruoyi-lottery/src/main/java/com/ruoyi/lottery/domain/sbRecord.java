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
 * 沙巴体育注单对象 t_sb_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_sb_record")
public class sbRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 平台用户名(vendor_member_id) */
    @Excel(name = "平台用户名(vendor_member_id)")
    private String platUserName;

    /** 游戏局号(trans_id) */
    @Excel(name = "游戏局号(trans_id)")
    private String orderNo;

    /** sportname */
    @Excel(name = "sportname")
    private String gameName;

    /** 滚球 非滚球 */
    @Excel(name = "滚球 非滚球")
    private String wtype;

    /** 玩法结果bettypename */
    @Excel(name = "玩法结果bettypename")
    private String rtype;

    /** 主队名称hometeamname */
    @Excel(name = "主队名称hometeamname")
    private String tnameHome;

    /** 客队名称awayteamname */
    @Excel(name = "客队名称awayteamname")
    private String tnameAway;

    /** 联赛名称leaguename */
    @Excel(name = "联赛名称leaguename")
    private String league;

    /** 赔率 odds */
    @Excel(name = "赔率 odds")
    private BigDecimal ioratio;

    /** 有效投注 */
    @Excel(name = "有效投注")
    private BigDecimal effectiveBet;

    /** 总投注额stake */
    @Excel(name = "总投注额stake")
    private BigDecimal allBet;

    /** 此注输或赢的金额winlost_amount */
    @Excel(name = "此注输或赢的金额winlost_amount")
    private BigDecimal profit;

    /** 下注时间transaction_time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间transaction_time", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date betTime;

    /** 结算时间settlement_time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间settlement_time", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    /** 0:未结算 1:已结算 */
    @Excel(name = "0:未结算 1:已结算")
    private Long settleStatus;

    /** waiting(等待中) running(进行中)void(作废)refund(退款)reject(已取消)lose(输)won(赢)draw(和局)half won(半赢)half lose(半输) */
    @Excel(name = "waiting(等待中) running(进行中)void(作废)refund(退款)reject(已取消)lose(输)won(赢)draw(和局)half won(半赢)half lose(半输)")
    private String resultStatus;

    /** 比分结果 */
    @Excel(name = "比分结果")
    private String resultScore;

    /** 球头 */
    @Excel(name = "球头")
    private String oddsFormat;

    /** 2:2串1 3:3串1 4:4串1 */
    @Excel(name = "2:2串1 3:3串1 4:4串1")
    private Long parlaynum;

    /** 串数内容 ParlayData */
    @Excel(name = "串数内容 ParlayData")
    private String parlaysub;

    /** 返回的原始数据 一般是json */
    @Excel(name = "返回的原始数据 一般是json")
    private String rawData;

    /** 重新结算信息 */
    @Excel(name = "重新结算信息")
    private String resettlementinfo;

    /** 滚球  0:否 1:是 */
    @Excel(name = "滚球  0:否 1:是")
    private Long isLive;

}
