package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mk3;

/**
 * 开奖结果(GS1分快3)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultGs1mk3Mapper extends BaseMapper<OpenresultGs1mk3>
{
    /**
     * 查询开奖结果(GS1分快3)
     * 
     * @param id 开奖结果(GS1分快3)主键
     * @return 开奖结果(GS1分快3)
     */
    public OpenresultGs1mk3 selectOpenresultGs1mk3ById(Long id);

    /**
     * 查询开奖结果(GS1分快3)列表
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 开奖结果(GS1分快3)集合
     */
    public List<OpenresultGs1mk3> selectOpenresultGs1mk3List(OpenresultGs1mk3 openresultGs1mk3);

    /**
     * 新增开奖结果(GS1分快3)
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 结果
     */
    public int insertOpenresultGs1mk3(OpenresultGs1mk3 openresultGs1mk3);

    /**
     * 修改开奖结果(GS1分快3)
     * 
     * @param openresultGs1mk3 开奖结果(GS1分快3)
     * @return 结果
     */
    public int updateOpenresultGs1mk3(OpenresultGs1mk3 openresultGs1mk3);

    /**
     * 删除开奖结果(GS1分快3)
     * 
     * @param id 开奖结果(GS1分快3)主键
     * @return 结果
     */
    public int deleteOpenresultGs1mk3ById(Long id);

    /**
     * 批量删除开奖结果(GS1分快3)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mk3ByIds(Long[] ids);
}
