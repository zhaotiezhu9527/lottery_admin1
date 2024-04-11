package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Group;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 分组管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IGroupService extends IService<Group>
{
    /**
     * 查询分组管理
     * 
     * @param id 分组管理主键
     * @return 分组管理
     */
    public Group selectGroupById(Long id);

    /**
     * 查询分组管理列表
     * 
     * @param group 分组管理
     * @return 分组管理集合
     */
    public List<Group> selectGroupList(Group group);

    /**
     * 新增分组管理
     * 
     * @param group 分组管理
     * @return 结果
     */
    public int insertGroup(Group group);

    /**
     * 修改分组管理
     * 
     * @param group 分组管理
     * @return 结果
     */
    public int updateGroup(Group group);

    /**
     * 批量删除分组管理
     * 
     * @param ids 需要删除的分组管理主键集合
     * @return 结果
     */
    public int deleteGroupByIds(Long[] ids);

    /**
     * 删除分组管理信息
     * 
     * @param id 分组管理主键
     * @return 结果
     */
    public int deleteGroupById(Long id);
}
