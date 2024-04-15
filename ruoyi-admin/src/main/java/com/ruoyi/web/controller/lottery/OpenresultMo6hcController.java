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
import com.ruoyi.lottery.domain.OpenresultMo6hc;
import com.ruoyi.lottery.service.IOpenresultMo6hcService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(澳门六合彩)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultMo6hc")
public class OpenresultMo6hcController extends BaseController
{
    @Autowired
    private IOpenresultMo6hcService openresultMo6hcService;

    /**
     * 查询开奖结果(澳门六合彩)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultMo6hc openresultMo6hc)
    {
        startPage();
        List<OpenresultMo6hc> list = openresultMo6hcService.selectOpenresultMo6hcList(openresultMo6hc);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(澳门六合彩)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:export')")
    @Log(title = "开奖结果(澳门六合彩)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultMo6hc openresultMo6hc)
    {
        startOrderBy();
        List<OpenresultMo6hc> list = openresultMo6hcService.selectOpenresultMo6hcList(openresultMo6hc);
        ExcelUtil<OpenresultMo6hc> util = new ExcelUtil<OpenresultMo6hc>(OpenresultMo6hc.class);
        util.exportExcel(response, list, "开奖结果(澳门六合彩)数据");
    }

    /**
     * 获取开奖结果(澳门六合彩)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultMo6hcService.selectOpenresultMo6hcById(id));
    }

    /**
     * 新增开奖结果(澳门六合彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:add')")
    @Log(title = "开奖结果(澳门六合彩)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultMo6hc openresultMo6hc)
    {
        return toAjax(openresultMo6hcService.insertOpenresultMo6hc(openresultMo6hc));
    }

    /**
     * 修改开奖结果(澳门六合彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:edit')")
    @Log(title = "开奖结果(澳门六合彩)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultMo6hc openresultMo6hc)
    {
        return toAjax(openresultMo6hcService.updateOpenresultMo6hc(openresultMo6hc));
    }

    /**
     * 删除开奖结果(澳门六合彩)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultMo6hc:remove')")
    @Log(title = "开奖结果(澳门六合彩)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultMo6hcService.deleteOpenresultMo6hcByIds(ids));
    }
}
