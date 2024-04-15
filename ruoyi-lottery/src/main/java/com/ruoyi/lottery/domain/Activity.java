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
 * 活动配置对象 t_activity
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_activity")
public class Activity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 活动标题 */
    @Excel(name = "活动标题")
    private String title;

    /** 封面图 */
    @Excel(name = "封面图")
    private String img1;

    /** 内容图 */
    @Excel(name = "内容图")
    private String img2;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

    /** 排序号 */
    private Long pxh;

}
