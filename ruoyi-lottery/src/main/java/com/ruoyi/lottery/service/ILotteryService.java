package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Lottery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 彩种管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILotteryService extends IService<Lottery>
{
    /**
     * 查询彩种管理
     * 
     * @param id 彩种管理主键
     * @return 彩种管理
     */
    public Lottery selectLotteryById(Long id);

    /**
     * 查询彩种管理列表
     * 
     * @param lottery 彩种管理
     * @return 彩种管理集合
     */
    public List<Lottery> selectLotteryList(Lottery lottery);

    /**
     * 新增彩种管理
     * 
     * @param lottery 彩种管理
     * @return 结果
     */
    public int insertLottery(Lottery lottery);

    /**
     * 修改彩种管理
     * 
     * @param lottery 彩种管理
     * @return 结果
     */
    public int updateLottery(Lottery lottery);

    /**
     * 批量删除彩种管理
     * 
     * @param ids 需要删除的彩种管理主键集合
     * @return 结果
     */
    public int deleteLotteryByIds(Long[] ids);

    /**
     * 删除彩种管理信息
     * 
     * @param id 彩种管理主键
     * @return 结果
     */
    public int deleteLotteryById(Long id);
}
