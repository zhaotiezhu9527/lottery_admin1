package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.UserPlatMapper;
import com.ruoyi.lottery.domain.UserPlat;
import com.ruoyi.lottery.service.IUserPlatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 三方用户Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class UserPlatServiceImpl extends ServiceImpl<UserPlatMapper, UserPlat> implements IUserPlatService
{
    @Autowired
    private UserPlatMapper userPlatMapper;

    /**
     * 查询三方用户
     * 
     * @param id 三方用户主键
     * @return 三方用户
     */
    @Override
    public UserPlat selectUserPlatById(Long id)
    {
        return userPlatMapper.selectUserPlatById(id);
    }

    /**
     * 查询三方用户列表
     * 
     * @param userPlat 三方用户
     * @return 三方用户
     */
    @Override
    public List<UserPlat> selectUserPlatList(UserPlat userPlat)
    {
        return userPlatMapper.selectUserPlatList(userPlat);
    }

    /**
     * 新增三方用户
     * 
     * @param userPlat 三方用户
     * @return 结果
     */
    @Override
    public int insertUserPlat(UserPlat userPlat)
    {
        userPlat.setCreateTime(DateUtils.getNowDate());
        return userPlatMapper.insertUserPlat(userPlat);
    }

    /**
     * 修改三方用户
     * 
     * @param userPlat 三方用户
     * @return 结果
     */
    @Override
    public int updateUserPlat(UserPlat userPlat)
    {
        return userPlatMapper.updateUserPlat(userPlat);
    }

    /**
     * 批量删除三方用户
     * 
     * @param ids 需要删除的三方用户主键
     * @return 结果
     */
    @Override
    public int deleteUserPlatByIds(Long[] ids)
    {
        return userPlatMapper.deleteUserPlatByIds(ids);
    }

    /**
     * 删除三方用户信息
     * 
     * @param id 三方用户主键
     * @return 结果
     */
    @Override
    public int deleteUserPlatById(Long id)
    {
        return userPlatMapper.deleteUserPlatById(id);
    }
}
