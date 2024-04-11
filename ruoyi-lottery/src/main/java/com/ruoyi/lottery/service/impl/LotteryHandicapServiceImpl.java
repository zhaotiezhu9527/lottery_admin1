package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LotteryHandicapMapper;
import com.ruoyi.lottery.domain.LotteryHandicap;
import com.ruoyi.lottery.service.ILotteryHandicapService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 盘口管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LotteryHandicapServiceImpl extends ServiceImpl<LotteryHandicapMapper, LotteryHandicap> implements ILotteryHandicapService
{
    @Autowired
    private LotteryHandicapMapper lotteryHandicapMapper;

    /**
     * 查询盘口管理
     * 
     * @param id 盘口管理主键
     * @return 盘口管理
     */
    @Override
    public LotteryHandicap selectLotteryHandicapById(Long id)
    {
        return lotteryHandicapMapper.selectLotteryHandicapById(id);
    }

    /**
     * 查询盘口管理列表
     * 
     * @param lotteryHandicap 盘口管理
     * @return 盘口管理
     */
    @Override
    public List<LotteryHandicap> selectLotteryHandicapList(LotteryHandicap lotteryHandicap)
    {
        return lotteryHandicapMapper.selectLotteryHandicapList(lotteryHandicap);
    }

    /**
     * 新增盘口管理
     * 
     * @param lotteryHandicap 盘口管理
     * @return 结果
     */
    @Override
    public int insertLotteryHandicap(LotteryHandicap lotteryHandicap)
    {
        lotteryHandicap.setCreateTime(DateUtils.getNowDate());
        return lotteryHandicapMapper.insertLotteryHandicap(lotteryHandicap);
    }

    /**
     * 修改盘口管理
     * 
     * @param lotteryHandicap 盘口管理
     * @return 结果
     */
    @Override
    public int updateLotteryHandicap(LotteryHandicap lotteryHandicap)
    {
        lotteryHandicap.setUpdateTime(DateUtils.getNowDate());
        return lotteryHandicapMapper.updateLotteryHandicap(lotteryHandicap);
    }

    /**
     * 批量删除盘口管理
     * 
     * @param ids 需要删除的盘口管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryHandicapByIds(Long[] ids)
    {
        return lotteryHandicapMapper.deleteLotteryHandicapByIds(ids);
    }

    /**
     * 删除盘口管理信息
     * 
     * @param id 盘口管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryHandicapById(Long id)
    {
        return lotteryHandicapMapper.deleteLotteryHandicapById(id);
    }
}
