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
 * banner管理对象 t_banner
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_banner")
public class Banner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** banner图 */
    @Excel(name = "banner图")
    private String img;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 操作人 */
    @Excel(name = "操作人")
    private String operName;

}
