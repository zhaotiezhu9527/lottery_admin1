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
import com.ruoyi.lottery.domain.CompanyVirtual;
import com.ruoyi.lottery.service.ICompanyVirtualService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司U地址Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/companyVirtual")
public class CompanyVirtualController extends BaseController
{
    @Autowired
    private ICompanyVirtualService companyVirtualService;

    /**
     * 查询公司U地址列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompanyVirtual companyVirtual)
    {
        startPage();
        List<CompanyVirtual> list = companyVirtualService.selectCompanyVirtualList(companyVirtual);
        return getDataTable(list);
    }

    /**
     * 导出公司U地址列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:export')")
    @Log(title = "公司U地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompanyVirtual companyVirtual)
    {
        startOrderBy();
        List<CompanyVirtual> list = companyVirtualService.selectCompanyVirtualList(companyVirtual);
        ExcelUtil<CompanyVirtual> util = new ExcelUtil<CompanyVirtual>(CompanyVirtual.class);
        util.exportExcel(response, list, "公司U地址数据");
    }

    /**
     * 获取公司U地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(companyVirtualService.selectCompanyVirtualById(id));
    }

    /**
     * 新增公司U地址
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:add')")
    @Log(title = "公司U地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompanyVirtual companyVirtual)
    {
        companyVirtual.setOperName(getUsername());
        return toAjax(companyVirtualService.insertCompanyVirtual(companyVirtual));
    }

    /**
     * 修改公司U地址
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:edit')")
    @Log(title = "公司U地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompanyVirtual companyVirtual)
    {
        companyVirtual.setOperName(getUsername());
        return toAjax(companyVirtualService.updateCompanyVirtual(companyVirtual));
    }

    /**
     * 删除公司U地址
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyVirtual:remove')")
    @Log(title = "公司U地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(companyVirtualService.deleteCompanyVirtualByIds(ids));
    }
}
