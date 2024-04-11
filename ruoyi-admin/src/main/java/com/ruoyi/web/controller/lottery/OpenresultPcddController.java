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
import com.ruoyi.lottery.domain.OpenresultPcdd;
import com.ruoyi.lottery.service.IOpenresultPcddService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(PC蛋蛋)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultPcdd")
public class OpenresultPcddController extends BaseController
{
    @Autowired
    private IOpenresultPcddService openresultPcddService;

    /**
     * 查询开奖结果(PC蛋蛋)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultPcdd openresultPcdd)
    {
        startPage();
        List<OpenresultPcdd> list = openresultPcddService.selectOpenresultPcddList(openresultPcdd);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(PC蛋蛋)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:export')")
    @Log(title = "开奖结果(PC蛋蛋)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultPcdd openresultPcdd)
    {
        List<OpenresultPcdd> list = openresultPcddService.selectOpenresultPcddList(openresultPcdd);
        ExcelUtil<OpenresultPcdd> util = new ExcelUtil<OpenresultPcdd>(OpenresultPcdd.class);
        util.exportExcel(response, list, "开奖结果(PC蛋蛋)数据");
    }

    /**
     * 获取开奖结果(PC蛋蛋)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultPcddService.selectOpenresultPcddById(id));
    }

    /**
     * 新增开奖结果(PC蛋蛋)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:add')")
    @Log(title = "开奖结果(PC蛋蛋)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultPcdd openresultPcdd)
    {
        return toAjax(openresultPcddService.insertOpenresultPcdd(openresultPcdd));
    }

    /**
     * 修改开奖结果(PC蛋蛋)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:edit')")
    @Log(title = "开奖结果(PC蛋蛋)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultPcdd openresultPcdd)
    {
        return toAjax(openresultPcddService.updateOpenresultPcdd(openresultPcdd));
    }

    /**
     * 删除开奖结果(PC蛋蛋)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultPcdd:remove')")
    @Log(title = "开奖结果(PC蛋蛋)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultPcddService.deleteOpenresultPcddByIds(ids));
    }
}
