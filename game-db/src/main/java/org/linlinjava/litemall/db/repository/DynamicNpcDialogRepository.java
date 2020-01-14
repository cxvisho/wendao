package org.linlinjava.litemall.db.repository;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.linlinjava.litemall.db.task.DynamicNpcDialogRecordVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DynamicNpcDialogRepository implements JsonBasedRepository {
    private static final Logger logger = LoggerFactory.getLogger(DynamicNpcDialogRepository.class);

    /**
     * key是(mapId, npcId)
     */
    private Map<Pair<Integer, Integer>, List<DynamicNpcDialogRecordVO>> dialogMap = Maps.newHashMap();

    public void loadConfigFromJsonString(String json) {
        dialogMap.clear();
        List<DynamicNpcDialogRecordVO> dynamicNpcDialogRecordVOList = JSON.parseArray(json, DynamicNpcDialogRecordVO.class);
        for (DynamicNpcDialogRecordVO vo : dynamicNpcDialogRecordVOList) {
            Pair<Integer, Integer> key = Pair.of(vo.getMapId(), vo.getMapId());
            List<DynamicNpcDialogRecordVO> value = dialogMap.getOrDefault(key, Lists.newArrayList());
            value.add(vo);
            dialogMap.put(key, value);
        }
    }

    public List<DynamicNpcDialogRecordVO> getDialogRecordList(int mapId, int npcId) {
        Pair<Integer, Integer> key = Pair.of(mapId, npcId);
        return dialogMap.getOrDefault(key, null);
    }
}
