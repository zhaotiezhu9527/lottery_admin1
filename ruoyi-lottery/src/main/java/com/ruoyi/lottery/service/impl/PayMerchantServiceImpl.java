package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.PayMerchantMapper;
import com.ruoyi.lottery.domain.PayMerchant;
import com.ruoyi.lottery.service.IPayMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 商家配置Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class PayMerchantServiceImpl extends ServiceImpl<PayMerchantMapper, PayMerchant> implements IPayMerchantService
{
    @Autowired
    private PayMerchantMapper payMerchantMapper;

    /**
     * 查询商家配置
     * 
     * @param id 商家配置主键
     * @return 商家配置
     */
    @Override
    public PayMerchant selectPayMerchantById(Long id)
    {
        return payMerchantMapper.selectPayMerchantById(id);
    }

    /**
     * 查询商家配置列表
     * 
     * @param payMerchant 商家配置
     * @return 商家配置
     */
    @Override
    public List<PayMerchant> selectPayMerchantList(PayMerchant payMerchant)
    {
        return payMerchantMapper.selectPayMerchantList(payMerchant);
    }

    /**
     * 新增商家配置
     * 
     * @param payMerchant 商家配置
     * @return 结果
     */
    @Override
    public int insertPayMerchant(PayMerchant payMerchant)
    {
        payMerchant.setCreateTime(DateUtils.getNowDate());
        return payMerchantMapper.insertPayMerchant(payMerchant);
    }

    /**
     * 修改商家配置
     * 
     * @param payMerchant 商家配置
     * @return 结果
     */
    @Override
    public int updatePayMerchant(PayMerchant payMerchant)
    {
        payMerchant.setUpdateTime(DateUtils.getNowDate());
        return payMerchantMapper.updatePayMerchant(payMerchant);
    }

    /**
     * 批量删除商家配置
     * 
     * @param ids 需要删除的商家配置主键
     * @return 结果
     */
    @Override
    public int deletePayMerchantByIds(Long[] ids)
    {
        return payMerchantMapper.deletePayMerchantByIds(ids);
    }

    /**
     * 删除商家配置信息
     * 
     * @param id 商家配置主键
     * @return 结果
     */
    @Override
    public int deletePayMerchantById(Long id)
    {
        return payMerchantMapper.deletePayMerchantById(id);
    }
}
