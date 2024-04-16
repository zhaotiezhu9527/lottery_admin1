package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultHklhcMapper;
import com.ruoyi.lottery.domain.OpenresultHklhc;
import com.ruoyi.lottery.service.IOpenresultHklhcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 香港六合彩Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-16
 */
@Service
public class OpenresultHklhcServiceImpl extends ServiceImpl<OpenresultHklhcMapper, OpenresultHklhc> implements IOpenresultHklhcService
{
    @Autowired
    private OpenresultHklhcMapper openresultHklhcMapper;

    /**
     * 查询香港六合彩
     * 
     * @param id 香港六合彩主键
     * @return 香港六合彩
     */
    @Override
    public OpenresultHklhc selectOpenresultHklhcById(Long id)
    {
        return openresultHklhcMapper.selectOpenresultHklhcById(id);
    }

    /**
     * 查询香港六合彩列表
     * 
     * @param openresultHklhc 香港六合彩
     * @return 香港六合彩
     */
    @Override
    public List<OpenresultHklhc> selectOpenresultHklhcList(OpenresultHklhc openresultHklhc)
    {
        return openresultHklhcMapper.selectOpenresultHklhcList(openresultHklhc);
    }

    /**
     * 新增香港六合彩
     * 
     * @param openresultHklhc 香港六合彩
     * @return 结果
     */
    @Override
    public int insertOpenresultHklhc(OpenresultHklhc openresultHklhc)
    {
        openresultHklhc.setCreateTime(DateUtils.getNowDate());
        return openresultHklhcMapper.insertOpenresultHklhc(openresultHklhc);
    }

    /**
     * 修改香港六合彩
     * 
     * @param openresultHklhc 香港六合彩
     * @return 结果
     */
    @Override
    public int updateOpenresultHklhc(OpenresultHklhc openresultHklhc)
    {
        openresultHklhc.setUpdateTime(DateUtils.getNowDate());
        return openresultHklhcMapper.updateOpenresultHklhc(openresultHklhc);
    }

    /**
     * 批量删除香港六合彩
     * 
     * @param ids 需要删除的香港六合彩主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultHklhcByIds(Long[] ids)
    {
        return openresultHklhcMapper.deleteOpenresultHklhcByIds(ids);
    }

    /**
     * 删除香港六合彩信息
     * 
     * @param id 香港六合彩主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultHklhcById(Long id)
    {
        return openresultHklhcMapper.deleteOpenresultHklhcById(id);
    }
}
