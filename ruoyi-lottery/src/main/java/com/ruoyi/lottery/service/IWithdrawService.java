package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Withdraw;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 提现订单Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IWithdrawService extends IService<Withdraw>
{
    /**
     * 查询提现订单
     * 
     * @param id 提现订单主键
     * @return 提现订单
     */
    public Withdraw selectWithdrawById(Long id);

    /**
     * 查询提现订单列表
     * 
     * @param withdraw 提现订单
     * @return 提现订单集合
     */
    public List<Withdraw> selectWithdrawList(Withdraw withdraw);

    /**
     * 新增提现订单
     * 
     * @param withdraw 提现订单
     * @return 结果
     */
    public int insertWithdraw(Withdraw withdraw);

    /**
     * 修改提现订单
     * 
     * @param withdraw 提现订单
     * @return 结果
     */
    public int updateWithdraw(Withdraw withdraw);

    /**
     * 批量删除提现订单
     * 
     * @param ids 需要删除的提现订单主键集合
     * @return 结果
     */
    public int deleteWithdrawByIds(Long[] ids);

    /**
     * 删除提现订单信息
     * 
     * @param id 提现订单主键
     * @return 结果
     */
    public int deleteWithdrawById(Long id);
}
