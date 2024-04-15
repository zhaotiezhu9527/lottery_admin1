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
import com.ruoyi.lottery.domain.AgRecord;
import com.ruoyi.lottery.service.IAgRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AG注单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/agRecord")
public class AgRecordController extends BaseController
{
    @Autowired
    private IAgRecordService agRecordService;

    /**
     * 查询AG注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgRecord agRecord)
    {
        startPage();
        List<AgRecord> list = agRecordService.selectAgRecordList(agRecord);
        return getDataTable(list);
    }

    /**
     * 导出AG注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:export')")
    @Log(title = "AG注单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgRecord agRecord)
    {
        startOrderBy();
        List<AgRecord> list = agRecordService.selectAgRecordList(agRecord);
        ExcelUtil<AgRecord> util = new ExcelUtil<AgRecord>(AgRecord.class);
        util.exportExcel(response, list, "AG注单数据");
    }

    /**
     * 获取AG注单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(agRecordService.selectAgRecordById(id));
    }

    /**
     * 新增AG注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:add')")
    @Log(title = "AG注单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgRecord agRecord)
    {
        return toAjax(agRecordService.insertAgRecord(agRecord));
    }

    /**
     * 修改AG注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:edit')")
    @Log(title = "AG注单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgRecord agRecord)
    {
        return toAjax(agRecordService.updateAgRecord(agRecord));
    }

    /**
     * 删除AG注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:agRecord:remove')")
    @Log(title = "AG注单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(agRecordService.deleteAgRecordByIds(ids));
    }
}
