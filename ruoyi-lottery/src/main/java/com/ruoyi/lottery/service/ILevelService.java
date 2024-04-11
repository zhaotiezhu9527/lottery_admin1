package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Level;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 等级管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILevelService extends IService<Level>
{
    /**
     * 查询等级管理
     * 
     * @param id 等级管理主键
     * @return 等级管理
     */
    public Level selectLevelById(Long id);

    /**
     * 查询等级管理列表
     * 
     * @param level 等级管理
     * @return 等级管理集合
     */
    public List<Level> selectLevelList(Level level);

    /**
     * 新增等级管理
     * 
     * @param level 等级管理
     * @return 结果
     */
    public int insertLevel(Level level);

    /**
     * 修改等级管理
     * 
     * @param level 等级管理
     * @return 结果
     */
    public int updateLevel(Level level);

    /**
     * 批量删除等级管理
     * 
     * @param ids 需要删除的等级管理主键集合
     * @return 结果
     */
    public int deleteLevelByIds(Long[] ids);

    /**
     * 删除等级管理信息
     * 
     * @param id 等级管理主键
     * @return 结果
     */
    public int deleteLevelById(Long id);
}
