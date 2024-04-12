package com.ruoyi.lottery.controller;

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
import com.ruoyi.lottery.domain.OpenresultGs1mft;
import com.ruoyi.lottery.service.IOpenresultGs1mftService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 1分飞艇开奖Controller
 * 
 * @author hardy
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/lottery/openresultGs1mft")
public class OpenresultGs1mftController extends BaseController
{
    @Autowired
    private IOpenresultGs1mftService openresultGs1mftService;

    /**
     * 查询1分飞艇开奖列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultGs1mft openresultGs1mft)
    {
        startPage();
        List<OpenresultGs1mft> list = openresultGs1mftService.selectOpenresultGs1mftList(openresultGs1mft);
        return getDataTable(list);
    }

    /**
     * 导出1分飞艇开奖列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:export')")
    @Log(title = "1分飞艇开奖", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultGs1mft openresultGs1mft)
    {
        List<OpenresultGs1mft> list = openresultGs1mftService.selectOpenresultGs1mftList(openresultGs1mft);
        ExcelUtil<OpenresultGs1mft> util = new ExcelUtil<OpenresultGs1mft>(OpenresultGs1mft.class);
        util.exportExcel(response, list, "1分飞艇开奖数据");
    }

    /**
     * 获取1分飞艇开奖详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultGs1mftService.selectOpenresultGs1mftById(id));
    }

    /**
     * 新增1分飞艇开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:add')")
    @Log(title = "1分飞艇开奖", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultGs1mft openresultGs1mft)
    {
        return toAjax(openresultGs1mftService.insertOpenresultGs1mft(openresultGs1mft));
    }

    /**
     * 修改1分飞艇开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:edit')")
    @Log(title = "1分飞艇开奖", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultGs1mft openresultGs1mft)
    {
        return toAjax(openresultGs1mftService.updateOpenresultGs1mft(openresultGs1mft));
    }

    /**
     * 删除1分飞艇开奖
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultGs1mft:remove')")
    @Log(title = "1分飞艇开奖", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultGs1mftService.deleteOpenresultGs1mftByIds(ids));
    }
}
