package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.AgRecordMapper;
import com.ruoyi.lottery.domain.AgRecord;
import com.ruoyi.lottery.service.IAgRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * AG注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class AgRecordServiceImpl extends ServiceImpl<AgRecordMapper, AgRecord> implements IAgRecordService
{
    @Autowired
    private AgRecordMapper agRecordMapper;

    /**
     * 查询AG注单
     * 
     * @param id AG注单主键
     * @return AG注单
     */
    @Override
    public AgRecord selectAgRecordById(Long id)
    {
        return agRecordMapper.selectAgRecordById(id);
    }

    /**
     * 查询AG注单列表
     * 
     * @param agRecord AG注单
     * @return AG注单
     */
    @Override
    public List<AgRecord> selectAgRecordList(AgRecord agRecord)
    {
        return agRecordMapper.selectAgRecordList(agRecord);
    }

    /**
     * 新增AG注单
     * 
     * @param agRecord AG注单
     * @return 结果
     */
    @Override
    public int insertAgRecord(AgRecord agRecord)
    {
        agRecord.setCreateTime(DateUtils.getNowDate());
        return agRecordMapper.insertAgRecord(agRecord);
    }

    /**
     * 修改AG注单
     * 
     * @param agRecord AG注单
     * @return 结果
     */
    @Override
    public int updateAgRecord(AgRecord agRecord)
    {
        agRecord.setUpdateTime(DateUtils.getNowDate());
        return agRecordMapper.updateAgRecord(agRecord);
    }

    /**
     * 批量删除AG注单
     * 
     * @param ids 需要删除的AG注单主键
     * @return 结果
     */
    @Override
    public int deleteAgRecordByIds(Long[] ids)
    {
        return agRecordMapper.deleteAgRecordByIds(ids);
    }

    /**
     * 删除AG注单信息
     * 
     * @param id AG注单主键
     * @return 结果
     */
    @Override
    public int deleteAgRecordById(Long id)
    {
        return agRecordMapper.deleteAgRecordById(id);
    }
}
