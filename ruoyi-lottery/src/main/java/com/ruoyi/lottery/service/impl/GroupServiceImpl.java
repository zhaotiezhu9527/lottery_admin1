package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.GroupMapper;
import com.ruoyi.lottery.domain.Group;
import com.ruoyi.lottery.service.IGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 分组管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService
{
    @Autowired
    private GroupMapper groupMapper;

    /**
     * 查询分组管理
     * 
     * @param id 分组管理主键
     * @return 分组管理
     */
    @Override
    public Group selectGroupById(Long id)
    {
        return groupMapper.selectGroupById(id);
    }

    /**
     * 查询分组管理列表
     * 
     * @param group 分组管理
     * @return 分组管理
     */
    @Override
    public List<Group> selectGroupList(Group group)
    {
        return groupMapper.selectGroupList(group);
    }

    /**
     * 新增分组管理
     * 
     * @param group 分组管理
     * @return 结果
     */
    @Override
    public int insertGroup(Group group)
    {
        group.setCreateTime(DateUtils.getNowDate());
        return groupMapper.insertGroup(group);
    }

    /**
     * 修改分组管理
     * 
     * @param group 分组管理
     * @return 结果
     */
    @Override
    public int updateGroup(Group group)
    {
        return groupMapper.updateGroup(group);
    }

    /**
     * 批量删除分组管理
     * 
     * @param ids 需要删除的分组管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupByIds(Long[] ids)
    {
        return groupMapper.deleteGroupByIds(ids);
    }

    /**
     * 删除分组管理信息
     * 
     * @param id 分组管理主键
     * @return 结果
     */
    @Override
    public int deleteGroupById(Long id)
    {
        return groupMapper.deleteGroupById(id);
    }
}
