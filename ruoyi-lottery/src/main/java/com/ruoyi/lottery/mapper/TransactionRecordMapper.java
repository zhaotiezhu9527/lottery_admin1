package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.TransactionRecord;

/**
 * 账变记录Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface TransactionRecordMapper extends BaseMapper<TransactionRecord>
{
    /**
     * 查询账变记录
     * 
     * @param id 账变记录主键
     * @return 账变记录
     */
    public TransactionRecord selectTransactionRecordById(Long id);

    /**
     * 查询账变记录列表
     * 
     * @param transactionRecord 账变记录
     * @return 账变记录集合
     */
    public List<TransactionRecord> selectTransactionRecordList(TransactionRecord transactionRecord);

    /**
     * 新增账变记录
     * 
     * @param transactionRecord 账变记录
     * @return 结果
     */
    public int insertTransactionRecord(TransactionRecord transactionRecord);

    /**
     * 修改账变记录
     * 
     * @param transactionRecord 账变记录
     * @return 结果
     */
    public int updateTransactionRecord(TransactionRecord transactionRecord);

    /**
     * 删除账变记录
     * 
     * @param id 账变记录主键
     * @return 结果
     */
    public int deleteTransactionRecordById(Long id);

    /**
     * 批量删除账变记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTransactionRecordByIds(Long[] ids);
}
