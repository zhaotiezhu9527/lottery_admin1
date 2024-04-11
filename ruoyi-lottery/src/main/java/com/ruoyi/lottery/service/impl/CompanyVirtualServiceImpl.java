package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.CompanyVirtualMapper;
import com.ruoyi.lottery.domain.CompanyVirtual;
import com.ruoyi.lottery.service.ICompanyVirtualService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 公司U地址Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class CompanyVirtualServiceImpl extends ServiceImpl<CompanyVirtualMapper, CompanyVirtual> implements ICompanyVirtualService
{
    @Autowired
    private CompanyVirtualMapper companyVirtualMapper;

    /**
     * 查询公司U地址
     * 
     * @param id 公司U地址主键
     * @return 公司U地址
     */
    @Override
    public CompanyVirtual selectCompanyVirtualById(Long id)
    {
        return companyVirtualMapper.selectCompanyVirtualById(id);
    }

    /**
     * 查询公司U地址列表
     * 
     * @param companyVirtual 公司U地址
     * @return 公司U地址
     */
    @Override
    public List<CompanyVirtual> selectCompanyVirtualList(CompanyVirtual companyVirtual)
    {
        return companyVirtualMapper.selectCompanyVirtualList(companyVirtual);
    }

    /**
     * 新增公司U地址
     * 
     * @param companyVirtual 公司U地址
     * @return 结果
     */
    @Override
    public int insertCompanyVirtual(CompanyVirtual companyVirtual)
    {
        companyVirtual.setCreateTime(DateUtils.getNowDate());
        return companyVirtualMapper.insertCompanyVirtual(companyVirtual);
    }

    /**
     * 修改公司U地址
     * 
     * @param companyVirtual 公司U地址
     * @return 结果
     */
    @Override
    public int updateCompanyVirtual(CompanyVirtual companyVirtual)
    {
        companyVirtual.setUpdateTime(DateUtils.getNowDate());
        return companyVirtualMapper.updateCompanyVirtual(companyVirtual);
    }

    /**
     * 批量删除公司U地址
     * 
     * @param ids 需要删除的公司U地址主键
     * @return 结果
     */
    @Override
    public int deleteCompanyVirtualByIds(Long[] ids)
    {
        return companyVirtualMapper.deleteCompanyVirtualByIds(ids);
    }

    /**
     * 删除公司U地址信息
     * 
     * @param id 公司U地址主键
     * @return 结果
     */
    @Override
    public int deleteCompanyVirtualById(Long id)
    {
        return companyVirtualMapper.deleteCompanyVirtualById(id);
    }
}
