package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.CompanyAccount;

/**
 * 公司入款账号Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface CompanyAccountMapper extends BaseMapper<CompanyAccount>
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
     * 删除公司入款账号
     * 
     * @param id 公司入款账号主键
     * @return 结果
     */
    public int deleteCompanyAccountById(Long id);

    /**
     * 批量删除公司入款账号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyAccountByIds(Long[] ids);
}
