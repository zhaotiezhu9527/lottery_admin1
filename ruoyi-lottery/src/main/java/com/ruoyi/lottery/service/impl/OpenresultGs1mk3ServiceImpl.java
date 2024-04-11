package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mk3Mapper;
import com.ruoyi.lottery.domain.OpenresultGs1mk3;
import com.ruoyi.lottery.service.IOpenresultGs1mk3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(GS1分快3)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultGs1mk3ServiceImpl extends ServiceImpl<OpenresultGs1mk3Mapper, OpenresultGs1mk3> implements IOpenresultGs1mk3Service
{
    @Autowired
    private OpenresultGs1mk3Mapper openresultGs1mk3Mapper;

    /**
     * 查询开奖结果(GS1分快3)
     * 
     * @param id 开奖结果(GS1分快3)主键
     * @return 开奖结果(GS1分快3)
     */
    @Override
    public OpenresultGs1mk3 selectOpenresultGs1mk3ById(Long id)
    {
        return openresultGs1mk3Mapper.selectOpenresultGs1mk3ById(id);
    }

    /**
     * 查询开奖结果(GS1分快3)列表
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 开奖结果(GS1分快3)
     */
    @Override
    public List<OpenresultGs1mk3> selectOpenresultGs1mk3List(OpenresultGs1mk3 openresultGs1mk3)
    {
        return openresultGs1mk3Mapper.selectOpenresultGs1mk3List(openresultGs1mk3);
    }

    /**
     * 新增开奖结果(GS1分快3)
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mk3(OpenresultGs1mk3 openresultGs1mk3)
    {
        openresultGs1mk3.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mk3Mapper.insertOpenresultGs1mk3(openresultGs1mk3);
    }

    /**
     * 修改开奖结果(GS1分快3)
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mk3(OpenresultGs1mk3 openresultGs1mk3)
    {
        openresultGs1mk3.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mk3Mapper.updateOpenresultGs1mk3(openresultGs1mk3);
    }

    /**
     * 批量删除开奖结果(GS1分快3)
     * 
     * @param ids 需要删除的开奖结果(GS1分快3)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mk3ByIds(Long[] ids)
    {
        return openresultGs1mk3Mapper.deleteOpenresultGs1mk3ByIds(ids);
    }

    /**
     * 删除开奖结果(GS1分快3)信息
     * 
     * @param id 开奖结果(GS1分快3)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mk3ById(Long id)
    {
        return openresultGs1mk3Mapper.deleteOpenresultGs1mk3ById(id);
    }
}
