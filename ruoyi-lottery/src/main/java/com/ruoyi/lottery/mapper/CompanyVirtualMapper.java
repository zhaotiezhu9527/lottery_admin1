package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.CompanyVirtual;

/**
 * 公司U地址Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface CompanyVirtualMapper extends BaseMapper<CompanyVirtual>
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
     * 删除公司U地址
     * 
     * @param id 公司U地址主键
     * @return 结果
     */
    public int deleteCompanyVirtualById(Long id);

    /**
     * 批量删除公司U地址
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyVirtualByIds(Long[] ids);
}
