package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.ActivityMapper;
import com.ruoyi.lottery.domain.Activity;
import com.ruoyi.lottery.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 活动配置Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService
{
    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 查询活动配置
     * 
     * @param id 活动配置主键
     * @return 活动配置
     */
    @Override
    public Activity selectActivityById(Long id)
    {
        return activityMapper.selectActivityById(id);
    }

    /**
     * 查询活动配置列表
     * 
     * @param activity 活动配置
     * @return 活动配置
     */
    @Override
    public List<Activity> selectActivityList(Activity activity)
    {
        return activityMapper.selectActivityList(activity);
    }

    /**
     * 新增活动配置
     * 
     * @param activity 活动配置
     * @return 结果
     */
    @Override
    public int insertActivity(Activity activity)
    {
        activity.setCreateTime(DateUtils.getNowDate());
        return activityMapper.insertActivity(activity);
    }

    /**
     * 修改活动配置
     * 
     * @param activity 活动配置
     * @return 结果
     */
    @Override
    public int updateActivity(Activity activity)
    {
        activity.setUpdateTime(DateUtils.getNowDate());
        return activityMapper.updateActivity(activity);
    }

    /**
     * 批量删除活动配置
     * 
     * @param ids 需要删除的活动配置主键
     * @return 结果
     */
    @Override
    public int deleteActivityByIds(Long[] ids)
    {
        return activityMapper.deleteActivityByIds(ids);
    }

    /**
     * 删除活动配置信息
     * 
     * @param id 活动配置主键
     * @return 结果
     */
    @Override
    public int deleteActivityById(Long id)
    {
        return activityMapper.deleteActivityById(id);
    }
}
