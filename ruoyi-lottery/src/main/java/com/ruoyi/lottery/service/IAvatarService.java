package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Avatar;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 头像管理Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IAvatarService extends IService<Avatar>
{
    /**
     * 查询头像管理
     * 
     * @param id 头像管理主键
     * @return 头像管理
     */
    public Avatar selectAvatarById(Long id);

    /**
     * 查询头像管理列表
     * 
     * @param avatar 头像管理
     * @return 头像管理集合
     */
    public List<Avatar> selectAvatarList(Avatar avatar);

    /**
     * 新增头像管理
     * 
     * @param avatar 头像管理
     * @return 结果
     */
    public int insertAvatar(Avatar avatar);

    /**
     * 修改头像管理
     * 
     * @param avatar 头像管理
     * @return 结果
     */
    public int updateAvatar(Avatar avatar);

    /**
     * 批量删除头像管理
     * 
     * @param ids 需要删除的头像管理主键集合
     * @return 结果
     */
    public int deleteAvatarByIds(Long[] ids);

    /**
     * 删除头像管理信息
     * 
     * @param id 头像管理主键
     * @return 结果
     */
    public int deleteAvatarById(Long id);
}
