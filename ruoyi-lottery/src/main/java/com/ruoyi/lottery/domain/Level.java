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
 * 等级管理对象 t_level
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_level")
public class Level extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 等级名称 */
    @Excel(name = "等级名称")
    private String levelName;

    /** 等级图标 */
    @Excel(name = "等级图标")
    private String levelImg;

}
