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
 * 玩法管理对象 t_lottery_play
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_lottery_play")
public class LotteryPlay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 玩法代码 */
    @Excel(name = "玩法代码")
    private String playCode;

    /** 玩法名称 */
    @Excel(name = "玩法名称")
    private String playName;

    /** 彩票代码 */
    @Excel(name = "彩票代码")
    private String lotteryCode;

    /** 盘口代码 */
    @Excel(name = "盘口代码")
    private String handicapCode;

    /** 玩法提示 */
    @Excel(name = "玩法提示")
    private String wfts;

    /** 中奖说明 */
    @Excel(name = "中奖说明")
    private String zjsm;

    /** 范例 */
    @Excel(name = "范例")
    private String fl;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

}
