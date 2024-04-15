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
import com.ruoyi.lottery.domain.OpenresultFc3d;
import com.ruoyi.lottery.service.IOpenresultFc3dService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开奖结果(福彩3D)Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/openresultFc3d")
public class OpenresultFc3dController extends BaseController
{
    @Autowired
    private IOpenresultFc3dService openresultFc3dService;

    /**
     * 查询开奖结果(福彩3D)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:list')")
    @GetMapping("/list")
    public TableDataInfo list(OpenresultFc3d openresultFc3d)
    {
        startPage();
        List<OpenresultFc3d> list = openresultFc3dService.selectOpenresultFc3dList(openresultFc3d);
        return getDataTable(list);
    }

    /**
     * 导出开奖结果(福彩3D)列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:export')")
    @Log(title = "开奖结果(福彩3D)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OpenresultFc3d openresultFc3d)
    {
        startOrderBy();
        List<OpenresultFc3d> list = openresultFc3dService.selectOpenresultFc3dList(openresultFc3d);
        ExcelUtil<OpenresultFc3d> util = new ExcelUtil<OpenresultFc3d>(OpenresultFc3d.class);
        util.exportExcel(response, list, "开奖结果(福彩3D)数据");
    }

    /**
     * 获取开奖结果(福彩3D)详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(openresultFc3dService.selectOpenresultFc3dById(id));
    }

    /**
     * 新增开奖结果(福彩3D)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:add')")
    @Log(title = "开奖结果(福彩3D)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OpenresultFc3d openresultFc3d)
    {
        return toAjax(openresultFc3dService.insertOpenresultFc3d(openresultFc3d));
    }

    /**
     * 修改开奖结果(福彩3D)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:edit')")
    @Log(title = "开奖结果(福彩3D)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OpenresultFc3d openresultFc3d)
    {
        return toAjax(openresultFc3dService.updateOpenresultFc3d(openresultFc3d));
    }

    /**
     * 删除开奖结果(福彩3D)
     */
    @PreAuthorize("@ss.hasPermi('lottery:openresultFc3d:remove')")
    @Log(title = "开奖结果(福彩3D)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(openresultFc3dService.deleteOpenresultFc3dByIds(ids));
    }
}
