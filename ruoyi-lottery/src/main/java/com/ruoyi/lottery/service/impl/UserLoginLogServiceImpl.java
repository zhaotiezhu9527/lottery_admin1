package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.UserLoginLogMapper;
import com.ruoyi.lottery.domain.UserLoginLog;
import com.ruoyi.lottery.service.IUserLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 登录日志Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements IUserLoginLogService
{
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    /**
     * 查询登录日志
     * 
     * @param id 登录日志主键
     * @return 登录日志
     */
    @Override
    public UserLoginLog selectUserLoginLogById(Long id)
    {
        return userLoginLogMapper.selectUserLoginLogById(id);
    }

    /**
     * 查询登录日志列表
     * 
     * @param userLoginLog 登录日志
     * @return 登录日志
     */
    @Override
    public List<UserLoginLog> selectUserLoginLogList(UserLoginLog userLoginLog)
    {
        return userLoginLogMapper.selectUserLoginLogList(userLoginLog);
    }

    /**
     * 新增登录日志
     * 
     * @param userLoginLog 登录日志
     * @return 结果
     */
    @Override
    public int insertUserLoginLog(UserLoginLog userLoginLog)
    {
        userLoginLog.setCreateTime(DateUtils.getNowDate());
        return userLoginLogMapper.insertUserLoginLog(userLoginLog);
    }

    /**
     * 修改登录日志
     * 
     * @param userLoginLog 登录日志
     * @return 结果
     */
    @Override
    public int updateUserLoginLog(UserLoginLog userLoginLog)
    {
        return userLoginLogMapper.updateUserLoginLog(userLoginLog);
    }

    /**
     * 批量删除登录日志
     * 
     * @param ids 需要删除的登录日志主键
     * @return 结果
     */
    @Override
    public int deleteUserLoginLogByIds(Long[] ids)
    {
        return userLoginLogMapper.deleteUserLoginLogByIds(ids);
    }

    /**
     * 删除登录日志信息
     * 
     * @param id 登录日志主键
     * @return 结果
     */
    @Override
    public int deleteUserLoginLogById(Long id)
    {
        return userLoginLogMapper.deleteUserLoginLogById(id);
    }
}
