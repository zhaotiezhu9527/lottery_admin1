package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.OpenresultFc3d;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 开奖结果(福彩3D)Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IOpenresultFc3dService extends IService<OpenresultFc3d>
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
     * 批量删除开奖结果(福彩3D)
     * 
     * @param ids 需要删除的开奖结果(福彩3D)主键集合
     * @return 结果
     */
    public int deleteOpenresultFc3dByIds(Long[] ids);

    /**
     * 删除开奖结果(福彩3D)信息
     * 
     * @param id 开奖结果(福彩3D)主键
     * @return 结果
     */
    public int deleteOpenresultFc3dById(Long id);
}
