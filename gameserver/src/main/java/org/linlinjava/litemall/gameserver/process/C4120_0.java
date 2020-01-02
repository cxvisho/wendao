package org.linlinjava.litemall.gameserver.process;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20568_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45124_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49189_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;

@org.springframework.stereotype.Service
public class C4120_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(io.netty.channel.ChannelHandlerContext ctx, io.netty.buffer.ByteBuf buff) {
        String peer_name = org.linlinjava.litemall.gameserver.data.GameReadTool.readString(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        Chara chara1 = null;
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;
        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            if (((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).name.equals(peer_name)) {
                chara1 = (Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i);
            }
        }

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara1.id;
            vo_61671_0.count = 0;
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);
        }
        List<org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0> object1 = new ArrayList();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M4119_0(), object1);
        List<Vo_4121_0> vo_4121_0List = new ArrayList();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M4121_0(), vo_4121_0List);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "你被请离了队伍。";
        vo_20481_0.time = 1562987118;
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M20481_0(), vo_20481_0);

        for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.duiwu.size(); i++) {
            org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0 vo_61661_0 = GameUtil.a61661((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
            GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M61661_0(), vo_61661_0);
            vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = (peer_name + "离开了队伍。。");
            vo_20481_0.time = 1562987118;
            if (((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id != chara1.id) {
                GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).sendOne(new M20481_0(), vo_20481_0);
            } else {
                GameObjectCharMng.getGameObjectChar(((Chara) GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i)).id).gameTeam.duiwu.remove(GameObjectChar.getGameObjectChar().gameTeam.duiwu.get(i));
                GameObjectCharMng.getGameObjectChar(((Vo_4121_0) GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i)).id).gameTeam.zhanliduiyuan.remove(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i));
                GameObjectCharMng.getGameObjectChar(chara1.id).gameTeam = null;
            }
        }


        Vo_20568_0 vo_20568_0 = new Vo_20568_0();
        vo_20568_0.gid = "";
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20568_0(), vo_20568_0);
        GameUtil.a4119(GameObjectChar.getGameObjectChar().gameTeam.duiwu);
        GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);
        Vo_49189_0 vo_49189_0 = new Vo_49189_0();
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M49189_0(), vo_49189_0);

        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "你被请离了队伍";
        vo_8165_0.active = 0;
        GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M8165_0(), vo_8165_0);

        Vo_45124_0 vo_45124_0 = new Vo_45124_0();
        GameObjectChar.getGameObjectChar();
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M45124_0(), vo_45124_0);
    }

    public int cmd() {
        return 4120;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4120_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */