package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.PlatRecordControl;

/**
 * 拉单控制Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface PlatRecordControlMapper extends BaseMapper<PlatRecordControl>
{
    /**
     * 查询拉单控制
     * 
     * @param id 拉单控制主键
     * @return 拉单控制
     */
    public PlatRecordControl selectPlatRecordControlById(Long id);

    /**
     * 查询拉单控制列表
     * 
     * @param platRecordControl 拉单控制
     * @return 拉单控制集合
     */
    public List<PlatRecordControl> selectPlatRecordControlList(PlatRecordControl platRecordControl);

    /**
     * 新增拉单控制
     * 
     * @param platRecordControl 拉单控制
     * @return 结果
     */
    public int insertPlatRecordControl(PlatRecordControl platRecordControl);

    /**
     * 修改拉单控制
     * 
     * @param platRecordControl 拉单控制
     * @return 结果
     */
    public int updatePlatRecordControl(PlatRecordControl platRecordControl);

    /**
     * 删除拉单控制
     * 
     * @param id 拉单控制主键
     * @return 结果
     */
    public int deletePlatRecordControlById(Long id);

    /**
     * 批量删除拉单控制
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlatRecordControlByIds(Long[] ids);
}
