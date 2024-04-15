package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultGs1mpcdd;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 1分PC蛋蛋Service接口
 * 
 * @author hardy
 * @date 2024-04-15
 */
public interface IOpenresultGs1mpcddService extends IService<OpenresultGs1mpcdd>
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
     * 批量删除1分PC蛋蛋
     * 
     * @param ids 需要删除的1分PC蛋蛋主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mpcddByIds(Long[] ids);

    /**
     * 删除1分PC蛋蛋信息
     * 
     * @param id 1分PC蛋蛋主键
     * @return 结果
     */
    public int deleteOpenresultGs1mpcddById(Long id);
}
