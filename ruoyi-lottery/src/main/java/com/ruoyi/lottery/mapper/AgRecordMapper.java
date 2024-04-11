package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.AgRecord;

/**
 * AG注单Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface AgRecordMapper extends BaseMapper<AgRecord>
{
    /**
     * 查询AG注单
     * 
     * @param id AG注单主键
     * @return AG注单
     */
    public AgRecord selectAgRecordById(Long id);

    /**
     * 查询AG注单列表
     * 
     * @param agRecord AG注单
     * @return AG注单集合
     */
    public List<AgRecord> selectAgRecordList(AgRecord agRecord);

    /**
     * 新增AG注单
     * 
     * @param agRecord AG注单
     * @return 结果
     */
    public int insertAgRecord(AgRecord agRecord);

    /**
     * 修改AG注单
     * 
     * @param agRecord AG注单
     * @return 结果
     */
    public int updateAgRecord(AgRecord agRecord);

    /**
     * 删除AG注单
     * 
     * @param id AG注单主键
     * @return 结果
     */
    public int deleteAgRecordById(Long id);

    /**
     * 批量删除AG注单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgRecordByIds(Long[] ids);
}
