package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.PayChannel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 渠道管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IPayChannelService extends IService<PayChannel>
{
    /**
     * 查询渠道管理
     * 
     * @param id 渠道管理主键
     * @return 渠道管理
     */
    public PayChannel selectPayChannelById(Long id);

    /**
     * 查询渠道管理列表
     * 
     * @param payChannel 渠道管理
     * @return 渠道管理集合
     */
    public List<PayChannel> selectPayChannelList(PayChannel payChannel);

    /**
     * 新增渠道管理
     * 
     * @param payChannel 渠道管理
     * @return 结果
     */
    public int insertPayChannel(PayChannel payChannel);

    /**
     * 修改渠道管理
     * 
     * @param payChannel 渠道管理
     * @return 结果
     */
    public int updatePayChannel(PayChannel payChannel);

    /**
     * 批量删除渠道管理
     * 
     * @param ids 需要删除的渠道管理主键集合
     * @return 结果
     */
    public int deletePayChannelByIds(Long[] ids);

    /**
     * 删除渠道管理信息
     * 
     * @param id 渠道管理主键
     * @return 结果
     */
    public int deletePayChannelById(Long id);
}
