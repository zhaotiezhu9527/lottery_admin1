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
 * 彩种管理对象 t_lottery
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_lottery")
public class Lottery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 彩种代码 */
    @Excel(name = "彩种代码")
    private String lotteryCode;

    /** 彩种名称 */
    @Excel(name = "彩种名称")
    private String lotteryName;

    /** 9:00-23:50(全天开奖不用填) */
    @Excel(name = "9:00-23:50(全天开奖不用填)")
    private String dayOpen;

    /** 0:启用 1:停用 */
    @Excel(name = "是否启用", readConverterExp = "o=启用,1=停用")
    private Long status;

    /** 彩种图标 */
    @Excel(name = "彩种图标")
    private String img;

    /** 提前封盘时间 */
    @Excel(name = "提前封盘时间")
    private Long closeTime;

    /** 排序号(值越大越靠前) */
    @Excel(name = "排序号(值越大越靠前)")
    private Long pxh;

    /** 1:快3 2:时时彩 3:PK10 4:六合彩 5:PC蛋蛋 6:11选5 7:福彩3D 8:快乐8 */
    @Excel(name = "彩票类型", readConverterExp = "1=快3,2=时时彩,3=PK10,4=六合彩,5=PC蛋蛋,6=11选5,7=福彩3D,8=快乐8")
    private Long lotteryType;

    /** 一天多少期 */
    @Excel(name = "一天多少期")
    private Long dayCount;

    /** 第一期开奖时间 */
    @Excel(name = "第一期开奖时间")
    private String firstQsTime;

    /** 多少分钟一期 */
    @Excel(name = "多少分钟一期")
    private Long qsTime;

    /** 昨天最后一期期号（bjkl8,bjpk10,pcdd排期使用) */
    @Excel(name = "昨天最后一期期号", readConverterExp = "昨天最后一期期号（bjkl8,bjpk10,pcdd排期使用)")
    private String yesterdayQs;

}
