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
import com.ruoyi.lottery.domain.HgRecord;
import com.ruoyi.lottery.service.IHgRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 皇冠体育注单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/hgRecord")
public class HgRecordController extends BaseController
{
    @Autowired
    private IHgRecordService hgRecordService;

    /**
     * 查询皇冠体育注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(HgRecord hgRecord)
    {
        startPage();
        List<HgRecord> list = hgRecordService.selectHgRecordList(hgRecord);
        return getDataTable(list);
    }

    /**
     * 导出皇冠体育注单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:export')")
    @Log(title = "皇冠体育注单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HgRecord hgRecord)
    {
        startOrderBy();
        List<HgRecord> list = hgRecordService.selectHgRecordList(hgRecord);
        ExcelUtil<HgRecord> util = new ExcelUtil<HgRecord>(HgRecord.class);
        util.exportExcel(response, list, "皇冠体育注单数据");
    }

    /**
     * 获取皇冠体育注单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hgRecordService.selectHgRecordById(id));
    }

    /**
     * 新增皇冠体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:add')")
    @Log(title = "皇冠体育注单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HgRecord hgRecord)
    {
        return toAjax(hgRecordService.insertHgRecord(hgRecord));
    }

    /**
     * 修改皇冠体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:edit')")
    @Log(title = "皇冠体育注单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HgRecord hgRecord)
    {
        return toAjax(hgRecordService.updateHgRecord(hgRecord));
    }

    /**
     * 删除皇冠体育注单
     */
    @PreAuthorize("@ss.hasPermi('lottery:hgRecord:remove')")
    @Log(title = "皇冠体育注单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hgRecordService.deleteHgRecordByIds(ids));
    }
}
