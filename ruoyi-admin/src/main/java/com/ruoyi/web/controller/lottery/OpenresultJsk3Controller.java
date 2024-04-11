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
import com.ruoyi.lottery.domain.OpenresultJsk3;
import com.ruoyi.lottery.service.IOpenresultJsk3Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(江苏快3)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultJsk3")
public class OpenresultJsk3Controller extends BaseController
{
    @Autowired
    private IOpenresultJsk3Service openresultJsk3Service;

    /**
     * 查询开奖结果(江苏快3)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultJsk3 openresultJsk3)
    {
        startPage();
        List<OpenresultJsk3> list = openresultJsk3Service.selectOpenresultJsk3List(openresultJsk3);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(江苏快3)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:export')")
    @Log(title = "开奖结果(江苏快3)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultJsk3 openresultJsk3)
    {
        List<OpenresultJsk3> list = openresultJsk3Service.selectOpenresultJsk3List(openresultJsk3);
        ExcelUtil<OpenresultJsk3> util = new ExcelUtil<OpenresultJsk3>(OpenresultJsk3.class);
        util.exportExcel(response, list, "开奖结果(江苏快3)数据");
    }

    /**
     * 获取开奖结果(江苏快3)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultJsk3Service.selectOpenresultJsk3ById(id));
    }

    /**
     * 新增开奖结果(江苏快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:add')")
    @Log(title = "开奖结果(江苏快3)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultJsk3 openresultJsk3)
    {
        return toAjax(openresultJsk3Service.insertOpenresultJsk3(openresultJsk3));
    }

    /**
     * 修改开奖结果(江苏快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:edit')")
    @Log(title = "开奖结果(江苏快3)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultJsk3 openresultJsk3)
    {
        return toAjax(openresultJsk3Service.updateOpenresultJsk3(openresultJsk3));
    }

    /**
     * 删除开奖结果(江苏快3)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultJsk3:remove')")
    @Log(title = "开奖结果(江苏快3)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultJsk3Service.deleteOpenresultJsk3ByIds(ids));
    }
}
