package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.PayMerchant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商家配置Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IPayMerchantService extends IService<PayMerchant>
{
    /**
     * 查询商家配置
     * 
     * @param id 商家配置主键
     * @return 商家配置
     */
    public PayMerchant selectPayMerchantById(Long id);

    /**
     * 查询商家配置列表
     * 
     * @param payMerchant 商家配置
     * @return 商家配置集合
     */
    public List<PayMerchant> selectPayMerchantList(PayMerchant payMerchant);

    /**
     * 新增商家配置
     * 
     * @param payMerchant 商家配置
     * @return 结果
     */
    public int insertPayMerchant(PayMerchant payMerchant);

    /**
     * 修改商家配置
     * 
     * @param payMerchant 商家配置
     * @return 结果
     */
    public int updatePayMerchant(PayMerchant payMerchant);

    /**
     * 批量删除商家配置
     * 
     * @param ids 需要删除的商家配置主键集合
     * @return 结果
     */
    public int deletePayMerchantByIds(Long[] ids);

    /**
     * 删除商家配置信息
     * 
     * @param id 商家配置主键
     * @return 结果
     */
    public int deletePayMerchantById(Long id);
}
