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
import com.ruoyi.lottery.domain.LotteryOdds;
import com.ruoyi.lottery.service.ILotteryOddsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 赔率设置Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/lotteryOdds")
public class LotteryOddsController extends BaseController
{
    @Autowired
    private ILotteryOddsService lotteryOddsService;

    /**
     * 查询赔率设置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotteryOdds lotteryOdds)
    {
        startPage();
        List<LotteryOdds> list = lotteryOddsService.selectLotteryOddsList(lotteryOdds);
        return getDataTable(list);
    }

    /**
     * 导出赔率设置列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:export')")
    @Log(title = "赔率设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotteryOdds lotteryOdds)
    {
        List<LotteryOdds> list = lotteryOddsService.selectLotteryOddsList(lotteryOdds);
        ExcelUtil<LotteryOdds> util = new ExcelUtil<LotteryOdds>(LotteryOdds.class);
        util.exportExcel(response, list, "赔率设置数据");
    }

    /**
     * 获取赔率设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lotteryOddsService.selectLotteryOddsById(id));
    }

    /**
     * 新增赔率设置
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:add')")
    @Log(title = "赔率设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotteryOdds lotteryOdds)
    {
        return toAjax(lotteryOddsService.insertLotteryOdds(lotteryOdds));
    }

    /**
     * 修改赔率设置
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:edit')")
    @Log(title = "赔率设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotteryOdds lotteryOdds)
    {
        return toAjax(lotteryOddsService.updateLotteryOdds(lotteryOdds));
    }

    /**
     * 删除赔率设置
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOdds:remove')")
    @Log(title = "赔率设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lotteryOddsService.deleteLotteryOddsByIds(ids));
    }
}
