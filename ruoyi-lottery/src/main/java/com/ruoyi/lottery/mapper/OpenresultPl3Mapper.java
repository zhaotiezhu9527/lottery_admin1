package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultPl3;

/**
 * 排列3Mapper接口
 * 
 * @author hardy
 * @date 2024-04-17
 */
public interface OpenresultPl3Mapper extends BaseMapper<OpenresultPl3>
{
    /**
     * 查询排列3
     * 
     * @param id 排列3主键
     * @return 排列3
     */
    public OpenresultPl3 selectOpenresultPl3ById(Long id);

    /**
     * 查询排列3列表
     * 
     * @param openresultPl3 排列3
     * @return 排列3集合
     */
    public List<OpenresultPl3> selectOpenresultPl3List(OpenresultPl3 openresultPl3);

    /**
     * 新增排列3
     * 
     * @param openresultPl3 排列3
     * @return 结果
     */
    public int insertOpenresultPl3(OpenresultPl3 openresultPl3);

    /**
     * 修改排列3
     * 
     * @param openresultPl3 排列3
     * @return 结果
     */
    public int updateOpenresultPl3(OpenresultPl3 openresultPl3);

    /**
     * 删除排列3
     * 
     * @param id 排列3主键
     * @return 结果
     */
    public int deleteOpenresultPl3ById(Long id);

    /**
     * 批量删除排列3
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultPl3ByIds(Long[] ids);
}
