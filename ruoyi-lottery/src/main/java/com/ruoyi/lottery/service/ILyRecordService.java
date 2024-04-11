package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.LyRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 乐游注单Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ILyRecordService extends IService<LyRecord>
{
    /**
     * 查询乐游注单
     * 
     * @param id 乐游注单主键
     * @return 乐游注单
     */
    public LyRecord selectLyRecordById(Long id);

    /**
     * 查询乐游注单列表
     * 
     * @param lyRecord 乐游注单
     * @return 乐游注单集合
     */
    public List<LyRecord> selectLyRecordList(LyRecord lyRecord);

    /**
     * 新增乐游注单
     * 
     * @param lyRecord 乐游注单
     * @return 结果
     */
    public int insertLyRecord(LyRecord lyRecord);

    /**
     * 修改乐游注单
     * 
     * @param lyRecord 乐游注单
     * @return 结果
     */
    public int updateLyRecord(LyRecord lyRecord);

    /**
     * 批量删除乐游注单
     * 
     * @param ids 需要删除的乐游注单主键集合
     * @return 结果
     */
    public int deleteLyRecordByIds(Long[] ids);

    /**
     * 删除乐游注单信息
     * 
     * @param id 乐游注单主键
     * @return 结果
     */
    public int deleteLyRecordById(Long id);
}
