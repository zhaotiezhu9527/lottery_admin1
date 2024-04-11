package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.CompanyAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 公司入款账号Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ICompanyAccountService extends IService<CompanyAccount>
{
    /**
     * 查询公司入款账号
     * 
     * @param id 公司入款账号主键
     * @return 公司入款账号
     */
    public CompanyAccount selectCompanyAccountById(Long id);

    /**
     * 查询公司入款账号列表
     * 
     * @param companyAccount 公司入款账号
     * @return 公司入款账号集合
     */
    public List<CompanyAccount> selectCompanyAccountList(CompanyAccount companyAccount);

    /**
     * 新增公司入款账号
     * 
     * @param companyAccount 公司入款账号
     * @return 结果
     */
    public int insertCompanyAccount(CompanyAccount companyAccount);

    /**
     * 修改公司入款账号
     * 
     * @param companyAccount 公司入款账号
     * @return 结果
     */
    public int updateCompanyAccount(CompanyAccount companyAccount);

    /**
     * 批量删除公司入款账号
     * 
     * @param ids 需要删除的公司入款账号主键集合
     * @return 结果
     */
    public int deleteCompanyAccountByIds(Long[] ids);

    /**
     * 删除公司入款账号信息
     * 
     * @param id 公司入款账号主键
     * @return 结果
     */
    public int deleteCompanyAccountById(Long id);
}
