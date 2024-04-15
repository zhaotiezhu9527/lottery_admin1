package com.ruoyi.web.controller.lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
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
import com.ruoyi.lottery.domain.SysParam;
import com.ruoyi.lottery.service.ISysParamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统参数Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/sysParam")
public class SysParamController extends BaseController
{
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 查询系统参数列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysParam sysParam)
    {
        startPage();
        List<SysParam> list = sysParamService.selectSysParamList(sysParam);
        return getDataTable(list);
    }

    /**
     * 所有参数
     * @return
     */
    @Anonymous
    @GetMapping("/all")
    public AjaxResult all()
    {
        Map<String, String> allParamByMap = sysParamService.getAllParamByMap();
        Map<String, String> param = new HashMap<>();
        param.put("resourceDomain", allParamByMap.get("resource_domain"));
        return AjaxResult.success("操作成功!", param);
    }

    /**
     * 导出系统参数列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:export')")
    @Log(title = "系统参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysParam sysParam)
    {
        startOrderBy();
        List<SysParam> list = sysParamService.selectSysParamList(sysParam);
        ExcelUtil<SysParam> util = new ExcelUtil<SysParam>(SysParam.class);
        util.exportExcel(response, list, "系统参数数据");
    }

    /**
     * 获取系统参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysParamService.selectSysParamById(id));
    }

    /**
     * 新增系统参数
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:add')")
    @Log(title = "系统参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysParam sysParam)
    {
        sysParam.setOperName(getUsername());
        return toAjax(sysParamService.insertSysParam(sysParam));
    }

    /**
     * 修改系统参数
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:edit')")
    @Log(title = "系统参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysParam sysParam)
    {
        sysParam.setOperName(getUsername());
        return toAjax(sysParamService.updateSysParam(sysParam));
    }

    /**
     * 删除系统参数
     */
    @PreAuthorize("@ss.hasPermi('lottery:sysParam:remove')")
    @Log(title = "系统参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysParamService.deleteSysParamByIds(ids));
    }
}
