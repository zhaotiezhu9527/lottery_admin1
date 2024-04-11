package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGd11x5Mapper;
import com.ruoyi.lottery.domain.OpenresultGd11x5;
import com.ruoyi.lottery.service.IOpenresultGd11x5Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(广东11选5)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultGd11x5ServiceImpl extends ServiceImpl<OpenresultGd11x5Mapper, OpenresultGd11x5> implements IOpenresultGd11x5Service
{
    @Autowired
    private OpenresultGd11x5Mapper openresultGd11x5Mapper;

    /**
     * 查询开奖结果(广东11选5)
     * 
     * @param id 开奖结果(广东11选5)主键
     * @return 开奖结果(广东11选5)
     */
    @Override
    public OpenresultGd11x5 selectOpenresultGd11x5ById(Long id)
    {
        return openresultGd11x5Mapper.selectOpenresultGd11x5ById(id);
    }

    /**
     * 查询开奖结果(广东11选5)列表
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 开奖结果(广东11选5)
     */
    @Override
    public List<OpenresultGd11x5> selectOpenresultGd11x5List(OpenresultGd11x5 openresultGd11x5)
    {
        return openresultGd11x5Mapper.selectOpenresultGd11x5List(openresultGd11x5);
    }

    /**
     * 新增开奖结果(广东11选5)
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 结果
     */
    @Override
    public int insertOpenresultGd11x5(OpenresultGd11x5 openresultGd11x5)
    {
        openresultGd11x5.setCreateTime(DateUtils.getNowDate());
        return openresultGd11x5Mapper.insertOpenresultGd11x5(openresultGd11x5);
    }

    /**
     * 修改开奖结果(广东11选5)
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 结果
     */
    @Override
    public int updateOpenresultGd11x5(OpenresultGd11x5 openresultGd11x5)
    {
        openresultGd11x5.setUpdateTime(DateUtils.getNowDate());
        return openresultGd11x5Mapper.updateOpenresultGd11x5(openresultGd11x5);
    }

    /**
     * 批量删除开奖结果(广东11选5)
     * 
     * @param ids 需要删除的开奖结果(广东11选5)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGd11x5ByIds(Long[] ids)
    {
        return openresultGd11x5Mapper.deleteOpenresultGd11x5ByIds(ids);
    }

    /**
     * 删除开奖结果(广东11选5)信息
     * 
     * @param id 开奖结果(广东11选5)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGd11x5ById(Long id)
    {
        return openresultGd11x5Mapper.deleteOpenresultGd11x5ById(id);
    }
}
