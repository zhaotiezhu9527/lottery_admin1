package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mpk10;

/**
 * 开奖结果(GS1分PK10)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultGs1mpk10Mapper extends BaseMapper<OpenresultGs1mpk10>
{
    /**
     * 查询开奖结果(GS1分PK10)
     * 
     * @param id 开奖结果(GS1分PK10)主键
     * @return 开奖结果(GS1分PK10)
     */
    public OpenresultGs1mpk10 selectOpenresultGs1mpk10ById(Long id);

    /**
     * 查询开奖结果(GS1分PK10)列表
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 开奖结果(GS1分PK10)集合
     */
    public List<OpenresultGs1mpk10> selectOpenresultGs1mpk10List(OpenresultGs1mpk10 openresultGs1mpk10);

    /**
     * 新增开奖结果(GS1分PK10)
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 结果
     */
    public int insertOpenresultGs1mpk10(OpenresultGs1mpk10 openresultGs1mpk10);

    /**
     * 修改开奖结果(GS1分PK10)
     * 
     * @param openresultGs1mpk10 开奖结果(GS1分PK10)
     * @return 结果
     */
    public int updateOpenresultGs1mpk10(OpenresultGs1mpk10 openresultGs1mpk10);

    /**
     * 删除开奖结果(GS1分PK10)
     * 
     * @param id 开奖结果(GS1分PK10)主键
     * @return 结果
     */
    public int deleteOpenresultGs1mpk10ById(Long id);

    /**
     * 批量删除开奖结果(GS1分PK10)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mpk10ByIds(Long[] ids);
}
