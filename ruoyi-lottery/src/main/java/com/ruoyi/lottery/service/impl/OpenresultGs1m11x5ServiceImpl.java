package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1m11x5Mapper;
import com.ruoyi.lottery.domain.OpenresultGs1m11x5;
import com.ruoyi.lottery.service.IOpenresultGs1m11x5Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 1分11选5Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-15
 */
@Service
public class OpenresultGs1m11x5ServiceImpl extends ServiceImpl<OpenresultGs1m11x5Mapper, OpenresultGs1m11x5> implements IOpenresultGs1m11x5Service
{
    @Autowired
    private OpenresultGs1m11x5Mapper openresultGs1m11x5Mapper;

    /**
     * 查询1分11选5
     * 
     * @param id 1分11选5主键
     * @return 1分11选5
     */
    @Override
    public OpenresultGs1m11x5 selectOpenresultGs1m11x5ById(Long id)
    {
        return openresultGs1m11x5Mapper.selectOpenresultGs1m11x5ById(id);
    }

    /**
     * 查询1分11选5列表
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 1分11选5
     */
    @Override
    public List<OpenresultGs1m11x5> selectOpenresultGs1m11x5List(OpenresultGs1m11x5 openresultGs1m11x5)
    {
        return openresultGs1m11x5Mapper.selectOpenresultGs1m11x5List(openresultGs1m11x5);
    }

    /**
     * 新增1分11选5
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1m11x5(OpenresultGs1m11x5 openresultGs1m11x5)
    {
        openresultGs1m11x5.setCreateTime(DateUtils.getNowDate());
        return openresultGs1m11x5Mapper.insertOpenresultGs1m11x5(openresultGs1m11x5);
    }

    /**
     * 修改1分11选5
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1m11x5(OpenresultGs1m11x5 openresultGs1m11x5)
    {
        openresultGs1m11x5.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1m11x5Mapper.updateOpenresultGs1m11x5(openresultGs1m11x5);
    }

    /**
     * 批量删除1分11选5
     * 
     * @param ids 需要删除的1分11选5主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1m11x5ByIds(Long[] ids)
    {
        return openresultGs1m11x5Mapper.deleteOpenresultGs1m11x5ByIds(ids);
    }

    /**
     * 删除1分11选5信息
     * 
     * @param id 1分11选5主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1m11x5ById(Long id)
    {
        return openresultGs1m11x5Mapper.deleteOpenresultGs1m11x5ById(id);
    }
}
