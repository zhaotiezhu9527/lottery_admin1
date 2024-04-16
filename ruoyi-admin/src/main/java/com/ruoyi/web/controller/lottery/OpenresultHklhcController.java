package com.ruoyi.web.controller.lottery;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.ruoyi.lottery.domain.OpenresultHklhc;
import com.ruoyi.lottery.service.IOpenresultHklhcService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 香港六合彩Controller
 * 
 * @author hardy
 * @date 2024-04-16
 */
@RestController
@RequestMapping("/lottery/openresultHklhc")
public class OpenresultHklhcController extends BaseController
{
    @Autowired
    private IOpenresultHklhcService openresultHklhcService;

    /**
     * 查询香港六合彩列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultHklhc openresultHklhc)
    {
        startPage();
        List<OpenresultHklhc> list = openresultHklhcService.selectOpenresultHklhcList(openresultHklhc);
        return getDataTable(list);
    }

    /**
     * 导出香港六合彩列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:export')")
    @Log(title = "香港六合彩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultHklhc openresultHklhc)
    {
        startOrderBy();
        List<OpenresultHklhc> list = openresultHklhcService.selectOpenresultHklhcList(openresultHklhc);
        ExcelUtil<OpenresultHklhc> util = new ExcelUtil<OpenresultHklhc>(OpenresultHklhc.class);
        util.exportExcel(response, list, "香港六合彩数据");
    }

    /**
     * 获取香港六合彩详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultHklhcService.selectOpenresultHklhcById(id));
    }

    /**
     * 新增香港六合彩
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:add')")
    @Log(title = "香港六合彩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultHklhc openresultHklhc)
    {
        OpenresultHklhc result = new OpenresultHklhc();
        result.setQs(openresultHklhc.getQs());
        result.setPlatQs("");
        result.setOpenResult("");
        result.setOpenStatus(1L);
        result.setCurrCount(1L);
        result.setOpenTime(openresultHklhc.getOpenTime());
        result.setCloseTime(openresultHklhc.getCloseTime());
        result.setOpenResultTime(openresultHklhc.getOpenResultTime());
        result.setCreateTime(new Date());
        result.setUpdateTime(new Date());
        return toAjax(openresultHklhcService.insertOpenresultHklhc(result));
    }

    /**
     * 修改香港六合彩
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:edit')")
    @Log(title = "香港六合彩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultHklhc openresultHklhc)
    {
        openresultHklhc.setOpenStatus(StringUtils.isNotEmpty(openresultHklhc.getOpenResult()) ? 0L : 1L);
        openresultHklhc.setUpdateTime(new Date());
        return toAjax(openresultHklhcService.updateOpenresultHklhc(openresultHklhc));
    }

    /**
     * 删除香港六合彩
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultHklhc:remove')")
    @Log(title = "香港六合彩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultHklhcService.deleteOpenresultHklhcByIds(ids));
    }
}
