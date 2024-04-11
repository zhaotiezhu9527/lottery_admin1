package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultMo6hc;

/**
 * 开奖结果(澳门六合彩)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultMo6hcMapper extends BaseMapper<OpenresultMo6hc>
{
    /**
     * 查询开奖结果(澳门六合彩)
     * 
     * @param id 开奖结果(澳门六合彩)主键
     * @return 开奖结果(澳门六合彩)
     */
    public OpenresultMo6hc selectOpenresultMo6hcById(Long id);

    /**
     * 查询开奖结果(澳门六合彩)列表
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 开奖结果(澳门六合彩)集合
     */
    public List<OpenresultMo6hc> selectOpenresultMo6hcList(OpenresultMo6hc openresultMo6hc);

    /**
     * 新增开奖结果(澳门六合彩)
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 结果
     */
    public int insertOpenresultMo6hc(OpenresultMo6hc openresultMo6hc);

    /**
     * 修改开奖结果(澳门六合彩)
     * 
     * @param openresultMo6hc 开奖结果(澳门六合彩)
     * @return 结果
     */
    public int updateOpenresultMo6hc(OpenresultMo6hc openresultMo6hc);

    /**
     * 删除开奖结果(澳门六合彩)
     * 
     * @param id 开奖结果(澳门六合彩)主键
     * @return 结果
     */
    public int deleteOpenresultMo6hcById(Long id);

    /**
     * 批量删除开奖结果(澳门六合彩)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultMo6hcByIds(Long[] ids);
}
