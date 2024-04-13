package com.ruoyi.lottery.business.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.IdUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.lottery.business.CheckBusiness;
import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.domain.TransactionRecord;
import com.ruoyi.lottery.domain.UserInfo;
import com.ruoyi.lottery.domain.Withdraw;
import com.ruoyi.lottery.pojo.DepositCheckDto;
import com.ruoyi.lottery.pojo.WithdrawCheckDto;
import com.ruoyi.lottery.service.IDepositService;
import com.ruoyi.lottery.service.ITransactionRecordService;
import com.ruoyi.lottery.service.IUserInfoService;
import com.ruoyi.lottery.service.IWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 充提审核
 */
@Service
public class CheckBusinessImpl implements CheckBusiness {

    @Autowired
    private IDepositService depositService;

    @Autowired
    private IWithdrawService withdrawService;

    @Autowired
    private ITransactionRecordService transactionRecordService;

    @Autowired
    private IUserInfoService userInfoService;

    @Transactional
    @Override
    public void depositCheck(DepositCheckDto request, Deposit deposit) {
        Date now = new Date();
        int status = 2;
        if (StringUtils.equals(request.getStatus(), "1")) {
            status = 1;
            // 审核通过
            UserInfo userInfo = userInfoService.getUserByName(deposit.getUserName());
            // 给用户加钱
            userInfoService.updateUserBalance(deposit.getUserName(), deposit.getAmount());
            // 流水记录
            TransactionRecord record = new TransactionRecord();
            record.setUserName(deposit.getUserName());
            record.setTrxId(IdUtils.getTransactionOrderNo());
            record.setAmount(deposit.getAmount());
            record.setBeforeAmount(userInfo.getBalance());
            record.setAfterAmount(NumberUtil.add(userInfo.getBalance(), deposit.getAmount()));
            record.setPayType(0L);
            record.setBusinessType(0L);
            record.setBusinessOrder(deposit.getOrderNo());
            record.setOperName(SecurityUtils.getUsername());
            record.setCreateTime(now);
            record.setRemark(request.getRemark());
            transactionRecordService.save(record);
        }

        // 修改订单状态
        boolean update = depositService.update(
                new LambdaUpdateWrapper<Deposit>()
                        .set(Deposit::getCheckTime, now)
                        .set(Deposit::getUpdateTime, now)
                        .set(Deposit::getOperName, SecurityUtils.getUsername())
                        .set(StringUtils.isNotEmpty(request.getRemark()), Deposit::getRemark, request.getRemark())
                        .set(Deposit::getStatus, status)
                        .eq(Deposit::getId, deposit.getId())
                        .set(Deposit::getStatus, 0)
        );
        if (!update) {
            throw new ServiceException("修改订单失败");
        }
    }

    @Override
    public void withdrawCheck(WithdrawCheckDto request, Withdraw withdraw) {
        Date now = new Date();
        int status = 1;
        if (StringUtils.equals(request.getStatus(), "2")) {
            status = 2;
            // 审核拒绝
            UserInfo userInfo = userInfoService.getUserByName(withdraw.getUserName());
            // 给用户退钱
            userInfoService.updateUserBalance(withdraw.getUserName(), withdraw.getAmount());
            // 流水记录
            TransactionRecord record = new TransactionRecord();
            record.setUserName(withdraw.getUserName());
            record.setTrxId(IdUtils.getTransactionOrderNo());
            record.setAmount(withdraw.getAmount());
            record.setBeforeAmount(userInfo.getBalance());
            record.setAfterAmount(NumberUtil.sub(userInfo.getBalance(), withdraw.getAmount()));
            record.setPayType(0L);
            record.setBusinessType(12L);
            record.setBusinessOrder(withdraw.getOrderNo());
            record.setOperName(SecurityUtils.getUsername());
            record.setCreateTime(now);
            record.setRemark(request.getRemark());
            transactionRecordService.save(record);
        }

        // 修改订单状态
        boolean update = withdrawService.update(
                new LambdaUpdateWrapper<Withdraw>()
                        .set(Withdraw::getCheckTime, now)
                        .set(Withdraw::getUpdateTime, now)
                        .set(Withdraw::getOperName, SecurityUtils.getUsername())
                        .set(StringUtils.isNotEmpty(request.getRemark()), Withdraw::getRemark, request.getRemark())
                        .set(Withdraw::getStatus, status)
                        .eq(Withdraw::getId, withdraw.getId())
                        .set(Withdraw::getStatus, 0)
        );
        if (!update) {
            throw new ServiceException("修改订单失败");
        }
    }
}
