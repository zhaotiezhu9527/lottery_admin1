package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultGs1m11x5;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 1分11选5Service接口
 * 
 * @author hardy
 * @date 2024-04-15
 */
public interface IOpenresultGs1m11x5Service extends IService<OpenresultGs1m11x5>
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
     * 批量删除1分11选5
     * 
     * @param ids 需要删除的1分11选5主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1m11x5ByIds(Long[] ids);

    /**
     * 删除1分11选5信息
     * 
     * @param id 1分11选5主键
     * @return 结果
     */
    public int deleteOpenresultGs1m11x5ById(Long id);
}
