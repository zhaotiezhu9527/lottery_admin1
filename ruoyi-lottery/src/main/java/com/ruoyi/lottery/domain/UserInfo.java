package com.ruoyi.lottery.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 会员列表对象 t_user_info
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_user_info")
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 余额宝余额 */
    @Excel(name = "余额宝余额")
    private BigDecimal yebBalance;

    /** 余额宝利息 */
    @Excel(name = "余额宝利息")
    private BigDecimal yebInterest;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String loginPwd;

    /** 支付密码 */
    @Excel(name = "支付密码")
    private String payPwd;

    /** 状态(0:正常 1:停用) */
    @Excel(name = "状态(0:正常 1:停用)")
    private Long loginStatus;

    /** 支付状态(0:正常 1:停用) */
    @Excel(name = "支付状态(0:正常 1:停用)")
    private Long payStatus;

    /** 手机号 */
    @Excel(name = "手机号")
    private String userPhone;

    /** 上级代理 */
    @Excel(name = "上级代理")
    private String userAgent;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String referralCode;

    /** 用户头像ID */
    @Excel(name = "用户头像ID")
    private Long avatarId;

    /** 等级ID */
    @Excel(name = "等级ID")
    private Long levelId;

    /** 分组ID */
    @Excel(name = "分组ID")
    private Long groupId;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    /** 最后登录IP */
    @Excel(name = "最后登录IP")
    private String lastIp;

    /** 注册IP */
    @Excel(name = "注册IP")
    private String registerIp;

}
