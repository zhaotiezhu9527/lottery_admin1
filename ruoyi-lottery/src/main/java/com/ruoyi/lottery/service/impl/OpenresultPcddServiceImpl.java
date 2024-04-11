package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultPcddMapper;
import com.ruoyi.lottery.domain.OpenresultPcdd;
import com.ruoyi.lottery.service.IOpenresultPcddService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(PC蛋蛋)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultPcddServiceImpl extends ServiceImpl<OpenresultPcddMapper, OpenresultPcdd> implements IOpenresultPcddService
{
    @Autowired
    private OpenresultPcddMapper openresultPcddMapper;

    /**
     * 查询开奖结果(PC蛋蛋)
     * 
     * @param id 开奖结果(PC蛋蛋)主键
     * @return 开奖结果(PC蛋蛋)
     */
    @Override
    public OpenresultPcdd selectOpenresultPcddById(Long id)
    {
        return openresultPcddMapper.selectOpenresultPcddById(id);
    }

    /**
     * 查询开奖结果(PC蛋蛋)列表
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 开奖结果(PC蛋蛋)
     */
    @Override
    public List<OpenresultPcdd> selectOpenresultPcddList(OpenresultPcdd openresultPcdd)
    {
        return openresultPcddMapper.selectOpenresultPcddList(openresultPcdd);
    }

    /**
     * 新增开奖结果(PC蛋蛋)
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 结果
     */
    @Override
    public int insertOpenresultPcdd(OpenresultPcdd openresultPcdd)
    {
        openresultPcdd.setCreateTime(DateUtils.getNowDate());
        return openresultPcddMapper.insertOpenresultPcdd(openresultPcdd);
    }

    /**
     * 修改开奖结果(PC蛋蛋)
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 结果
     */
    @Override
    public int updateOpenresultPcdd(OpenresultPcdd openresultPcdd)
    {
        openresultPcdd.setUpdateTime(DateUtils.getNowDate());
        return openresultPcddMapper.updateOpenresultPcdd(openresultPcdd);
    }

    /**
     * 批量删除开奖结果(PC蛋蛋)
     * 
     * @param ids 需要删除的开奖结果(PC蛋蛋)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultPcddByIds(Long[] ids)
    {
        return openresultPcddMapper.deleteOpenresultPcddByIds(ids);
    }

    /**
     * 删除开奖结果(PC蛋蛋)信息
     * 
     * @param id 开奖结果(PC蛋蛋)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultPcddById(Long id)
    {
        return openresultPcddMapper.deleteOpenresultPcddById(id);
    }
}
