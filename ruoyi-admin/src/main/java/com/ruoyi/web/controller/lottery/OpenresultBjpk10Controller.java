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
import com.ruoyi.lottery.domain.OpenresultBjpk10;
import com.ruoyi.lottery.service.IOpenresultBjpk10Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(北京PK10)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultBjpk10")
public class OpenresultBjpk10Controller extends BaseController
{
    @Autowired
    private IOpenresultBjpk10Service openresultBjpk10Service;

    /**
     * 查询开奖结果(北京PK10)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultBjpk10 openresultBjpk10)
    {
        startPage();
        List<OpenresultBjpk10> list = openresultBjpk10Service.selectOpenresultBjpk10List(openresultBjpk10);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(北京PK10)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:export')")
    @Log(title = "开奖结果(北京PK10)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultBjpk10 openresultBjpk10)
    {
        startOrderBy();
        List<OpenresultBjpk10> list = openresultBjpk10Service.selectOpenresultBjpk10List(openresultBjpk10);
        ExcelUtil<OpenresultBjpk10> util = new ExcelUtil<OpenresultBjpk10>(OpenresultBjpk10.class);
        util.exportExcel(response, list, "开奖结果(北京PK10)数据");
    }

    /**
     * 获取开奖结果(北京PK10)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultBjpk10Service.selectOpenresultBjpk10ById(id));
    }

    /**
     * 新增开奖结果(北京PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:add')")
    @Log(title = "开奖结果(北京PK10)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultBjpk10 openresultBjpk10)
    {
        return toAjax(openresultBjpk10Service.insertOpenresultBjpk10(openresultBjpk10));
    }

    /**
     * 修改开奖结果(北京PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:edit')")
    @Log(title = "开奖结果(北京PK10)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultBjpk10 openresultBjpk10)
    {
        OpenresultBjpk10 result = openresultBjpk10Service.selectOpenresultBjpk10ById(openresultBjpk10.getId());
        Date now = new Date();
        if (now.getTime() >= result.getOpenResultTime().getTime()) {
            return error("当前期已过开奖时间");
        }
        openresultBjpk10.setOpenStatus(0L);
        return toAjax(openresultBjpk10Service.updateOpenresultBjpk10(openresultBjpk10));
    }

    /**
     * 删除开奖结果(北京PK10)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjpk10:remove')")
    @Log(title = "开奖结果(北京PK10)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultBjpk10Service.deleteOpenresultBjpk10ByIds(ids));
    }
}
