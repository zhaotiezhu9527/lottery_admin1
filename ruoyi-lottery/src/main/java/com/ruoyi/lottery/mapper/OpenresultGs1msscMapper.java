package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mssc;

/**
 * 开奖结果(gs1mssc)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultGs1msscMapper extends BaseMapper<OpenresultGs1mssc>
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
     * 删除开奖结果(gs1mssc)
     * 
     * @param id 开奖结果(gs1mssc)主键
     * @return 结果
     */
    public int deleteOpenresultGs1msscById(Long id);

    /**
     * 批量删除开奖结果(gs1mssc)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1msscByIds(Long[] ids);
}
