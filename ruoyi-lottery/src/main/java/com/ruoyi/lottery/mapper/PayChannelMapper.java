package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.PayChannel;

/**
 * 渠道管理Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface PayChannelMapper extends BaseMapper<PayChannel>
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
     * 删除渠道管理
     * 
     * @param id 渠道管理主键
     * @return 结果
     */
    public int deletePayChannelById(Long id);

    /**
     * 批量删除渠道管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayChannelByIds(Long[] ids);
}
