package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mpcdd;

/**
 * 1分PC蛋蛋Mapper接口
 * 
 * @author hardy
 * @date 2024-04-15
 */
public interface OpenresultGs1mpcddMapper extends BaseMapper<OpenresultGs1mpcdd>
{
    /**
     * 查询1分PC蛋蛋
     * 
     * @param id 1分PC蛋蛋主键
     * @return 1分PC蛋蛋
     */
    public OpenresultGs1mpcdd selectOpenresultGs1mpcddById(Long id);

    /**
     * 查询1分PC蛋蛋列表
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 1分PC蛋蛋集合
     */
    public List<OpenresultGs1mpcdd> selectOpenresultGs1mpcddList(OpenresultGs1mpcdd openresultGs1mpcdd);

    /**
     * 新增1分PC蛋蛋
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 结果
     */
    public int insertOpenresultGs1mpcdd(OpenresultGs1mpcdd openresultGs1mpcdd);

    /**
     * 修改1分PC蛋蛋
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 结果
     */
    public int updateOpenresultGs1mpcdd(OpenresultGs1mpcdd openresultGs1mpcdd);

    /**
     * 删除1分PC蛋蛋
     * 
     * @param id 1分PC蛋蛋主键
     * @return 结果
     */
    public int deleteOpenresultGs1mpcddById(Long id);

    /**
     * 批量删除1分PC蛋蛋
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mpcddByIds(Long[] ids);
}
