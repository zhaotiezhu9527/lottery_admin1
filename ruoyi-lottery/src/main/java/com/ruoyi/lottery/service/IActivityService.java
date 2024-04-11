package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 活动配置Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IActivityService extends IService<Activity>
{
    /**
     * 查询活动配置
     * 
     * @param id 活动配置主键
     * @return 活动配置
     */
    public Activity selectActivityById(Long id);

    /**
     * 查询活动配置列表
     * 
     * @param activity 活动配置
     * @return 活动配置集合
     */
    public List<Activity> selectActivityList(Activity activity);

    /**
     * 新增活动配置
     * 
     * @param activity 活动配置
     * @return 结果
     */
    public int insertActivity(Activity activity);

    /**
     * 修改活动配置
     * 
     * @param activity 活动配置
     * @return 结果
     */
    public int updateActivity(Activity activity);

    /**
     * 批量删除活动配置
     * 
     * @param ids 需要删除的活动配置主键集合
     * @return 结果
     */
    public int deleteActivityByIds(Long[] ids);

    /**
     * 删除活动配置信息
     * 
     * @param id 活动配置主键
     * @return 结果
     */
    public int deleteActivityById(Long id);
}
