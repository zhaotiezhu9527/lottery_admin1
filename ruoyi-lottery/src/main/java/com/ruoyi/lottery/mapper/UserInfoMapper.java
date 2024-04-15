package com.ruoyi.lottery.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 会员列表Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface UserInfoMapper extends BaseMapper<UserInfo>
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
     * 删除会员列表
     * 
     * @param id 会员列表主键
     * @return 结果
     */
    public int deleteUserInfoById(Long id);

    /**
     * 批量删除会员列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserInfoByIds(Long[] ids);


    /**
     * 修改用户余额
     * @param userName 用户名
     * @param balance 金额,扣除传负数
     * @return
     */
    int updateUserBalance(@Param("userName") String userName, @Param("balance") BigDecimal balance);
}
