package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultJsk3;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(江苏快3)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultJsk3Service extends IService<OpenresultJsk3>
{
    /**
     * 查询开奖结果(江苏快3)
     * 
     * @param id 开奖结果(江苏快3)主键
     * @return 开奖结果(江苏快3)
     */
    public OpenresultJsk3 selectOpenresultJsk3ById(Long id);

    /**
     * 查询开奖结果(江苏快3)列表
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 开奖结果(江苏快3)集合
     */
    public List<OpenresultJsk3> selectOpenresultJsk3List(OpenresultJsk3 openresultJsk3);

    /**
     * 新增开奖结果(江苏快3)
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 结果
     */
    public int insertOpenresultJsk3(OpenresultJsk3 openresultJsk3);

    /**
     * 修改开奖结果(江苏快3)
     * 
     * @param openresultJsk3 开奖结果(江苏快3)
     * @return 结果
     */
    public int updateOpenresultJsk3(OpenresultJsk3 openresultJsk3);

    /**
     * 批量删除开奖结果(江苏快3)
     * 
     * @param ids 需要删除的开奖结果(江苏快3)主键集合
     * @return 结果
     */
    public int deleteOpenresultJsk3ByIds(Long[] ids);

    /**
     * 删除开奖结果(江苏快3)信息
     * 
     * @param id 开奖结果(江苏快3)主键
     * @return 结果
     */
    public int deleteOpenresultJsk3ById(Long id);
}
