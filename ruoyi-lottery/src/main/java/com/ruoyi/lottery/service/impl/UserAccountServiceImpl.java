package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.UserAccountMapper;
import com.ruoyi.lottery.domain.UserAccount;
import com.ruoyi.lottery.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 收款方式Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService
{
    @Autowired
    private UserAccountMapper userAccountMapper;

    /**
     * 查询收款方式
     * 
     * @param id 收款方式主键
     * @return 收款方式
     */
    @Override
    public UserAccount selectUserAccountById(Long id)
    {
        return userAccountMapper.selectUserAccountById(id);
    }

    /**
     * 查询收款方式列表
     * 
     * @param userAccount 收款方式
     * @return 收款方式
     */
    @Override
    public List<UserAccount> selectUserAccountList(UserAccount userAccount)
    {
        return userAccountMapper.selectUserAccountList(userAccount);
    }

    /**
     * 新增收款方式
     * 
     * @param userAccount 收款方式
     * @return 结果
     */
    @Override
    public int insertUserAccount(UserAccount userAccount)
    {
        userAccount.setCreateTime(DateUtils.getNowDate());
        return userAccountMapper.insertUserAccount(userAccount);
    }

    /**
     * 修改收款方式
     * 
     * @param userAccount 收款方式
     * @return 结果
     */
    @Override
    public int updateUserAccount(UserAccount userAccount)
    {
        return userAccountMapper.updateUserAccount(userAccount);
    }

    /**
     * 批量删除收款方式
     * 
     * @param ids 需要删除的收款方式主键
     * @return 结果
     */
    @Override
    public int deleteUserAccountByIds(Long[] ids)
    {
        return userAccountMapper.deleteUserAccountByIds(ids);
    }

    /**
     * 删除收款方式信息
     * 
     * @param id 收款方式主键
     * @return 结果
     */
    @Override
    public int deleteUserAccountById(Long id)
    {
        return userAccountMapper.deleteUserAccountById(id);
    }
}
