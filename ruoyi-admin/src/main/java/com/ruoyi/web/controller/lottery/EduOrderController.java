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
import com.ruoyi.lottery.domain.EduOrder;
import com.ruoyi.lottery.service.IEduOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 额度转换Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/eduOrder")
public class EduOrderController extends BaseController
{
    @Autowired
    private IEduOrderService eduOrderService;

    /**
     * 查询额度转换列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduOrder eduOrder)
    {
        startPage();
        List<EduOrder> list = eduOrderService.selectEduOrderList(eduOrder);
        return getDataTable(list);
    }

    /**
     * 导出额度转换列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:export')")
    @Log(title = "额度转换", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduOrder eduOrder)
    {
        List<EduOrder> list = eduOrderService.selectEduOrderList(eduOrder);
        ExcelUtil<EduOrder> util = new ExcelUtil<EduOrder>(EduOrder.class);
        util.exportExcel(response, list, "额度转换数据");
    }

    /**
     * 获取额度转换详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduOrderService.selectEduOrderById(id));
    }

    /**
     * 新增额度转换
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:add')")
    @Log(title = "额度转换", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduOrder eduOrder)
    {
        return toAjax(eduOrderService.insertEduOrder(eduOrder));
    }

    /**
     * 修改额度转换
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:edit')")
    @Log(title = "额度转换", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduOrder eduOrder)
    {
        return toAjax(eduOrderService.updateEduOrder(eduOrder));
    }

    /**
     * 删除额度转换
     */
    @PreAuthorize("@ss.hasPermi('lottery:eduOrder:remove')")
    @Log(title = "额度转换", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduOrderService.deleteEduOrderByIds(ids));
    }
}
