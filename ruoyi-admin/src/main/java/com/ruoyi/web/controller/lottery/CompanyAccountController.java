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
import com.ruoyi.lottery.domain.CompanyAccount;
import com.ruoyi.lottery.service.ICompanyAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司入款账号Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/companyAccount")
public class CompanyAccountController extends BaseController
{
    @Autowired
    private ICompanyAccountService companyAccountService;

    /**
     * 查询公司入款账号列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompanyAccount companyAccount)
    {
        startPage();
        List<CompanyAccount> list = companyAccountService.selectCompanyAccountList(companyAccount);
        return getDataTable(list);
    }

    /**
     * 导出公司入款账号列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:export')")
    @Log(title = "公司入款账号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompanyAccount companyAccount)
    {
        List<CompanyAccount> list = companyAccountService.selectCompanyAccountList(companyAccount);
        ExcelUtil<CompanyAccount> util = new ExcelUtil<CompanyAccount>(CompanyAccount.class);
        util.exportExcel(response, list, "公司入款账号数据");
    }

    /**
     * 获取公司入款账号详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(companyAccountService.selectCompanyAccountById(id));
    }

    /**
     * 新增公司入款账号
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:add')")
    @Log(title = "公司入款账号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompanyAccount companyAccount)
    {
        return toAjax(companyAccountService.insertCompanyAccount(companyAccount));
    }

    /**
     * 修改公司入款账号
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:edit')")
    @Log(title = "公司入款账号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompanyAccount companyAccount)
    {
        return toAjax(companyAccountService.updateCompanyAccount(companyAccount));
    }

    /**
     * 删除公司入款账号
     */
    @PreAuthorize("@ss.hasPermi('lottery:companyAccount:remove')")
    @Log(title = "公司入款账号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(companyAccountService.deleteCompanyAccountByIds(ids));
    }
}
