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
 * 三方用户对象 t_user_plat
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_user_plat")
public class UserPlat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 平台代码 */
    @Excel(name = "平台代码")
    private String platCode;

    /** 平台游戏账号 */
    @Excel(name = "平台游戏账号")
    private String platUserName;

    /** 平台游戏密码 */
    private String platUserPassword;

    /** 0:正常 1:停用 */
    @Excel(name = "0:正常 1:停用")
    private Long status;

}
