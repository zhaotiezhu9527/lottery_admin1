package com.ruoyi.web.controller.lottery;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.lottery.domain.sbRecord;
import com.ruoyi.lottery.service.IsbRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 沙巴体育注单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/sbRecord")
public class sbRecordController extends BaseController
{
    @Autowired
    private IsbRecordService sbRecordService;

    /**
     * 查询沙巴体育注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(sbRecord sbRecord)
    {
        startPage();
        List<sbRecord> list = sbRecordService.selectsbRecordList(sbRecord);
        return getDataTable(list);
    }

    /**
     * 导出沙巴体育注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:export')")
    @Log(title = "沙巴体育注单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, sbRecord sbRecord)
    {
        startOrderBy();
        List<sbRecord> list = sbRecordService.selectsbRecordList(sbRecord);
        ExcelUtil<sbRecord> util = new ExcelUtil<sbRecord>(sbRecord.class);
        util.exportExcel(response, list, "沙巴体育注单数据");
    }

    /**
     * 获取沙巴体育注单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sbRecordService.selectsbRecordById(id));
    }

    /**
     * 新增沙巴体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:add')")
    @Log(title = "沙巴体育注单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody sbRecord sbRecord)
    {
        return toAjax(sbRecordService.insertsbRecord(sbRecord));
    }

    /**
     * 修改沙巴体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:edit')")
    @Log(title = "沙巴体育注单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody sbRecord sbRecord)
    {
        return toAjax(sbRecordService.updatesbRecord(sbRecord));
    }

    /**
     * 删除沙巴体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:sbRecord:remove')")
    @Log(title = "沙巴体育注单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sbRecordService.deletesbRecordByIds(ids));
    }
}
