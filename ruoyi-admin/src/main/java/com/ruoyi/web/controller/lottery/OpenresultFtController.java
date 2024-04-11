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
import com.ruoyi.lottery.domain.OpenresultFt;
import com.ruoyi.lottery.service.IOpenresultFtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(飞艇)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultFt")
public class OpenresultFtController extends BaseController
{
    @Autowired
    private IOpenresultFtService openresultFtService;

    /**
     * 查询开奖结果(飞艇)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultFt openresultFt)
    {
        startPage();
        List<OpenresultFt> list = openresultFtService.selectOpenresultFtList(openresultFt);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(飞艇)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:export')")
    @Log(title = "开奖结果(飞艇)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultFt openresultFt)
    {
        List<OpenresultFt> list = openresultFtService.selectOpenresultFtList(openresultFt);
        ExcelUtil<OpenresultFt> util = new ExcelUtil<OpenresultFt>(OpenresultFt.class);
        util.exportExcel(response, list, "开奖结果(飞艇)数据");
    }

    /**
     * 获取开奖结果(飞艇)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultFtService.selectOpenresultFtById(id));
    }

    /**
     * 新增开奖结果(飞艇)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:add')")
    @Log(title = "开奖结果(飞艇)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultFt openresultFt)
    {
        return toAjax(openresultFtService.insertOpenresultFt(openresultFt));
    }

    /**
     * 修改开奖结果(飞艇)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:edit')")
    @Log(title = "开奖结果(飞艇)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultFt openresultFt)
    {
        return toAjax(openresultFtService.updateOpenresultFt(openresultFt));
    }

    /**
     * 删除开奖结果(飞艇)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFt:remove')")
    @Log(title = "开奖结果(飞艇)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultFtService.deleteOpenresultFtByIds(ids));
    }
}
