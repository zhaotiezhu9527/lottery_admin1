package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultGs1mft;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 1分飞艇开奖Service接口
 * 
 * @author hardy
 * @date 2024-04-12
 */
public interface IOpenresultGs1mftService extends IService<OpenresultGs1mft>
{
    /**
     * 查询1分飞艇开奖
     * 
     * @param id 1分飞艇开奖主键
     * @return 1分飞艇开奖
     */
    public OpenresultGs1mft selectOpenresultGs1mftById(Long id);

    /**
     * 查询1分飞艇开奖列表
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 1分飞艇开奖集合
     */
    public List<OpenresultGs1mft> selectOpenresultGs1mftList(OpenresultGs1mft openresultGs1mft);

    /**
     * 新增1分飞艇开奖
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 结果
     */
    public int insertOpenresultGs1mft(OpenresultGs1mft openresultGs1mft);

    /**
     * 修改1分飞艇开奖
     * 
     * @param openresultGs1mft 1分飞艇开奖
     * @return 结果
     */
    public int updateOpenresultGs1mft(OpenresultGs1mft openresultGs1mft);

    /**
     * 批量删除1分飞艇开奖
     * 
     * @param ids 需要删除的1分飞艇开奖主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mftByIds(Long[] ids);

    /**
     * 删除1分飞艇开奖信息
     * 
     * @param id 1分飞艇开奖主键
     * @return 结果
     */
    public int deleteOpenresultGs1mftById(Long id);
}
