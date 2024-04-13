package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.lottery.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.BannerMapper;
import com.ruoyi.lottery.domain.Banner;
import com.ruoyi.lottery.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * banner管理Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService
{
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询banner管理
     * 
     * @param id banner管理主键
     * @return banner管理
     */
    @Override
    public Banner selectBannerById(Long id)
    {
        Banner banner = bannerMapper.selectBannerById(id);
        String url = sysParamService.getParamByKey("resource_domain");
        banner.setImg(url + banner.getImg());
        return banner;
    }

    /**
     * 查询banner管理列表
     * 
     * @param banner banner管理
     * @return banner管理
     */
    @Override
    public List<Banner> selectBannerList(Banner banner)
    {
        List<Banner> list = bannerMapper.selectBannerList(banner);
        String url = sysParamService.getParamByKey("resource_domain");
        list.forEach(b -> b.setImg(url + b.getImg()));
        return list;
    }

    /**
     * 新增banner管理
     * 
     * @param banner banner管理
     * @return 结果
     */
    @Override
    public int insertBanner(Banner banner)
    {
        banner.setCreateTime(DateUtils.getNowDate());
        return bannerMapper.insertBanner(banner);
    }

    /**
     * 修改banner管理
     * 
     * @param banner banner管理
     * @return 结果
     */
    @Override
    public int updateBanner(Banner banner)
    {
        banner.setUpdateTime(DateUtils.getNowDate());
        return bannerMapper.updateBanner(banner);
    }

    /**
     * 批量删除banner管理
     * 
     * @param ids 需要删除的banner管理主键
     * @return 结果
     */
    @Override
    public int deleteBannerByIds(Long[] ids)
    {
        return bannerMapper.deleteBannerByIds(ids);
    }

    /**
     * 删除banner管理信息
     * 
     * @param id banner管理主键
     * @return 结果
     */
    @Override
    public int deleteBannerById(Long id)
    {
        return bannerMapper.deleteBannerById(id);
    }
}
