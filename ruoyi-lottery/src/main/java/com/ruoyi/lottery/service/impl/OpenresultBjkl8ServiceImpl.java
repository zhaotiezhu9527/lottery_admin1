package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultBjkl8Mapper;
import com.ruoyi.lottery.domain.OpenresultBjkl8;
import com.ruoyi.lottery.service.IOpenresultBjkl8Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(北京快乐8)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultBjkl8ServiceImpl extends ServiceImpl<OpenresultBjkl8Mapper, OpenresultBjkl8> implements IOpenresultBjkl8Service
{
    @Autowired
    private OpenresultBjkl8Mapper openresultBjkl8Mapper;

    /**
     * 查询开奖结果(北京快乐8)
     * 
     * @param id 开奖结果(北京快乐8)主键
     * @return 开奖结果(北京快乐8)
     */
    @Override
    public OpenresultBjkl8 selectOpenresultBjkl8ById(Long id)
    {
        return openresultBjkl8Mapper.selectOpenresultBjkl8ById(id);
    }

    /**
     * 查询开奖结果(北京快乐8)列表
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 开奖结果(北京快乐8)
     */
    @Override
    public List<OpenresultBjkl8> selectOpenresultBjkl8List(OpenresultBjkl8 openresultBjkl8)
    {
        return openresultBjkl8Mapper.selectOpenresultBjkl8List(openresultBjkl8);
    }

    /**
     * 新增开奖结果(北京快乐8)
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 结果
     */
    @Override
    public int insertOpenresultBjkl8(OpenresultBjkl8 openresultBjkl8)
    {
        openresultBjkl8.setCreateTime(DateUtils.getNowDate());
        return openresultBjkl8Mapper.insertOpenresultBjkl8(openresultBjkl8);
    }

    /**
     * 修改开奖结果(北京快乐8)
     * 
     * @param openresultBjkl8 开奖结果(北京快乐8)
     * @return 结果
     */
    @Override
    public int updateOpenresultBjkl8(OpenresultBjkl8 openresultBjkl8)
    {
        openresultBjkl8.setUpdateTime(DateUtils.getNowDate());
        return openresultBjkl8Mapper.updateOpenresultBjkl8(openresultBjkl8);
    }

    /**
     * 批量删除开奖结果(北京快乐8)
     * 
     * @param ids 需要删除的开奖结果(北京快乐8)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultBjkl8ByIds(Long[] ids)
    {
        return openresultBjkl8Mapper.deleteOpenresultBjkl8ByIds(ids);
    }

    /**
     * 删除开奖结果(北京快乐8)信息
     * 
     * @param id 开奖结果(北京快乐8)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultBjkl8ById(Long id)
    {
        return openresultBjkl8Mapper.deleteOpenresultBjkl8ById(id);
    }
}
