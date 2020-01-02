package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16431_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40981_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M16431_0;
import org.linlinjava.litemall.gameserver.data.write.M40981_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.fight.FightMove;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameTeam;

@org.springframework.stereotype.Service
public class C61634_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int id = GameReadTool.readInt(buff);

        int map_id = GameReadTool.readInt(buff);

        int map_index = GameReadTool.readInt(buff);

        int count = GameReadTool.readShort(buff);

        int x = 0;
        int y = 0;
        for (int i = 0; i < count; i++) {
            x = GameReadTool.readShort(buff);

            y = GameReadTool.readShort(buff);
        }


        int dir = GameReadTool.readShort(buff);

        int send_time = GameReadTool.readInt(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if ((GameObjectChar.getGameObjectChar().gameTeam != null) && (GameObjectChar.getGameObjectChar().gameTeam.duiwu != null) && (GameObjectChar.getGameObjectChar().gameTeam.duiwu.size() > 0)) {
            for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
                Chara chara1 = (Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);
                chara1.x = x;
                chara1.y = y;
            }
        } else {
            GameObjectChar.getGameObjectChar().chara.x = x;
            GameObjectChar.getGameObjectChar().chara.y = y;
        }


        Vo_16431_0 vo_16431_0 = new Vo_16431_0();
        vo_16431_0.id = id;
        vo_16431_0.x = x;
        vo_16431_0.y = y;
        GameObjectChar.getGameObjectChar().gameMap.send(new M16431_0(), vo_16431_0);
        if ((chara.qumoxiang != 1) &&
                (FightMove.move(chara.id))) {
            org.linlinjava.litemall.gameserver.fight.FightManager.goFight(GameObjectChar.getGameObjectChar().chara, GameObjectChar.getGameObjectChar().chara.mapName);
            return;
        }


        if ((chara.changbaotu.mapid == chara.mapid) && (chara.changbaotu.x == chara.x) && (chara.changbaotu.y == y)) {
            Vo_40981_0 vo_40981_0 = new Vo_40981_0();
            vo_40981_0.start_time = ((int) (System.currentTimeMillis() / 1000L));
            vo_40981_0.end_time = ((int) (System.currentTimeMillis() / 1000L) + 3);
            vo_40981_0.icon = 258;
            vo_40981_0.word = "挖宝中…";
            vo_40981_0.gather_style = "default";
            GameObjectChar.getGameObjectChar();
            GameObjectChar.send(new M40981_0(), vo_40981_0);
            chara.changbaotu = new Vo_65529_0();
        }
    }


    public int cmd() {
        return 61634;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C61634_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */