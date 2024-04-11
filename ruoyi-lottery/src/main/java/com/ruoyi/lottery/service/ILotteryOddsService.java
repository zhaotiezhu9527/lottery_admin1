package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.LotteryOdds;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 赔率设置Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILotteryOddsService extends IService<LotteryOdds>
{
    /**
     * 查询赔率设置
     * 
     * @param id 赔率设置主键
     * @return 赔率设置
     */
    public LotteryOdds selectLotteryOddsById(Long id);

    /**
     * 查询赔率设置列表
     * 
     * @param lotteryOdds 赔率设置
     * @return 赔率设置集合
     */
    public List<LotteryOdds> selectLotteryOddsList(LotteryOdds lotteryOdds);

    /**
     * 新增赔率设置
     * 
     * @param lotteryOdds 赔率设置
     * @return 结果
     */
    public int insertLotteryOdds(LotteryOdds lotteryOdds);

    /**
     * 修改赔率设置
     * 
     * @param lotteryOdds 赔率设置
     * @return 结果
     */
    public int updateLotteryOdds(LotteryOdds lotteryOdds);

    /**
     * 批量删除赔率设置
     * 
     * @param ids 需要删除的赔率设置主键集合
     * @return 结果
     */
    public int deleteLotteryOddsByIds(Long[] ids);

    /**
     * 删除赔率设置信息
     * 
     * @param id 赔率设置主键
     * @return 结果
     */
    public int deleteLotteryOddsById(Long id);
}
