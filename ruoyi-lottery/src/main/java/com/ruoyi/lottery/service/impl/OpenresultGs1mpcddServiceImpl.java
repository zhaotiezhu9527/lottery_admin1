package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultGs1mpcddMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mpcdd;
import com.ruoyi.lottery.service.IOpenresultGs1mpcddService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 1分PC蛋蛋Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-15
 */
@Service
public class OpenresultGs1mpcddServiceImpl extends ServiceImpl<OpenresultGs1mpcddMapper, OpenresultGs1mpcdd> implements IOpenresultGs1mpcddService
{
    @Autowired
    private OpenresultGs1mpcddMapper openresultGs1mpcddMapper;

    /**
     * 查询1分PC蛋蛋
     * 
     * @param id 1分PC蛋蛋主键
     * @return 1分PC蛋蛋
     */
    @Override
    public OpenresultGs1mpcdd selectOpenresultGs1mpcddById(Long id)
    {
        return openresultGs1mpcddMapper.selectOpenresultGs1mpcddById(id);
    }

    /**
     * 查询1分PC蛋蛋列表
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 1分PC蛋蛋
     */
    @Override
    public List<OpenresultGs1mpcdd> selectOpenresultGs1mpcddList(OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        return openresultGs1mpcddMapper.selectOpenresultGs1mpcddList(openresultGs1mpcdd);
    }

    /**
     * 新增1分PC蛋蛋
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 结果
     */
    @Override
    public int insertOpenresultGs1mpcdd(OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        openresultGs1mpcdd.setCreateTime(DateUtils.getNowDate());
        return openresultGs1mpcddMapper.insertOpenresultGs1mpcdd(openresultGs1mpcdd);
    }

    /**
     * 修改1分PC蛋蛋
     * 
     * @param openresultGs1mpcdd 1分PC蛋蛋
     * @return 结果
     */
    @Override
    public int updateOpenresultGs1mpcdd(OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        openresultGs1mpcdd.setUpdateTime(DateUtils.getNowDate());
        return openresultGs1mpcddMapper.updateOpenresultGs1mpcdd(openresultGs1mpcdd);
    }

    /**
     * 批量删除1分PC蛋蛋
     * 
     * @param ids 需要删除的1分PC蛋蛋主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mpcddByIds(Long[] ids)
    {
        return openresultGs1mpcddMapper.deleteOpenresultGs1mpcddByIds(ids);
    }

    /**
     * 删除1分PC蛋蛋信息
     * 
     * @param id 1分PC蛋蛋主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultGs1mpcddById(Long id)
    {
        return openresultGs1mpcddMapper.deleteOpenresultGs1mpcddById(id);
    }
}
