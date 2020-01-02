package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.Random;

import org.linlinjava.litemall.db.domain.Experience;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32747_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41482_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M32747_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C41481_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int index = org.linlinjava.litemall.gameserver.data.GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        if (index == 0) {
            for (int w = 0; w < 8; w++) {
                index = w + 1;
                int time = ((Vo_41480_0) chara.shenmiliwu.get(w)).time;
                if ((chara.online_time / 1000L + (System.currentTimeMillis() - chara.uptime) / 1000L > time) && (((Vo_41480_0) chara.shenmiliwu.get(index - 1)).brate == 0)) {
                    String name = "";
                    int potentialPoint = 0;
                    Random random = new Random();
                    int i = random.nextInt(3);
                    if (i == 1) {
                        name = "潜能";
                        potentialPoint = chara.level * 810;
                        chara.cash += potentialPoint;
                        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = ("你获得了#R" + potentialPoint + "#n点" + name);
                        vo_20480_0.time = 1562593376;
                        GameObjectChar.send(new M20480_0(), vo_20480_0);
                    }
                    if (i == 2) {
                        name = "道行";
                        potentialPoint = chara.level * 7;
                        GameUtil.adddaohang(chara, potentialPoint);
                    } else if (i == 0) {
                        name = "经验";
                        Experience experience1 = GameData.that.baseExperienceService.findOneByAttrib(Integer.valueOf(chara.level));
                        potentialPoint = experience1.getMaxLevel().intValue() * 2 / (chara.level + 9);
                        GameUtil.huodejingyan(chara, potentialPoint);
                    }
                    ((Vo_41480_0) chara.shenmiliwu.get(index - 1)).name = name;
                    ((Vo_41480_0) chara.shenmiliwu.get(index - 1)).brate = 1;

                    Vo_41482_0 vo_41482_0 = new Vo_41482_0();
                    vo_41482_0.brate = 1;
                    vo_41482_0.name = name;
                    vo_41482_0.index = index;
                    vo_41482_0.result = 0;
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M41482_0(), vo_41482_0);


                    org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65527_0(), listVo_65527_0);

                    List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
                    GameObjectChar.send(new M32747_0(), vo_32747_0List);

                    GameUtil.a65511(chara);

                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("恭喜，你意外获得了#R" + name + "#n奖励");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);

                    GameUtil.a49159(chara);


                    List<Vo_41480_0> list = new java.util.LinkedList();
                    for (int k = 0; k < chara.shenmiliwu.size(); k++) {
                        Vo_41480_0 vo_41480_0 = new Vo_41480_0();
                        vo_41480_0.online_time = ((int) (chara.online_time / 1000L + (System.currentTimeMillis() - chara.uptime) / 1000L));
                        vo_41480_0.time = ((Vo_41480_0) chara.shenmiliwu.get(k)).time;
                        vo_41480_0.name = ((Vo_41480_0) chara.shenmiliwu.get(k)).name;
                        vo_41480_0.index = ((Vo_41480_0) chara.shenmiliwu.get(k)).index;
                        vo_41480_0.brate = ((Vo_41480_0) chara.shenmiliwu.get(k)).brate;
                        list.add(vo_41480_0);
                    }
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M41480_0(), list);
                }
            }
            return;
        }
        int time = ((Vo_41480_0) chara.shenmiliwu.get(index - 1)).time;


        long times = System.currentTimeMillis();
        boolean istime = chara.online_time / 1000L + (System.currentTimeMillis() - chara.uptime) / 1000L > time;
        if ((istime) && (((Vo_41480_0) chara.shenmiliwu.get(index - 1)).brate == 0)) {
            String name = "";
            int potentialPoint = 0;
            Random random = new Random();
            int i = random.nextInt(3);
            if (i == 1) {
                name = "潜能";
                potentialPoint = chara.level * 810;
                chara.cash += potentialPoint;
                Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                vo_20480_0.msg = ("你获得了#R" + potentialPoint + "#n点" + name);
                vo_20480_0.time = 1562593376;
                GameObjectChar.send(new M20480_0(), vo_20480_0);
            }
            if (i == 2) {
                name = "道行";
                potentialPoint = chara.level * 7;
                GameUtil.adddaohang(chara, potentialPoint);
            } else if (i == 0) {
                name = "经验";
                Experience experience1 = GameData.that.baseExperienceService.findOneByAttrib(Integer.valueOf(chara.level));
                potentialPoint = experience1.getMaxLevel().intValue() * 2 / (chara.level + 9);
                GameUtil.huodejingyan(chara, potentialPoint);
            }
            ((Vo_41480_0) chara.shenmiliwu.get(index - 1)).name = name;
            ((Vo_41480_0) chara.shenmiliwu.get(index - 1)).brate = 1;

            Vo_41482_0 vo_41482_0 = new Vo_41482_0();
            vo_41482_0.brate = 1;
            vo_41482_0.name = name;
            vo_41482_0.index = index;
            vo_41482_0.result = 0;
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M41482_0(), vo_41482_0);


            org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65527_0(), listVo_65527_0);

            List<Vo_32747_0> vo_32747_0List = GameUtil.a32747(chara);
            GameObjectChar.send(new M32747_0(), vo_32747_0List);

            GameUtil.a65511(chara);

            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
            vo_8165_0.msg = ("恭喜，你意外获得了#R" + name + "#n奖励");
            vo_8165_0.active = 0;
            GameObjectChar.send(new M8165_0(), vo_8165_0);

            GameUtil.a49159(chara);


            List<Vo_41480_0> list = new java.util.LinkedList();
            for (int k = 0; k < chara.shenmiliwu.size(); k++) {
                Vo_41480_0 vo_41480_0 = new Vo_41480_0();
                vo_41480_0.online_time = ((int) (chara.online_time / 1000L + (System.currentTimeMillis() - chara.uptime) / 1000L));
                vo_41480_0.time = ((Vo_41480_0) chara.shenmiliwu.get(k)).time;
                vo_41480_0.name = ((Vo_41480_0) chara.shenmiliwu.get(k)).name;
                vo_41480_0.index = ((Vo_41480_0) chara.shenmiliwu.get(k)).index;
                vo_41480_0.brate = ((Vo_41480_0) chara.shenmiliwu.get(k)).brate;
                list.add(vo_41480_0);
            }
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M41480_0(), list);
        } else {
        }
    }


    public int cmd() {
        return 41481;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C41481_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */