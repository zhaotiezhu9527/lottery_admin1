package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultCqsscMapper;
import com.ruoyi.lottery.domain.OpenresultCqssc;
import com.ruoyi.lottery.service.IOpenresultCqsscService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(重庆时时彩)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultCqsscServiceImpl extends ServiceImpl<OpenresultCqsscMapper, OpenresultCqssc> implements IOpenresultCqsscService
{
    @Autowired
    private OpenresultCqsscMapper openresultCqsscMapper;

    /**
     * 查询开奖结果(重庆时时彩)
     * 
     * @param id 开奖结果(重庆时时彩)主键
     * @return 开奖结果(重庆时时彩)
     */
    @Override
    public OpenresultCqssc selectOpenresultCqsscById(Long id)
    {
        return openresultCqsscMapper.selectOpenresultCqsscById(id);
    }

    /**
     * 查询开奖结果(重庆时时彩)列表
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 开奖结果(重庆时时彩)
     */
    @Override
    public List<OpenresultCqssc> selectOpenresultCqsscList(OpenresultCqssc openresultCqssc)
    {
        return openresultCqsscMapper.selectOpenresultCqsscList(openresultCqssc);
    }

    /**
     * 新增开奖结果(重庆时时彩)
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 结果
     */
    @Override
    public int insertOpenresultCqssc(OpenresultCqssc openresultCqssc)
    {
        openresultCqssc.setCreateTime(DateUtils.getNowDate());
        return openresultCqsscMapper.insertOpenresultCqssc(openresultCqssc);
    }

    /**
     * 修改开奖结果(重庆时时彩)
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 结果
     */
    @Override
    public int updateOpenresultCqssc(OpenresultCqssc openresultCqssc)
    {
        openresultCqssc.setUpdateTime(DateUtils.getNowDate());
        return openresultCqsscMapper.updateOpenresultCqssc(openresultCqssc);
    }

    /**
     * 批量删除开奖结果(重庆时时彩)
     * 
     * @param ids 需要删除的开奖结果(重庆时时彩)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultCqsscByIds(Long[] ids)
    {
        return openresultCqsscMapper.deleteOpenresultCqsscByIds(ids);
    }

    /**
     * 删除开奖结果(重庆时时彩)信息
     * 
     * @param id 开奖结果(重庆时时彩)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultCqsscById(Long id)
    {
        return openresultCqsscMapper.deleteOpenresultCqsscById(id);
    }
}
