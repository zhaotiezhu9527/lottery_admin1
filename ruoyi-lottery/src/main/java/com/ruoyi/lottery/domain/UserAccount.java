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
 * 收款方式对象 t_user_account
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Data
@TableName(value ="t_user_account")
public class UserAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 1:银行卡 2:微信 3:支付宝 4:虚拟货币 */
    @Excel(name = "1:银行卡 2:微信 3:支付宝 4:虚拟货币")
    private Long accountType;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String channelName;

    /** 账号地址 */
    @Excel(name = "账号地址")
    private String accountNo;

    /** 开户网点 */
    @Excel(name = "开户网点")
    private String address;

    /** 持卡人姓名 */
    @Excel(name = "持卡人姓名")
    private String realName;

}
