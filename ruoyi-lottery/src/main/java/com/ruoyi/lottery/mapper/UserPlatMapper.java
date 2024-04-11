package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.UserPlat;

/**
 * 三方用户Mapper接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface UserPlatMapper extends BaseMapper<UserPlat>
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
     * 删除三方用户
     * 
     * @param id 三方用户主键
     * @return 结果
     */
    public int deleteUserPlatById(Long id);

    /**
     * 批量删除三方用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserPlatByIds(Long[] ids);
}
