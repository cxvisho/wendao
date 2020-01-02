package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.data.write.M65529_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C4248 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int id = GameReadTool.readInt(buff);
        int x = GameReadTool.readShort(buff);
        int y = GameReadTool.readShort(buff);
        int taskwalk = GameReadTool.readShort(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        Characters characters = GameData.that.characterService.findOneByID(id);
        String data = characters.getData();
        Chara chara1 = (Chara) JSONUtils.parseObject(data, Chara.class);
        chara1.x = chara.x;
        chara1.y = chara.y;
        chara1.mapid = chara.mapid;
        chara1.mapName = chara.mapName;

        org.linlinjava.litemall.gameserver.game.GameLine.getGameMap(chara.line, chara.mapName).joinduiyuan(org.linlinjava.litemall.gameserver.game.GameObjectCharMng.getGameObjectChar(chara1.id), chara);

        for (int i = 0; i < chara.npcchubao.size(); i++) {
            if (chara1.mapid == ((Vo_65529_0) chara.npcchubao.get(i)).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcchubao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcshuadao.size(); i++) {
            if (chara1.mapid == ((Vo_65529_0) chara.npcshuadao.get(i)).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcshuadao.get(i), chara.id);
            }
        }


        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara1.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(5));
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(3));
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
    }

    public Vo_65505_0 a65505(Chara chara) {
        Vo_65505_0 vo_65505_1 = new Vo_65505_0();
        vo_65505_1.map_id = chara.mapid;
        vo_65505_1.map_name = GameData.that.baseMapService.findOneByMapId(Integer.valueOf(chara.mapid)).getName();
        vo_65505_1.map_show_name = vo_65505_1.map_name;
        vo_65505_1.x = chara.x;
        vo_65505_1.y = chara.y;
        vo_65505_1.map_index = 50331648;
        vo_65505_1.compact_map_index = 49408;
        vo_65505_1.floor_index = 0;
        vo_65505_1.wall_index = 0;
        vo_65505_1.is_safe_zone = 0;
        vo_65505_1.is_task_walk = 0;
        vo_65505_1.enter_effect_index = 0;
        return vo_65505_1;
    }

    public int cmd() {
        return 4248;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4248.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */