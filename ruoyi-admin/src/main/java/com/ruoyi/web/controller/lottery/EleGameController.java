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
import com.ruoyi.lottery.domain.EleGame;
import com.ruoyi.lottery.service.IEleGameService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏列表Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/eleGame")
public class EleGameController extends BaseController
{
    @Autowired
    private IEleGameService eleGameService;

    /**
     * 查询游戏列表列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:list')")
    @GetMapping("/list")
    public TableDataInfo list(EleGame eleGame)
    {
        startPage();
        List<EleGame> list = eleGameService.selectEleGameList(eleGame);
        return getDataTable(list);
    }

    /**
     * 导出游戏列表列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:export')")
    @Log(title = "游戏列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EleGame eleGame)
    {
        startOrderBy();
        List<EleGame> list = eleGameService.selectEleGameList(eleGame);
        ExcelUtil<EleGame> util = new ExcelUtil<EleGame>(EleGame.class);
        util.exportExcel(response, list, "游戏列表数据");
    }

    /**
     * 获取游戏列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eleGameService.selectEleGameById(id));
    }

    /**
     * 新增游戏列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:add')")
    @Log(title = "游戏列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EleGame eleGame)
    {
        return toAjax(eleGameService.insertEleGame(eleGame));
    }

    /**
     * 修改游戏列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:edit')")
    @Log(title = "游戏列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EleGame eleGame)
    {
        return toAjax(eleGameService.updateEleGame(eleGame));
    }

    /**
     * 删除游戏列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:eleGame:remove')")
    @Log(title = "游戏列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eleGameService.deleteEleGameByIds(ids));
    }
}
