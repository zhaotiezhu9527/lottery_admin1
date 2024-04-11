package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.EduOrderMapper;
import com.ruoyi.lottery.domain.EduOrder;
import com.ruoyi.lottery.service.IEduOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 额度转换Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class EduOrderServiceImpl extends ServiceImpl<EduOrderMapper, EduOrder> implements IEduOrderService
{
    @Autowired
    private EduOrderMapper eduOrderMapper;

    /**
     * 查询额度转换
     * 
     * @param id 额度转换主键
     * @return 额度转换
     */
    @Override
    public EduOrder selectEduOrderById(Long id)
    {
        return eduOrderMapper.selectEduOrderById(id);
    }

    /**
     * 查询额度转换列表
     * 
     * @param eduOrder 额度转换
     * @return 额度转换
     */
    @Override
    public List<EduOrder> selectEduOrderList(EduOrder eduOrder)
    {
        return eduOrderMapper.selectEduOrderList(eduOrder);
    }

    /**
     * 新增额度转换
     * 
     * @param eduOrder 额度转换
     * @return 结果
     */
    @Override
    public int insertEduOrder(EduOrder eduOrder)
    {
        eduOrder.setCreateTime(DateUtils.getNowDate());
        return eduOrderMapper.insertEduOrder(eduOrder);
    }

    /**
     * 修改额度转换
     * 
     * @param eduOrder 额度转换
     * @return 结果
     */
    @Override
    public int updateEduOrder(EduOrder eduOrder)
    {
        eduOrder.setUpdateTime(DateUtils.getNowDate());
        return eduOrderMapper.updateEduOrder(eduOrder);
    }

    /**
     * 批量删除额度转换
     * 
     * @param ids 需要删除的额度转换主键
     * @return 结果
     */
    @Override
    public int deleteEduOrderByIds(Long[] ids)
    {
        return eduOrderMapper.deleteEduOrderByIds(ids);
    }

    /**
     * 删除额度转换信息
     * 
     * @param id 额度转换主键
     * @return 结果
     */
    @Override
    public int deleteEduOrderById(Long id)
    {
        return eduOrderMapper.deleteEduOrderById(id);
    }
}
