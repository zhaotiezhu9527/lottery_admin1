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
import com.ruoyi.lottery.domain.PayChannel;
import com.ruoyi.lottery.service.IPayChannelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 渠道管理Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/payChannel")
public class PayChannelController extends BaseController
{
    @Autowired
    private IPayChannelService payChannelService;

    /**
     * 查询渠道管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayChannel payChannel)
    {
        startPage();
        List<PayChannel> list = payChannelService.selectPayChannelList(payChannel);
        return getDataTable(list);
    }

    /**
     * 导出渠道管理列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:export')")
    @Log(title = "渠道管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayChannel payChannel)
    {
        startOrderBy();
        List<PayChannel> list = payChannelService.selectPayChannelList(payChannel);
        ExcelUtil<PayChannel> util = new ExcelUtil<PayChannel>(PayChannel.class);
        util.exportExcel(response, list, "渠道管理数据");
    }

    /**
     * 获取渠道管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(payChannelService.selectPayChannelById(id));
    }

    /**
     * 新增渠道管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:add')")
    @Log(title = "渠道管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayChannel payChannel)
    {
        return toAjax(payChannelService.insertPayChannel(payChannel));
    }

    /**
     * 修改渠道管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:edit')")
    @Log(title = "渠道管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayChannel payChannel)
    {
        return toAjax(payChannelService.updatePayChannel(payChannel));
    }

    /**
     * 删除渠道管理
     */
    @PreAuthorize("@ss.hasPermi('lottery:payChannel:remove')")
    @Log(title = "渠道管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(payChannelService.deletePayChannelByIds(ids));
    }
}
