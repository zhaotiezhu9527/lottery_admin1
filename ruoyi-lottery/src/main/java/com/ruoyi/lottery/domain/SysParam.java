package com.ruoyi.lottery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 系统参数对象 t_sys_param
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_sys_param")
public class SysParam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 参数KEY */
    @Excel(name = "参数KEY")
    private String paramKey;

    /** 参数值 */
    @Excel(name = "参数值")
    private String paramValue;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

}
