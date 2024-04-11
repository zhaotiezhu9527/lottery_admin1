package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.PayChannelMapper;
import com.ruoyi.lottery.domain.PayChannel;
import com.ruoyi.lottery.service.IPayChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 渠道管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class PayChannelServiceImpl extends ServiceImpl<PayChannelMapper, PayChannel> implements IPayChannelService
{
    @Autowired
    private PayChannelMapper payChannelMapper;

    /**
     * 查询渠道管理
     * 
     * @param id 渠道管理主键
     * @return 渠道管理
     */
    @Override
    public PayChannel selectPayChannelById(Long id)
    {
        return payChannelMapper.selectPayChannelById(id);
    }

    /**
     * 查询渠道管理列表
     * 
     * @param payChannel 渠道管理
     * @return 渠道管理
     */
    @Override
    public List<PayChannel> selectPayChannelList(PayChannel payChannel)
    {
        return payChannelMapper.selectPayChannelList(payChannel);
    }

    /**
     * 新增渠道管理
     * 
     * @param payChannel 渠道管理
     * @return 结果
     */
    @Override
    public int insertPayChannel(PayChannel payChannel)
    {
        payChannel.setCreateTime(DateUtils.getNowDate());
        return payChannelMapper.insertPayChannel(payChannel);
    }

    /**
     * 修改渠道管理
     * 
     * @param payChannel 渠道管理
     * @return 结果
     */
    @Override
    public int updatePayChannel(PayChannel payChannel)
    {
        payChannel.setUpdateTime(DateUtils.getNowDate());
        return payChannelMapper.updatePayChannel(payChannel);
    }

    /**
     * 批量删除渠道管理
     * 
     * @param ids 需要删除的渠道管理主键
     * @return 结果
     */
    @Override
    public int deletePayChannelByIds(Long[] ids)
    {
        return payChannelMapper.deletePayChannelByIds(ids);
    }

    /**
     * 删除渠道管理信息
     * 
     * @param id 渠道管理主键
     * @return 结果
     */
    @Override
    public int deletePayChannelById(Long id)
    {
        return payChannelMapper.deletePayChannelById(id);
    }
}
