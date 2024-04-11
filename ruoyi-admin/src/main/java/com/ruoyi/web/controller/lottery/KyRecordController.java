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
import com.ruoyi.lottery.domain.KyRecord;
import com.ruoyi.lottery.service.IKyRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开元注单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/kyRecord")
public class KyRecordController extends BaseController
{
    @Autowired
    private IKyRecordService kyRecordService;

    /**
     * 查询开元注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(KyRecord kyRecord)
    {
        startPage();
        List<KyRecord> list = kyRecordService.selectKyRecordList(kyRecord);
        return getDataTable(list);
    }

    /**
     * 导出开元注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:export')")
    @Log(title = "开元注单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, KyRecord kyRecord)
    {
        List<KyRecord> list = kyRecordService.selectKyRecordList(kyRecord);
        ExcelUtil<KyRecord> util = new ExcelUtil<KyRecord>(KyRecord.class);
        util.exportExcel(response, list, "开元注单数据");
    }

    /**
     * 获取开元注单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(kyRecordService.selectKyRecordById(id));
    }

    /**
     * 新增开元注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:add')")
    @Log(title = "开元注单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KyRecord kyRecord)
    {
        return toAjax(kyRecordService.insertKyRecord(kyRecord));
    }

    /**
     * 修改开元注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:edit')")
    @Log(title = "开元注单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KyRecord kyRecord)
    {
        return toAjax(kyRecordService.updateKyRecord(kyRecord));
    }

    /**
     * 删除开元注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:kyRecord:remove')")
    @Log(title = "开元注单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(kyRecordService.deleteKyRecordByIds(ids));
    }
}
