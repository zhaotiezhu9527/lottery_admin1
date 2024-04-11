package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.LotteryOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 投注记录Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILotteryOrderService extends IService<LotteryOrder>
{
    /**
     * 查询投注记录
     * 
     * @param id 投注记录主键
     * @return 投注记录
     */
    public LotteryOrder selectLotteryOrderById(Long id);

    /**
     * 查询投注记录列表
     * 
     * @param lotteryOrder 投注记录
     * @return 投注记录集合
     */
    public List<LotteryOrder> selectLotteryOrderList(LotteryOrder lotteryOrder);

    /**
     * 新增投注记录
     * 
     * @param lotteryOrder 投注记录
     * @return 结果
     */
    public int insertLotteryOrder(LotteryOrder lotteryOrder);

    /**
     * 修改投注记录
     * 
     * @param lotteryOrder 投注记录
     * @return 结果
     */
    public int updateLotteryOrder(LotteryOrder lotteryOrder);

    /**
     * 批量删除投注记录
     * 
     * @param ids 需要删除的投注记录主键集合
     * @return 结果
     */
    public int deleteLotteryOrderByIds(Long[] ids);

    /**
     * 删除投注记录信息
     * 
     * @param id 投注记录主键
     * @return 结果
     */
    public int deleteLotteryOrderById(Long id);
}
