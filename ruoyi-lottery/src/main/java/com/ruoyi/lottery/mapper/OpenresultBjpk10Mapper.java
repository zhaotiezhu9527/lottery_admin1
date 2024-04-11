package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultBjpk10;

/**
 * 开奖结果(北京PK10)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultBjpk10Mapper extends BaseMapper<OpenresultBjpk10>
{
    /**
     * 查询开奖结果(北京PK10)
     * 
     * @param id 开奖结果(北京PK10)主键
     * @return 开奖结果(北京PK10)
     */
    public OpenresultBjpk10 selectOpenresultBjpk10ById(Long id);

    /**
     * 查询开奖结果(北京PK10)列表
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 开奖结果(北京PK10)集合
     */
    public List<OpenresultBjpk10> selectOpenresultBjpk10List(OpenresultBjpk10 openresultBjpk10);

    /**
     * 新增开奖结果(北京PK10)
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 结果
     */
    public int insertOpenresultBjpk10(OpenresultBjpk10 openresultBjpk10);

    /**
     * 修改开奖结果(北京PK10)
     * 
     * @param openresultBjpk10 开奖结果(北京PK10)
     * @return 结果
     */
    public int updateOpenresultBjpk10(OpenresultBjpk10 openresultBjpk10);

    /**
     * 删除开奖结果(北京PK10)
     * 
     * @param id 开奖结果(北京PK10)主键
     * @return 结果
     */
    public int deleteOpenresultBjpk10ById(Long id);

    /**
     * 批量删除开奖结果(北京PK10)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultBjpk10ByIds(Long[] ids);
}
