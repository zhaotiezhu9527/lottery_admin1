package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultCqssc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(重庆时时彩)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultCqsscService extends IService<OpenresultCqssc>
{
    /**
     * 查询开奖结果(重庆时时彩)
     * 
     * @param id 开奖结果(重庆时时彩)主键
     * @return 开奖结果(重庆时时彩)
     */
    public OpenresultCqssc selectOpenresultCqsscById(Long id);

    /**
     * 查询开奖结果(重庆时时彩)列表
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 开奖结果(重庆时时彩)集合
     */
    public List<OpenresultCqssc> selectOpenresultCqsscList(OpenresultCqssc openresultCqssc);

    /**
     * 新增开奖结果(重庆时时彩)
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 结果
     */
    public int insertOpenresultCqssc(OpenresultCqssc openresultCqssc);

    /**
     * 修改开奖结果(重庆时时彩)
     * 
     * @param openresultCqssc 开奖结果(重庆时时彩)
     * @return 结果
     */
    public int updateOpenresultCqssc(OpenresultCqssc openresultCqssc);

    /**
     * 批量删除开奖结果(重庆时时彩)
     * 
     * @param ids 需要删除的开奖结果(重庆时时彩)主键集合
     * @return 结果
     */
    public int deleteOpenresultCqsscByIds(Long[] ids);

    /**
     * 删除开奖结果(重庆时时彩)信息
     * 
     * @param id 开奖结果(重庆时时彩)主键
     * @return 结果
     */
    public int deleteOpenresultCqsscById(Long id);
}
