package org.linlinjava.litemall.gameserver.process;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20568_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49189_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61593_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M4121_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.linlinjava.litemall.gameserver.game.GameTeam;

@org.springframework.stereotype.Service
public class C26_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(io.netty.channel.ChannelHandlerContext ctx, io.netty.buffer.ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        GameTeam gameTeam = GameObjectChar.getGameObjectChar().gameTeam;


        if (chara.id == ((Chara) gameTeam.duiwu.get(0)).id) {
            for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                List<Vo_4119_0> object1 = new ArrayList();
                GameObjectCharMng.getGameObjectChar(((Vo_4121_0) gameTeam.zhanliduiyuan.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M4119_0(), object1);
                List<Vo_4121_0> vo_4121_0List = new ArrayList();
                GameObjectCharMng.getGameObjectChar(((Vo_4121_0) gameTeam.zhanliduiyuan.get(i)).id).sendOne(new M4121_0(), vo_4121_0List);
                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = "队伍解散了。";
                vo_20480_0.time = 1562593376;
                GameObjectCharMng.getGameObjectChar(((Vo_4121_0) gameTeam.zhanliduiyuan.get(i)).id).sendOne(new M20480_0(), vo_20480_0);
                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = ((Vo_4121_0) gameTeam.zhanliduiyuan.get(i)).id;
                vo_61671_0.count = 0;
                GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);
            }

            for (int i = 0; i < GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.size() - 1; i++) {
                GameObjectCharMng.getGameObjectChar(((Vo_4121_0) GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan.get(i + 1)).id).gameTeam = null;
            }
            GameObjectChar.getGameObjectChar().gameTeam = null;
            Vo_61593_0 vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_join";
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M61593_0(), vo_61593_0);


            vo_61593_0 = new Vo_61593_0();
            vo_61593_0.ask_type = "request_team_leader";
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M61593_0(), vo_61593_0);
            List<Vo_4121_0> vo_4121_0List = new ArrayList();
            GameObjectChar.send(new M4121_0(), vo_4121_0List);
            GameObjectChar.getGameObjectChar().gameTeam = null;
        } else {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = chara.id;
            vo_61671_0.count = 0;
            GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);
            List<Vo_4119_0> object1 = new ArrayList();
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M4119_0(), object1);
            List<Vo_4121_0> vo_4121_0List = new ArrayList();
            GameObjectChar.send(new M4121_0(), vo_4121_0List);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = "你离开了队伍";
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0 vo_61661_0 = GameUtil.a61661((Chara) gameTeam.duiwu.get(i));
                GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M61661_0(), vo_61661_0);
            }

            Vo_49189_0 vo_49189_0 = new Vo_49189_0();
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M49189_0(), vo_49189_0);
            for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                if (((Chara) gameTeam.duiwu.get(i)).id == chara.id) {
                    gameTeam.duiwu.remove(i);
                }
            }
            for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                if (((Vo_4121_0) gameTeam.zhanliduiyuan.get(i)).id == chara.id) {
                    gameTeam.zhanliduiyuan.remove(i);
                }
            }
            List<Chara> duiwu = GameObjectChar.getGameObjectChar().gameTeam.duiwu;
            GameUtil.a4119(duiwu);
            GameUtil.a4121(GameObjectChar.getGameObjectChar().gameTeam.zhanliduiyuan);

            Vo_20568_0 vo_20568_0 = new Vo_20568_0();
            vo_20568_0.gid = "";
            GameObjectCharMng.getGameObjectChar(((Chara) gameTeam.duiwu.get(0)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M20568_0(), vo_20568_0);

            for (int i = 0; i < duiwu.size(); i++) {
                vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = (chara.name + "离开了队伍");
                vo_20480_0.time = 1562593376;
                GameObjectCharMng.getGameObjectChar(((Chara) duiwu.get(i)).id).sendOne(new M20480_0(), vo_20480_0);


                org.linlinjava.litemall.gameserver.data.vo.Vo_45124_0 vo_45124_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_45124_0();
                GameObjectCharMng.getGameObjectChar(((Chara) duiwu.get(i)).id).sendOne(new org.linlinjava.litemall.gameserver.data.write.M45124_0(), vo_45124_0);
            }
        }
        GameObjectChar.getGameObjectChar().gameTeam = null;
    }


    public int cmd() {
        return 26;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C26_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */