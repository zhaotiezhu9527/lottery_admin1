package com.ruoyi.lottery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 分组管理对象 t_group
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_group")
public class Group extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 分组名称 */
    @Excel(name = "分组名称")
    private String groupName;

}
