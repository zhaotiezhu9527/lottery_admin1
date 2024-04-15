package com.ruoyi.web.controller.lottery;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.lottery.business.CheckBusiness;
import com.ruoyi.lottery.domain.Deposit;
import com.ruoyi.lottery.pojo.DepositCheckDto;
import com.ruoyi.lottery.pojo.WithdrawCheckDto;
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
import com.ruoyi.lottery.domain.Withdraw;
import com.ruoyi.lottery.service.IWithdrawService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现订单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/withdraw")
public class WithdrawController extends BaseController
{
    @Autowired
    private IWithdrawService withdrawService;

    @Autowired
    private CheckBusiness checkBusiness;

    /**
     * 查询提现订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:list')")
    @GetMapping("/list")
    public TableDataInfo list(Withdraw withdraw)
    {
        startPage();
        List<Withdraw> list = withdrawService.selectWithdrawList(withdraw);
        return getDataTable(list);
    }

    /**
     * 导出提现订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:export')")
    @Log(title = "提现订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Withdraw withdraw)
    {
        startOrderBy();
        List<Withdraw> list = withdrawService.selectWithdrawList(withdraw);
        ExcelUtil<Withdraw> util = new ExcelUtil<Withdraw>(Withdraw.class);
        util.exportExcel(response, list, "提现订单数据");
    }

    /**
     * 获取提现订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(withdrawService.selectWithdrawById(id));
    }

    /**
     * 新增提现订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:add')")
    @Log(title = "提现订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Withdraw withdraw)
    {
        return toAjax(withdrawService.insertWithdraw(withdraw));
    }

    /**
     * 修改提现订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:edit')")
    @Log(title = "提现订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Withdraw withdraw)
    {
        return toAjax(withdrawService.updateWithdraw(withdraw));
    }

    /**
     * 删除提现订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:withdraw:remove')")
    @Log(title = "提现订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(withdrawService.deleteWithdrawByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('lottery:deposit:check')")
    @Log(title = "充值审核", businessType = BusinessType.UPDATE)
    @PostMapping("/check")
    public AjaxResult check(@RequestBody WithdrawCheckDto request) throws Exception {
        Withdraw withdraw = withdrawService.getById(request.getId());
        if (withdraw == null) {
            return error("订单号不存在.");
        }
        if (withdraw.getStatus().intValue() != 0) {
            return error("该订单已被审核.");
        }
        checkBusiness.withdrawCheck(request, withdraw);
        return success();
    }
}
