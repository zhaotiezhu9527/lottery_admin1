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
import com.ruoyi.lottery.domain.Avatar;
import com.ruoyi.lottery.service.IAvatarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 头像管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/avatar")
public class AvatarController extends BaseController
{
    @Autowired
    private IAvatarService avatarService;

    /**
     * 查询头像管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:list')")
    @GetMapping("/list")
    public TableDataInfo list(Avatar avatar)
    {
        startPage();
        List<Avatar> list = avatarService.selectAvatarList(avatar);
        return getDataTable(list);
    }

    /**
     * 导出头像管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:export')")
    @Log(title = "头像管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Avatar avatar)
    {
        List<Avatar> list = avatarService.selectAvatarList(avatar);
        ExcelUtil<Avatar> util = new ExcelUtil<Avatar>(Avatar.class);
        util.exportExcel(response, list, "头像管理数据");
    }

    /**
     * 获取头像管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(avatarService.selectAvatarById(id));
    }

    /**
     * 新增头像管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:add')")
    @Log(title = "头像管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Avatar avatar)
    {
        return toAjax(avatarService.insertAvatar(avatar));
    }

    /**
     * 修改头像管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:edit')")
    @Log(title = "头像管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Avatar avatar)
    {
        return toAjax(avatarService.updateAvatar(avatar));
    }

    /**
     * 删除头像管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:avatar:remove')")
    @Log(title = "头像管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(avatarService.deleteAvatarByIds(ids));
    }
}
