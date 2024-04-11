package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 平台管理对象 t_platform
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_platform")
public class Platform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 平台大类 */
    @Excel(name = "平台大类")
    private String platCode;

    /** 平台名称 */
    @Excel(name = "平台名称")
    private String platName;

    /** 平台子类 */
    @Excel(name = "平台子类")
    private String subPlatCode;

    /** 子平台名称 */
    @Excel(name = "子平台名称")
    private String subPlatName;

    /** 平台类型 1:真人 2:电子 3:体育 4:棋牌 5:捕鱼 */
    @Excel(name = "平台类型 1:真人 2:电子 3:体育 4:棋牌 5:捕鱼")
    private Long platType;

    /** 返水比例 */
    @Excel(name = "返水比例")
    private BigDecimal ratio;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 0:正常 1:维护 */
    @Excel(name = "0:正常 1:维护")
    private Long maintenanceStatus;

    /** 维护信息 */
    @Excel(name = "维护信息")
    private String maintenanceMsg;

    /** 图标 */
    @Excel(name = "图标")
    private String img1;

    /** 排序(值越大越靠前) */
    @Excel(name = "排序(值越大越靠前)")
    private Long pxh;

}
