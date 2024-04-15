package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mkl8Mapper;
import com.ruoyi.lottery.domain.OpenresultGs1mkl8;
import com.ruoyi.lottery.service.IOpenresultGs1mkl8Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 1分快乐8Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-15
 */
@Service
public class OpenresultGs1mkl8ServiceImpl extends ServiceImpl<OpenresultGs1mkl8Mapper, OpenresultGs1mkl8> implements IOpenresultGs1mkl8Service
{
    @Autowired
    private OpenresultGs1mkl8Mapper openresultGs1mkl8Mapper;

    /**
     * 查询1分快乐8
     * 
     * @param id 1分快乐8主键
     * @return 1分快乐8
     */
    @Override
    public OpenresultGs1mkl8 selectOpenresultGs1mkl8ById(Long id)
    {
        return openresultGs1mkl8Mapper.selectOpenresultGs1mkl8ById(id);
    }

    /**
     * 查询1分快乐8列表
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 1分快乐8
     */
    @Override
    public List<OpenresultGs1mkl8> selectOpenresultGs1mkl8List(OpenresultGs1mkl8 openresultGs1mkl8)
    {
        return openresultGs1mkl8Mapper.selectOpenresultGs1mkl8List(openresultGs1mkl8);
    }

    /**
     * 新增1分快乐8
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mkl8(OpenresultGs1mkl8 openresultGs1mkl8)
    {
        openresultGs1mkl8.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mkl8Mapper.insertOpenresultGs1mkl8(openresultGs1mkl8);
    }

    /**
     * 修改1分快乐8
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mkl8(OpenresultGs1mkl8 openresultGs1mkl8)
    {
        openresultGs1mkl8.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mkl8Mapper.updateOpenresultGs1mkl8(openresultGs1mkl8);
    }

    /**
     * 批量删除1分快乐8
     * 
     * @param ids 需要删除的1分快乐8主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mkl8ByIds(Long[] ids)
    {
        return openresultGs1mkl8Mapper.deleteOpenresultGs1mkl8ByIds(ids);
    }

    /**
     * 删除1分快乐8信息
     * 
     * @param id 1分快乐8主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mkl8ById(Long id)
    {
        return openresultGs1mkl8Mapper.deleteOpenresultGs1mkl8ById(id);
    }
}
