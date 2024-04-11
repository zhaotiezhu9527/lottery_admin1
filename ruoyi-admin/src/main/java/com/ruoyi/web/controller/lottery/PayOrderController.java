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
import com.ruoyi.lottery.domain.PayOrder;
import com.ruoyi.lottery.service.IPayOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付订单Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/payOrder")
public class PayOrderController extends BaseController
{
    @Autowired
    private IPayOrderService payOrderService;

    /**
     * 查询支付订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayOrder payOrder)
    {
        startPage();
        List<PayOrder> list = payOrderService.selectPayOrderList(payOrder);
        return getDataTable(list);
    }

    /**
     * 导出支付订单列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:export')")
    @Log(title = "支付订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayOrder payOrder)
    {
        List<PayOrder> list = payOrderService.selectPayOrderList(payOrder);
        ExcelUtil<PayOrder> util = new ExcelUtil<PayOrder>(PayOrder.class);
        util.exportExcel(response, list, "支付订单数据");
    }

    /**
     * 获取支付订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(payOrderService.selectPayOrderById(id));
    }

    /**
     * 新增支付订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:add')")
    @Log(title = "支付订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayOrder payOrder)
    {
        return toAjax(payOrderService.insertPayOrder(payOrder));
    }

    /**
     * 修改支付订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:edit')")
    @Log(title = "支付订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayOrder payOrder)
    {
        return toAjax(payOrderService.updatePayOrder(payOrder));
    }

    /**
     * 删除支付订单
     */
    @PreAuthorize("@ss.hasPermi('lottery:payOrder:remove')")
    @Log(title = "支付订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(payOrderService.deletePayOrderByIds(ids));
    }
}
