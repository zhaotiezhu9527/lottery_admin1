package com.ruoyi.web.controller.lottery;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.api.RemoteLotteryService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.lottery.domain.LotteryOrder;
import com.ruoyi.lottery.service.ILotteryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 投注记录Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/lotteryOrder")
public class LotteryOrderController extends BaseController
{
    @Autowired
    private ILotteryOrderService lotteryOrderService;

    @Autowired
    private RemoteLotteryService remoteLotteryService;

    /**
     * 查询投注记录列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotteryOrder lotteryOrder)
    {
        startPage();
        List<LotteryOrder> list = lotteryOrderService.selectLotteryOrderList(lotteryOrder);
        return getDataTable(list);
    }

    /**
     * 导出投注记录列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:export')")
    @Log(title = "投注记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotteryOrder lotteryOrder)
    {
        startOrderBy();
        List<LotteryOrder> list = lotteryOrderService.selectLotteryOrderList(lotteryOrder);
        ExcelUtil<LotteryOrder> util = new ExcelUtil<LotteryOrder>(LotteryOrder.class);
        util.exportExcel(response, list, "投注记录数据");
    }

    /**
     * 获取投注记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lotteryOrderService.selectLotteryOrderById(id));
    }

    /**
     * 新增投注记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:add')")
    @Log(title = "投注记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotteryOrder lotteryOrder)
    {
        return toAjax(lotteryOrderService.insertLotteryOrder(lotteryOrder));
    }

    /**
     * 修改投注记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:edit')")
    @Log(title = "投注记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotteryOrder lotteryOrder)
    {
        return toAjax(lotteryOrderService.updateLotteryOrder(lotteryOrder));
    }

    /**
     * 删除投注记录
     */
    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:remove')")
    @Log(title = "投注记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lotteryOrderService.deleteLotteryOrderByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('lottery:lotteryOrder:cancel')")
    @GetMapping(value = "/cancel/{orderNo}")
    public AjaxResult cancel(@PathVariable("orderNo") String orderNo)
    {
        String result = remoteLotteryService.orderCancel(orderNo);
        if (StringUtils.isNotBlank(result)) {
            JSONObject object = JSONObject.parseObject(result);
            int code = object.getIntValue("code");
            if (code == 0) {
                return success();
            }
            return error(object.getString("msg"));
        }
        return error();
    }
}
