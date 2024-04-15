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
import com.ruoyi.lottery.domain.BbinRecord;
import com.ruoyi.lottery.service.IBbinRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 三方注单(BBIN)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/bbinRecord")
public class BbinRecordController extends BaseController
{
    @Autowired
    private IBbinRecordService bbinRecordService;

    /**
     * 查询三方注单(BBIN)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(BbinRecord bbinRecord)
    {
        startPage();
        List<BbinRecord> list = bbinRecordService.selectBbinRecordList(bbinRecord);
        return getDataTable(list);
    }

    /**
     * 导出三方注单(BBIN)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:export')")
    @Log(title = "三方注单(BBIN)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BbinRecord bbinRecord)
    {
        startOrderBy();
        List<BbinRecord> list = bbinRecordService.selectBbinRecordList(bbinRecord);
        ExcelUtil<BbinRecord> util = new ExcelUtil<BbinRecord>(BbinRecord.class);
        util.exportExcel(response, list, "三方注单(BBIN)数据");
    }

    /**
     * 获取三方注单(BBIN)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bbinRecordService.selectBbinRecordById(id));
    }

    /**
     * 新增三方注单(BBIN)
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:add')")
    @Log(title = "三方注单(BBIN)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BbinRecord bbinRecord)
    {
        return toAjax(bbinRecordService.insertBbinRecord(bbinRecord));
    }

    /**
     * 修改三方注单(BBIN)
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:edit')")
    @Log(title = "三方注单(BBIN)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BbinRecord bbinRecord)
    {
        return toAjax(bbinRecordService.updateBbinRecord(bbinRecord));
    }

    /**
     * 删除三方注单(BBIN)
     */
    @PreAuthorize("@ss.hasPermi('lottery:bbinRecord:remove')")
    @Log(title = "三方注单(BBIN)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bbinRecordService.deleteBbinRecordByIds(ids));
    }
}
