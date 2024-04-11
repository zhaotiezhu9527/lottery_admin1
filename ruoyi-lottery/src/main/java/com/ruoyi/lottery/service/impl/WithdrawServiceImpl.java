package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.WithdrawMapper;
import com.ruoyi.lottery.domain.Withdraw;
import com.ruoyi.lottery.service.IWithdrawService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 提现订单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class WithdrawServiceImpl extends ServiceImpl<WithdrawMapper, Withdraw> implements IWithdrawService
{
    @Autowired
    private WithdrawMapper withdrawMapper;

    /**
     * 查询提现订单
     * 
     * @param id 提现订单主键
     * @return 提现订单
     */
    @Override
    public Withdraw selectWithdrawById(Long id)
    {
        return withdrawMapper.selectWithdrawById(id);
    }

    /**
     * 查询提现订单列表
     * 
     * @param withdraw 提现订单
     * @return 提现订单
     */
    @Override
    public List<Withdraw> selectWithdrawList(Withdraw withdraw)
    {
        return withdrawMapper.selectWithdrawList(withdraw);
    }

    /**
     * 新增提现订单
     * 
     * @param withdraw 提现订单
     * @return 结果
     */
    @Override
    public int insertWithdraw(Withdraw withdraw)
    {
        withdraw.setCreateTime(DateUtils.getNowDate());
        return withdrawMapper.insertWithdraw(withdraw);
    }

    /**
     * 修改提现订单
     * 
     * @param withdraw 提现订单
     * @return 结果
     */
    @Override
    public int updateWithdraw(Withdraw withdraw)
    {
        withdraw.setUpdateTime(DateUtils.getNowDate());
        return withdrawMapper.updateWithdraw(withdraw);
    }

    /**
     * 批量删除提现订单
     * 
     * @param ids 需要删除的提现订单主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawByIds(Long[] ids)
    {
        return withdrawMapper.deleteWithdrawByIds(ids);
    }

    /**
     * 删除提现订单信息
     * 
     * @param id 提现订单主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawById(Long id)
    {
        return withdrawMapper.deleteWithdrawById(id);
    }
}
