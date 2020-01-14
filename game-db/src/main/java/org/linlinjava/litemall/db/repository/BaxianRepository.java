package org.linlinjava.litemall.db.repository;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.service.base.BaseMapService;
import org.linlinjava.litemall.db.service.base.BaseNpcService;
import org.linlinjava.litemall.db.task.TaskChain;
import org.linlinjava.litemall.db.task.TaskVO;
import org.linlinjava.litemall.db.util.JsonConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Repository(value = "baxian")
public class BaxianRepository implements JsonBasedRepository {
    private static final Logger logger = LoggerFactory.getLogger(BaxianRepository.class);

    private Map<Integer, TaskChain> taskChainMap = Maps.newHashMap();

    @Autowired
    private BaseMapService mapService;

    @Autowired
    private BaseNpcService npcService;

    public void loadConfigFromJsonString(String json) {
        taskChainMap.clear();
        List<TaskChain> taskChainList = JSON.parseArray(json, TaskChain.class);
        for (TaskChain taskChain : taskChainList) {
            for (TaskVO taskVO : taskChain.getTaskList()) {
                taskVO.setChainId(taskChain.getChainId());
                Integer npcId = taskVO.getNpcId();
                Npc npc = npcService.findById(npcId);
                if (npc != null) {
                    taskVO.setMapId(npc.getMapId());
                    taskVO.setNpcX(npc.getX());
                    taskVO.setNpcY(npc.getY());
                    List<org.linlinjava.litemall.db.domain.Map> mapList = mapService.findByMapId(npc.getMapId());
                    if (mapList.size() != 0) {
                        taskVO.setMapName(mapList.get(0).getName());
                    }
                }
            }
            taskChainMap.put(taskChain.getChainId(), taskChain);
        }

        logger.info(taskChainMap.toString());
    }

    @PostConstruct
    private void init() {
        String json = JsonConfigLoader.getJson("baxian");
        loadConfigFromJsonString(json);
    }

    public TaskVO getChainAndTaskIdByNpcId(int npcId) {
        for (Integer chainId : taskChainMap.keySet()) {
            TaskChain taskChain = taskChainMap.get(chainId);
            for (TaskVO taskVO : taskChain.getTaskList()) {
                if (taskVO.getNpcId().equals(npcId)) {
                    return taskVO;
                }
            }
        }
        return null;
    }

    public TaskVO getNextTask(Integer chainId, Integer taskId) {
        TaskChain taskChain = taskChainMap.getOrDefault(chainId, null);
        if (taskChain == null) return null;
        if (taskId == null) {
            return taskChain.getFirstTask();
        } else {
            return taskChain.getNextTask(taskId);
        }
    }

    public TaskVO getTask(Integer chainId, Integer taskId) {
        TaskChain taskChain = taskChainMap.getOrDefault(chainId, null);
        if (taskChain == null) return null;
        if (taskId != null) {
            return taskChain.getTask(taskId);
        }
        return null;
    }

    public List<Integer> getNpcList() {
        List<Integer> npcList = Lists.newArrayList();

        for (TaskChain taskChain : taskChainMap.values()) {
            for (TaskVO taskVO : taskChain.getTaskList()) {
                npcList.add(taskVO.getNpcId());
            }
        }

        return npcList;
    }
}
