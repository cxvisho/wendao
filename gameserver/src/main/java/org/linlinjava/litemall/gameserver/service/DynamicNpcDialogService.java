package org.linlinjava.litemall.gameserver.service;

import com.google.common.collect.Maps;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.repository.DynamicNpcDialogRepository;
import org.linlinjava.litemall.db.service.base.BaseNpcService;
import org.linlinjava.litemall.db.task.DynamicNpcDialogOptionVO;
import org.linlinjava.litemall.db.task.DynamicNpcDialogRecordVO;
import org.linlinjava.litemall.gameserver.data.vo.MSG_MENU_LIST_VO;
import org.linlinjava.litemall.gameserver.data.write.MSG_MENU_LIST;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
public class DynamicNpcDialogService {
    @Autowired
    private BaseNpcService npcService;

    @Autowired
    private MSG_MENU_LIST msg_menu_list;

    @Autowired
    private DynamicNpcDialogRepository dynamicNpcDialogRepository;

    private Map<String, BiFunction<GameObjectChar, String, Boolean>> checkRuleMap = Maps.newHashMap();

    @PostConstruct
    private void init() {

    }

    /**
     * 判断角色当前是不是符合npc说话的条件
     * @param gameObjectChar 玩家对象
     * @param checkType 校验的类型
     * @param checkPara 校验过程的参数
     * @return 如果符合返回true，否则返回false
     */
    private boolean checkRule(GameObjectChar gameObjectChar, String checkType, String checkPara) {
        BiFunction<GameObjectChar, String, Boolean> booleanBiFunction = checkRuleMap.getOrDefault(checkType, null);
        if (booleanBiFunction == null) {
            return false;
        }
        return booleanBiFunction.apply(gameObjectChar, checkPara);
    }

    private List<DynamicNpcDialogOptionVO> getDynamicNpcDialogOptionList(GameObjectChar gameObjectChar, int mapId, int npcId) {
        List<DynamicNpcDialogRecordVO> dynamicNpcDialogRecordVOList = dynamicNpcDialogRepository.getDialogRecordList(mapId, npcId);
        if (CollectionUtils.isEmpty(dynamicNpcDialogRecordVOList)) {
            return null;
        }
        for (DynamicNpcDialogRecordVO vo : dynamicNpcDialogRecordVOList) {
            if (checkRule(gameObjectChar, vo.getCheckType(), vo.getCheckPara())) {
                return vo.getOptions();
            }
        }
        return null;
    }

    private String getDynamicNpcContent(GameObjectChar gameObjectChar, int mapId, int npcId) {
        List<DynamicNpcDialogOptionVO> dynamicNpcDialogOptionVOList = getDynamicNpcDialogOptionList(gameObjectChar, mapId, npcId);
        if (CollectionUtils.isEmpty(dynamicNpcDialogOptionVOList)) {
            return null;
        }
        return dynamicNpcDialogOptionVOList
                .stream()
                .map(vo -> String.format("[%s/%s]", vo.getContent(), vo.getCommand()))
                .collect(Collectors.joining());
    }

    public MSG_MENU_LIST_VO getNpcDialogContent(GameObjectChar gameObjectChar, int mapId, int npcId) {
        Npc npc = npcService.findById(npcId);

        if (npc == null) {
            return null;
        }

        String content = getDynamicNpcContent(gameObjectChar, mapId, npcId);
        if (content == null) {
            return null;
        }

        MSG_MENU_LIST_VO menu_list_vo = new MSG_MENU_LIST_VO();
        menu_list_vo.id = npc.getId();
        menu_list_vo.portrait = npc.getIcon();
        menu_list_vo.pic_no = 1;
        menu_list_vo.content = content;
        menu_list_vo.secret_key = "";
        menu_list_vo.name = npc.getName();
        menu_list_vo.attrib = 0;

        return menu_list_vo;
    }

    /**
     * 弹出 NPC 操作对话框
     * @param npc Npc
     * @param content 对话内容
     */
    public static void sendNpcDlg(Npc npc, String content){
        MSG_MENU_LIST_VO menu_list_vo = new MSG_MENU_LIST_VO();
        menu_list_vo.id = npc.getId();
        menu_list_vo.portrait = npc.getIcon();
        menu_list_vo.pic_no = 1;
        menu_list_vo.content = content;
        menu_list_vo.secret_key = "";
        menu_list_vo.name = npc.getName();
        menu_list_vo.attrib = 0;
        GameObjectChar.send(new MSG_MENU_LIST(), menu_list_vo);
    }
}
