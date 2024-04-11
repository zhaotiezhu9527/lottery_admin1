package com.ruoyi.web.controller.lottery;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lottery.domain.Banner;
import com.ruoyi.lottery.service.IBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * banner管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/banner")
public class BannerController extends BaseController
{
    @Autowired
    private IBannerService bannerService;

    /**
     * 查询banner管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:list')")
    @GetMapping("/list")
    public TableDataInfo list(Banner banner)
    {
        startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
        return getDataTable(list);
    }

    /**
     * 导出banner管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:export')")
    @Log(title = "banner管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Banner banner)
    {
        List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        util.exportExcel(response, list, "banner管理数据");
    }

    /**
     * 获取banner管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bannerService.selectBannerById(id));
    }

    /**
     * 新增banner管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:add')")
    @Log(title = "banner管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Banner banner)
    {
        return toAjax(bannerService.insertBanner(banner));
    }

    /**
     * 修改banner管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:edit')")
    @Log(title = "banner管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Banner banner)
    {
        return toAjax(bannerService.updateBanner(banner));
    }

    /**
     * 删除banner管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:banner:remove')")
    @Log(title = "banner管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bannerService.deleteBannerByIds(ids));
    }
}
