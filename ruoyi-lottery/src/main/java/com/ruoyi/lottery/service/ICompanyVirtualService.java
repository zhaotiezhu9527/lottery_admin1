package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.CompanyVirtual;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 公司U地址Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ICompanyVirtualService extends IService<CompanyVirtual>
{
    /**
     * 查询公司U地址
     * 
     * @param id 公司U地址主键
     * @return 公司U地址
     */
    public CompanyVirtual selectCompanyVirtualById(Long id);

    /**
     * 查询公司U地址列表
     * 
     * @param companyVirtual 公司U地址
     * @return 公司U地址集合
     */
    public List<CompanyVirtual> selectCompanyVirtualList(CompanyVirtual companyVirtual);

    /**
     * 新增公司U地址
     * 
     * @param companyVirtual 公司U地址
     * @return 结果
     */
    public int insertCompanyVirtual(CompanyVirtual companyVirtual);

    /**
     * 修改公司U地址
     * 
     * @param companyVirtual 公司U地址
     * @return 结果
     */
    public int updateCompanyVirtual(CompanyVirtual companyVirtual);

    /**
     * 批量删除公司U地址
     * 
     * @param ids 需要删除的公司U地址主键集合
     * @return 结果
     */
    public int deleteCompanyVirtualByIds(Long[] ids);

    /**
     * 删除公司U地址信息
     * 
     * @param id 公司U地址主键
     * @return 结果
     */
    public int deleteCompanyVirtualById(Long id);
}
