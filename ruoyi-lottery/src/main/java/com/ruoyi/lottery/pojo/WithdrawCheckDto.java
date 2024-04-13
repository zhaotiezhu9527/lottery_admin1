package com.ruoyi.lottery.pojo;

import lombok.Data;

@Data
public class WithdrawCheckDto {
    /**
     * 订单ID
     */
    private String id;
    /**
     * 1：通过 2:拒绝
     */
    private String status;

    private String remark;
}
