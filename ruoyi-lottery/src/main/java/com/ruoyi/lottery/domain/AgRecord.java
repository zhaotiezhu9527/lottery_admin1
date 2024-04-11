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
 * AG注单对象 t_ag_record
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_ag_record")
public class AgRecord extends BaseEntity
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

    /** 注单号码 */
    @Excel(name = "注单号码")
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

    /** 派彩金额(不包含本金) */
    @Excel(name = "派彩金额(不包含本金)")
    private BigDecimal profit;

    /** 下注时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date betTime;

    /** 下注时间美东 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下注时间美东", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date wagersDate;

    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date settleTime;

    /** 结算时间美东 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间美东", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;

    /** 0：异常(请联系客服) 1：已派彩 -8：取消指定局注单 -9：取消指定注单 */
    @Excel(name = "0：异常(请联系客服) 1：已派彩 -8：取消指定局注单 -9：取消指定注单")
    private String resultStatus;

    /** 局号gameCode */
    @Excel(name = "局号gameCode")
    private String serialId;

    /** 1:视讯 2:电子 3:捕鱼 */
    @Excel(name = "1:视讯 2:电子 3:捕鱼")
    private Long gameType;

}
