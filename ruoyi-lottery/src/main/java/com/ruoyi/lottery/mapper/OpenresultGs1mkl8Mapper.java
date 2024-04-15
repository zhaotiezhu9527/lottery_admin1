package com.ruoyi.lottery.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.lottery.domain.OpenresultGs1mkl8;

/**
 * 1分快乐8Mapper接口
 * 
 * @author hardy
 * @date 2024-04-15
 */
public interface OpenresultGs1mkl8Mapper extends BaseMapper<OpenresultGs1mkl8>
{
    /**
     * 查询1分快乐8
     * 
     * @param id 1分快乐8主键
     * @return 1分快乐8
     */
    public OpenresultGs1mkl8 selectOpenresultGs1mkl8ById(Long id);

    /**
     * 查询1分快乐8列表
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 1分快乐8集合
     */
    public List<OpenresultGs1mkl8> selectOpenresultGs1mkl8List(OpenresultGs1mkl8 openresultGs1mkl8);

    /**
     * 新增1分快乐8
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 结果
     */
    public int insertOpenresultGs1mkl8(OpenresultGs1mkl8 openresultGs1mkl8);

    /**
     * 修改1分快乐8
     * 
     * @param openresultGs1mkl8 1分快乐8
     * @return 结果
     */
    public int updateOpenresultGs1mkl8(OpenresultGs1mkl8 openresultGs1mkl8);

    /**
     * 删除1分快乐8
     * 
     * @param id 1分快乐8主键
     * @return 结果
     */
    public int deleteOpenresultGs1mkl8ById(Long id);

    /**
     * 批量删除1分快乐8
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOpenresultGs1mkl8ByIds(Long[] ids);
}
