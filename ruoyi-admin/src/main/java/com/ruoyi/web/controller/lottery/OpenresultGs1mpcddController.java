package com.ruoyi.lottery.controller;

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
import com.ruoyi.lottery.domain.OpenresultGs1mpcdd;
import com.ruoyi.lottery.service.IOpenresultGs1mpcddService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 1分PC蛋蛋Controller
 * 
 * @author hardy
 * @date 2024-04-15
 */
@RestController
@RequestMapping("/lottery/openresultGs1mpcdd")
public class OpenresultGs1mpcddController extends BaseController
{
    @Autowired
    private IOpenresultGs1mpcddService openresultGs1mpcddService;

    /**
     * 查询1分PC蛋蛋列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        startPage();
        List<OpenresultGs1mpcdd> list = openresultGs1mpcddService.selectOpenresultGs1mpcddList(openresultGs1mpcdd);
        return getDataTable(list);
    }

    /**
     * 导出1分PC蛋蛋列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:export')")
    @Log(title = "1分PC蛋蛋", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        startOrderBy();
        List<OpenresultGs1mpcdd> list = openresultGs1mpcddService.selectOpenresultGs1mpcddList(openresultGs1mpcdd);
        ExcelUtil<OpenresultGs1mpcdd> util = new ExcelUtil<OpenresultGs1mpcdd>(OpenresultGs1mpcdd.class);
        util.exportExcel(response, list, "1分PC蛋蛋数据");
    }

    /**
     * 获取1分PC蛋蛋详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mpcddService.selectOpenresultGs1mpcddById(id));
    }

    /**
     * 新增1分PC蛋蛋
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:add')")
    @Log(title = "1分PC蛋蛋", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        return toAjax(openresultGs1mpcddService.insertOpenresultGs1mpcdd(openresultGs1mpcdd));
    }

    /**
     * 修改1分PC蛋蛋
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:edit')")
    @Log(title = "1分PC蛋蛋", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mpcdd openresultGs1mpcdd)
    {
        return toAjax(openresultGs1mpcddService.updateOpenresultGs1mpcdd(openresultGs1mpcdd));
    }

    /**
     * 删除1分PC蛋蛋
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpcdd:remove')")
    @Log(title = "1分PC蛋蛋", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mpcddService.deleteOpenresultGs1mpcddByIds(ids));
    }
}
