package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.LotteryPlay;

/**
 * 玩法管理Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface LotteryPlayMapper extends BaseMapper<LotteryPlay>
{
    /**
     * 查询玩法管理
     * 
     * @param id 玩法管理主键
     * @return 玩法管理
     */
    public LotteryPlay selectLotteryPlayById(Long id);

    /**
     * 查询玩法管理列表
     * 
     * @param lotteryPlay 玩法管理
     * @return 玩法管理集合
     */
    public List<LotteryPlay> selectLotteryPlayList(LotteryPlay lotteryPlay);

    /**
     * 新增玩法管理
     * 
     * @param lotteryPlay 玩法管理
     * @return 结果
     */
    public int insertLotteryPlay(LotteryPlay lotteryPlay);

    /**
     * 修改玩法管理
     * 
     * @param lotteryPlay 玩法管理
     * @return 结果
     */
    public int updateLotteryPlay(LotteryPlay lotteryPlay);

    /**
     * 删除玩法管理
     * 
     * @param id 玩法管理主键
     * @return 结果
     */
    public int deleteLotteryPlayById(Long id);

    /**
     * 批量删除玩法管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotteryPlayByIds(Long[] ids);
}
