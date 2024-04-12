package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.AvatarMapper;
import com.ruoyi.lottery.domain.Avatar;
import com.ruoyi.lottery.service.IAvatarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 头像管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class AvatarServiceImpl extends ServiceImpl<AvatarMapper, Avatar> implements IAvatarService
{
    @Autowired
    private AvatarMapper avatarMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询头像管理
     * 
     * @param id 头像管理主键
     * @return 头像管理
     */
    @Override
    public Avatar selectAvatarById(Long id)
    {
        return avatarMapper.selectAvatarById(id);
    }

    /**
     * 查询头像管理列表
     * 
     * @param avatar 头像管理
     * @return 头像管理
     */
    @Override
    public List<Avatar> selectAvatarList(Avatar avatar)
    {
        List<Avatar> list = avatarMapper.selectAvatarList(avatar);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(a -> a.setAvatarImg(url + a.getAvatarImg()));
        return list;
    }

    /**
     * 新增头像管理
     * 
     * @param avatar 头像管理
     * @return 结果
     */
    @Override
    public int insertAvatar(Avatar avatar)
    {
        avatar.setCreateTime(DateUtils.getNowDate());
        return avatarMapper.insertAvatar(avatar);
    }

    /**
     * 修改头像管理
     * 
     * @param avatar 头像管理
     * @return 结果
     */
    @Override
    public int updateAvatar(Avatar avatar)
    {
        return avatarMapper.updateAvatar(avatar);
    }

    /**
     * 批量删除头像管理
     * 
     * @param ids 需要删除的头像管理主键
     * @return 结果
     */
    @Override
    public int deleteAvatarByIds(Long[] ids)
    {
        return avatarMapper.deleteAvatarByIds(ids);
    }

    /**
     * 删除头像管理信息
     * 
     * @param id 头像管理主键
     * @return 结果
     */
    @Override
    public int deleteAvatarById(Long id)
    {
        return avatarMapper.deleteAvatarById(id);
    }
}
