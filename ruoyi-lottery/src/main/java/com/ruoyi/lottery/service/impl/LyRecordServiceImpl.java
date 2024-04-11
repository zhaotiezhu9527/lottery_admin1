package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.LyRecordMapper;
import com.ruoyi.lottery.domain.LyRecord;
import com.ruoyi.lottery.service.ILyRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 乐游注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class LyRecordServiceImpl extends ServiceImpl<LyRecordMapper, LyRecord> implements ILyRecordService
{
    @Autowired
    private LyRecordMapper lyRecordMapper;

    /**
     * 查询乐游注单
     * 
     * @param id 乐游注单主键
     * @return 乐游注单
     */
    @Override
    public LyRecord selectLyRecordById(Long id)
    {
        return lyRecordMapper.selectLyRecordById(id);
    }

    /**
     * 查询乐游注单列表
     * 
     * @param lyRecord 乐游注单
     * @return 乐游注单
     */
    @Override
    public List<LyRecord> selectLyRecordList(LyRecord lyRecord)
    {
        return lyRecordMapper.selectLyRecordList(lyRecord);
    }

    /**
     * 新增乐游注单
     * 
     * @param lyRecord 乐游注单
     * @return 结果
     */
    @Override
    public int insertLyRecord(LyRecord lyRecord)
    {
        lyRecord.setCreateTime(DateUtils.getNowDate());
        return lyRecordMapper.insertLyRecord(lyRecord);
    }

    /**
     * 修改乐游注单
     * 
     * @param lyRecord 乐游注单
     * @return 结果
     */
    @Override
    public int updateLyRecord(LyRecord lyRecord)
    {
        lyRecord.setUpdateTime(DateUtils.getNowDate());
        return lyRecordMapper.updateLyRecord(lyRecord);
    }

    /**
     * 批量删除乐游注单
     * 
     * @param ids 需要删除的乐游注单主键
     * @return 结果
     */
    @Override
    public int deleteLyRecordByIds(Long[] ids)
    {
        return lyRecordMapper.deleteLyRecordByIds(ids);
    }

    /**
     * 删除乐游注单信息
     * 
     * @param id 乐游注单主键
     * @return 结果
     */
    @Override
    public int deleteLyRecordById(Long id)
    {
        return lyRecordMapper.deleteLyRecordById(id);
    }
}
