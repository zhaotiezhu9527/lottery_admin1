package com.ruoyi.lottery.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.lottery.domain.SysParam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统参数Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface ISysParamService extends IService<SysParam>
{
    /**
     * 查询系统参数
     * 
     * @param id 系统参数主键
     * @return 系统参数
     */
    public SysParam selectSysParamById(Long id);

    /**
     * 查询系统参数列表
     * 
     * @param sysParam 系统参数
     * @return 系统参数集合
     */
    public List<SysParam> selectSysParamList(SysParam sysParam);

    /**
     * 新增系统参数
     * 
     * @param sysParam 系统参数
     * @return 结果
     */
    public int insertSysParam(SysParam sysParam);

    /**
     * 修改系统参数
     * 
     * @param sysParam 系统参数
     * @return 结果
     */
    public int updateSysParam(SysParam sysParam);

    /**
     * 批量删除系统参数
     * 
     * @param ids 需要删除的系统参数主键集合
     * @return 结果
     */
    public int deleteSysParamByIds(Long[] ids);

    /**
     * 删除系统参数信息
     * 
     * @param id 系统参数主键
     * @return 结果
     */
    public int deleteSysParamById(Long id);

    public String getParamByKey(String key);

    Map<String, String> getAllParamByMap();
}
