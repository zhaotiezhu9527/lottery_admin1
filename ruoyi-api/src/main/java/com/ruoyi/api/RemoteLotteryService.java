package com.ruoyi.api;

import com.ruoyi.api.factory.RemoteLotteryFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(contextId = "remoteLotteryService", value = "innerapi", fallbackFactory = RemoteLotteryFallbackFactory.class)
public interface RemoteLotteryService
{
    /**
     * 注单取消
     * @return
     */
    @GetMapping(value = "/lottery/cancel/{orderNo}")
    String orderCancel(@PathVariable("orderNo") String orderNo);

}