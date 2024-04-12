package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultGs1mlhc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 1分六合彩开奖Service接口
 * 
 * @author hardy
 * @date 2024-04-12
 */
public interface IOpenresultGs1mlhcService extends IService<OpenresultGs1mlhc>
{
    /**
     * 查询1分六合彩开奖
     * 
     * @param id 1分六合彩开奖主键
     * @return 1分六合彩开奖
     */
    public OpenresultGs1mlhc selectOpenresultGs1mlhcById(Long id);

    /**
     * 查询1分六合彩开奖列表
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 1分六合彩开奖集合
     */
    public List<OpenresultGs1mlhc> selectOpenresultGs1mlhcList(OpenresultGs1mlhc openresultGs1mlhc);

    /**
     * 新增1分六合彩开奖
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 结果
     */
    public int insertOpenresultGs1mlhc(OpenresultGs1mlhc openresultGs1mlhc);

    /**
     * 修改1分六合彩开奖
     * 
     * @param openresultGs1mlhc 1分六合彩开奖
     * @return 结果
     */
    public int updateOpenresultGs1mlhc(OpenresultGs1mlhc openresultGs1mlhc);

    /**
     * 批量删除1分六合彩开奖
     * 
     * @param ids 需要删除的1分六合彩开奖主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mlhcByIds(Long[] ids);

    /**
     * 删除1分六合彩开奖信息
     * 
     * @param id 1分六合彩开奖主键
     * @return 结果
     */
    public int deleteOpenresultGs1mlhcById(Long id);
}
