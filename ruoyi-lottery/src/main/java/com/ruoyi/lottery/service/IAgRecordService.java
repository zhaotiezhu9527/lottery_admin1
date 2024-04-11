package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.AgRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * AG注单Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IAgRecordService extends IService<AgRecord>
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
     * 批量删除AG注单
     * 
     * @param ids 需要删除的AG注单主键集合
     * @return 结果
     */
    public int deleteAgRecordByIds(Long[] ids);

    /**
     * 删除AG注单信息
     * 
     * @param id AG注单主键
     * @return 结果
     */
    public int deleteAgRecordById(Long id);
}
