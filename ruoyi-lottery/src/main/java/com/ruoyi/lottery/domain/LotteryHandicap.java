package com.ruoyi.lottery.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 盘口管理对象 t_lottery_handicap
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_lottery_handicap")
public class LotteryHandicap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 盘口代码 */
    @Excel(name = "盘口代码")
    private String handicapCode;

    /** 盘口名称 */
    @Excel(name = "盘口名称")
    private String handicapName;

    /** 彩种代码 */
    @Excel(name = "彩种代码")
    private String lotteryCode;

    /** 排序号(值越大越靠前) */
    @Excel(name = "排序号(值越大越靠前)")
    private Long pxh;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

}
