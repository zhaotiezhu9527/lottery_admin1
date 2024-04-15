package com.ruoyi.lottery.business.impl;
import java.math.BigDecimal;
import java.util.Date;

import cn.hutool.core.util.NumberUtil;

import com.ruoyi.common.utils.IdUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.lottery.business.OptMoneyBusiness;
import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.domain.TransactionRecord;
import com.ruoyi.lottery.domain.UserInfo;
import com.ruoyi.lottery.pojo.OptUserMoneyDto;
import com.ruoyi.lottery.service.IDepositService;
import com.ruoyi.lottery.service.ITransactionRecordService;
import com.ruoyi.lottery.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptMoneyBusinessImpl implements OptMoneyBusiness {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IDepositService depositService;

    @Autowired
    private ITransactionRecordService transactionRecordService;

    @Transactional
    @Override
    public void addMoney(UserInfo user, OptUserMoneyDto request) {
        Date now = new Date();
        BigDecimal amount = new BigDecimal(request.getMoney());
        // 给用户加钱
        userInfoService.updateUserBalance(user.getUserName(), amount);

        // 添加充值记录
        Deposit deposit = new Deposit();
        deposit.setUserName(user.getUserName());
        deposit.setOrderNo(IdUtils.getDepositOrderNo());
        deposit.setAmount(amount);
        deposit.setDepositType(6L);
        deposit.setCheckTime(now);
        deposit.setOperName(SecurityUtils.getUsername());
        deposit.setAccountDetail("后台充值");
        deposit.setDepositDetail("后台充值");
        deposit.setStatus(1L);
        deposit.setCreateTime(now);
        deposit.setUpdateTime(now);
        deposit.setRemark("后台充值");
        depositService.save(deposit);

        // 添加流水记录
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setUserName(request.getUserName());
        transactionRecord.setTrxId(IdUtils.getTransactionOrderNo());
        transactionRecord.setAmount(amount);
        transactionRecord.setBeforeAmount(user.getBalance());
        transactionRecord.setAfterAmount(NumberUtil.add(user.getBalance(), amount));
        transactionRecord.setPayType(0L);
        transactionRecord.setBusinessType(9L);
        transactionRecord.setBusinessOrder(deposit.getOrderNo());
        transactionRecord.setOperName(SecurityUtils.getUsername());
        transactionRecord.setCreateTime(now);
        transactionRecord.setRemark("后台充值");
        transactionRecordService.save(transactionRecord);
    }

    @Transactional
    @Override
    public void subMoney(UserInfo user, OptUserMoneyDto request) {
        // 扣除用户金额
        Date now = new Date();
        BigDecimal amount = new BigDecimal(request.getMoney());
        // 给用户加钱
        userInfoService.updateUserBalance(user.getUserName(), amount.negate());
        // 添加流水记录
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setUserName(request.getUserName());
        transactionRecord.setTrxId(IdUtils.getTransactionOrderNo());
        transactionRecord.setAmount(amount.negate());
        transactionRecord.setBeforeAmount(user.getBalance());
        transactionRecord.setAfterAmount(NumberUtil.sub(user.getBalance(), amount));
        transactionRecord.setPayType(1L);
        transactionRecord.setBusinessType(10L);
        transactionRecord.setBusinessOrder(null);
        transactionRecord.setOperName(SecurityUtils.getUsername());
        transactionRecord.setCreateTime(now);
        transactionRecord.setRemark("后台扣款");
        transactionRecordService.save(transactionRecord);
    }
}
