package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1msscMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mssc;
import com.ruoyi.lottery.service.IOpenresultGs1msscService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(gs1mssc)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultGs1msscServiceImpl extends ServiceImpl<OpenresultGs1msscMapper, OpenresultGs1mssc> implements IOpenresultGs1msscService
{
    @Autowired
    private OpenresultGs1msscMapper openresultGs1msscMapper;

    /**
     * 查询开奖结果(gs1mssc)
     * 
     * @param id 开奖结果(gs1mssc)主键
     * @return 开奖结果(gs1mssc)
     */
    @Override
    public OpenresultGs1mssc selectOpenresultGs1msscById(Long id)
    {
        return openresultGs1msscMapper.selectOpenresultGs1msscById(id);
    }

    /**
     * 查询开奖结果(gs1mssc)列表
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 开奖结果(gs1mssc)
     */
    @Override
    public List<OpenresultGs1mssc> selectOpenresultGs1msscList(OpenresultGs1mssc openresultGs1mssc)
    {
        return openresultGs1msscMapper.selectOpenresultGs1msscList(openresultGs1mssc);
    }

    /**
     * 新增开奖结果(gs1mssc)
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mssc(OpenresultGs1mssc openresultGs1mssc)
    {
        openresultGs1mssc.setCreateTime(DateUtils.getNowDate());
        return openresultGs1msscMapper.insertOpenresultGs1mssc(openresultGs1mssc);
    }

    /**
     * 修改开奖结果(gs1mssc)
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mssc(OpenresultGs1mssc openresultGs1mssc)
    {
        openresultGs1mssc.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1msscMapper.updateOpenresultGs1mssc(openresultGs1mssc);
    }

    /**
     * 批量删除开奖结果(gs1mssc)
     * 
     * @param ids 需要删除的开奖结果(gs1mssc)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1msscByIds(Long[] ids)
    {
        return openresultGs1msscMapper.deleteOpenresultGs1msscByIds(ids);
    }

    /**
     * 删除开奖结果(gs1mssc)信息
     * 
     * @param id 开奖结果(gs1mssc)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1msscById(Long id)
    {
        return openresultGs1msscMapper.deleteOpenresultGs1msscById(id);
    }
}
