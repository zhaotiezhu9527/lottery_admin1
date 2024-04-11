package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.Deposit;

/**
 * 充值订单Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface DepositMapper extends BaseMapper<Deposit>
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
     * 删除充值订单
     * 
     * @param id 充值订单主键
     * @return 结果
     */
    public int deleteDepositById(Long id);

    /**
     * 批量删除充值订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepositByIds(Long[] ids);
}
