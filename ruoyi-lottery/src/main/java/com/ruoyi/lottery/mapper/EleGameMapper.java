package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.EleGame;

/**
 * 游戏列表Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface EleGameMapper extends BaseMapper<EleGame>
{
    /**
     * 查询游戏列表
     * 
     * @param id 游戏列表主键
     * @return 游戏列表
     */
    public EleGame selectEleGameById(Long id);

    /**
     * 查询游戏列表列表
     * 
     * @param eleGame 游戏列表
     * @return 游戏列表集合
     */
    public List<EleGame> selectEleGameList(EleGame eleGame);

    /**
     * 新增游戏列表
     * 
     * @param eleGame 游戏列表
     * @return 结果
     */
    public int insertEleGame(EleGame eleGame);

    /**
     * 修改游戏列表
     * 
     * @param eleGame 游戏列表
     * @return 结果
     */
    public int updateEleGame(EleGame eleGame);

    /**
     * 删除游戏列表
     * 
     * @param id 游戏列表主键
     * @return 结果
     */
    public int deleteEleGameById(Long id);

    /**
     * 批量删除游戏列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEleGameByIds(Long[] ids);
}
