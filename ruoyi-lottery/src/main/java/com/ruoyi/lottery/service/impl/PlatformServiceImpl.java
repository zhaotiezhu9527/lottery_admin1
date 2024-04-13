package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.PlatformMapper;
import com.ruoyi.lottery.domain.Platform;
import com.ruoyi.lottery.service.IPlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 平台管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, Platform> implements IPlatformService
{
    @Autowired
    private PlatformMapper platformMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询平台管理
     * 
     * @param id 平台管理主键
     * @return 平台管理
     */
    @Override
    public Platform selectPlatformById(Long id)
    {
        return platformMapper.selectPlatformById(id);
    }

    /**
     * 查询平台管理列表
     * 
     * @param platform 平台管理
     * @return 平台管理
     */
    @Override
    public List<Platform> selectPlatformList(Platform platform)
    {
        List<Platform> list = platformMapper.selectPlatformList(platform);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(p -> p.setImg1(url + p.getImg1()));
        return list;
    }

    /**
     * 新增平台管理
     * 
     * @param platform 平台管理
     * @return 结果
     */
    @Override
    public int insertPlatform(Platform platform)
    {
        platform.setCreateTime(DateUtils.getNowDate());
        return platformMapper.insertPlatform(platform);
    }

    /**
     * 修改平台管理
     * 
     * @param platform 平台管理
     * @return 结果
     */
    @Override
    public int updatePlatform(Platform platform)
    {
        platform.setUpdateTime(DateUtils.getNowDate());
        return platformMapper.updatePlatform(platform);
    }

    /**
     * 批量删除平台管理
     * 
     * @param ids 需要删除的平台管理主键
     * @return 结果
     */
    @Override
    public int deletePlatformByIds(Long[] ids)
    {
        return platformMapper.deletePlatformByIds(ids);
    }

    /**
     * 删除平台管理信息
     * 
     * @param id 平台管理主键
     * @return 结果
     */
    @Override
    public int deletePlatformById(Long id)
    {
        return platformMapper.deletePlatformById(id);
    }
}
