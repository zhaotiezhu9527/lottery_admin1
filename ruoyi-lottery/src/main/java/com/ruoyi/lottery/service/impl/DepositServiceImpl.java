package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.DepositMapper;
import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.service.IDepositService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 充值订单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class DepositServiceImpl extends ServiceImpl<DepositMapper, Deposit> implements IDepositService
{
    @Autowired
    private DepositMapper depositMapper;

    /**
     * 查询充值订单
     * 
     * @param id 充值订单主键
     * @return 充值订单
     */
    @Override
    public Deposit selectDepositById(Long id)
    {
        return depositMapper.selectDepositById(id);
    }

    /**
     * 查询充值订单列表
     * 
     * @param deposit 充值订单
     * @return 充值订单
     */
    @Override
    public List<Deposit> selectDepositList(Deposit deposit)
    {
        return depositMapper.selectDepositList(deposit);
    }

    /**
     * 新增充值订单
     * 
     * @param deposit 充值订单
     * @return 结果
     */
    @Override
    public int insertDeposit(Deposit deposit)
    {
        deposit.setCreateTime(DateUtils.getNowDate());
        return depositMapper.insertDeposit(deposit);
    }

    /**
     * 修改充值订单
     * 
     * @param deposit 充值订单
     * @return 结果
     */
    @Override
    public int updateDeposit(Deposit deposit)
    {
        deposit.setUpdateTime(DateUtils.getNowDate());
        return depositMapper.updateDeposit(deposit);
    }

    /**
     * 批量删除充值订单
     * 
     * @param ids 需要删除的充值订单主键
     * @return 结果
     */
    @Override
    public int deleteDepositByIds(Long[] ids)
    {
        return depositMapper.deleteDepositByIds(ids);
    }

    /**
     * 删除充值订单信息
     * 
     * @param id 充值订单主键
     * @return 结果
     */
    @Override
    public int deleteDepositById(Long id)
    {
        return depositMapper.deleteDepositById(id);
    }
}
