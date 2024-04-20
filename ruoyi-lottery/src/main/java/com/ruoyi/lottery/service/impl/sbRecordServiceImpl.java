package com.ruoyi.lottery.service.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.sbRecordMapper;
import com.ruoyi.lottery.domain.sbRecord;
import com.ruoyi.lottery.service.IsbRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 沙巴体育注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class sbRecordServiceImpl extends ServiceImpl<sbRecordMapper, sbRecord> implements IsbRecordService
{
    @Autowired
    private sbRecordMapper sbRecordMapper;

    /**
     * 查询沙巴体育注单
     * 
     * @param id 沙巴体育注单主键
     * @return 沙巴体育注单
     */
    @Override
    public sbRecord selectsbRecordById(Long id)
    {
        return sbRecordMapper.selectsbRecordById(id);
    }

    /**
     * 查询沙巴体育注单列表
     * 
     * @param sbRecord 沙巴体育注单
     * @return 沙巴体育注单
     */
    @Override
    public List<sbRecord> selectsbRecordList(sbRecord sbRecord)
    {
        List<sbRecord> list = sbRecordMapper.selectsbRecordList(sbRecord);
        for (sbRecord record : list) {
            record.setParlaynum(0L);
            if (StringUtils.isNotBlank(record.getParlaysub())) {
                JSONArray array = JSON.parseArray(record.getParlaysub());
                record.setParlaysubArr(array);
                record.setParlaynum(Long.valueOf(array.size()));
            }
        }
        return list;
    }

    /**
     * 新增沙巴体育注单
     * 
     * @param sbRecord 沙巴体育注单
     * @return 结果
     */
    @Override
    public int insertsbRecord(sbRecord sbRecord)
    {
        sbRecord.setCreateTime(DateUtils.getNowDate());
        return sbRecordMapper.insertsbRecord(sbRecord);
    }

    /**
     * 修改沙巴体育注单
     * 
     * @param sbRecord 沙巴体育注单
     * @return 结果
     */
    @Override
    public int updatesbRecord(sbRecord sbRecord)
    {
        sbRecord.setUpdateTime(DateUtils.getNowDate());
        return sbRecordMapper.updatesbRecord(sbRecord);
    }

    /**
     * 批量删除沙巴体育注单
     * 
     * @param ids 需要删除的沙巴体育注单主键
     * @return 结果
     */
    @Override
    public int deletesbRecordByIds(Long[] ids)
    {
        return sbRecordMapper.deletesbRecordByIds(ids);
    }

    /**
     * 删除沙巴体育注单信息
     * 
     * @param id 沙巴体育注单主键
     * @return 结果
     */
    @Override
    public int deletesbRecordById(Long id)
    {
        return sbRecordMapper.deletesbRecordById(id);
    }
}
