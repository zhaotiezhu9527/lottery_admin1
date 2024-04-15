package com.ruoyi.lottery.business;

import com.ruoyi.lottery.domain.UserInfo;
import com.ruoyi.lottery.pojo.OptUserMoneyDto;

public interface OptMoneyBusiness {

    void addMoney(UserInfo user, OptUserMoneyDto request);

    void subMoney(UserInfo user, OptUserMoneyDto request);
}
