package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mftMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mft;
import com.ruoyi.lottery.service.IOpenresultGs1mftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 1分飞艇开奖Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-12
 */
@Service
public class OpenresultGs1mftServiceImpl extends ServiceImpl<OpenresultGs1mftMapper, OpenresultGs1mft> implements IOpenresultGs1mftService
{
    @Autowired
    private OpenresultGs1mftMapper openresultGs1mftMapper;

    /**
     * 查询1分飞艇开奖
     * 
     * @param id 1分飞艇开奖主键
     * @return 1分飞艇开奖
     */
    @Override
    public OpenresultGs1mft selectOpenresultGs1mftById(Long id)
    {
        return openresultGs1mftMapper.selectOpenresultGs1mftById(id);
    }

    /**
     * 查询1分飞艇开奖列表
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 1分飞艇开奖
     */
    @Override
    public List<OpenresultGs1mft> selectOpenresultGs1mftList(OpenresultGs1mft openresultGs1mft)
    {
        return openresultGs1mftMapper.selectOpenresultGs1mftList(openresultGs1mft);
    }

    /**
     * 新增1分飞艇开奖
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mft(OpenresultGs1mft openresultGs1mft)
    {
        openresultGs1mft.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mftMapper.insertOpenresultGs1mft(openresultGs1mft);
    }

    /**
     * 修改1分飞艇开奖
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mft(OpenresultGs1mft openresultGs1mft)
    {
        openresultGs1mft.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mftMapper.updateOpenresultGs1mft(openresultGs1mft);
    }

    /**
     * 批量删除1分飞艇开奖
     * 
     * @param ids 需要删除的1分飞艇开奖主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mftByIds(Long[] ids)
    {
        return openresultGs1mftMapper.deleteOpenresultGs1mftByIds(ids);
    }

    /**
     * 删除1分飞艇开奖信息
     * 
     * @param id 1分飞艇开奖主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mftById(Long id)
    {
        return openresultGs1mftMapper.deleteOpenresultGs1mftById(id);
    }
}
