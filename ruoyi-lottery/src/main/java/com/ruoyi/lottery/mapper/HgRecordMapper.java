package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.HgRecord;

/**
 * 皇冠体育注单Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface HgRecordMapper extends BaseMapper<HgRecord>
{
    /**
     * 查询皇冠体育注单
     * 
     * @param id 皇冠体育注单主键
     * @return 皇冠体育注单
     */
    public HgRecord selectHgRecordById(Long id);

    /**
     * 查询皇冠体育注单列表
     * 
     * @param hgRecord 皇冠体育注单
     * @return 皇冠体育注单集合
     */
    public List<HgRecord> selectHgRecordList(HgRecord hgRecord);

    /**
     * 新增皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    public int insertHgRecord(HgRecord hgRecord);

    /**
     * 修改皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    public int updateHgRecord(HgRecord hgRecord);

    /**
     * 删除皇冠体育注单
     * 
     * @param id 皇冠体育注单主键
     * @return 结果
     */
    public int deleteHgRecordById(Long id);

    /**
     * 批量删除皇冠体育注单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHgRecordByIds(Long[] ids);
}
