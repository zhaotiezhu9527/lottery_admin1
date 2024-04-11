package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultMo6hc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(澳门六合彩)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultMo6hcService extends IService<OpenresultMo6hc>
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
     * 批量删除开奖结果(澳门六合彩)
     * 
     * @param ids 需要删除的开奖结果(澳门六合彩)主键集合
     * @return 结果
     */
    public int deleteOpenresultMo6hcByIds(Long[] ids);

    /**
     * 删除开奖结果(澳门六合彩)信息
     * 
     * @param id 开奖结果(澳门六合彩)主键
     * @return 结果
     */
    public int deleteOpenresultMo6hcById(Long id);
}
