package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Platform;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 平台管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IPlatformService extends IService<Platform>
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
     * 批量删除平台管理
     * 
     * @param ids 需要删除的平台管理主键集合
     * @return 结果
     */
    public int deletePlatformByIds(Long[] ids);

    /**
     * 删除平台管理信息
     * 
     * @param id 平台管理主键
     * @return 结果
     */
    public int deletePlatformById(Long id);
}
