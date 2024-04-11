package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LotteryMapper;
import com.ruoyi.lottery.domain.Lottery;
import com.ruoyi.lottery.service.ILotteryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 彩种管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LotteryServiceImpl extends ServiceImpl<LotteryMapper, Lottery> implements ILotteryService
{
    @Autowired
    private LotteryMapper lotteryMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询彩种管理
     * 
     * @param id 彩种管理主键
     * @return 彩种管理
     */
    @Override
    public Lottery selectLotteryById(Long id)
    {
        return lotteryMapper.selectLotteryById(id);
    }

    /**
     * 查询彩种管理列表
     * 
     * @param lottery 彩种管理
     * @return 彩种管理
     */
    @Override
    public List<Lottery> selectLotteryList(Lottery lottery)
    {
        List<Lottery> list = lotteryMapper.selectLotteryList(lottery);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(entity -> entity.setImg(url + entity.getImg()));
        return list;
    }

    /**
     * 新增彩种管理
     * 
     * @param lottery 彩种管理
     * @return 结果
     */
    @Override
    public int insertLottery(Lottery lottery)
    {
        lottery.setCreateTime(DateUtils.getNowDate());
        return lotteryMapper.insertLottery(lottery);
    }

    /**
     * 修改彩种管理
     * 
     * @param lottery 彩种管理
     * @return 结果
     */
    @Override
    public int updateLottery(Lottery lottery)
    {
        lottery.setUpdateTime(DateUtils.getNowDate());
        return lotteryMapper.updateLottery(lottery);
    }

    /**
     * 批量删除彩种管理
     * 
     * @param ids 需要删除的彩种管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryByIds(Long[] ids)
    {
        return lotteryMapper.deleteLotteryByIds(ids);
    }

    /**
     * 删除彩种管理信息
     * 
     * @param id 彩种管理主键
     * @return 结果
     */
    @Override
    public int deleteLotteryById(Long id)
    {
        return lotteryMapper.deleteLotteryById(id);
    }
}
