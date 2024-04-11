package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultMo6hcMapper;
import com.ruoyi.lottery.domain.OpenresultMo6hc;
import com.ruoyi.lottery.service.IOpenresultMo6hcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(澳门六合彩)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultMo6hcServiceImpl extends ServiceImpl<OpenresultMo6hcMapper, OpenresultMo6hc> implements IOpenresultMo6hcService
{
    @Autowired
    private OpenresultMo6hcMapper openresultMo6hcMapper;

    /**
     * 查询开奖结果(澳门六合彩)
     * 
     * @param id 开奖结果(澳门六合彩)主键
     * @return 开奖结果(澳门六合彩)
     */
    @Override
    public OpenresultMo6hc selectOpenresultMo6hcById(Long id)
    {
        return openresultMo6hcMapper.selectOpenresultMo6hcById(id);
    }

    /**
     * 查询开奖结果(澳门六合彩)列表
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 开奖结果(澳门六合彩)
     */
    @Override
    public List<OpenresultMo6hc> selectOpenresultMo6hcList(OpenresultMo6hc openresultMo6hc)
    {
        return openresultMo6hcMapper.selectOpenresultMo6hcList(openresultMo6hc);
    }

    /**
     * 新增开奖结果(澳门六合彩)
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 结果
     */
    @Override
    public int insertOpenresultMo6hc(OpenresultMo6hc openresultMo6hc)
    {
        openresultMo6hc.setCreateTime(DateUtils.getNowDate());
        return openresultMo6hcMapper.insertOpenresultMo6hc(openresultMo6hc);
    }

    /**
     * 修改开奖结果(澳门六合彩)
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 结果
     */
    @Override
    public int updateOpenresultMo6hc(OpenresultMo6hc openresultMo6hc)
    {
        openresultMo6hc.setUpdateTime(DateUtils.getNowDate());
        return openresultMo6hcMapper.updateOpenresultMo6hc(openresultMo6hc);
    }

    /**
     * 批量删除开奖结果(澳门六合彩)
     * 
     * @param ids 需要删除的开奖结果(澳门六合彩)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultMo6hcByIds(Long[] ids)
    {
        return openresultMo6hcMapper.deleteOpenresultMo6hcByIds(ids);
    }

    /**
     * 删除开奖结果(澳门六合彩)信息
     * 
     * @param id 开奖结果(澳门六合彩)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultMo6hcById(Long id)
    {
        return openresultMo6hcMapper.deleteOpenresultMo6hcById(id);
    }
}
