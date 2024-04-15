package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1m11x5;

/**
 * 1分11选5Mapper接口
 * 
 * @author hardy
 * @date 2024-04-15
 */
public interface OpenresultGs1m11x5Mapper extends BaseMapper<OpenresultGs1m11x5>
{
    /**
     * 查询1分11选5
     * 
     * @param id 1分11选5主键
     * @return 1分11选5
     */
    public OpenresultGs1m11x5 selectOpenresultGs1m11x5ById(Long id);

    /**
     * 查询1分11选5列表
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 1分11选5集合
     */
    public List<OpenresultGs1m11x5> selectOpenresultGs1m11x5List(OpenresultGs1m11x5 openresultGs1m11x5);

    /**
     * 新增1分11选5
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 结果
     */
    public int insertOpenresultGs1m11x5(OpenresultGs1m11x5 openresultGs1m11x5);

    /**
     * 修改1分11选5
     * 
     * @param openresultGs1m11x5 1分11选5
     * @return 结果
     */
    public int updateOpenresultGs1m11x5(OpenresultGs1m11x5 openresultGs1m11x5);

    /**
     * 删除1分11选5
     * 
     * @param id 1分11选5主键
     * @return 结果
     */
    public int deleteOpenresultGs1m11x5ById(Long id);

    /**
     * 批量删除1分11选5
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1m11x5ByIds(Long[] ids);
}
