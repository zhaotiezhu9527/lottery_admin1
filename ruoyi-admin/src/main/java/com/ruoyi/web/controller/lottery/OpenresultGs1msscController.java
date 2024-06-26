package com.ruoyi.web.controller.lottery;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.lottery.domain.OpenresultGs1mssc;
import com.ruoyi.lottery.service.IOpenresultGs1msscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 开奖结果(gs1mssc)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultGs1mssc")
public class OpenresultGs1msscController extends BaseController
{
    @Autowired
    private IOpenresultGs1msscService openresultGs1msscService;

    /**
     * 查询开奖结果(gs1mssc)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mssc openresultGs1mssc)
    {
        startPage();
        List<OpenresultGs1mssc> list = openresultGs1msscService.selectOpenresultGs1msscList(openresultGs1mssc);
        Date now = new Date();
        for (OpenresultGs1mssc result : list) {
            if (now.getTime() < result.getOpenResultTime().getTime()) {
                result.setOpenStatus(1L);
                result.setOpenResult("");
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(gs1mssc)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:export')")
    @Log(title = "开奖结果(gs1mssc)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mssc openresultGs1mssc)
    {
        startOrderBy();
        List<OpenresultGs1mssc> list = openresultGs1msscService.selectOpenresultGs1msscList(openresultGs1mssc);
        ExcelUtil<OpenresultGs1mssc> util = new ExcelUtil<OpenresultGs1mssc>(OpenresultGs1mssc.class);
        util.exportExcel(response, list, "开奖结果(gs1mssc)数据");
    }

    /**
     * 获取开奖结果(gs1mssc)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1msscService.selectOpenresultGs1msscById(id));
    }

    /**
     * 新增开奖结果(gs1mssc)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:add')")
    @Log(title = "开奖结果(gs1mssc)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mssc openresultGs1mssc)
    {
        return toAjax(openresultGs1msscService.insertOpenresultGs1mssc(openresultGs1mssc));
    }

    /**
     * 修改开奖结果(gs1mssc)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:edit')")
    @Log(title = "开奖结果(gs1mssc)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mssc openresultGs1mssc)
    {
        OpenresultGs1mssc result = openresultGs1msscService.selectOpenresultGs1msscById(openresultGs1mssc.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        result.setOpenStatus(0L);
        return toAjax(openresultGs1msscService.updateOpenresultGs1mssc(openresultGs1mssc));
    }

    /**
     * 删除开奖结果(gs1mssc)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mssc:remove')")
    @Log(title = "开奖结果(gs1mssc)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1msscService.deleteOpenresultGs1msscByIds(ids));
    }
}
