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
import com.ruoyi.lottery.domain.OpenresultCqssc;
import com.ruoyi.lottery.service.IOpenresultCqsscService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(重庆时时彩)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultCqssc")
public class OpenresultCqsscController extends BaseController
{
    @Autowired
    private IOpenresultCqsscService openresultCqsscService;

    /**
     * 查询开奖结果(重庆时时彩)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultCqssc openresultCqssc)
    {
        startPage();
        List<OpenresultCqssc> list = openresultCqsscService.selectOpenresultCqsscList(openresultCqssc);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(重庆时时彩)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:export')")
    @Log(title = "开奖结果(重庆时时彩)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultCqssc openresultCqssc)
    {
        startOrderBy();
        List<OpenresultCqssc> list = openresultCqsscService.selectOpenresultCqsscList(openresultCqssc);
        ExcelUtil<OpenresultCqssc> util = new ExcelUtil<OpenresultCqssc>(OpenresultCqssc.class);
        util.exportExcel(response, list, "开奖结果(重庆时时彩)数据");
    }

    /**
     * 获取开奖结果(重庆时时彩)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultCqsscService.selectOpenresultCqsscById(id));
    }

    /**
     * 新增开奖结果(重庆时时彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:add')")
    @Log(title = "开奖结果(重庆时时彩)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultCqssc openresultCqssc)
    {
        return toAjax(openresultCqsscService.insertOpenresultCqssc(openresultCqssc));
    }

    /**
     * 修改开奖结果(重庆时时彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:edit')")
    @Log(title = "开奖结果(重庆时时彩)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultCqssc openresultCqssc)
    {
        return toAjax(openresultCqsscService.updateOpenresultCqssc(openresultCqssc));
    }

    /**
     * 删除开奖结果(重庆时时彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultCqssc:remove')")
    @Log(title = "开奖结果(重庆时时彩)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultCqsscService.deleteOpenresultCqsscByIds(ids));
    }
}
