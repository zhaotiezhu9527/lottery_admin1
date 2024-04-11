package com.ruoyi.lottery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 游戏列表对象 t_ele_game
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_ele_game")
public class EleGame extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 平台代码 */
    @Excel(name = "平台代码")
    private String platCode;

    /** 子平台代码 */
    @Excel(name = "子平台代码")
    private String platSubCode;

    /** 游戏代码 */
    @Excel(name = "游戏代码")
    private String gameCode;

    /** 游戏名称 */
    @Excel(name = "游戏名称")
    private String gameName;

    /** 游戏图标 */
    @Excel(name = "游戏图标")
    private String img;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long pxh;

}
