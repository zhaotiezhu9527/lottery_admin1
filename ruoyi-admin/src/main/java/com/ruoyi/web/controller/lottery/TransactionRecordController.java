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
import com.ruoyi.lottery.domain.TransactionRecord;
import com.ruoyi.lottery.service.ITransactionRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账变记录Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/transactionRecord")
public class TransactionRecordController extends BaseController
{
    @Autowired
    private ITransactionRecordService transactionRecordService;

    /**
     * 查询账变记录列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TransactionRecord transactionRecord)
    {
        startPage();
        List<TransactionRecord> list = transactionRecordService.selectTransactionRecordList(transactionRecord);
        return getDataTable(list);
    }

    /**
     * 导出账变记录列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:export')")
    @Log(title = "账变记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TransactionRecord transactionRecord)
    {
        List<TransactionRecord> list = transactionRecordService.selectTransactionRecordList(transactionRecord);
        ExcelUtil<TransactionRecord> util = new ExcelUtil<TransactionRecord>(TransactionRecord.class);
        util.exportExcel(response, list, "账变记录数据");
    }

    /**
     * 获取账变记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(transactionRecordService.selectTransactionRecordById(id));
    }

    /**
     * 新增账变记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:add')")
    @Log(title = "账变记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TransactionRecord transactionRecord)
    {
        return toAjax(transactionRecordService.insertTransactionRecord(transactionRecord));
    }

    /**
     * 修改账变记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:edit')")
    @Log(title = "账变记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TransactionRecord transactionRecord)
    {
        return toAjax(transactionRecordService.updateTransactionRecord(transactionRecord));
    }

    /**
     * 删除账变记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:transactionRecord:remove')")
    @Log(title = "账变记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(transactionRecordService.deleteTransactionRecordByIds(ids));
    }
}
