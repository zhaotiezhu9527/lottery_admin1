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
import com.ruoyi.lottery.domain.OpenresultBjkl8;
import com.ruoyi.lottery.service.IOpenresultBjkl8Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(北京快乐8)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultBjkl8")
public class OpenresultBjkl8Controller extends BaseController
{
    @Autowired
    private IOpenresultBjkl8Service openresultBjkl8Service;

    /**
     * 查询开奖结果(北京快乐8)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultBjkl8 openresultBjkl8)
    {
        startPage();
        List<OpenresultBjkl8> list = openresultBjkl8Service.selectOpenresultBjkl8List(openresultBjkl8);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(北京快乐8)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:export')")
    @Log(title = "开奖结果(北京快乐8)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultBjkl8 openresultBjkl8)
    {
        List<OpenresultBjkl8> list = openresultBjkl8Service.selectOpenresultBjkl8List(openresultBjkl8);
        ExcelUtil<OpenresultBjkl8> util = new ExcelUtil<OpenresultBjkl8>(OpenresultBjkl8.class);
        util.exportExcel(response, list, "开奖结果(北京快乐8)数据");
    }

    /**
     * 获取开奖结果(北京快乐8)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultBjkl8Service.selectOpenresultBjkl8ById(id));
    }

    /**
     * 新增开奖结果(北京快乐8)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:add')")
    @Log(title = "开奖结果(北京快乐8)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultBjkl8 openresultBjkl8)
    {
        return toAjax(openresultBjkl8Service.insertOpenresultBjkl8(openresultBjkl8));
    }

    /**
     * 修改开奖结果(北京快乐8)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:edit')")
    @Log(title = "开奖结果(北京快乐8)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultBjkl8 openresultBjkl8)
    {
        return toAjax(openresultBjkl8Service.updateOpenresultBjkl8(openresultBjkl8));
    }

    /**
     * 删除开奖结果(北京快乐8)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultBjkl8:remove')")
    @Log(title = "开奖结果(北京快乐8)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultBjkl8Service.deleteOpenresultBjkl8ByIds(ids));
    }
}
