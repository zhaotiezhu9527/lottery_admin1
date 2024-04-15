package com.ruoyi.web.controller.lottery;

import java.util.Date;
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
import com.ruoyi.lottery.domain.OpenresultGs1m11x5;
import com.ruoyi.lottery.service.IOpenresultGs1m11x5Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 1分11选5Controller
 * 
 * @author hardy
 * @date 2024-04-15
 */
@RestController
@RequestMapping("/lottery/openresultGs1m11x5")
public class OpenresultGs1m11x5Controller extends BaseController
{
    @Autowired
    private IOpenresultGs1m11x5Service openresultGs1m11x5Service;

    /**
     * 查询1分11选5列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1m11x5 openresultGs1m11x5)
    {
        startPage();
        List<OpenresultGs1m11x5> list = openresultGs1m11x5Service.selectOpenresultGs1m11x5List(openresultGs1m11x5);
        Date now = new Date();
        for (OpenresultGs1m11x5 result : list) {
            if (now.getTime() < result.getOpenResultTime().getTime()) {
                result.setOpenStatus(1L);
                result.setOpenResult("");
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出1分11选5列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:export')")
    @Log(title = "1分11选5", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1m11x5 openresultGs1m11x5)
    {
        startOrderBy();
        List<OpenresultGs1m11x5> list = openresultGs1m11x5Service.selectOpenresultGs1m11x5List(openresultGs1m11x5);
        ExcelUtil<OpenresultGs1m11x5> util = new ExcelUtil<OpenresultGs1m11x5>(OpenresultGs1m11x5.class);
        util.exportExcel(response, list, "1分11选5数据");
    }

    /**
     * 获取1分11选5详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1m11x5Service.selectOpenresultGs1m11x5ById(id));
    }

    /**
     * 新增1分11选5
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:add')")
    @Log(title = "1分11选5", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1m11x5 openresultGs1m11x5)
    {
        return toAjax(openresultGs1m11x5Service.insertOpenresultGs1m11x5(openresultGs1m11x5));
    }

    /**
     * 修改1分11选5
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:edit')")
    @Log(title = "1分11选5", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1m11x5 openresultGs1m11x5)
    {
        OpenresultGs1m11x5 result = openresultGs1m11x5Service.selectOpenresultGs1m11x5ById(openresultGs1m11x5.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        result.setOpenStatus(0L);
        return toAjax(openresultGs1m11x5Service.updateOpenresultGs1m11x5(openresultGs1m11x5));
    }

    /**
     * 删除1分11选5
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1m11x5:remove')")
    @Log(title = "1分11选5", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1m11x5Service.deleteOpenresultGs1m11x5ByIds(ids));
    }
}
