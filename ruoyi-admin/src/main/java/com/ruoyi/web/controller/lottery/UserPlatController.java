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
import com.ruoyi.lottery.domain.UserPlat;
import com.ruoyi.lottery.service.IUserPlatService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 三方用户Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/userPlat")
public class UserPlatController extends BaseController
{
    @Autowired
    private IUserPlatService userPlatService;

    /**
     * 查询三方用户列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserPlat userPlat)
    {
        startPage();
        List<UserPlat> list = userPlatService.selectUserPlatList(userPlat);
        return getDataTable(list);
    }

    /**
     * 导出三方用户列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:export')")
    @Log(title = "三方用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserPlat userPlat)
    {
        List<UserPlat> list = userPlatService.selectUserPlatList(userPlat);
        ExcelUtil<UserPlat> util = new ExcelUtil<UserPlat>(UserPlat.class);
        util.exportExcel(response, list, "三方用户数据");
    }

    /**
     * 获取三方用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userPlatService.selectUserPlatById(id));
    }

    /**
     * 新增三方用户
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:add')")
    @Log(title = "三方用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserPlat userPlat)
    {
        return toAjax(userPlatService.insertUserPlat(userPlat));
    }

    /**
     * 修改三方用户
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:edit')")
    @Log(title = "三方用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserPlat userPlat)
    {
        return toAjax(userPlatService.updateUserPlat(userPlat));
    }

    /**
     * 删除三方用户
     */
    @PreAuthorize("@ss.hasPermi('lottery:userPlat:remove')")
    @Log(title = "三方用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userPlatService.deleteUserPlatByIds(ids));
    }
}
