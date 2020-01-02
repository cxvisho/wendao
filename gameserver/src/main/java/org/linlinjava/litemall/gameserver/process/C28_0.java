package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;
import org.springframework.stereotype.Service;

@Service
public class C28_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        GameObjectChar.getGameObjectChar().gameTeam = GameObjectCharMng.getGameObjectChar(((Chara) gameTeam.duiwu.get(0)).id).gameTeam;

        GameObjectChar session1 = GameObjectCharMng.getGameObjectChar(((Chara) gameTeam.duiwu.get(0)).id);

        GameObjectChar.getGameObjectChar().gameTeam.duiwu.add(chara);
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id);
            session.gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
        }

        GameObjectChar.getGameObjectChar().gameMap.joinduiyuan(GameObjectChar.getGameObjectChar(), session1.chara);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size(); i++) {
            GameObjectChar session = GameObjectCharMng.getGameObjectChar(((Vo_4121_0) GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i)).id);
            for (int j = 0; j < session.gameTeam.zhanliduiyuan.size(); j++) {
                if (((Vo_4121_0) session.gameTeam.zhanliduiyuan.get(j)).id == chara.id) {
                    ((Vo_4121_0) session.gameTeam.zhanliduiyuan.get(j)).memberteam_status = 1;
                }
            }
        }
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61661_0 vo_61661_0 = GameUtil.a61661((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new M61661_0(), vo_61661_0);
            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = (chara.name + "回到队伍中");
            vo_8165_0.active = 0;
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new M8165_0(), vo_8165_0);
        }

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = ((Chara) GameObjectCharMng.getGameObjectChar(((Chara) gameTeam.duiwu.get(0)).id).gameTeam.duiwu.get(0)).id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(3));
        session1.gameMap.send(new M61671_0(), vo_61671_0);

        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(5));
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = (chara.name + "回到了队伍。");
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);
        vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = (chara.name + "你回到了#Y#<" + session1.chara.name + "#>#n的队伍。");
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);

        GameUtil.a4119(gameTeam.duiwu);
        GameUtil.a4121(gameTeam.zhanliduiyuan);


        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(5));
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);


        vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = ((Chara) GameObjectCharMng.getGameObjectChar(((Chara) gameTeam.duiwu.get(0)).id).gameTeam.duiwu.get(0)).id;
        vo_61671_0.count = 2;
        vo_61671_0.list.add(Integer.valueOf(2));
        vo_61671_0.list.add(Integer.valueOf(3));
        GameObjectChar.getGameObjectChar().gameMap.send(new M61671_0(), vo_61671_0);
    }


    public int cmd() {
        return 28;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C28_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */