package com.ruoyi.common.utils;

import cn.hutool.core.util.IdUtil;

/**
 * 生成各类业务订单ID
 */
public class IdUtils {
    public static String getDepositOrderNo() {
        return "D" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getWithdrawOrderNo() {
        return "W" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getPlatInOrderNo() {
        return "IN" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getPlatOutOrderNo() {
        return "OUT" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getTransactionOrderNo() {
        return "T" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getLotteryOrderNo() {
        return "L" + IdUtil.getSnowflakeNextIdStr();
    }

    public static String getPayOrderNo() {
        return "P" + IdUtil.getSnowflakeNextIdStr();
    }
}
