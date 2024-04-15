package com.ruoyi.lottery.service;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.lottery.domain.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * 会员列表Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IUserInfoService extends IService<UserInfo>
{
    /**
     * 查询会员列表
     * 
     * @param id 会员列表主键
     * @return 会员列表
     */
    public UserInfo selectUserInfoById(Long id);

    /**
     * 查询会员列表列表
     * 
     * @param userInfo 会员列表
     * @return 会员列表集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增会员列表
     * 
     * @param userInfo 会员列表
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改会员列表
     * 
     * @param userInfo 会员列表
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除会员列表
     * 
     * @param ids 需要删除的会员列表主键集合
     * @return 结果
     */
    public int deleteUserInfoByIds(Long[] ids);

    /**
     * 删除会员列表信息
     * 
     * @param id 会员列表主键
     * @return 结果
     */
    public int deleteUserInfoById(Long id);

    /**
     * 修改用户余额
     * @param userName 用户名
     * @param balance 金额,扣除传负数
     * @return
     */
    void updateUserBalance(@Param("userName") String userName, @Param("balance") BigDecimal balance) throws ServiceException;

    UserInfo getUserByName(String userName);
}
