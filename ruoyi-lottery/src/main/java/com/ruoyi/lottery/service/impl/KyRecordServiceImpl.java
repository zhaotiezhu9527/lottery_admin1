package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.KyRecordMapper;
import com.ruoyi.lottery.domain.KyRecord;
import com.ruoyi.lottery.service.IKyRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开元注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class KyRecordServiceImpl extends ServiceImpl<KyRecordMapper, KyRecord> implements IKyRecordService
{
    @Autowired
    private KyRecordMapper kyRecordMapper;

    /**
     * 查询开元注单
     * 
     * @param id 开元注单主键
     * @return 开元注单
     */
    @Override
    public KyRecord selectKyRecordById(Long id)
    {
        return kyRecordMapper.selectKyRecordById(id);
    }

    /**
     * 查询开元注单列表
     * 
     * @param kyRecord 开元注单
     * @return 开元注单
     */
    @Override
    public List<KyRecord> selectKyRecordList(KyRecord kyRecord)
    {
        return kyRecordMapper.selectKyRecordList(kyRecord);
    }

    /**
     * 新增开元注单
     * 
     * @param kyRecord 开元注单
     * @return 结果
     */
    @Override
    public int insertKyRecord(KyRecord kyRecord)
    {
        kyRecord.setCreateTime(DateUtils.getNowDate());
        return kyRecordMapper.insertKyRecord(kyRecord);
    }

    /**
     * 修改开元注单
     * 
     * @param kyRecord 开元注单
     * @return 结果
     */
    @Override
    public int updateKyRecord(KyRecord kyRecord)
    {
        kyRecord.setUpdateTime(DateUtils.getNowDate());
        return kyRecordMapper.updateKyRecord(kyRecord);
    }

    /**
     * 批量删除开元注单
     * 
     * @param ids 需要删除的开元注单主键
     * @return 结果
     */
    @Override
    public int deleteKyRecordByIds(Long[] ids)
    {
        return kyRecordMapper.deleteKyRecordByIds(ids);
    }

    /**
     * 删除开元注单信息
     * 
     * @param id 开元注单主键
     * @return 结果
     */
    @Override
    public int deleteKyRecordById(Long id)
    {
        return kyRecordMapper.deleteKyRecordById(id);
    }
}
