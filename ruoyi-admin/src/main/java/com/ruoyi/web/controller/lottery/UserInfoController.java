package com.ruoyi.web.controller.lottery;

import cn.hutool.core.util.ReUtil;
import cn.hutool.crypto.SecureUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.lottery.business.OptMoneyBusiness;
import com.ruoyi.lottery.domain.UserInfo;
import com.ruoyi.lottery.pojo.OptUserMoneyDto;
import com.ruoyi.lottery.service.IUserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 会员列表Controller
 * 
 * @author hardy
 * @date 2024-04-11
 */
@RestController
@RequestMapping("/lottery/userInfo")
public class UserInfoController extends BaseController
{
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private OptMoneyBusiness optMoneyBusiness;

    /**
     * 查询会员列表列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员列表列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userInfo:export')")
    @Log(title = "会员列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        util.exportExcel(response, list, "会员列表数据");
    }

    /**
     * 获取会员列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('lottery:userInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userInfoService.selectUserInfoById(id));
    }

    /**
     * 新增会员列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userInfo:add')")
    @Log(title = "会员列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改会员列表
     */
    @PreAuthorize("@ss.hasPermi('lottery:userInfo:edit')")
    @Log(title = "会员列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserInfo userInfo)
    {
        if (StringUtils.isNotBlank(userInfo.getLoginPwd())) {
            boolean matchLoginPwd = ReUtil.isMatch("^[a-zA-Z0-9]{6,12}$", userInfo.getLoginPwd());
            if (!matchLoginPwd) {
                return AjaxResult.error("请输入6-12位登录密码");
            }
            userInfo.setLoginPwd(SecureUtil.md5(userInfo.getLoginPwd()));
        }

        if (StringUtils.isNotBlank(userInfo.getPayPwd())) {
            boolean matchPayPwd = ReUtil.isMatch("^\\d{6}$", userInfo.getPayPwd());
            if (!matchPayPwd) {
                return AjaxResult.error("请输入6位支付密码");
            }
            userInfo.setPayPwd(SecureUtil.md5(userInfo.getPayPwd()));
        }
        userInfo.setBalance(null);

        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    @PreAuthorize("@ss.hasPermi('lottery:userInfo:optMoney')")
    @Log(title = "【用户上下分】", businessType = BusinessType.UPDATE)
    @PostMapping("/optMoney")
    public AjaxResult optMoney(@RequestBody OptUserMoneyDto request) throws Exception {
        UserInfo user = userInfoService.getUserByName(request.getUserName());
        if (user == null) {
            return AjaxResult.error("用户不存在.");
        }
        BigDecimal money = new BigDecimal(request.getMoney());
        if (money.doubleValue() <= 0) {
            return AjaxResult.error("请正确输入金额.");
        }

        if (StringUtils.equals("1", request.getType())) {
            // 上分
            optMoneyBusiness.addMoney(user, request);
            return toAjax(true);
        } else if (StringUtils.equals("2", request.getType())) {
            // 下分
            if (money.doubleValue() > user.getBalance().doubleValue()) {
                return AjaxResult.error("用户账户余额为:" + user.getBalance() + "元");
            }
            optMoneyBusiness.subMoney(user, request);
            return toAjax(true);
        }
        return toAjax(false);
    }


    /**
     * 删除会员列表
     */
//    @PreAuthorize("@ss.hasPermi('lottery:userInfo:remove')")
//    @Log(title = "会员列表", businessType = BusinessType.DELETE)
//	@DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Long[] ids)
//    {
//        return toAjax(userInfoService.deleteUserInfoByIds(ids));
//    }
}
