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
import com.ruoyi.lottery.domain.Platform;
import com.ruoyi.lottery.service.IPlatformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 平台管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/platform")
public class PlatformController extends BaseController
{
    @Autowired
    private IPlatformService platformService;

    /**
     * 查询平台管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:list')")
    @GetMapping("/list")
    public TableDataInfo list(Platform platform)
    {
        startPage();
        List<Platform> list = platformService.selectPlatformList(platform);
        return getDataTable(list);
    }

    /**
     * 导出平台管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:export')")
    @Log(title = "平台管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Platform platform)
    {
        startOrderBy();
        List<Platform> list = platformService.selectPlatformList(platform);
        ExcelUtil<Platform> util = new ExcelUtil<Platform>(Platform.class);
        util.exportExcel(response, list, "平台管理数据");
    }

    /**
     * 获取平台管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(platformService.selectPlatformById(id));
    }

    /**
     * 新增平台管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:add')")
    @Log(title = "平台管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Platform platform)
    {
        return toAjax(platformService.insertPlatform(platform));
    }

    /**
     * 修改平台管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:edit')")
    @Log(title = "平台管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Platform platform)
    {
        return toAjax(platformService.updatePlatform(platform));
    }

    /**
     * 删除平台管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:platform:remove')")
    @Log(title = "平台管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(platformService.deletePlatformByIds(ids));
    }
}
