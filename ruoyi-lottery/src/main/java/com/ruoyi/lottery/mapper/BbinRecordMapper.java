package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.BbinRecord;

/**
 * 三方注单(BBIN)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface BbinRecordMapper extends BaseMapper<BbinRecord>
{
    /**
     * 查询三方注单(BBIN)
     * 
     * @param id 三方注单(BBIN)主键
     * @return 三方注单(BBIN)
     */
    public BbinRecord selectBbinRecordById(Long id);

    /**
     * 查询三方注单(BBIN)列表
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 三方注单(BBIN)集合
     */
    public List<BbinRecord> selectBbinRecordList(BbinRecord bbinRecord);

    /**
     * 新增三方注单(BBIN)
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 结果
     */
    public int insertBbinRecord(BbinRecord bbinRecord);

    /**
     * 修改三方注单(BBIN)
     * 
     * @param bbinRecord 三方注单(BBIN)
     * @return 结果
     */
    public int updateBbinRecord(BbinRecord bbinRecord);

    /**
     * 删除三方注单(BBIN)
     * 
     * @param id 三方注单(BBIN)主键
     * @return 结果
     */
    public int deleteBbinRecordById(Long id);

    /**
     * 批量删除三方注单(BBIN)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBbinRecordByIds(Long[] ids);
}
