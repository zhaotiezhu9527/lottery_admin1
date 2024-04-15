package com.ruoyi.lottery.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.UserInfoMapper;
import com.ruoyi.lottery.domain.UserInfo;
import com.ruoyi.lottery.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 会员列表Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService
{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询会员列表
     * 
     * @param id 会员列表主键
     * @return 会员列表
     */
    @Override
    public UserInfo selectUserInfoById(Long id)
    {
        return userInfoMapper.selectUserInfoById(id);
    }

    /**
     * 查询会员列表列表
     * 
     * @param userInfo 会员列表
     * @return 会员列表
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo)
    {
        List<UserInfo> list = userInfoMapper.selectUserInfoList(userInfo);
        //获取资源路径
        String url = sysParamService.getParamByKey("resource_domain");
        list.stream().map(a -> {a.setAvatarImg(url + a.getAvatarImg());a.setLevelImg(url + a.getLevelImg());return a;}).collect(Collectors.toList());
        return list;
    }

    /**
     * 新增会员列表
     * 
     * @param userInfo 会员列表
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo)
    {
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改会员列表
     * 
     * @param userInfo 会员列表
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo)
    {
        userInfo.setUpdateTime(DateUtils.getNowDate());
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除会员列表
     * 
     * @param ids 需要删除的会员列表主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByIds(Long[] ids)
    {
        return userInfoMapper.deleteUserInfoByIds(ids);
    }

    /**
     * 删除会员列表信息
     * 
     * @param id 会员列表主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoById(Long id)
    {
        return userInfoMapper.deleteUserInfoById(id);
    }

    @Override
    public void updateUserBalance(String userName, BigDecimal balance) throws ServiceException {
        int updateUserBalance = userInfoMapper.updateUserBalance(userName, balance);
        if (updateUserBalance <= 0) {
            throw new ServiceException("修改用户余额失败.");
        }
    }

    @Override
    public UserInfo getUserByName(String userName) {
        return getOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserName, userName));
    }
}
