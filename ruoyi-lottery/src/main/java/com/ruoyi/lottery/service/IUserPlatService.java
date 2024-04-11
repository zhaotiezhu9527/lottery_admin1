package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.UserPlat;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 三方用户Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface IUserPlatService extends IService<UserPlat>
{
    /**
     * 查询三方用户
     * 
     * @param id 三方用户主键
     * @return 三方用户
     */
    public UserPlat selectUserPlatById(Long id);

    /**
     * 查询三方用户列表
     * 
     * @param userPlat 三方用户
     * @return 三方用户集合
     */
    public List<UserPlat> selectUserPlatList(UserPlat userPlat);

    /**
     * 新增三方用户
     * 
     * @param userPlat 三方用户
     * @return 结果
     */
    public int insertUserPlat(UserPlat userPlat);

    /**
     * 修改三方用户
     * 
     * @param userPlat 三方用户
     * @return 结果
     */
    public int updateUserPlat(UserPlat userPlat);

    /**
     * 批量删除三方用户
     * 
     * @param ids 需要删除的三方用户主键集合
     * @return 结果
     */
    public int deleteUserPlatByIds(Long[] ids);

    /**
     * 删除三方用户信息
     * 
     * @param id 三方用户主键
     * @return 结果
     */
    public int deleteUserPlatById(Long id);
}
