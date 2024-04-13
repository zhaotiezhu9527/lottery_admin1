package com.ruoyi.web.controller.lottery;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.lottery.business.CheckBusiness;
import com.ruoyi.lottery.pojo.DepositCheckDto;
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
import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.service.IDepositService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充值订单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/deposit")
public class DepositController extends BaseController
{
    @Autowired
    private IDepositService depositService;

    @Autowired
    private CheckBusiness checkBusiness;

    /**
     * 查询充值订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deposit deposit)
    {
        startPage();
        List<Deposit> list = depositService.selectDepositList(deposit);
        return getDataTable(list);
    }

    /**
     * 导出充值订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:export')")
    @Log(title = "充值订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deposit deposit)
    {
        List<Deposit> list = depositService.selectDepositList(deposit);
        ExcelUtil<Deposit> util = new ExcelUtil<Deposit>(Deposit.class);
        util.exportExcel(response, list, "充值订单数据");
    }

    /**
     * 获取充值订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(depositService.selectDepositById(id));
    }

    /**
     * 新增充值订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:add')")
    @Log(title = "充值订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deposit deposit)
    {
        return toAjax(depositService.insertDeposit(deposit));
    }

    /**
     * 修改充值订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:edit')")
    @Log(title = "充值订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deposit deposit)
    {
        return toAjax(depositService.updateDeposit(deposit));
    }

    /**
     * 删除充值订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:deposit:remove')")
    @Log(title = "充值订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(depositService.deleteDepositByIds(ids));
    }


    @PreAuthorize("@ss.hasPermi('lottery:deposit:check')")
    @Log(title = "充值审核", businessType = BusinessType.UPDATE)
    @PostMapping("/check")
    public AjaxResult check(@RequestBody DepositCheckDto request) throws Exception {
        Deposit deposit = depositService.getById(request.getId());
        if (deposit == null) {
            return error("订单号不存在.");
        }
        if (deposit.getStatus().intValue() != 0) {
            return error("该订单已被审核.");
        }
        checkBusiness.depositCheck(request, deposit);
        return success();
    }
}
