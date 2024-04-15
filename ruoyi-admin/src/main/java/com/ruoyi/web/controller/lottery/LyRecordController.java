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
import com.ruoyi.lottery.domain.LyRecord;
import com.ruoyi.lottery.service.ILyRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 乐游注单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/lyRecord")
public class LyRecordController extends BaseController
{
    @Autowired
    private ILyRecordService lyRecordService;

    /**
     * 查询乐游注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(LyRecord lyRecord)
    {
        startPage();
        List<LyRecord> list = lyRecordService.selectLyRecordList(lyRecord);
        return getDataTable(list);
    }

    /**
     * 导出乐游注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:export')")
    @Log(title = "乐游注单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LyRecord lyRecord)
    {
        startOrderBy();
        List<LyRecord> list = lyRecordService.selectLyRecordList(lyRecord);
        ExcelUtil<LyRecord> util = new ExcelUtil<LyRecord>(LyRecord.class);
        util.exportExcel(response, list, "乐游注单数据");
    }

    /**
     * 获取乐游注单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lyRecordService.selectLyRecordById(id));
    }

    /**
     * 新增乐游注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:add')")
    @Log(title = "乐游注单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LyRecord lyRecord)
    {
        return toAjax(lyRecordService.insertLyRecord(lyRecord));
    }

    /**
     * 修改乐游注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:edit')")
    @Log(title = "乐游注单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LyRecord lyRecord)
    {
        return toAjax(lyRecordService.updateLyRecord(lyRecord));
    }

    /**
     * 删除乐游注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:lyRecord:remove')")
    @Log(title = "乐游注单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lyRecordService.deleteLyRecordByIds(ids));
    }
}
