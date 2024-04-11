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
import com.ruoyi.lottery.domain.UserLoginLog;
import com.ruoyi.lottery.service.IUserLoginLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 登录日志Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/userLoginLog")
public class UserLoginLogController extends BaseController
{
    @Autowired
    private IUserLoginLogService userLoginLogService;

    /**
     * 查询登录日志列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserLoginLog userLoginLog)
    {
        startPage();
        List<UserLoginLog> list = userLoginLogService.selectUserLoginLogList(userLoginLog);
        return getDataTable(list);
    }

    /**
     * 导出登录日志列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:export')")
    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserLoginLog userLoginLog)
    {
        List<UserLoginLog> list = userLoginLogService.selectUserLoginLogList(userLoginLog);
        ExcelUtil<UserLoginLog> util = new ExcelUtil<UserLoginLog>(UserLoginLog.class);
        util.exportExcel(response, list, "登录日志数据");
    }

    /**
     * 获取登录日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userLoginLogService.selectUserLoginLogById(id));
    }

    /**
     * 新增登录日志
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:add')")
    @Log(title = "登录日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserLoginLog userLoginLog)
    {
        return toAjax(userLoginLogService.insertUserLoginLog(userLoginLog));
    }

    /**
     * 修改登录日志
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:edit')")
    @Log(title = "登录日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserLoginLog userLoginLog)
    {
        return toAjax(userLoginLogService.updateUserLoginLog(userLoginLog));
    }

    /**
     * 删除登录日志
     */
    @PreAuthorize("@ss.hasPermi('lottery:userLoginLog:remove')")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userLoginLogService.deleteUserLoginLogByIds(ids));
    }
}
