package com.ruoyi.web.controller.lottery;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.lottery.domain.OpenresultGs1mlhc;
import com.ruoyi.lottery.service.IOpenresultGs1mlhcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 1分六合彩开奖Controller
 * 
 * @author hardy
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/lottery/openresultGs1mlhc")
public class OpenresultGs1mlhcController extends BaseController
{
    @Autowired
    private IOpenresultGs1mlhcService openresultGs1mlhcService;

    /**
     * 查询1分六合彩开奖列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mlhc openresultGs1mlhc)
    {
        startPage();
        List<OpenresultGs1mlhc> list = openresultGs1mlhcService.selectOpenresultGs1mlhcList(openresultGs1mlhc);
        Date now = new Date();
        for (OpenresultGs1mlhc result : list) {
            if (now.getTime() < result.getOpenResultTime().getTime()) {
                result.setOpenStatus(1L);
                result.setOpenResult("");
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出1分六合彩开奖列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:export')")
    @Log(title = "1分六合彩开奖", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mlhc openresultGs1mlhc)
    {
        startOrderBy();
        List<OpenresultGs1mlhc> list = openresultGs1mlhcService.selectOpenresultGs1mlhcList(openresultGs1mlhc);
        ExcelUtil<OpenresultGs1mlhc> util = new ExcelUtil<OpenresultGs1mlhc>(OpenresultGs1mlhc.class);
        util.exportExcel(response, list, "1分六合彩开奖数据");
    }

    /**
     * 获取1分六合彩开奖详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mlhcService.selectOpenresultGs1mlhcById(id));
    }

    /**
     * 新增1分六合彩开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:add')")
    @Log(title = "1分六合彩开奖", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mlhc openresultGs1mlhc)
    {
        return toAjax(openresultGs1mlhcService.insertOpenresultGs1mlhc(openresultGs1mlhc));
    }

    /**
     * 修改1分六合彩开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:edit')")
    @Log(title = "1分六合彩开奖", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mlhc openresultGs1mlhc)
    {
        OpenresultGs1mlhc result = openresultGs1mlhcService.selectOpenresultGs1mlhcById(openresultGs1mlhc.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        result.setOpenStatus(0L);
        return toAjax(openresultGs1mlhcService.updateOpenresultGs1mlhc(openresultGs1mlhc));
    }

    /**
     * 删除1分六合彩开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mlhc:remove')")
    @Log(title = "1分六合彩开奖", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mlhcService.deleteOpenresultGs1mlhcByIds(ids));
    }
}
