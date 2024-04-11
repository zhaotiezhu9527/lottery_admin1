package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultFt;

/**
 * 开奖结果(飞艇)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultFtMapper extends BaseMapper<OpenresultFt>
{
    /**
     * 查询开奖结果(飞艇)
     * 
     * @param id 开奖结果(飞艇)主键
     * @return 开奖结果(飞艇)
     */
    public OpenresultFt selectOpenresultFtById(Long id);

    /**
     * 查询开奖结果(飞艇)列表
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 开奖结果(飞艇)集合
     */
    public List<OpenresultFt> selectOpenresultFtList(OpenresultFt openresultFt);

    /**
     * 新增开奖结果(飞艇)
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 结果
     */
    public int insertOpenresultFt(OpenresultFt openresultFt);

    /**
     * 修改开奖结果(飞艇)
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 结果
     */
    public int updateOpenresultFt(OpenresultFt openresultFt);

    /**
     * 删除开奖结果(飞艇)
     * 
     * @param id 开奖结果(飞艇)主键
     * @return 结果
     */
    public int deleteOpenresultFtById(Long id);

    /**
     * 批量删除开奖结果(飞艇)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultFtByIds(Long[] ids);
}
