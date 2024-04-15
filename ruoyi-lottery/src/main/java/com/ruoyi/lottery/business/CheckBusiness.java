package com.ruoyi.lottery.business;

import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.domain.Withdraw;
import com.ruoyi.lottery.pojo.DepositCheckDto;
import com.ruoyi.lottery.pojo.WithdrawCheckDto;

/**
 * 充提审核
 */
public interface CheckBusiness {

    void depositCheck(DepositCheckDto request, Deposit deposit);

    void withdrawCheck(WithdrawCheckDto request, Withdraw withdraw);
}
