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
import com.ruoyi.lottery.domain.PlatRecordControl;
import com.ruoyi.lottery.service.IPlatRecordControlService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拉单控制Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/platRecordControl")
public class PlatRecordControlController extends BaseController
{
    @Autowired
    private IPlatRecordControlService platRecordControlService;

    /**
     * 查询拉单控制列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlatRecordControl platRecordControl)
    {
        startPage();
        List<PlatRecordControl> list = platRecordControlService.selectPlatRecordControlList(platRecordControl);
        return getDataTable(list);
    }

    /**
     * 导出拉单控制列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:export')")
    @Log(title = "拉单控制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PlatRecordControl platRecordControl)
    {
        startOrderBy();
        List<PlatRecordControl> list = platRecordControlService.selectPlatRecordControlList(platRecordControl);
        ExcelUtil<PlatRecordControl> util = new ExcelUtil<PlatRecordControl>(PlatRecordControl.class);
        util.exportExcel(response, list, "拉单控制数据");
    }

    /**
     * 获取拉单控制详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(platRecordControlService.selectPlatRecordControlById(id));
    }

    /**
     * 新增拉单控制
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:add')")
    @Log(title = "拉单控制", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlatRecordControl platRecordControl)
    {
        return toAjax(platRecordControlService.insertPlatRecordControl(platRecordControl));
    }

    /**
     * 修改拉单控制
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:edit')")
    @Log(title = "拉单控制", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlatRecordControl platRecordControl)
    {
        return toAjax(platRecordControlService.updatePlatRecordControl(platRecordControl));
    }

    /**
     * 删除拉单控制
     */
    @PreAuthorize("@ss.hasPermi('lottery:platRecordControl:remove')")
    @Log(title = "拉单控制", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(platRecordControlService.deletePlatRecordControlByIds(ids));
    }
}
