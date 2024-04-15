package com.ruoyi.api.factory;

import com.ruoyi.api.RemoteLotteryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteLotteryFallbackFactory implements FallbackFactory<RemoteLotteryService>
{

    @Override
    public RemoteLotteryService create(Throwable throwable)
    {
        log.error("订单取消失败:{}", throwable.getMessage());
        return new RemoteLotteryService()
        {
            @Override
            public String orderCancel(String username)
            {

                return "订单取消失败:" + throwable.getMessage();
            }
        };
    }
}