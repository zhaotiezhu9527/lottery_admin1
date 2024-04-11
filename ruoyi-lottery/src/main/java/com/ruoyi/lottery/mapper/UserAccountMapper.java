package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.UserAccount;

/**
 * 收款方式Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface UserAccountMapper extends BaseMapper<UserAccount>
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
     * 删除收款方式
     * 
     * @param id 收款方式主键
     * @return 结果
     */
    public int deleteUserAccountById(Long id);

    /**
     * 批量删除收款方式
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserAccountByIds(Long[] ids);
}
