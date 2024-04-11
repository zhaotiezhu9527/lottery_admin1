package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.PayMerchant;

/**
 * 商家配置Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface PayMerchantMapper extends BaseMapper<PayMerchant>
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
     * 删除商家配置
     * 
     * @param id 商家配置主键
     * @return 结果
     */
    public int deletePayMerchantById(Long id);

    /**
     * 批量删除商家配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayMerchantByIds(Long[] ids);
}
