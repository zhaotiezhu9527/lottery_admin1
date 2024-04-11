package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.HgRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 皇冠体育注单Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IHgRecordService extends IService<HgRecord>
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
     * 批量删除皇冠体育注单
     * 
     * @param ids 需要删除的皇冠体育注单主键集合
     * @return 结果
     */
    public int deleteHgRecordByIds(Long[] ids);

    /**
     * 删除皇冠体育注单信息
     * 
     * @param id 皇冠体育注单主键
     * @return 结果
     */
    public int deleteHgRecordById(Long id);
}
