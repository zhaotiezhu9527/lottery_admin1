package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.LotteryOrder;

/**
 * 投注记录Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface LotteryOrderMapper extends BaseMapper<LotteryOrder>
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
     * 删除投注记录
     * 
     * @param id 投注记录主键
     * @return 结果
     */
    public int deleteLotteryOrderById(Long id);

    /**
     * 批量删除投注记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotteryOrderByIds(Long[] ids);
}
