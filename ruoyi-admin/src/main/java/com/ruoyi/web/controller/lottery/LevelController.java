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
import com.ruoyi.lottery.domain.Level;
import com.ruoyi.lottery.service.ILevelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 等级管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/level")
public class LevelController extends BaseController
{
    @Autowired
    private ILevelService levelService;

    /**
     * 查询等级管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:list')")
    @GetMapping("/list")
    public TableDataInfo list(Level level)
    {
        startPage();
        List<Level> list = levelService.selectLevelList(level);
        return getDataTable(list);
    }

    /**
     * 导出等级管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:export')")
    @Log(title = "等级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Level level)
    {
        List<Level> list = levelService.selectLevelList(level);
        ExcelUtil<Level> util = new ExcelUtil<Level>(Level.class);
        util.exportExcel(response, list, "等级管理数据");
    }

    /**
     * 获取等级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(levelService.selectLevelById(id));
    }

    /**
     * 新增等级管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:add')")
    @Log(title = "等级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Level level)
    {
        return toAjax(levelService.insertLevel(level));
    }

    /**
     * 修改等级管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:edit')")
    @Log(title = "等级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Level level)
    {
        return toAjax(levelService.updateLevel(level));
    }

    /**
     * 删除等级管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:level:remove')")
    @Log(title = "等级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(levelService.deleteLevelByIds(ids));
    }
}
