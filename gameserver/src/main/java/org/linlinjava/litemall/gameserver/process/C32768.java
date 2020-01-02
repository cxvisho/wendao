package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.db.domain.Renwu;
import org.linlinjava.litemall.db.service.base.BaseRenwuService;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M61553_0;
import org.linlinjava.litemall.gameserver.data.write.M65529_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameShuaGuai;

@org.springframework.stereotype.Service
public class C32768 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(io.netty.channel.ChannelHandlerContext ctx, ByteBuf buff) {
        int mapid = GameReadTool.readInt(buff);
        int x = GameReadTool.readInt(buff);
        int y = GameReadTool.readInt(buff);
        int taskwalk = GameReadTool.readByte(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        chara.x = x;
        chara.y = y;
        String[] shidaolevel = {"试道场(60-79)", "试道场(80-89)", "试道场(90-99)", "试道场(100-109)", "试道场(110-119)", "试道场(120-129)"};
        if (chara.mapid == 38004) {
            chara.shidaocishu = 0;
            chara.shidaodaguaijifen = 0;
        }
        if (mapid == 38004) {
            return;
        }
        GameLine.getGameMap(chara.line, mapid).join(GameObjectChar.getGameObjectChar());


        for (int i = 0; i < GameLine.gameShuaGuai.shuaXing.size(); i++) {
            if (((Vo_65529_0) GameLine.gameShuaGuai.shuaXing.get(i)).mapid == mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), GameLine.gameShuaGuai.shuaXing.get(i), chara.id);
            }
        }


        for (int i = 0; i < chara.npcchubao.size(); i++) {
            if (mapid == ((Vo_65529_0) chara.npcchubao.get(i)).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcchubao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcshuadao.size(); i++) {
            if (mapid == ((Vo_65529_0) chara.npcshuadao.get(i)).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcshuadao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcxuanshang.size(); i++) {
            if (mapid == ((Vo_65529_0) chara.npcxuanshang.get(i)).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcxuanshang.get(i), chara.id);
            }
        }


        if ((chara.current_task.equals("主线—浮生若梦_s19")) && (mapid == 5000)) {
            GameUtil.renwujiangli(chara);
            chara.current_task = GameUtil.nextrenw(chara.current_task);
            Renwu tasks = GameData.that.baseRenwuService.findOneByCurrentTask(chara.current_task);


            org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0 vo_61553_0 = GameUtil.a61553(tasks, chara);
            GameObjectChar.send(new M61553_0(), vo_61553_0);
        }
        if ((chara.current_task.equals("主线—浮生若梦_s21")) && ((mapid == 10000) || (mapid == 14000) || (mapid == 15000) || (mapid == 13000) || (mapid == 16000))) {
            GameUtil.renwujiangli(chara);
            chara.current_task = GameUtil.nextrenw(chara.current_task);
            Renwu tasks = GameData.that.baseRenwuService.findOneByCurrentTask(chara.current_task);


            org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0 vo_61553_0 = GameUtil.a61553(tasks, chara);
            GameObjectChar.send(new M61553_0(), vo_61553_0);
        }


        org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M61661_0(), vo_61661_0);
        if ((GameObjectChar.getGameObjectChar().gameTeam != null) && (GameObjectChar.getGameObjectChar().gameTeam.duiwu.size() > 0) &&
                (((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0)).id == chara.id)) {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(Integer.valueOf(2));
            vo_61671_0.list.add(Integer.valueOf(3));
            GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);
        }


        GameUtil.genchongfei(chara);
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
        return 32768;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C32768.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */