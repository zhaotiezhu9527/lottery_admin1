package com.ruoyi.lottery.domain;

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
 * 1分六合彩开奖对象 t_openresult_gs1mlhc
 * 
 * @author hardy
 * @date 2024-04-12
 */
@Data
@TableName(value ="t_openresult_gs1mlhc")
public class OpenresultGs1mlhc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 期号 */
    @Excel(name = "期号")
    private String qs;

    /** 三方期号 */
    @Excel(name = "三方期号")
    private String platQs;

    /** 开奖号码 */
    @Excel(name = "开奖号码")
    private String openResult;

    /** 0:已开奖 1:未开奖 */
    @Excel(name = "是否开奖", readConverterExp = "0=已开奖,1=未开奖")
    private Long openStatus;

    /** 当前第N期 */
    @Excel(name = "当前第N期")
    private Long currCount;

    /** 开盘时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开盘时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date openTime;

    /** 封盘时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "封盘时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

    /** 开奖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开奖时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date openResultTime;

}
