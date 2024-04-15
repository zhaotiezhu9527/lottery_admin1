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
import com.ruoyi.lottery.domain.LotteryPlay;
import com.ruoyi.lottery.service.ILotteryPlayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 玩法管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/lotteryPlay")
public class LotteryPlayController extends BaseController
{
    @Autowired
    private ILotteryPlayService lotteryPlayService;

    /**
     * 查询玩法管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotteryPlay lotteryPlay)
    {
        startPage();
        List<LotteryPlay> list = lotteryPlayService.selectLotteryPlayList(lotteryPlay);
        return getDataTable(list);
    }

    /**
     * 导出玩法管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:export')")
    @Log(title = "玩法管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotteryPlay lotteryPlay)
    {
        startOrderBy();
        List<LotteryPlay> list = lotteryPlayService.selectLotteryPlayList(lotteryPlay);
        ExcelUtil<LotteryPlay> util = new ExcelUtil<LotteryPlay>(LotteryPlay.class);
        util.exportExcel(response, list, "玩法管理数据");
    }

    /**
     * 获取玩法管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lotteryPlayService.selectLotteryPlayById(id));
    }

    /**
     * 新增玩法管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:add')")
    @Log(title = "玩法管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotteryPlay lotteryPlay)
    {
        return toAjax(lotteryPlayService.insertLotteryPlay(lotteryPlay));
    }

    /**
     * 修改玩法管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:edit')")
    @Log(title = "玩法管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotteryPlay lotteryPlay)
    {
        return toAjax(lotteryPlayService.updateLotteryPlay(lotteryPlay));
    }

    /**
     * 删除玩法管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryPlay:remove')")
    @Log(title = "玩法管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lotteryPlayService.deleteLotteryPlayByIds(ids));
    }
}
