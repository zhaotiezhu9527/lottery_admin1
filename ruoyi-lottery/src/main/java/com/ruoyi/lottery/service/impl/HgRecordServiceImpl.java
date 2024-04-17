package com.ruoyi.lottery.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lottery.mapper.HgRecordMapper;
import com.ruoyi.lottery.domain.HgRecord;
import com.ruoyi.lottery.service.IHgRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 皇冠体育注单Service业务层处理
 * 
 * @author hardy
 * @date 2024-04-11
 */
@Service
public class HgRecordServiceImpl extends ServiceImpl<HgRecordMapper, HgRecord> implements IHgRecordService
{
    @Autowired
    private HgRecordMapper hgRecordMapper;

    /**
     * 查询皇冠体育注单
     * 
     * @param id 皇冠体育注单主键
     * @return 皇冠体育注单
     */
    @Override
    public HgRecord selectHgRecordById(Long id)
    {
        return hgRecordMapper.selectHgRecordById(id);
    }

    /**
     * 查询皇冠体育注单列表
     * 
     * @param hgRecord 皇冠体育注单
     * @return 皇冠体育注单
     */
    @Override
    public List<HgRecord> selectHgRecordList(HgRecord hgRecord)
    {
        List<HgRecord> list = hgRecordMapper.selectHgRecordList(hgRecord);
        if(CollUtil.isNotEmpty(list)){
            for (HgRecord record: list) {
                if(record.getParlaynum() != null){
                    JSONObject parlaySub = JSONObject.parse(record.getParlaysub());
                    List<JSONObject> sportDetailList = new ArrayList<>();
                    for(int i = 1; i <= record.getParlaynum(); i++){
                        String key = i + "";
                        JSONObject sub = parlaySub.getJSONObject(key);
//                        JSONObject recordSport = new JSONObject();
//                        recordSport.put("wf",sub.getString("wtype"));
//                        recordSport.put("odds",sub.getBigDecimal("ioratio"));
//                        recordSport.put("tnameHome",sub.getString("tname_home"));
//                        recordSport.put("tnameAway",sub.getString("tname_away"));
//                        recordSport.put("resultScore",sub.getString("score"));
//                        recordSport.put("league",sub.getString("league"));
//                        recordSport.put("gameName",GAME_NAME.getOrDefault(sub.getString("wtype"), sub.getString("wtype")));
//                        recordSport.put("oddsFormat",sub.getString("oddsFormat"));
//                        String rtype = sub.getString("rtype");
//                        recordSport.put("openResult",rtype.split("-")[1]);
//                        recordSport.put("orderContent",sub.getString("order"));
                        sportDetailList.add(sub);
                    }
                    record.setParlaysubArr(sportDetailList);
                }
            }
        }
        return list;
    }

    public static final Map<String, String> GAME_NAME = new HashMap<>();
    static {
        GAME_NAME.put("FT", "足球");
        GAME_NAME.put("BK", "篮球");
        GAME_NAME.put("TB", "网球");
        GAME_NAME.put("BS", "棒球");
        GAME_NAME.put("OP", "其他");
        GAME_NAME.put("VF", "虚拟足球");
        GAME_NAME.put("SK", "台球");
        GAME_NAME.put("MT", "跨球类过关");
    }

    /**
     * 新增皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    @Override
    public int insertHgRecord(HgRecord hgRecord)
    {
        hgRecord.setCreateTime(DateUtils.getNowDate());
        return hgRecordMapper.insertHgRecord(hgRecord);
    }

    /**
     * 修改皇冠体育注单
     * 
     * @param hgRecord 皇冠体育注单
     * @return 结果
     */
    @Override
    public int updateHgRecord(HgRecord hgRecord)
    {
        hgRecord.setUpdateTime(DateUtils.getNowDate());
        return hgRecordMapper.updateHgRecord(hgRecord);
    }

    /**
     * 批量删除皇冠体育注单
     * 
     * @param ids 需要删除的皇冠体育注单主键
     * @return 结果
     */
    @Override
    public int deleteHgRecordByIds(Long[] ids)
    {
        return hgRecordMapper.deleteHgRecordByIds(ids);
    }

    /**
     * 删除皇冠体育注单信息
     * 
     * @param id 皇冠体育注单主键
     * @return 结果
     */
    @Override
    public int deleteHgRecordById(Long id)
    {
        return hgRecordMapper.deleteHgRecordById(id);
    }
}
