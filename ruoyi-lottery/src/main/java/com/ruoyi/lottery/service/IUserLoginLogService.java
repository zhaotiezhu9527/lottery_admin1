package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.UserLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 登录日志Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IUserLoginLogService extends IService<UserLoginLog>
{
    /**
     * 查询登录日志
     * 
     * @param id 登录日志主键
     * @return 登录日志
     */
    public UserLoginLog selectUserLoginLogById(Long id);

    /**
     * 查询登录日志列表
     * 
     * @param userLoginLog 登录日志
     * @return 登录日志集合
     */
    public List<UserLoginLog> selectUserLoginLogList(UserLoginLog userLoginLog);

    /**
     * 新增登录日志
     * 
     * @param userLoginLog 登录日志
     * @return 结果
     */
    public int insertUserLoginLog(UserLoginLog userLoginLog);

    /**
     * 修改登录日志
     * 
     * @param userLoginLog 登录日志
     * @return 结果
     */
    public int updateUserLoginLog(UserLoginLog userLoginLog);

    /**
     * 批量删除登录日志
     * 
     * @param ids 需要删除的登录日志主键集合
     * @return 结果
     */
    public int deleteUserLoginLogByIds(Long[] ids);

    /**
     * 删除登录日志信息
     * 
     * @param id 登录日志主键
     * @return 结果
     */
    public int deleteUserLoginLogById(Long id);
}
