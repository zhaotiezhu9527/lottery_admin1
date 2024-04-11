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
import com.ruoyi.lottery.domain.Group;
import com.ruoyi.lottery.service.IGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分组管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/group")
public class GroupController extends BaseController
{
    @Autowired
    private IGroupService groupService;

    /**
     * 查询分组管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(Group group)
    {
        startPage();
        List<Group> list = groupService.selectGroupList(group);
        return getDataTable(list);
    }

    /**
     * 导出分组管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:export')")
    @Log(title = "分组管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Group group)
    {
        List<Group> list = groupService.selectGroupList(group);
        ExcelUtil<Group> util = new ExcelUtil<Group>(Group.class);
        util.exportExcel(response, list, "分组管理数据");
    }

    /**
     * 获取分组管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(groupService.selectGroupById(id));
    }

    /**
     * 新增分组管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:add')")
    @Log(title = "分组管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Group group)
    {
        return toAjax(groupService.insertGroup(group));
    }

    /**
     * 修改分组管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:edit')")
    @Log(title = "分组管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Group group)
    {
        return toAjax(groupService.updateGroup(group));
    }

    /**
     * 删除分组管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:group:remove')")
    @Log(title = "分组管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(groupService.deleteGroupByIds(ids));
    }
}
