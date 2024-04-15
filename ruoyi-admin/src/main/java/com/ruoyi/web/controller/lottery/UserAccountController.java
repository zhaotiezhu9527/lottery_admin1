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
import com.ruoyi.lottery.domain.UserAccount;
import com.ruoyi.lottery.service.IUserAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收款方式Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/userAccount")
public class UserAccountController extends BaseController
{
    @Autowired
    private IUserAccountService userAccountService;

    /**
     * 查询收款方式列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserAccount userAccount)
    {
        startPage();
        List<UserAccount> list = userAccountService.selectUserAccountList(userAccount);
        return getDataTable(list);
    }

    /**
     * 导出收款方式列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:export')")
    @Log(title = "收款方式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserAccount userAccount)
    {
        startOrderBy();
        List<UserAccount> list = userAccountService.selectUserAccountList(userAccount);
        ExcelUtil<UserAccount> util = new ExcelUtil<UserAccount>(UserAccount.class);
        util.exportExcel(response, list, "收款方式数据");
    }

    /**
     * 获取收款方式详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userAccountService.selectUserAccountById(id));
    }

    /**
     * 新增收款方式
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:add')")
    @Log(title = "收款方式", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserAccount userAccount)
    {
        return toAjax(userAccountService.insertUserAccount(userAccount));
    }

    /**
     * 修改收款方式
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:edit')")
    @Log(title = "收款方式", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserAccount userAccount)
    {
        return toAjax(userAccountService.updateUserAccount(userAccount));
    }

    /**
     * 删除收款方式
     */
    @PreAuthorize("@ss.hasPermi('lottery:userAccount:remove')")
    @Log(title = "收款方式", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userAccountService.deleteUserAccountByIds(ids));
    }
}
