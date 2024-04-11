package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.EduOrder;

/**
 * 额度转换Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface EduOrderMapper extends BaseMapper<EduOrder>
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
     * 删除额度转换
     * 
     * @param id 额度转换主键
     * @return 结果
     */
    public int deleteEduOrderById(Long id);

    /**
     * 批量删除额度转换
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduOrderByIds(Long[] ids);
}
