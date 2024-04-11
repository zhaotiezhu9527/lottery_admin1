package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.HgRecordMapper;
import com.ruoyi.lottery.domain.HgRecord;
import com.ruoyi.lottery.service.IHgRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 皇冠体育注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class HgRecordServiceImpl extends ServiceImpl<HgRecordMapper, HgRecord> implements IHgRecordService
{
    @Autowired
    private HgRecordMapper hgRecordMapper;

    /**
     * 查询皇冠体育注单
     * 
     * @param id 皇冠体育注单主键
     * @return 皇冠体育注单
     */
    @Override
    public HgRecord selectHgRecordById(Long id)
    {
        return hgRecordMapper.selectHgRecordById(id);
    }

    /**
     * 查询皇冠体育注单列表
     * 
     * @param hgRecord 皇冠体育注单
     * @return 皇冠体育注单
     */
    @Override
    public List<HgRecord> selectHgRecordList(HgRecord hgRecord)
    {
        return hgRecordMapper.selectHgRecordList(hgRecord);
    }

    /**
     * 新增皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    @Override
    public int insertHgRecord(HgRecord hgRecord)
    {
        hgRecord.setCreateTime(DateUtils.getNowDate());
        return hgRecordMapper.insertHgRecord(hgRecord);
    }

    /**
     * 修改皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    @Override
    public int updateHgRecord(HgRecord hgRecord)
    {
        hgRecord.setUpdateTime(DateUtils.getNowDate());
        return hgRecordMapper.updateHgRecord(hgRecord);
    }

    /**
     * 批量删除皇冠体育注单
     * 
     * @param ids 需要删除的皇冠体育注单主键
     * @return 结果
     */
    @Override
    public int deleteHgRecordByIds(Long[] ids)
    {
        return hgRecordMapper.deleteHgRecordByIds(ids);
    }

    /**
     * 删除皇冠体育注单信息
     * 
     * @param id 皇冠体育注单主键
     * @return 结果
     */
    @Override
    public int deleteHgRecordById(Long id)
    {
        return hgRecordMapper.deleteHgRecordById(id);
    }
}
