package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.sbRecord;

/**
 * 沙巴体育注单Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface sbRecordMapper extends BaseMapper<sbRecord>
{
    /**
     * 查询沙巴体育注单
     * 
     * @param id 沙巴体育注单主键
     * @return 沙巴体育注单
     */
    public sbRecord selectsbRecordById(Long id);

    /**
     * 查询沙巴体育注单列表
     * 
     * @param sbRecord 沙巴体育注单
     * @return 沙巴体育注单集合
     */
    public List<sbRecord> selectsbRecordList(sbRecord sbRecord);

    /**
     * 新增沙巴体育注单
     * 
     * @param sbRecord 沙巴体育注单
     * @return 结果
     */
    public int insertsbRecord(sbRecord sbRecord);

    /**
     * 修改沙巴体育注单
     * 
     * @param sbRecord 沙巴体育注单
     * @return 结果
     */
    public int updatesbRecord(sbRecord sbRecord);

    /**
     * 删除沙巴体育注单
     * 
     * @param id 沙巴体育注单主键
     * @return 结果
     */
    public int deletesbRecordById(Long id);

    /**
     * 批量删除沙巴体育注单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletesbRecordByIds(Long[] ids);
}
