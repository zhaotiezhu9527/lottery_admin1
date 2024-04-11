package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.BbinRecordMapper;
import com.ruoyi.lottery.domain.BbinRecord;
import com.ruoyi.lottery.service.IBbinRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 三方注单(BBIN)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class BbinRecordServiceImpl extends ServiceImpl<BbinRecordMapper, BbinRecord> implements IBbinRecordService
{
    @Autowired
    private BbinRecordMapper bbinRecordMapper;

    /**
     * 查询三方注单(BBIN)
     * 
     * @param id 三方注单(BBIN)主键
     * @return 三方注单(BBIN)
     */
    @Override
    public BbinRecord selectBbinRecordById(Long id)
    {
        return bbinRecordMapper.selectBbinRecordById(id);
    }

    /**
     * 查询三方注单(BBIN)列表
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 三方注单(BBIN)
     */
    @Override
    public List<BbinRecord> selectBbinRecordList(BbinRecord bbinRecord)
    {
        return bbinRecordMapper.selectBbinRecordList(bbinRecord);
    }

    /**
     * 新增三方注单(BBIN)
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 结果
     */
    @Override
    public int insertBbinRecord(BbinRecord bbinRecord)
    {
        bbinRecord.setCreateTime(DateUtils.getNowDate());
        return bbinRecordMapper.insertBbinRecord(bbinRecord);
    }

    /**
     * 修改三方注单(BBIN)
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 结果
     */
    @Override
    public int updateBbinRecord(BbinRecord bbinRecord)
    {
        bbinRecord.setUpdateTime(DateUtils.getNowDate());
        return bbinRecordMapper.updateBbinRecord(bbinRecord);
    }

    /**
     * 批量删除三方注单(BBIN)
     * 
     * @param ids 需要删除的三方注单(BBIN)主键
     * @return 结果
     */
    @Override
    public int deleteBbinRecordByIds(Long[] ids)
    {
        return bbinRecordMapper.deleteBbinRecordByIds(ids);
    }

    /**
     * 删除三方注单(BBIN)信息
     * 
     * @param id 三方注单(BBIN)主键
     * @return 结果
     */
    @Override
    public int deleteBbinRecordById(Long id)
    {
        return bbinRecordMapper.deleteBbinRecordById(id);
    }
}
