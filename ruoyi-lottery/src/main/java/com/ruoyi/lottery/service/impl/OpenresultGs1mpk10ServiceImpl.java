package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mpk10Mapper;
import com.ruoyi.lottery.domain.OpenresultGs1mpk10;
import com.ruoyi.lottery.service.IOpenresultGs1mpk10Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(GS1分PK10)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultGs1mpk10ServiceImpl extends ServiceImpl<OpenresultGs1mpk10Mapper, OpenresultGs1mpk10> implements IOpenresultGs1mpk10Service
{
    @Autowired
    private OpenresultGs1mpk10Mapper openresultGs1mpk10Mapper;

    /**
     * 查询开奖结果(GS1分PK10)
     * 
     * @param id 开奖结果(GS1分PK10)主键
     * @return 开奖结果(GS1分PK10)
     */
    @Override
    public OpenresultGs1mpk10 selectOpenresultGs1mpk10ById(Long id)
    {
        return openresultGs1mpk10Mapper.selectOpenresultGs1mpk10ById(id);
    }

    /**
     * 查询开奖结果(GS1分PK10)列表
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 开奖结果(GS1分PK10)
     */
    @Override
    public List<OpenresultGs1mpk10> selectOpenresultGs1mpk10List(OpenresultGs1mpk10 openresultGs1mpk10)
    {
        return openresultGs1mpk10Mapper.selectOpenresultGs1mpk10List(openresultGs1mpk10);
    }

    /**
     * 新增开奖结果(GS1分PK10)
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mpk10(OpenresultGs1mpk10 openresultGs1mpk10)
    {
        openresultGs1mpk10.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mpk10Mapper.insertOpenresultGs1mpk10(openresultGs1mpk10);
    }

    /**
     * 修改开奖结果(GS1分PK10)
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mpk10(OpenresultGs1mpk10 openresultGs1mpk10)
    {
        openresultGs1mpk10.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mpk10Mapper.updateOpenresultGs1mpk10(openresultGs1mpk10);
    }

    /**
     * 批量删除开奖结果(GS1分PK10)
     * 
     * @param ids 需要删除的开奖结果(GS1分PK10)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mpk10ByIds(Long[] ids)
    {
        return openresultGs1mpk10Mapper.deleteOpenresultGs1mpk10ByIds(ids);
    }

    /**
     * 删除开奖结果(GS1分PK10)信息
     * 
     * @param id 开奖结果(GS1分PK10)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mpk10ById(Long id)
    {
        return openresultGs1mpk10Mapper.deleteOpenresultGs1mpk10ById(id);
    }
}
