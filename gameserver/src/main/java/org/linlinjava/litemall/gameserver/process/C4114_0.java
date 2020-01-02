package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;

@Service
public class C4114_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int victim_id = GameReadTool.readInt(buff);

        int flag = GameReadTool.readShort(buff);

        String gid = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Characters characters = GameData.that.characterService.finOnByGiD(gid);
        Chara chara1 = (Chara) JSONUtils.parseObject(characters.getData(), Chara.class);

        if ((GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam != null) && (GameObjectChar.getGameObjectChar().gameTeam != null) && (GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu != null) && (GameObjectChar.getGameObjectChar().gameTeam.duiwu != null) &&
                (((Chara) GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam.duiwu.get(0)).id == ((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0)).id)) {
            return;
        }


        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你进入切磋战斗中！";
        vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
        GameObjectChar.getGameObjectChar();
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20481_0(), vo_20481_0);


        org.linlinjava.litemall.gameserver.fight.FightManager.goFight(chara, chara1);
    }

    public int cmd() {
        return 4114;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4114_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */