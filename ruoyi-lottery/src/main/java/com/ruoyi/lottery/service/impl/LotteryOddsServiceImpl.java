package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LotteryOddsMapper;
import com.ruoyi.lottery.domain.LotteryOdds;
import com.ruoyi.lottery.service.ILotteryOddsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 赔率设置Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LotteryOddsServiceImpl extends ServiceImpl<LotteryOddsMapper, LotteryOdds> implements ILotteryOddsService
{
    @Autowired
    private LotteryOddsMapper lotteryOddsMapper;

    /**
     * 查询赔率设置
     * 
     * @param id 赔率设置主键
     * @return 赔率设置
     */
    @Override
    public LotteryOdds selectLotteryOddsById(Long id)
    {
        return lotteryOddsMapper.selectLotteryOddsById(id);
    }

    /**
     * 查询赔率设置列表
     * 
     * @param lotteryOdds 赔率设置
     * @return 赔率设置
     */
    @Override
    public List<LotteryOdds> selectLotteryOddsList(LotteryOdds lotteryOdds)
    {
        return lotteryOddsMapper.selectLotteryOddsList(lotteryOdds);
    }

    /**
     * 新增赔率设置
     * 
     * @param lotteryOdds 赔率设置
     * @return 结果
     */
    @Override
    public int insertLotteryOdds(LotteryOdds lotteryOdds)
    {
        lotteryOdds.setCreateTime(DateUtils.getNowDate());
        return lotteryOddsMapper.insertLotteryOdds(lotteryOdds);
    }

    /**
     * 修改赔率设置
     * 
     * @param lotteryOdds 赔率设置
     * @return 结果
     */
    @Override
    public int updateLotteryOdds(LotteryOdds lotteryOdds)
    {
        lotteryOdds.setUpdateTime(DateUtils.getNowDate());
        return lotteryOddsMapper.updateLotteryOdds(lotteryOdds);
    }

    /**
     * 批量删除赔率设置
     * 
     * @param ids 需要删除的赔率设置主键
     * @return 结果
     */
    @Override
    public int deleteLotteryOddsByIds(Long[] ids)
    {
        return lotteryOddsMapper.deleteLotteryOddsByIds(ids);
    }

    /**
     * 删除赔率设置信息
     * 
     * @param id 赔率设置主键
     * @return 结果
     */
    @Override
    public int deleteLotteryOddsById(Long id)
    {
        return lotteryOddsMapper.deleteLotteryOddsById(id);
    }
}
