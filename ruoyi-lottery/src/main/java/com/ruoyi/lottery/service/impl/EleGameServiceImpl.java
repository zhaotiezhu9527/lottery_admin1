package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.EleGameMapper;
import com.ruoyi.lottery.domain.EleGame;
import com.ruoyi.lottery.service.IEleGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 游戏列表Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class EleGameServiceImpl extends ServiceImpl<EleGameMapper, EleGame> implements IEleGameService
{
    @Autowired
    private EleGameMapper eleGameMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询游戏列表
     * 
     * @param id 游戏列表主键
     * @return 游戏列表
     */
    @Override
    public EleGame selectEleGameById(Long id)
    {
        EleGame eleGame = eleGameMapper.selectEleGameById(id);
        String url = sysParamService.getParamByKey("resource_domain");
        eleGame.setImg(url + eleGame.getImg());
        return eleGame;
    }

    /**
     * 查询游戏列表列表
     * 
     * @param eleGame 游戏列表
     * @return 游戏列表
     */
    @Override
    public List<EleGame> selectEleGameList(EleGame eleGame)
    {
        List<EleGame> list = eleGameMapper.selectEleGameList(eleGame);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(e -> e.setImg(url + e.getImg()));
        return list;
    }

    /**
     * 新增游戏列表
     * 
     * @param eleGame 游戏列表
     * @return 结果
     */
    @Override
    public int insertEleGame(EleGame eleGame)
    {
        eleGame.setCreateTime(DateUtils.getNowDate());
        return eleGameMapper.insertEleGame(eleGame);
    }

    /**
     * 修改游戏列表
     * 
     * @param eleGame 游戏列表
     * @return 结果
     */
    @Override
    public int updateEleGame(EleGame eleGame)
    {
        eleGame.setUpdateTime(DateUtils.getNowDate());
        return eleGameMapper.updateEleGame(eleGame);
    }

    /**
     * 批量删除游戏列表
     * 
     * @param ids 需要删除的游戏列表主键
     * @return 结果
     */
    @Override
    public int deleteEleGameByIds(Long[] ids)
    {
        return eleGameMapper.deleteEleGameByIds(ids);
    }

    /**
     * 删除游戏列表信息
     * 
     * @param id 游戏列表主键
     * @return 结果
     */
    @Override
    public int deleteEleGameById(Long id)
    {
        return eleGameMapper.deleteEleGameById(id);
    }
}
