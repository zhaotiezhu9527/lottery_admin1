package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.PayOrderMapper;
import com.ruoyi.lottery.domain.PayOrder;
import com.ruoyi.lottery.service.IPayOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 支付订单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder> implements IPayOrderService
{
    @Autowired
    private PayOrderMapper payOrderMapper;

    /**
     * 查询支付订单
     * 
     * @param id 支付订单主键
     * @return 支付订单
     */
    @Override
    public PayOrder selectPayOrderById(Long id)
    {
        return payOrderMapper.selectPayOrderById(id);
    }

    /**
     * 查询支付订单列表
     * 
     * @param payOrder 支付订单
     * @return 支付订单
     */
    @Override
    public List<PayOrder> selectPayOrderList(PayOrder payOrder)
    {
        return payOrderMapper.selectPayOrderList(payOrder);
    }

    /**
     * 新增支付订单
     * 
     * @param payOrder 支付订单
     * @return 结果
     */
    @Override
    public int insertPayOrder(PayOrder payOrder)
    {
        payOrder.setCreateTime(DateUtils.getNowDate());
        return payOrderMapper.insertPayOrder(payOrder);
    }

    /**
     * 修改支付订单
     * 
     * @param payOrder 支付订单
     * @return 结果
     */
    @Override
    public int updatePayOrder(PayOrder payOrder)
    {
        payOrder.setUpdateTime(DateUtils.getNowDate());
        return payOrderMapper.updatePayOrder(payOrder);
    }

    /**
     * 批量删除支付订单
     * 
     * @param ids 需要删除的支付订单主键
     * @return 结果
     */
    @Override
    public int deletePayOrderByIds(Long[] ids)
    {
        return payOrderMapper.deletePayOrderByIds(ids);
    }

    /**
     * 删除支付订单信息
     * 
     * @param id 支付订单主键
     * @return 结果
     */
    @Override
    public int deletePayOrderById(Long id)
    {
        return payOrderMapper.deletePayOrderById(id);
    }
}
