package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGd11x5;

/**
 * 开奖结果(广东11选5)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultGd11x5Mapper extends BaseMapper<OpenresultGd11x5>
{
    /**
     * 查询开奖结果(广东11选5)
     * 
     * @param id 开奖结果(广东11选5)主键
     * @return 开奖结果(广东11选5)
     */
    public OpenresultGd11x5 selectOpenresultGd11x5ById(Long id);

    /**
     * 查询开奖结果(广东11选5)列表
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 开奖结果(广东11选5)集合
     */
    public List<OpenresultGd11x5> selectOpenresultGd11x5List(OpenresultGd11x5 openresultGd11x5);

    /**
     * 新增开奖结果(广东11选5)
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 结果
     */
    public int insertOpenresultGd11x5(OpenresultGd11x5 openresultGd11x5);

    /**
     * 修改开奖结果(广东11选5)
     * 
     * @param openresultGd11x5 开奖结果(广东11选5)
     * @return 结果
     */
    public int updateOpenresultGd11x5(OpenresultGd11x5 openresultGd11x5);

    /**
     * 删除开奖结果(广东11选5)
     * 
     * @param id 开奖结果(广东11选5)主键
     * @return 结果
     */
    public int deleteOpenresultGd11x5ById(Long id);

    /**
     * 批量删除开奖结果(广东11选5)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGd11x5ByIds(Long[] ids);
}
