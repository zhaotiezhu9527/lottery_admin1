package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultBjpk10Mapper;
import com.ruoyi.lottery.domain.OpenresultBjpk10;
import com.ruoyi.lottery.service.IOpenresultBjpk10Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(北京PK10)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultBjpk10ServiceImpl extends ServiceImpl<OpenresultBjpk10Mapper, OpenresultBjpk10> implements IOpenresultBjpk10Service
{
    @Autowired
    private OpenresultBjpk10Mapper openresultBjpk10Mapper;

    /**
     * 查询开奖结果(北京PK10)
     * 
     * @param id 开奖结果(北京PK10)主键
     * @return 开奖结果(北京PK10)
     */
    @Override
    public OpenresultBjpk10 selectOpenresultBjpk10ById(Long id)
    {
        return openresultBjpk10Mapper.selectOpenresultBjpk10ById(id);
    }

    /**
     * 查询开奖结果(北京PK10)列表
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 开奖结果(北京PK10)
     */
    @Override
    public List<OpenresultBjpk10> selectOpenresultBjpk10List(OpenresultBjpk10 openresultBjpk10)
    {
        return openresultBjpk10Mapper.selectOpenresultBjpk10List(openresultBjpk10);
    }

    /**
     * 新增开奖结果(北京PK10)
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 结果
     */
    @Override
    public int insertOpenresultBjpk10(OpenresultBjpk10 openresultBjpk10)
    {
        openresultBjpk10.setCreateTime(DateUtils.getNowDate());
        return openresultBjpk10Mapper.insertOpenresultBjpk10(openresultBjpk10);
    }

    /**
     * 修改开奖结果(北京PK10)
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 结果
     */
    @Override
    public int updateOpenresultBjpk10(OpenresultBjpk10 openresultBjpk10)
    {
        openresultBjpk10.setUpdateTime(DateUtils.getNowDate());
        return openresultBjpk10Mapper.updateOpenresultBjpk10(openresultBjpk10);
    }

    /**
     * 批量删除开奖结果(北京PK10)
     * 
     * @param ids 需要删除的开奖结果(北京PK10)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultBjpk10ByIds(Long[] ids)
    {
        return openresultBjpk10Mapper.deleteOpenresultBjpk10ByIds(ids);
    }

    /**
     * 删除开奖结果(北京PK10)信息
     * 
     * @param id 开奖结果(北京PK10)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultBjpk10ById(Long id)
    {
        return openresultBjpk10Mapper.deleteOpenresultBjpk10ById(id);
    }
}
