package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultHklhc;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 香港六合彩Service接口
 * 
 * @author hardy
 * @date 2024-04-16
 */
public interface IOpenresultHklhcService extends IService<OpenresultHklhc>
{
    /**
     * 查询香港六合彩
     * 
     * @param id 香港六合彩主键
     * @return 香港六合彩
     */
    public OpenresultHklhc selectOpenresultHklhcById(Long id);

    /**
     * 查询香港六合彩列表
     * 
     * @param openresultHklhc 香港六合彩
     * @return 香港六合彩集合
     */
    public List<OpenresultHklhc> selectOpenresultHklhcList(OpenresultHklhc openresultHklhc);

    /**
     * 新增香港六合彩
     * 
     * @param openresultHklhc 香港六合彩
     * @return 结果
     */
    public int insertOpenresultHklhc(OpenresultHklhc openresultHklhc);

    /**
     * 修改香港六合彩
     * 
     * @param openresultHklhc 香港六合彩
     * @return 结果
     */
    public int updateOpenresultHklhc(OpenresultHklhc openresultHklhc);

    /**
     * 批量删除香港六合彩
     * 
     * @param ids 需要删除的香港六合彩主键集合
     * @return 结果
     */
    public int deleteOpenresultHklhcByIds(Long[] ids);

    /**
     * 删除香港六合彩信息
     * 
     * @param id 香港六合彩主键
     * @return 结果
     */
    public int deleteOpenresultHklhcById(Long id);
}
