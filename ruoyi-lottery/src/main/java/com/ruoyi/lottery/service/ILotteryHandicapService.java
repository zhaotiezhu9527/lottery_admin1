package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.LotteryHandicap;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 盘口管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILotteryHandicapService extends IService<LotteryHandicap>
{
    /**
     * 查询盘口管理
     * 
     * @param id 盘口管理主键
     * @return 盘口管理
     */
    public LotteryHandicap selectLotteryHandicapById(Long id);

    /**
     * 查询盘口管理列表
     * 
     * @param lotteryHandicap 盘口管理
     * @return 盘口管理集合
     */
    public List<LotteryHandicap> selectLotteryHandicapList(LotteryHandicap lotteryHandicap);

    /**
     * 新增盘口管理
     * 
     * @param lotteryHandicap 盘口管理
     * @return 结果
     */
    public int insertLotteryHandicap(LotteryHandicap lotteryHandicap);

    /**
     * 修改盘口管理
     * 
     * @param lotteryHandicap 盘口管理
     * @return 结果
     */
    public int updateLotteryHandicap(LotteryHandicap lotteryHandicap);

    /**
     * 批量删除盘口管理
     * 
     * @param ids 需要删除的盘口管理主键集合
     * @return 结果
     */
    public int deleteLotteryHandicapByIds(Long[] ids);

    /**
     * 删除盘口管理信息
     * 
     * @param id 盘口管理主键
     * @return 结果
     */
    public int deleteLotteryHandicapById(Long id);
}
