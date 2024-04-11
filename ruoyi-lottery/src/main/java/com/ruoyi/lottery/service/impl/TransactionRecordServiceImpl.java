package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.TransactionRecordMapper;
import com.ruoyi.lottery.domain.TransactionRecord;
import com.ruoyi.lottery.service.ITransactionRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 账变记录Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class TransactionRecordServiceImpl extends ServiceImpl<TransactionRecordMapper, TransactionRecord> implements ITransactionRecordService
{
    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 查询账变记录
     * 
     * @param id 账变记录主键
     * @return 账变记录
     */
    @Override
    public TransactionRecord selectTransactionRecordById(Long id)
    {
        return transactionRecordMapper.selectTransactionRecordById(id);
    }

    /**
     * 查询账变记录列表
     * 
     * @param transactionRecord 账变记录
     * @return 账变记录
     */
    @Override
    public List<TransactionRecord> selectTransactionRecordList(TransactionRecord transactionRecord)
    {
        return transactionRecordMapper.selectTransactionRecordList(transactionRecord);
    }

    /**
     * 新增账变记录
     * 
     * @param transactionRecord 账变记录
     * @return 结果
     */
    @Override
    public int insertTransactionRecord(TransactionRecord transactionRecord)
    {
        transactionRecord.setCreateTime(DateUtils.getNowDate());
        return transactionRecordMapper.insertTransactionRecord(transactionRecord);
    }

    /**
     * 修改账变记录
     * 
     * @param transactionRecord 账变记录
     * @return 结果
     */
    @Override
    public int updateTransactionRecord(TransactionRecord transactionRecord)
    {
        return transactionRecordMapper.updateTransactionRecord(transactionRecord);
    }

    /**
     * 批量删除账变记录
     * 
     * @param ids 需要删除的账变记录主键
     * @return 结果
     */
    @Override
    public int deleteTransactionRecordByIds(Long[] ids)
    {
        return transactionRecordMapper.deleteTransactionRecordByIds(ids);
    }

    /**
     * 删除账变记录信息
     * 
     * @param id 账变记录主键
     * @return 结果
     */
    @Override
    public int deleteTransactionRecordById(Long id)
    {
        return transactionRecordMapper.deleteTransactionRecordById(id);
    }
}
