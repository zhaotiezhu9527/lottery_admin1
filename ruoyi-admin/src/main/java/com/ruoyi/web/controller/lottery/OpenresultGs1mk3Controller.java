package com.ruoyi.web.controller.lottery;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.lottery.domain.OpenresultGs1mk3;
import com.ruoyi.lottery.service.IOpenresultGs1mk3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 开奖结果(GS1分快3)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultGs1mk3")
public class OpenresultGs1mk3Controller extends BaseController
{
    @Autowired
    private IOpenresultGs1mk3Service openresultGs1mk3Service;

    /**
     * 查询开奖结果(GS1分快3)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mk3 openresultGs1mk3)
    {
        startPage();
        List<OpenresultGs1mk3> list = openresultGs1mk3Service.selectOpenresultGs1mk3List(openresultGs1mk3);
        Date now = new Date();
        for (OpenresultGs1mk3 result : list) {
            if (now.getTime() < result.getOpenResultTime().getTime()) {
                result.setOpenStatus(1L);
                result.setOpenResult("");
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(GS1分快3)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:export')")
    @Log(title = "开奖结果(GS1分快3)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mk3 openresultGs1mk3)
    {
        startOrderBy();
        List<OpenresultGs1mk3> list = openresultGs1mk3Service.selectOpenresultGs1mk3List(openresultGs1mk3);
        ExcelUtil<OpenresultGs1mk3> util = new ExcelUtil<OpenresultGs1mk3>(OpenresultGs1mk3.class);
        util.exportExcel(response, list, "开奖结果(GS1分快3)数据");
    }

    /**
     * 获取开奖结果(GS1分快3)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mk3Service.selectOpenresultGs1mk3ById(id));
    }

    /**
     * 新增开奖结果(GS1分快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:add')")
    @Log(title = "开奖结果(GS1分快3)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mk3 openresultGs1mk3)
    {
        return toAjax(openresultGs1mk3Service.insertOpenresultGs1mk3(openresultGs1mk3));
    }

    /**
     * 修改开奖结果(GS1分快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:edit')")
    @Log(title = "开奖结果(GS1分快3)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mk3 openresultGs1mk3)
    {
        OpenresultGs1mk3 result = openresultGs1mk3Service.selectOpenresultGs1mk3ById(openresultGs1mk3.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        result.setOpenStatus(0L);
        return toAjax(openresultGs1mk3Service.updateOpenresultGs1mk3(openresultGs1mk3));
    }

    /**
     * 删除开奖结果(GS1分快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mk3:remove')")
    @Log(title = "开奖结果(GS1分快3)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mk3Service.deleteOpenresultGs1mk3ByIds(ids));
    }
}
