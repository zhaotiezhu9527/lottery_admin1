package com.ruoyi.lottery.pojo;

import lombok.Data;

@Data
public class OptUserMoneyDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 金额
     */
    private String money;

    /**
     * 1：上分 2:下分
     */
    private String type;

    private String remark;
}
