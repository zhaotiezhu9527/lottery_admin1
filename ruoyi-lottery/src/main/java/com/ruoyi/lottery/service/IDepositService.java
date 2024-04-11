package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Deposit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 充值订单Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IDepositService extends IService<Deposit>
{
    /**
     * 查询充值订单
     * 
     * @param id 充值订单主键
     * @return 充值订单
     */
    public Deposit selectDepositById(Long id);

    /**
     * 查询充值订单列表
     * 
     * @param deposit 充值订单
     * @return 充值订单集合
     */
    public List<Deposit> selectDepositList(Deposit deposit);

    /**
     * 新增充值订单
     * 
     * @param deposit 充值订单
     * @return 结果
     */
    public int insertDeposit(Deposit deposit);

    /**
     * 修改充值订单
     * 
     * @param deposit 充值订单
     * @return 结果
     */
    public int updateDeposit(Deposit deposit);

    /**
     * 批量删除充值订单
     * 
     * @param ids 需要删除的充值订单主键集合
     * @return 结果
     */
    public int deleteDepositByIds(Long[] ids);

    /**
     * 删除充值订单信息
     * 
     * @param id 充值订单主键
     * @return 结果
     */
    public int deleteDepositById(Long id);
}
