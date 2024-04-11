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
import com.ruoyi.lottery.domain.LotteryHandicap;
import com.ruoyi.lottery.service.ILotteryHandicapService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘口管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/lotteryHandicap")
public class LotteryHandicapController extends BaseController
{
    @Autowired
    private ILotteryHandicapService lotteryHandicapService;

    /**
     * 查询盘口管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotteryHandicap lotteryHandicap)
    {
        startPage();
        List<LotteryHandicap> list = lotteryHandicapService.selectLotteryHandicapList(lotteryHandicap);
        return getDataTable(list);
    }

    /**
     * 导出盘口管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:export')")
    @Log(title = "盘口管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotteryHandicap lotteryHandicap)
    {
        List<LotteryHandicap> list = lotteryHandicapService.selectLotteryHandicapList(lotteryHandicap);
        ExcelUtil<LotteryHandicap> util = new ExcelUtil<LotteryHandicap>(LotteryHandicap.class);
        util.exportExcel(response, list, "盘口管理数据");
    }

    /**
     * 获取盘口管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lotteryHandicapService.selectLotteryHandicapById(id));
    }

    /**
     * 新增盘口管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:add')")
    @Log(title = "盘口管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotteryHandicap lotteryHandicap)
    {
        return toAjax(lotteryHandicapService.insertLotteryHandicap(lotteryHandicap));
    }

    /**
     * 修改盘口管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:edit')")
    @Log(title = "盘口管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotteryHandicap lotteryHandicap)
    {
        return toAjax(lotteryHandicapService.updateLotteryHandicap(lotteryHandicap));
    }

    /**
     * 删除盘口管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryHandicap:remove')")
    @Log(title = "盘口管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lotteryHandicapService.deleteLotteryHandicapByIds(ids));
    }
}
