package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.KyRecord;

/**
 * 开元注单Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface KyRecordMapper extends BaseMapper<KyRecord>
{
    /**
     * 查询开元注单
     * 
     * @param id 开元注单主键
     * @return 开元注单
     */
    public KyRecord selectKyRecordById(Long id);

    /**
     * 查询开元注单列表
     * 
     * @param kyRecord 开元注单
     * @return 开元注单集合
     */
    public List<KyRecord> selectKyRecordList(KyRecord kyRecord);

    /**
     * 新增开元注单
     * 
     * @param kyRecord 开元注单
     * @return 结果
     */
    public int insertKyRecord(KyRecord kyRecord);

    /**
     * 修改开元注单
     * 
     * @param kyRecord 开元注单
     * @return 结果
     */
    public int updateKyRecord(KyRecord kyRecord);

    /**
     * 删除开元注单
     * 
     * @param id 开元注单主键
     * @return 结果
     */
    public int deleteKyRecordById(Long id);

    /**
     * 批量删除开元注单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKyRecordByIds(Long[] ids);
}
