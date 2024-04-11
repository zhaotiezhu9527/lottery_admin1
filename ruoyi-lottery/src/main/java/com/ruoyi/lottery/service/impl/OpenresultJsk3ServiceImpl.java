package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultJsk3Mapper;
import com.ruoyi.lottery.domain.OpenresultJsk3;
import com.ruoyi.lottery.service.IOpenresultJsk3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(江苏快3)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultJsk3ServiceImpl extends ServiceImpl<OpenresultJsk3Mapper, OpenresultJsk3> implements IOpenresultJsk3Service
{
    @Autowired
    private OpenresultJsk3Mapper openresultJsk3Mapper;

    /**
     * 查询开奖结果(江苏快3)
     * 
     * @param id 开奖结果(江苏快3)主键
     * @return 开奖结果(江苏快3)
     */
    @Override
    public OpenresultJsk3 selectOpenresultJsk3ById(Long id)
    {
        return openresultJsk3Mapper.selectOpenresultJsk3ById(id);
    }

    /**
     * 查询开奖结果(江苏快3)列表
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 开奖结果(江苏快3)
     */
    @Override
    public List<OpenresultJsk3> selectOpenresultJsk3List(OpenresultJsk3 openresultJsk3)
    {
        return openresultJsk3Mapper.selectOpenresultJsk3List(openresultJsk3);
    }

    /**
     * 新增开奖结果(江苏快3)
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 结果
     */
    @Override
    public int insertOpenresultJsk3(OpenresultJsk3 openresultJsk3)
    {
        openresultJsk3.setCreateTime(DateUtils.getNowDate());
        return openresultJsk3Mapper.insertOpenresultJsk3(openresultJsk3);
    }

    /**
     * 修改开奖结果(江苏快3)
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 结果
     */
    @Override
    public int updateOpenresultJsk3(OpenresultJsk3 openresultJsk3)
    {
        openresultJsk3.setUpdateTime(DateUtils.getNowDate());
        return openresultJsk3Mapper.updateOpenresultJsk3(openresultJsk3);
    }

    /**
     * 批量删除开奖结果(江苏快3)
     * 
     * @param ids 需要删除的开奖结果(江苏快3)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultJsk3ByIds(Long[] ids)
    {
        return openresultJsk3Mapper.deleteOpenresultJsk3ByIds(ids);
    }

    /**
     * 删除开奖结果(江苏快3)信息
     * 
     * @param id 开奖结果(江苏快3)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultJsk3ById(Long id)
    {
        return openresultJsk3Mapper.deleteOpenresultJsk3ById(id);
    }
}
