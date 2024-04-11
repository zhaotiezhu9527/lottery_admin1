package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.CompanyAccountMapper;
import com.ruoyi.lottery.domain.CompanyAccount;
import com.ruoyi.lottery.service.ICompanyAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 公司入款账号Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class CompanyAccountServiceImpl extends ServiceImpl<CompanyAccountMapper, CompanyAccount> implements ICompanyAccountService
{
    @Autowired
    private CompanyAccountMapper companyAccountMapper;

    /**
     * 查询公司入款账号
     * 
     * @param id 公司入款账号主键
     * @return 公司入款账号
     */
    @Override
    public CompanyAccount selectCompanyAccountById(Long id)
    {
        return companyAccountMapper.selectCompanyAccountById(id);
    }

    /**
     * 查询公司入款账号列表
     * 
     * @param companyAccount 公司入款账号
     * @return 公司入款账号
     */
    @Override
    public List<CompanyAccount> selectCompanyAccountList(CompanyAccount companyAccount)
    {
        return companyAccountMapper.selectCompanyAccountList(companyAccount);
    }

    /**
     * 新增公司入款账号
     * 
     * @param companyAccount 公司入款账号
     * @return 结果
     */
    @Override
    public int insertCompanyAccount(CompanyAccount companyAccount)
    {
        companyAccount.setCreateTime(DateUtils.getNowDate());
        return companyAccountMapper.insertCompanyAccount(companyAccount);
    }

    /**
     * 修改公司入款账号
     * 
     * @param companyAccount 公司入款账号
     * @return 结果
     */
    @Override
    public int updateCompanyAccount(CompanyAccount companyAccount)
    {
        companyAccount.setUpdateTime(DateUtils.getNowDate());
        return companyAccountMapper.updateCompanyAccount(companyAccount);
    }

    /**
     * 批量删除公司入款账号
     * 
     * @param ids 需要删除的公司入款账号主键
     * @return 结果
     */
    @Override
    public int deleteCompanyAccountByIds(Long[] ids)
    {
        return companyAccountMapper.deleteCompanyAccountByIds(ids);
    }

    /**
     * 删除公司入款账号信息
     * 
     * @param id 公司入款账号主键
     * @return 结果
     */
    @Override
    public int deleteCompanyAccountById(Long id)
    {
        return companyAccountMapper.deleteCompanyAccountById(id);
    }
}
