package com.ruoyi.lottery.service;

import java.util.List;
import com.ruoyi.lottery.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 公告设置Service接口
 * 
 * @author hardy
 * @date 2024-04-11
 */
public interface INoticeService extends IService<Notice>
{
    /**
     * 查询公告设置
     * 
     * @param id 公告设置主键
     * @return 公告设置
     */
    public Notice selectNoticeById(Long id);

    /**
     * 查询公告设置列表
     * 
     * @param notice 公告设置
     * @return 公告设置集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增公告设置
     * 
     * @param notice 公告设置
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改公告设置
     * 
     * @param notice 公告设置
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 批量删除公告设置
     * 
     * @param ids 需要删除的公告设置主键集合
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] ids);

    /**
     * 删除公告设置信息
     * 
     * @param id 公告设置主键
     * @return 结果
     */
    public int deleteNoticeById(Long id);
}
