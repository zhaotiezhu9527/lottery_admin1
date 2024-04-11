package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.Platform;

/**
 * 平台管理Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface PlatformMapper extends BaseMapper<Platform>
{
    /**
     * 查询平台管理
     * 
     * @param id 平台管理主键
     * @return 平台管理
     */
    public Platform selectPlatformById(Long id);

    /**
     * 查询平台管理列表
     * 
     * @param platform 平台管理
     * @return 平台管理集合
     */
    public List<Platform> selectPlatformList(Platform platform);

    /**
     * 新增平台管理
     * 
     * @param platform 平台管理
     * @return 结果
     */
    public int insertPlatform(Platform platform);

    /**
     * 修改平台管理
     * 
     * @param platform 平台管理
     * @return 结果
     */
    public int updatePlatform(Platform platform);

    /**
     * 删除平台管理
     * 
     * @param id 平台管理主键
     * @return 结果
     */
    public int deletePlatformById(Long id);

    /**
     * 批量删除平台管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlatformByIds(Long[] ids);
}
