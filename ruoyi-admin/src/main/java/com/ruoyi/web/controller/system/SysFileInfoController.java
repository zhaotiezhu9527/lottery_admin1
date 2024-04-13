package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysFileInfoService;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件信息Controller
 * 
 * @author hardy
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/system/sysFileInfo")
public class SysFileInfoController extends BaseController
{
    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @Autowired
    private FileStorageService fileStorageService;//注入实列

    /**
     * 上传文件
     */
    @PreAuthorize("@ss.hasPermi('system:info:upload')")
    @PostMapping("/upload")
    public AjaxResult uploadImage(MultipartFile file, HttpServletRequest httpServletRequest) {
        String pathType = httpServletRequest.getParameter("pathType");
        System.out.println(pathType);
        String path = "default/";
        // 头像
        if (StringUtils.equals(pathType, "1")) {
            path = "avatar/";
        } else if (StringUtils.equals(pathType, "2")) {
            path = "lottery/";
        }  else if (StringUtils.equals(pathType, "3")) {
            path = "banner/";
        }  else if (StringUtils.equals(pathType, "4")) {
            path = "activity/";
        }  else if (StringUtils.equals(pathType, "5")) {
            path = "platform/";
        }  else if (StringUtils.equals(pathType, "6")) {
            path = "platform/elegame/ag/";
        }  else if (StringUtils.equals(pathType, "7")) {
            path = "platform/elegame/bbin/";
        }  else if (StringUtils.equals(pathType, "8")) {
            path = "platform/elegame/ky/";
        }  else if (StringUtils.equals(pathType, "9")) {
            path = "platform/elegame/ly/";
        }
        FileInfo fileInfo = fileStorageService.of(file).setPath(path)
                .upload();  //将文件上传到对应地方

        String url = "/" + fileInfo.getBasePath() + fileInfo.getPath() + fileInfo.getFilename();
        return AjaxResult.success("操作成功", url);
    }
}
