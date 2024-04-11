package com.ruoyi.lottery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 头像管理对象 t_avatar
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_avatar")
public class Avatar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatarImg;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 排序号(值越大越靠前) */
    @Excel(name = "排序号(值越大越靠前)")
    private Long pxh;

}
