package com.ruoyi.web.controller.lottery;

import java.util.Date;
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
import com.ruoyi.lottery.domain.OpenresultGd11x5;
import com.ruoyi.lottery.service.IOpenresultGd11x5Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(广东11选5)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultGd11x5")
public class OpenresultGd11x5Controller extends BaseController
{
    @Autowired
    private IOpenresultGd11x5Service openresultGd11x5Service;

    /**
     * 查询开奖结果(广东11选5)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGd11x5 openresultGd11x5)
    {
        startPage();
        List<OpenresultGd11x5> list = openresultGd11x5Service.selectOpenresultGd11x5List(openresultGd11x5);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(广东11选5)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:export')")
    @Log(title = "开奖结果(广东11选5)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGd11x5 openresultGd11x5)
    {
        startOrderBy();
        List<OpenresultGd11x5> list = openresultGd11x5Service.selectOpenresultGd11x5List(openresultGd11x5);
        ExcelUtil<OpenresultGd11x5> util = new ExcelUtil<OpenresultGd11x5>(OpenresultGd11x5.class);
        util.exportExcel(response, list, "开奖结果(广东11选5)数据");
    }

    /**
     * 获取开奖结果(广东11选5)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGd11x5Service.selectOpenresultGd11x5ById(id));
    }

    /**
     * 新增开奖结果(广东11选5)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:add')")
    @Log(title = "开奖结果(广东11选5)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGd11x5 openresultGd11x5)
    {
        return toAjax(openresultGd11x5Service.insertOpenresultGd11x5(openresultGd11x5));
    }

    /**
     * 修改开奖结果(广东11选5)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:edit')")
    @Log(title = "开奖结果(广东11选5)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGd11x5 openresultGd11x5)
    {
        OpenresultGd11x5 result = openresultGd11x5Service.selectOpenresultGd11x5ById(openresultGd11x5.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        result.setOpenStatus(0L);
        return toAjax(openresultGd11x5Service.updateOpenresultGd11x5(openresultGd11x5));
    }

    /**
     * 删除开奖结果(广东11选5)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGd11x5:remove')")
    @Log(title = "开奖结果(广东11选5)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGd11x5Service.deleteOpenresultGd11x5ByIds(ids));
    }
}
