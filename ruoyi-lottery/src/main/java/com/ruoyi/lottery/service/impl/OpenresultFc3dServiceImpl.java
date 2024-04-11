package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.OpenresultFc3dMapper;
import com.ruoyi.lottery.domain.OpenresultFc3d;
import com.ruoyi.lottery.service.IOpenresultFc3dService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 开奖结果(福彩3D)Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class OpenresultFc3dServiceImpl extends ServiceImpl<OpenresultFc3dMapper, OpenresultFc3d> implements IOpenresultFc3dService
{
    @Autowired
    private OpenresultFc3dMapper openresultFc3dMapper;

    /**
     * 查询开奖结果(福彩3D)
     * 
     * @param id 开奖结果(福彩3D)主键
     * @return 开奖结果(福彩3D)
     */
    @Override
    public OpenresultFc3d selectOpenresultFc3dById(Long id)
    {
        return openresultFc3dMapper.selectOpenresultFc3dById(id);
    }

    /**
     * 查询开奖结果(福彩3D)列表
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 开奖结果(福彩3D)
     */
    @Override
    public List<OpenresultFc3d> selectOpenresultFc3dList(OpenresultFc3d openresultFc3d)
    {
        return openresultFc3dMapper.selectOpenresultFc3dList(openresultFc3d);
    }

    /**
     * 新增开奖结果(福彩3D)
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 结果
     */
    @Override
    public int insertOpenresultFc3d(OpenresultFc3d openresultFc3d)
    {
        openresultFc3d.setCreateTime(DateUtils.getNowDate());
        return openresultFc3dMapper.insertOpenresultFc3d(openresultFc3d);
    }

    /**
     * 修改开奖结果(福彩3D)
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 结果
     */
    @Override
    public int updateOpenresultFc3d(OpenresultFc3d openresultFc3d)
    {
        openresultFc3d.setUpdateTime(DateUtils.getNowDate());
        return openresultFc3dMapper.updateOpenresultFc3d(openresultFc3d);
    }

    /**
     * 批量删除开奖结果(福彩3D)
     * 
     * @param ids 需要删除的开奖结果(福彩3D)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultFc3dByIds(Long[] ids)
    {
        return openresultFc3dMapper.deleteOpenresultFc3dByIds(ids);
    }

    /**
     * 删除开奖结果(福彩3D)信息
     * 
     * @param id 开奖结果(福彩3D)主键
     * @return 结果
     */
    @Override
    public int deleteOpenresultFc3dById(Long id)
    {
        return openresultFc3dMapper.deleteOpenresultFc3dById(id);
    }
}
