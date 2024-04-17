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
import com.ruoyi.lottery.domain.OpenresultPl3;
import com.ruoyi.lottery.service.IOpenresultPl3Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 排列3Controller
 * 
 * @author hardy
 * @date 2024-04-17
 */
@RestController
@RequestMapping("/lottery/openresultPl3")
public class OpenresultPl3Controller extends BaseController
{
    @Autowired
    private IOpenresultPl3Service openresultPl3Service;

    /**
     * 查询排列3列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultPl3 openresultPl3)
    {
        startPage();
        List<OpenresultPl3> list = openresultPl3Service.selectOpenresultPl3List(openresultPl3);
        return getDataTable(list);
    }

    /**
     * 导出排列3列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:export')")
    @Log(title = "排列3", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultPl3 openresultPl3)
    {
        startOrderBy();
        List<OpenresultPl3> list = openresultPl3Service.selectOpenresultPl3List(openresultPl3);
        ExcelUtil<OpenresultPl3> util = new ExcelUtil<OpenresultPl3>(OpenresultPl3.class);
        util.exportExcel(response, list, "排列3数据");
    }

    /**
     * 获取排列3详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultPl3Service.selectOpenresultPl3ById(id));
    }

    /**
     * 新增排列3
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:add')")
    @Log(title = "排列3", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultPl3 openresultPl3)
    {
        return toAjax(openresultPl3Service.insertOpenresultPl3(openresultPl3));
    }

    /**
     * 修改排列3
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:edit')")
    @Log(title = "排列3", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultPl3 openresultPl3)
    {
        return toAjax(openresultPl3Service.updateOpenresultPl3(openresultPl3));
    }

    /**
     * 删除排列3
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPl3:remove')")
    @Log(title = "排列3", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultPl3Service.deleteOpenresultPl3ByIds(ids));
    }
}
