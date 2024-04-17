package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultPl3Mapper;
import com.ruoyi.lottery.domain.OpenresultPl3;
import com.ruoyi.lottery.service.IOpenresultPl3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 排列3Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-17
 */
@Service
public class OpenresultPl3ServiceImpl extends ServiceImpl<OpenresultPl3Mapper, OpenresultPl3> implements IOpenresultPl3Service
{
    @Autowired
    private OpenresultPl3Mapper openresultPl3Mapper;

    /**
     * 查询排列3
     * 
     * @param id 排列3主键
     * @return 排列3
     */
    @Override
    public OpenresultPl3 selectOpenresultPl3ById(Long id)
    {
        return openresultPl3Mapper.selectOpenresultPl3ById(id);
    }

    /**
     * 查询排列3列表
     * 
     * @param openresultPl3 排列3
     * @return 排列3
     */
    @Override
    public List<OpenresultPl3> selectOpenresultPl3List(OpenresultPl3 openresultPl3)
    {
        return openresultPl3Mapper.selectOpenresultPl3List(openresultPl3);
    }

    /**
     * 新增排列3
     * 
     * @param openresultPl3 排列3
     * @return 结果
     */
    @Override
    public int insertOpenresultPl3(OpenresultPl3 openresultPl3)
    {
        openresultPl3.setCreateTime(DateUtils.getNowDate());
        return openresultPl3Mapper.insertOpenresultPl3(openresultPl3);
    }

    /**
     * 修改排列3
     * 
     * @param openresultPl3 排列3
     * @return 结果
     */
    @Override
    public int updateOpenresultPl3(OpenresultPl3 openresultPl3)
    {
        openresultPl3.setUpdateTime(DateUtils.getNowDate());
        return openresultPl3Mapper.updateOpenresultPl3(openresultPl3);
    }

    /**
     * 批量删除排列3
     * 
     * @param ids 需要删除的排列3主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultPl3ByIds(Long[] ids)
    {
        return openresultPl3Mapper.deleteOpenresultPl3ByIds(ids);
    }

    /**
     * 删除排列3信息
     * 
     * @param id 排列3主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultPl3ById(Long id)
    {
        return openresultPl3Mapper.deleteOpenresultPl3ById(id);
    }
}
