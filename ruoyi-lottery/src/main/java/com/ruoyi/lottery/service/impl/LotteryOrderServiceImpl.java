package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LotteryOrderMapper;
import com.ruoyi.lottery.domain.LotteryOrder;
import com.ruoyi.lottery.service.ILotteryOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 投注记录Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LotteryOrderServiceImpl extends ServiceImpl<LotteryOrderMapper, LotteryOrder> implements ILotteryOrderService
{
    @Autowired
    private LotteryOrderMapper lotteryOrderMapper;

    /**
     * 查询投注记录
     * 
     * @param id 投注记录主键
     * @return 投注记录
     */
    @Override
    public LotteryOrder selectLotteryOrderById(Long id)
    {
        return lotteryOrderMapper.selectLotteryOrderById(id);
    }

    /**
     * 查询投注记录列表
     * 
     * @param lotteryOrder 投注记录
     * @return 投注记录
     */
    @Override
    public List<LotteryOrder> selectLotteryOrderList(LotteryOrder lotteryOrder)
    {
        return lotteryOrderMapper.selectLotteryOrderList(lotteryOrder);
    }

    /**
     * 新增投注记录
     * 
     * @param lotteryOrder 投注记录
     * @return 结果
     */
    @Override
    public int insertLotteryOrder(LotteryOrder lotteryOrder)
    {
        return lotteryOrderMapper.insertLotteryOrder(lotteryOrder);
    }

    /**
     * 修改投注记录
     * 
     * @param lotteryOrder 投注记录
     * @return 结果
     */
    @Override
    public int updateLotteryOrder(LotteryOrder lotteryOrder)
    {
        lotteryOrder.setUpdateTime(DateUtils.getNowDate());
        return lotteryOrderMapper.updateLotteryOrder(lotteryOrder);
    }

    /**
     * 批量删除投注记录
     * 
     * @param ids 需要删除的投注记录主键
     * @return 结果
     */
    @Override
    public int deleteLotteryOrderByIds(Long[] ids)
    {
        return lotteryOrderMapper.deleteLotteryOrderByIds(ids);
    }

    /**
     * 删除投注记录信息
     * 
     * @param id 投注记录主键
     * @return 结果
     */
    @Override
    public int deleteLotteryOrderById(Long id)
    {
        return lotteryOrderMapper.deleteLotteryOrderById(id);
    }
}
