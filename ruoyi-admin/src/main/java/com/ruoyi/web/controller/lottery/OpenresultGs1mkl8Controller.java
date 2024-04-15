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
import com.ruoyi.lottery.domain.OpenresultGs1mkl8;
import com.ruoyi.lottery.service.IOpenresultGs1mkl8Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 1分快乐8Controller
 * 
 * @author hardy
 * @date 2024-04-15
 */
@RestController
@RequestMapping("/lottery/openresultGs1mkl8")
public class OpenresultGs1mkl8Controller extends BaseController
{
    @Autowired
    private IOpenresultGs1mkl8Service openresultGs1mkl8Service;

    /**
     * 查询1分快乐8列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mkl8 openresultGs1mkl8)
    {
        startPage();
        List<OpenresultGs1mkl8> list = openresultGs1mkl8Service.selectOpenresultGs1mkl8List(openresultGs1mkl8);
        return getDataTable(list);
    }

    /**
     * 导出1分快乐8列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:export')")
    @Log(title = "1分快乐8", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mkl8 openresultGs1mkl8)
    {
        startOrderBy();
        List<OpenresultGs1mkl8> list = openresultGs1mkl8Service.selectOpenresultGs1mkl8List(openresultGs1mkl8);
        ExcelUtil<OpenresultGs1mkl8> util = new ExcelUtil<OpenresultGs1mkl8>(OpenresultGs1mkl8.class);
        util.exportExcel(response, list, "1分快乐8数据");
    }

    /**
     * 获取1分快乐8详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mkl8Service.selectOpenresultGs1mkl8ById(id));
    }

    /**
     * 新增1分快乐8
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:add')")
    @Log(title = "1分快乐8", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mkl8 openresultGs1mkl8)
    {
        return toAjax(openresultGs1mkl8Service.insertOpenresultGs1mkl8(openresultGs1mkl8));
    }

    /**
     * 修改1分快乐8
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:edit')")
    @Log(title = "1分快乐8", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mkl8 openresultGs1mkl8)
    {
        return toAjax(openresultGs1mkl8Service.updateOpenresultGs1mkl8(openresultGs1mkl8));
    }

    /**
     * 删除1分快乐8
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mkl8:remove')")
    @Log(title = "1分快乐8", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mkl8Service.deleteOpenresultGs1mkl8ByIds(ids));
    }
}
