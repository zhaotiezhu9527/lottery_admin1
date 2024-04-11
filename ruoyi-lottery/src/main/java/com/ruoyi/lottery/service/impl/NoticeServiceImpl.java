package com.ruoyi.lottery.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.NoticeMapper;
import com.ruoyi.lottery.domain.Notice;
import com.ruoyi.lottery.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 公告设置Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询公告设置
     * 
     * @param id 公告设置主键
     * @return 公告设置
     */
    @Override
    public Notice selectNoticeById(Long id)
    {
        return noticeMapper.selectNoticeById(id);
    }

    /**
     * 查询公告设置列表
     * 
     * @param notice 公告设置
     * @return 公告设置
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告设置
     * 
     * @param notice 公告设置
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        notice.setCreateTime(DateUtils.getNowDate());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告设置
     * 
     * @param notice 公告设置
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        notice.setUpdateTime(DateUtils.getNowDate());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 批量删除公告设置
     * 
     * @param ids 需要删除的公告设置主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] ids)
    {
        return noticeMapper.deleteNoticeByIds(ids);
    }

    /**
     * 删除公告设置信息
     * 
     * @param id 公告设置主键
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long id)
    {
        return noticeMapper.deleteNoticeById(id);
    }
}
