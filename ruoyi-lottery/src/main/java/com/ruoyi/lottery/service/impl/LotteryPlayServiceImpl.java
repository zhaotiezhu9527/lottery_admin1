package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LotteryPlayMapper;
import com.ruoyi.lottery.domain.LotteryPlay;
import com.ruoyi.lottery.service.ILotteryPlayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 玩法管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LotteryPlayServiceImpl extends ServiceImpl<LotteryPlayMapper, LotteryPlay> implements ILotteryPlayService
{
    @Autowired
    private LotteryPlayMapper lotteryPlayMapper;

    /**
     * 查询玩法管理
     * 
     * @param id 玩法管理主键
     * @return 玩法管理
     */
    @Override
    public LotteryPlay selectLotteryPlayById(Long id)
    {
        return lotteryPlayMapper.selectLotteryPlayById(id);
    }

    /**
     * 查询玩法管理列表
     * 
     * @param lotteryPlay 玩法管理
     * @return 玩法管理
     */
    @Override
    public List<LotteryPlay> selectLotteryPlayList(LotteryPlay lotteryPlay)
    {
        return lotteryPlayMapper.selectLotteryPlayList(lotteryPlay);
    }

    /**
     * 新增玩法管理
     * 
     * @param lotteryPlay 玩法管理
     * @return 结果
     */
    @Override
    public int insertLotteryPlay(LotteryPlay lotteryPlay)
    {
        lotteryPlay.setCreateTime(DateUtils.getNowDate());
        return lotteryPlayMapper.insertLotteryPlay(lotteryPlay);
    }

    /**
     * 修改玩法管理
     * 
     * @param lotteryPlay 玩法管理
     * @return 结果
     */
    @Override
    public int updateLotteryPlay(LotteryPlay lotteryPlay)
    {
        lotteryPlay.setUpdateTime(DateUtils.getNowDate());
        return lotteryPlayMapper.updateLotteryPlay(lotteryPlay);
    }

    /**
     * 批量删除玩法管理
     * 
     * @param ids 需要删除的玩法管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryPlayByIds(Long[] ids)
    {
        return lotteryPlayMapper.deleteLotteryPlayByIds(ids);
    }

    /**
     * 删除玩法管理信息
     * 
     * @param id 玩法管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryPlayById(Long id)
    {
        return lotteryPlayMapper.deleteLotteryPlayById(id);
    }
}
