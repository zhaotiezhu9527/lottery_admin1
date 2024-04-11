package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultGs1mssc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(gs1mssc)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultGs1msscService extends IService<OpenresultGs1mssc>
{
    /**
     * 查询开奖结果(gs1mssc)
     * 
     * @param id 开奖结果(gs1mssc)主键
     * @return 开奖结果(gs1mssc)
     */
    public OpenresultGs1mssc selectOpenresultGs1msscById(Long id);

    /**
     * 查询开奖结果(gs1mssc)列表
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 开奖结果(gs1mssc)集合
     */
    public List<OpenresultGs1mssc> selectOpenresultGs1msscList(OpenresultGs1mssc openresultGs1mssc);

    /**
     * 新增开奖结果(gs1mssc)
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 结果
     */
    public int insertOpenresultGs1mssc(OpenresultGs1mssc openresultGs1mssc);

    /**
     * 修改开奖结果(gs1mssc)
     * 
     * @param openresultGs1mssc 开奖结果(gs1mssc)
     * @return 结果
     */
    public int updateOpenresultGs1mssc(OpenresultGs1mssc openresultGs1mssc);

    /**
     * 批量删除开奖结果(gs1mssc)
     * 
     * @param ids 需要删除的开奖结果(gs1mssc)主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1msscByIds(Long[] ids);

    /**
     * 删除开奖结果(gs1mssc)信息
     * 
     * @param id 开奖结果(gs1mssc)主键
     * @return 结果
     */
    public int deleteOpenresultGs1msscById(Long id);
}
