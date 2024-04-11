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
import com.ruoyi.lottery.domain.OpenresultGs1mpk10;
import com.ruoyi.lottery.service.IOpenresultGs1mpk10Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(GS1分PK10)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultGs1mpk10")
public class OpenresultGs1mpk10Controller extends BaseController
{
    @Autowired
    private IOpenresultGs1mpk10Service openresultGs1mpk10Service;

    /**
     * 查询开奖结果(GS1分PK10)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mpk10 openresultGs1mpk10)
    {
        startPage();
        List<OpenresultGs1mpk10> list = openresultGs1mpk10Service.selectOpenresultGs1mpk10List(openresultGs1mpk10);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(GS1分PK10)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:export')")
    @Log(title = "开奖结果(GS1分PK10)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mpk10 openresultGs1mpk10)
    {
        List<OpenresultGs1mpk10> list = openresultGs1mpk10Service.selectOpenresultGs1mpk10List(openresultGs1mpk10);
        ExcelUtil<OpenresultGs1mpk10> util = new ExcelUtil<OpenresultGs1mpk10>(OpenresultGs1mpk10.class);
        util.exportExcel(response, list, "开奖结果(GS1分PK10)数据");
    }

    /**
     * 获取开奖结果(GS1分PK10)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mpk10Service.selectOpenresultGs1mpk10ById(id));
    }

    /**
     * 新增开奖结果(GS1分PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:add')")
    @Log(title = "开奖结果(GS1分PK10)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mpk10 openresultGs1mpk10)
    {
        return toAjax(openresultGs1mpk10Service.insertOpenresultGs1mpk10(openresultGs1mpk10));
    }

    /**
     * 修改开奖结果(GS1分PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:edit')")
    @Log(title = "开奖结果(GS1分PK10)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mpk10 openresultGs1mpk10)
    {
        return toAjax(openresultGs1mpk10Service.updateOpenresultGs1mpk10(openresultGs1mpk10));
    }

    /**
     * 删除开奖结果(GS1分PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mpk10:remove')")
    @Log(title = "开奖结果(GS1分PK10)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mpk10Service.deleteOpenresultGs1mpk10ByIds(ids));
    }
}
