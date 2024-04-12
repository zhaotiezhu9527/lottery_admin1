package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LevelMapper;
import com.ruoyi.lottery.domain.Level;
import com.ruoyi.lottery.service.ILevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 等级管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements ILevelService
{
    @Autowired
    private LevelMapper levelMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询等级管理
     * 
     * @param id 等级管理主键
     * @return 等级管理
     */
    @Override
    public Level selectLevelById(Long id)
    {
        return levelMapper.selectLevelById(id);
    }

    /**
     * 查询等级管理列表
     * 
     * @param level 等级管理
     * @return 等级管理
     */
    @Override
    public List<Level> selectLevelList(Level level)
    {
        List<Level> list = levelMapper.selectLevelList(level);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(l -> l.setLevelImg(url + l.getLevelImg()));
        return list;
    }

    /**
     * 新增等级管理
     * 
     * @param level 等级管理
     * @return 结果
     */
    @Override
    public int insertLevel(Level level)
    {
        level.setCreateTime(DateUtils.getNowDate());
        return levelMapper.insertLevel(level);
    }

    /**
     * 修改等级管理
     * 
     * @param level 等级管理
     * @return 结果
     */
    @Override
    public int updateLevel(Level level)
    {
        return levelMapper.updateLevel(level);
    }

    /**
     * 批量删除等级管理
     * 
     * @param ids 需要删除的等级管理主键
     * @return 结果
     */
    @Override
    public int deleteLevelByIds(Long[] ids)
    {
        return levelMapper.deleteLevelByIds(ids);
    }

    /**
     * 删除等级管理信息
     * 
     * @param id 等级管理主键
     * @return 结果
     */
    @Override
    public int deleteLevelById(Long id)
    {
        return levelMapper.deleteLevelById(id);
    }
}
