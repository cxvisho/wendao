package org.linlinjava.litemall.gameserver.service;

import com.google.common.collect.Lists;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.service.base.BaseNpcService;
import org.linlinjava.litemall.gameserver.data.vo.MSG_MENU_LIST_VO;
import org.linlinjava.litemall.gameserver.data.write.MSG_MENU_LIST;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DynamicNpcDialogService {
    @Autowired
    private BaseNpcService npcService;

    @Autowired
    private MSG_MENU_LIST msg_menu_list;

    private List<DynamicNpcDialogOptionVO> getDynamicNpcDialogOptionList(GameObjectChar gameObjectChar, int npcId) {
        return Lists.newArrayList();
    }

    private String getDynamicNpcContent(GameObjectChar gameObjectChar, int npcId) {
        List<DynamicNpcDialogOptionVO> dynamicNpcDialogOptionVOList = getDynamicNpcDialogOptionList(gameObjectChar, npcId);
        return dynamicNpcDialogOptionVOList
                .stream()
                .map(vo -> String.format("[%s/%s]", vo.getContent(), vo.getCommand()))
                .collect(Collectors.joining());
    }

    public MSG_MENU_LIST_VO getDynamicNpcDialog(GameObjectChar gameObjectChar, int npcId) {
        Npc npc = npcService.findById(npcId);

        if (npc == null) return null;

        MSG_MENU_LIST_VO menu_list_vo = new MSG_MENU_LIST_VO();
        menu_list_vo.id = npc.getId();
        menu_list_vo.portrait = npc.getIcon();
        menu_list_vo.pic_no = 1;
        menu_list_vo.content = getDynamicNpcContent(gameObjectChar, npcId);
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
