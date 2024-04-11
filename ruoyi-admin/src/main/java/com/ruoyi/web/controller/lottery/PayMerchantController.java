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
import com.ruoyi.lottery.domain.PayMerchant;
import com.ruoyi.lottery.service.IPayMerchantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商家配置Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/payMerchant")
public class PayMerchantController extends BaseController
{
    @Autowired
    private IPayMerchantService payMerchantService;

    /**
     * 查询商家配置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayMerchant payMerchant)
    {
        startPage();
        List<PayMerchant> list = payMerchantService.selectPayMerchantList(payMerchant);
        return getDataTable(list);
    }

    /**
     * 导出商家配置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:export')")
    @Log(title = "商家配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayMerchant payMerchant)
    {
        List<PayMerchant> list = payMerchantService.selectPayMerchantList(payMerchant);
        ExcelUtil<PayMerchant> util = new ExcelUtil<PayMerchant>(PayMerchant.class);
        util.exportExcel(response, list, "商家配置数据");
    }

    /**
     * 获取商家配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(payMerchantService.selectPayMerchantById(id));
    }

    /**
     * 新增商家配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:add')")
    @Log(title = "商家配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayMerchant payMerchant)
    {
        return toAjax(payMerchantService.insertPayMerchant(payMerchant));
    }

    /**
     * 修改商家配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:edit')")
    @Log(title = "商家配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayMerchant payMerchant)
    {
        return toAjax(payMerchantService.updatePayMerchant(payMerchant));
    }

    /**
     * 删除商家配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:payMerchant:remove')")
    @Log(title = "商家配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(payMerchantService.deletePayMerchantByIds(ids));
    }
}
