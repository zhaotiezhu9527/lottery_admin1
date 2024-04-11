package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 收款方式Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IUserAccountService extends IService<UserAccount>
{
    /**
     * 查询收款方式
     * 
     * @param id 收款方式主键
     * @return 收款方式
     */
    public UserAccount selectUserAccountById(Long id);

    /**
     * 查询收款方式列表
     * 
     * @param userAccount 收款方式
     * @return 收款方式集合
     */
    public List<UserAccount> selectUserAccountList(UserAccount userAccount);

    /**
     * 新增收款方式
     * 
     * @param userAccount 收款方式
     * @return 结果
     */
    public int insertUserAccount(UserAccount userAccount);

    /**
     * 修改收款方式
     * 
     * @param userAccount 收款方式
     * @return 结果
     */
    public int updateUserAccount(UserAccount userAccount);

    /**
     * 批量删除收款方式
     * 
     * @param ids 需要删除的收款方式主键集合
     * @return 结果
     */
    public int deleteUserAccountByIds(Long[] ids);

    /**
     * 删除收款方式信息
     * 
     * @param id 收款方式主键
     * @return 结果
     */
    public int deleteUserAccountById(Long id);
}
