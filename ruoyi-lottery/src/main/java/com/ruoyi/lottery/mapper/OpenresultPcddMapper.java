package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultPcdd;

/**
 * 开奖结果(PC蛋蛋)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultPcddMapper extends BaseMapper<OpenresultPcdd>
{
    /**
     * 查询开奖结果(PC蛋蛋)
     * 
     * @param id 开奖结果(PC蛋蛋)主键
     * @return 开奖结果(PC蛋蛋)
     */
    public OpenresultPcdd selectOpenresultPcddById(Long id);

    /**
     * 查询开奖结果(PC蛋蛋)列表
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 开奖结果(PC蛋蛋)集合
     */
    public List<OpenresultPcdd> selectOpenresultPcddList(OpenresultPcdd openresultPcdd);

    /**
     * 新增开奖结果(PC蛋蛋)
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 结果
     */
    public int insertOpenresultPcdd(OpenresultPcdd openresultPcdd);

    /**
     * 修改开奖结果(PC蛋蛋)
     * 
     * @param openresultPcdd 开奖结果(PC蛋蛋)
     * @return 结果
     */
    public int updateOpenresultPcdd(OpenresultPcdd openresultPcdd);

    /**
     * 删除开奖结果(PC蛋蛋)
     * 
     * @param id 开奖结果(PC蛋蛋)主键
     * @return 结果
     */
    public int deleteOpenresultPcddById(Long id);

    /**
     * 批量删除开奖结果(PC蛋蛋)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultPcddByIds(Long[] ids);
}
