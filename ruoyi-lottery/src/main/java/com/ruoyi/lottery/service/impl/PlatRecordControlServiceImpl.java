package com.ruoyi.lottery.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.PlatRecordControlMapper;
import com.ruoyi.lottery.domain.PlatRecordControl;
import com.ruoyi.lottery.service.IPlatRecordControlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 拉单控制Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class PlatRecordControlServiceImpl extends ServiceImpl<PlatRecordControlMapper, PlatRecordControl> implements IPlatRecordControlService
{
    @Autowired
    private PlatRecordControlMapper platRecordControlMapper;

    /**
     * 查询拉单控制
     * 
     * @param id 拉单控制主键
     * @return 拉单控制
     */
    @Override
    public PlatRecordControl selectPlatRecordControlById(Long id)
    {
        return platRecordControlMapper.selectPlatRecordControlById(id);
    }

    /**
     * 查询拉单控制列表
     * 
     * @param platRecordControl 拉单控制
     * @return 拉单控制
     */
    @Override
    public List<PlatRecordControl> selectPlatRecordControlList(PlatRecordControl platRecordControl)
    {
        return platRecordControlMapper.selectPlatRecordControlList(platRecordControl);
    }

    /**
     * 新增拉单控制
     * 
     * @param platRecordControl 拉单控制
     * @return 结果
     */
    @Override
    public int insertPlatRecordControl(PlatRecordControl platRecordControl)
    {
        return platRecordControlMapper.insertPlatRecordControl(platRecordControl);
    }

    /**
     * 修改拉单控制
     * 
     * @param platRecordControl 拉单控制
     * @return 结果
     */
    @Override
    public int updatePlatRecordControl(PlatRecordControl platRecordControl)
    {
        return platRecordControlMapper.updatePlatRecordControl(platRecordControl);
    }

    /**
     * 批量删除拉单控制
     * 
     * @param ids 需要删除的拉单控制主键
     * @return 结果
     */
    @Override
    public int deletePlatRecordControlByIds(Long[] ids)
    {
        return platRecordControlMapper.deletePlatRecordControlByIds(ids);
    }

    /**
     * 删除拉单控制信息
     * 
     * @param id 拉单控制主键
     * @return 结果
     */
    @Override
    public int deletePlatRecordControlById(Long id)
    {
        return platRecordControlMapper.deletePlatRecordControlById(id);
    }
}
