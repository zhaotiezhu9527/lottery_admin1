package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultFtMapper;
import com.ruoyi.lottery.domain.OpenresultFt;
import com.ruoyi.lottery.service.IOpenresultFtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(飞艇)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultFtServiceImpl extends ServiceImpl<OpenresultFtMapper, OpenresultFt> implements IOpenresultFtService
{
    @Autowired
    private OpenresultFtMapper openresultFtMapper;

    /**
     * 查询开奖结果(飞艇)
     * 
     * @param id 开奖结果(飞艇)主键
     * @return 开奖结果(飞艇)
     */
    @Override
    public OpenresultFt selectOpenresultFtById(Long id)
    {
        return openresultFtMapper.selectOpenresultFtById(id);
    }

    /**
     * 查询开奖结果(飞艇)列表
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 开奖结果(飞艇)
     */
    @Override
    public List<OpenresultFt> selectOpenresultFtList(OpenresultFt openresultFt)
    {
        return openresultFtMapper.selectOpenresultFtList(openresultFt);
    }

    /**
     * 新增开奖结果(飞艇)
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 结果
     */
    @Override
    public int insertOpenresultFt(OpenresultFt openresultFt)
    {
        openresultFt.setCreateTime(DateUtils.getNowDate());
        return openresultFtMapper.insertOpenresultFt(openresultFt);
    }

    /**
     * 修改开奖结果(飞艇)
     * 
     * @param openresultFt 开奖结果(飞艇)
     * @return 结果
     */
    @Override
    public int updateOpenresultFt(OpenresultFt openresultFt)
    {
        openresultFt.setUpdateTime(DateUtils.getNowDate());
        return openresultFtMapper.updateOpenresultFt(openresultFt);
    }

    /**
     * 批量删除开奖结果(飞艇)
     * 
     * @param ids 需要删除的开奖结果(飞艇)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultFtByIds(Long[] ids)
    {
        return openresultFtMapper.deleteOpenresultFtByIds(ids);
    }

    /**
     * 删除开奖结果(飞艇)信息
     * 
     * @param id 开奖结果(飞艇)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultFtById(Long id)
    {
        return openresultFtMapper.deleteOpenresultFtById(id);
    }
}
