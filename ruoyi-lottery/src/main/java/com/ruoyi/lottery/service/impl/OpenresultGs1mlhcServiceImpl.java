package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mlhcMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mlhc;
import com.ruoyi.lottery.service.IOpenresultGs1mlhcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 1分六合彩开奖Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-12
 */
@Service
public class OpenresultGs1mlhcServiceImpl extends ServiceImpl<OpenresultGs1mlhcMapper, OpenresultGs1mlhc> implements IOpenresultGs1mlhcService
{
    @Autowired
    private OpenresultGs1mlhcMapper openresultGs1mlhcMapper;

    /**
     * 查询1分六合彩开奖
     * 
     * @param id 1分六合彩开奖主键
     * @return 1分六合彩开奖
     */
    @Override
    public OpenresultGs1mlhc selectOpenresultGs1mlhcById(Long id)
    {
        return openresultGs1mlhcMapper.selectOpenresultGs1mlhcById(id);
    }

    /**
     * 查询1分六合彩开奖列表
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 1分六合彩开奖
     */
    @Override
    public List<OpenresultGs1mlhc> selectOpenresultGs1mlhcList(OpenresultGs1mlhc openresultGs1mlhc)
    {
        return openresultGs1mlhcMapper.selectOpenresultGs1mlhcList(openresultGs1mlhc);
    }

    /**
     * 新增1分六合彩开奖
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mlhc(OpenresultGs1mlhc openresultGs1mlhc)
    {
        openresultGs1mlhc.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mlhcMapper.insertOpenresultGs1mlhc(openresultGs1mlhc);
    }

    /**
     * 修改1分六合彩开奖
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mlhc(OpenresultGs1mlhc openresultGs1mlhc)
    {
        openresultGs1mlhc.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mlhcMapper.updateOpenresultGs1mlhc(openresultGs1mlhc);
    }

    /**
     * 批量删除1分六合彩开奖
     * 
     * @param ids 需要删除的1分六合彩开奖主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mlhcByIds(Long[] ids)
    {
        return openresultGs1mlhcMapper.deleteOpenresultGs1mlhcByIds(ids);
    }

    /**
     * 删除1分六合彩开奖信息
     * 
     * @param id 1分六合彩开奖主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mlhcById(Long id)
    {
        return openresultGs1mlhcMapper.deleteOpenresultGs1mlhcById(id);
    }
}
