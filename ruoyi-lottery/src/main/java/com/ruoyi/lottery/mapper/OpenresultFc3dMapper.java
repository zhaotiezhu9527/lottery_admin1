package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultFc3d;

/**
 * 开奖结果(福彩3D)Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface OpenresultFc3dMapper extends BaseMapper<OpenresultFc3d>
{
    /**
     * 查询开奖结果(福彩3D)
     * 
     * @param id 开奖结果(福彩3D)主键
     * @return 开奖结果(福彩3D)
     */
    public OpenresultFc3d selectOpenresultFc3dById(Long id);

    /**
     * 查询开奖结果(福彩3D)列表
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 开奖结果(福彩3D)集合
     */
    public List<OpenresultFc3d> selectOpenresultFc3dList(OpenresultFc3d openresultFc3d);

    /**
     * 新增开奖结果(福彩3D)
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 结果
     */
    public int insertOpenresultFc3d(OpenresultFc3d openresultFc3d);

    /**
     * 修改开奖结果(福彩3D)
     * 
     * @param openresultFc3d 开奖结果(福彩3D)
     * @return 结果
     */
    public int updateOpenresultFc3d(OpenresultFc3d openresultFc3d);

    /**
     * 删除开奖结果(福彩3D)
     * 
     * @param id 开奖结果(福彩3D)主键
     * @return 结果
     */
    public int deleteOpenresultFc3dById(Long id);

    /**
     * 批量删除开奖结果(福彩3D)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultFc3dByIds(Long[] ids);
}
