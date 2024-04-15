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
import com.ruoyi.lottery.domain.Activity;
import com.ruoyi.lottery.service.IActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动配置Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/activity")
public class ActivityController extends BaseController
{
    @Autowired
    private IActivityService activityService;

    /**
     * 查询活动配置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(Activity activity)
    {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        return getDataTable(list);
    }

    /**
     * 导出活动配置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:export')")
    @Log(title = "活动配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Activity activity)
    {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.exportExcel(response, list, "活动配置数据");
    }

    /**
     * 获取活动配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(activityService.selectActivityById(id));
    }

    /**
     * 新增活动配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:add')")
    @Log(title = "活动配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Activity activity)
    {
        activity.setOperName(getUsername());
        return toAjax(activityService.insertActivity(activity));
    }

    /**
     * 修改活动配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:edit')")
    @Log(title = "活动配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Activity activity)
    {
        activity.setOperName(getUsername());
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除活动配置
     */
    @PreAuthorize("@ss.hasPermi('lottery:activity:remove')")
    @Log(title = "活动配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(activityService.deleteActivityByIds(ids));
    }
}
