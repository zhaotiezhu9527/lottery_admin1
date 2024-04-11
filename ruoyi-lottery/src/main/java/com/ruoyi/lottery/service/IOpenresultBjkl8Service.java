package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultBjkl8;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(北京快乐8)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultBjkl8Service extends IService<OpenresultBjkl8>
{
    /**
     * 查询开奖结果(北京快乐8)
     * 
     * @param id 开奖结果(北京快乐8)主键
     * @return 开奖结果(北京快乐8)
     */
    public OpenresultBjkl8 selectOpenresultBjkl8ById(Long id);

    /**
     * 查询开奖结果(北京快乐8)列表
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 开奖结果(北京快乐8)集合
     */
    public List<OpenresultBjkl8> selectOpenresultBjkl8List(OpenresultBjkl8 openresultBjkl8);

    /**
     * 新增开奖结果(北京快乐8)
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 结果
     */
    public int insertOpenresultBjkl8(OpenresultBjkl8 openresultBjkl8);

    /**
     * 修改开奖结果(北京快乐8)
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 结果
     */
    public int updateOpenresultBjkl8(OpenresultBjkl8 openresultBjkl8);

    /**
     * 批量删除开奖结果(北京快乐8)
     * 
     * @param ids 需要删除的开奖结果(北京快乐8)主键集合
     * @return 结果
     */
    public int deleteOpenresultBjkl8ByIds(Long[] ids);

    /**
     * 删除开奖结果(北京快乐8)信息
     * 
     * @param id 开奖结果(北京快乐8)主键
     * @return 结果
     */
    public int deleteOpenresultBjkl8ById(Long id);
}
