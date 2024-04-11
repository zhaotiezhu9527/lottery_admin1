package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.EduOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 额度转换Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IEduOrderService extends IService<EduOrder>
{
    /**
     * 查询额度转换
     * 
     * @param id 额度转换主键
     * @return 额度转换
     */
    public EduOrder selectEduOrderById(Long id);

    /**
     * 查询额度转换列表
     * 
     * @param eduOrder 额度转换
     * @return 额度转换集合
     */
    public List<EduOrder> selectEduOrderList(EduOrder eduOrder);

    /**
     * 新增额度转换
     * 
     * @param eduOrder 额度转换
     * @return 结果
     */
    public int insertEduOrder(EduOrder eduOrder);

    /**
     * 修改额度转换
     * 
     * @param eduOrder 额度转换
     * @return 结果
     */
    public int updateEduOrder(EduOrder eduOrder);

    /**
     * 批量删除额度转换
     * 
     * @param ids 需要删除的额度转换主键集合
     * @return 结果
     */
    public int deleteEduOrderByIds(Long[] ids);

    /**
     * 删除额度转换信息
     * 
     * @param id 额度转换主键
     * @return 结果
     */
    public int deleteEduOrderById(Long id);
}
