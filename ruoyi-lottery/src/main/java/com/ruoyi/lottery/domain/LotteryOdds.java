package com.ruoyi.lottery.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 赔率设置对象 t_lottery_odds
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_lottery_odds")
public class LotteryOdds extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 号码代码 */
    @Excel(name = "号码代码")
    private String hmCode;

    /** 号码名称 */
    @Excel(name = "号码名称")
    private String hmName;

    /** 赔率 */
    @Excel(name = "赔率")
    private BigDecimal odds;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 彩种代码 */
    @Excel(name = "彩种代码")
    private String lotteryCode;

    /** 盘口代码 */
    @Excel(name = "盘口代码")
    private String handicapCode;

    /** 盘口名称 */
    @Excel(name = "盘口名称")
    private String handicapName;

    /** 玩法代码 */
    @Excel(name = "玩法代码")
    private String playCode;

    /** 玩法名称 */
    @Excel(name = "玩法名称")
    private String playName;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

    /** 号码分组 */
    @Excel(name = "号码分组")
    private String groupName;

}
