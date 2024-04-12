package com.ruoyi.lottery.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.SysParamMapper;
import com.ruoyi.lottery.domain.SysParam;
import com.ruoyi.lottery.service.ISysParamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 系统参数Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParam> implements ISysParamService
{
    @Autowired
    private SysParamMapper sysParamMapper;

    /**
     * 查询系统参数
     * 
     * @param id 系统参数主键
     * @return 系统参数
     */
    @Override
    public SysParam selectSysParamById(Long id)
    {
        return sysParamMapper.selectSysParamById(id);
    }

    /**
     * 查询系统参数列表
     * 
     * @param sysParam 系统参数
     * @return 系统参数
     */
    @Override
    public List<SysParam> selectSysParamList(SysParam sysParam)
    {
        return sysParamMapper.selectSysParamList(sysParam);
    }

    /**
     * 新增系统参数
     * 
     * @param sysParam 系统参数
     * @return 结果
     */
    @Override
    public int insertSysParam(SysParam sysParam)
    {
        sysParam.setCreateTime(DateUtils.getNowDate());
        return sysParamMapper.insertSysParam(sysParam);
    }

    /**
     * 修改系统参数
     * 
     * @param sysParam 系统参数
     * @return 结果
     */
    @Override
    @CacheEvict(value = CacheConstants.SYS_PARAM)
    public int updateSysParam(SysParam sysParam)
    {
        sysParam.setUpdateTime(DateUtils.getNowDate());
        return sysParamMapper.updateSysParam(sysParam);
    }

    /**
     * 批量删除系统参数
     * 
     * @param ids 需要删除的系统参数主键
     * @return 结果
     */
    @Override
    @CacheEvict(value = CacheConstants.SYS_PARAM)
    public int deleteSysParamByIds(Long[] ids)
    {
        return sysParamMapper.deleteSysParamByIds(ids);
    }

    /**
     * 删除系统参数信息
     * 
     * @param id 系统参数主键
     * @return 结果
     */
    @Override
    public int deleteSysParamById(Long id)
    {
        return sysParamMapper.deleteSysParamById(id);
    }

    @Override
    public String getParamByKey(String key) {
        LambdaQueryWrapper<SysParam> wr = new LambdaQueryWrapper<>();
        wr.eq(SysParam::getParamKey, key);
        SysParam param = sysParamMapper.selectOne(wr);
        return param == null ? null : param.getParamValue();
    }
}
