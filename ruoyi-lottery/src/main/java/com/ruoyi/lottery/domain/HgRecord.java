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
 * 皇冠体育注单对象 t_hg_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_hg_record")
public class HgRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 平台用户名(mid) */
    @Excel(name = "平台用户名(mid)")
    private String platUserName;

    /** 游戏局号(id) */
    @Excel(name = "游戏局号(id)")
    private String orderNo;

    /** FT:足球 BK:篮球/美足 TB:网球 BS:棒球 OP:其他 VF:虚拟足球 SK:台球 MT:跨球类过关 FS:冠军 VB:排球 */
    @Excel(name = "FT:足球 BK:篮球/美足 TB:网球 BS:棒球 OP:其他 VF:虚拟足球 SK:台球 MT:跨球类过关 FS:冠军 VB:排球")
    private String gameName;

    /** 玩法 */
    @Excel(name = "玩法")
    private String wtype;

    /** 玩法结果 */
    @Excel(name = "玩法结果")
    private String rtype;

    /** 下注内容 */
    @Excel(name = "下注内容")
    private String orderContent;

    /** 主队名称 */
    @Excel(name = "主队名称")
    private String tnameHome;

    /** 客队名称 */
    @Excel(name = "客队名称")
    private String tnameAway;

    /** 联赛名称 */
    @Excel(name = "联赛名称")
    private String league;

    /** H:主队为强队 C:客队为强队 ''无 */
    @Excel(name = "H:主队为强队 C:客队为强队 ''无")
    private String strong;

    /** 赔率 */
    @Excel(name = "赔率")
    private BigDecimal ioratio;

    /** 有效投注 */
    @Excel(name = "有效投注")
    private BigDecimal effectiveBet;

    /** 总投注额gold */
    @Excel(name = "总投注额gold")
    private BigDecimal allBet;

    /** 输赢金额(纯盈利,不包含本金) */
    @Excel(name = "输赢金额(纯盈利,不包含本金)")
    private BigDecimal profit;

    /** 下注时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date betTime;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    /** 0:未结算 1:已结算 */
    @Excel(name = "0:未结算 1:已结算")
    private Long settleStatus;

    /** 0:无结果 L:输 W:赢 P:合 D:取消 A:还原 */
    @Excel(name = "0:无结果 L:输 W:赢 P:合 D:取消 A:还原")
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

    /** 串数内容 一般是json */
    @Excel(name = "串数内容 一般是json")
    private String parlaysub;

    /** 返回的原始数据 一般是json */
    @Excel(name = "返回的原始数据 一般是json")
    private String rawData;

}
