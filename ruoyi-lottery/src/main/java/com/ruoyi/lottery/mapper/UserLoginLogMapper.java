package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.UserLoginLog;

/**
 * 登录日志Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface UserLoginLogMapper extends BaseMapper<UserLoginLog>
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
     * 删除登录日志
     * 
     * @param id 登录日志主键
     * @return 结果
     */
    public int deleteUserLoginLogById(Long id);

    /**
     * 批量删除登录日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserLoginLogByIds(Long[] ids);
}
