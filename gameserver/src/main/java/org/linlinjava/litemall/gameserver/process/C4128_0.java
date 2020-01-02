package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20568_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;

@org.springframework.stereotype.Service
public class C4128_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;
        GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);


        List<Chara> list = new java.util.LinkedList();
        list.addAll(GameObjectChar.getGameObjectChar().gameTeam.duiwu);


        Chara chararemove = null;
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            if (chara.id == ((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id) {
                chararemove = (Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);
            }
        }


        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).gameTeam.duiwu.remove(chararemove);
        }

        list.remove(chararemove);
        GameUtil.a4119(list);
        List<Vo_4119_0> object1 = new java.util.ArrayList();
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M4119_0(), object1);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size(); i++) {
            if (chara.id == ((Vo_4121_0) GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i)).id) {
                ((Vo_4121_0) GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i)).memberteam_status = 2;
            }
        }
        GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);


        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0 vo_61661_0 = GameUtil.a61661((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M61661_0(), vo_61661_0);
            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M20568_0(), vo_20568_0);
        }

        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = (chara.name + "暂离了队伍。");
        vo_20480_0.time = 1562593376;
        GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0)).id).sendOne(new M20480_0(), vo_20480_0);


        vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = ("你暂时离开了#Y#<" + ((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(0)).name + "#>#n的队伍。");
        vo_20480_0.time = 1562593376;
        GameObjectChar.send(new M20480_0(), vo_20480_0);
    }


    public int cmd() {
        return 4128;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4128_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */