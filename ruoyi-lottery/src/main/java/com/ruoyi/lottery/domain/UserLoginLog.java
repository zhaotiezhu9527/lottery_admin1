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
 * 登录日志对象 t_user_login_log
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_user_login_log")
public class UserLoginLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 登录IP */
    @Excel(name = "登录IP")
    private String loginIp;

    /** 地址详情 */
    @Excel(name = "地址详情")
    private String addrDetail;

    /** 登录域名 */
    @Excel(name = "登录域名")
    private String loginDomain;

}
