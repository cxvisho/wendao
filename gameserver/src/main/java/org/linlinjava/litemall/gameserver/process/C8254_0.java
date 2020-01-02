package org.linlinjava.litemall.gameserver.process;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


@Service
public class C8254_0
        implements GameHandler {

    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int id = GameReadTool.readInt(buff);


        int type = GameReadTool.readByte(buff);


        int para1 = GameReadTool.readShort(buff);


        int para2 = GameReadTool.readShort(buff);


        int para3 = GameReadTool.readShort(buff);


        int para4 = GameReadTool.readShort(buff);


        int para5 = GameReadTool.readShort(buff);


        int para6 = GameReadTool.readShort(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;


        if (para1 > 3000) {

            para1 -= 65536;

        }

        if (para2 > 3000) {

            para2 -= 65536;

        }

        if (para3 > 3000) {

            para3 -= 65536;

        }

        if (para4 > 3000) {

            para4 -= 65536;

        }

        if (para5 > 3000) {

            para5 -= 65536;

        }


        int fen = 0;

        if (id == 0) {

            if (type == 1) {

                fen = 59;

            } else {

                fen = 164;

            }

        } else {

            fen = 36;

        }


        int zong = para1 + para2 + para3 + para4 + para5;

        if (zong < 0) {

            if (chara.balance < zong * -fen) {

                Vo_20481_0 vo_20481_0 = new Vo_20481_0();

                vo_20481_0.msg = "元宝不足";

                vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));

                GameObjectChar.send(new M20481_0(), vo_20481_0);

            } else {

                chara.extra_life -= -zong * fen;

                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);

                GameObjectChar.send(new M65527_0(), listVo_65527_0);

            }

        }

/**
 元宝减熟悉




 int count3 = para1 + para2 + para3 + para4 + para5;
 int polar_point = chara.polar_point;

 int level = chara.level;
 int phy_power = chara.phy_power; //力量
 int life = chara.life;//体质
 int speed = chara.speed; //敏捷
 int power = chara.mag_power;  //灵力
 /**
 * chara.life += para1;
 *
 *chara.mag_power += para2;
 *
 *chara.phy_power += para3;
 *
 *chara.speed += para4;
 *
 *chara.polar_point -= count;
 */

        if (id == 0) {


            int count = para1 + para2 + para3 + para4 + para5;

            if (type == 1) {  // 减熟悉

                if ((chara.polar_point == 0 && count3 > 0)
                        || count3 > chara.polar_point
                        || level > life + para1 || level > phy_power + para3 || level > speed + para4 || level > power + para2) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();

                    vo_20481_0.msg = "再刷wpe 我就顺着网线来了";

                    vo_20481_0.time = 1562987118;

                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                } else {

                    chara.life += para1;

                    chara.mag_power += para2;
                    /*  92 力量*/
                    chara.phy_power += para3;

                    chara.speed += para4;

                    chara.polar_point -= count;

                }

            } else if (type == 2) {  //加相性
                int resist_metal = chara.resist_metal;
                int wood = chara.wood;
                int water = chara.water;
                int fire = chara.fire;
                int earth = chara.earth;
        /*  resist_metal+= para5;  //火象
                    wood+= para1;  //金相
                    water+= para2; //木相
                    fire+= para3;  // 水相
                    earth+= para4;  //土相
                    chara.stamina -= count;*/

                if (count3 > chara.stamina || resist_metal + para5 < 0 || wood + para1 < 0 || water + para2 < 0 || fire + para3 < 0 || earth + para4 < 0) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();

                    vo_20481_0.msg = "再刷wpe 我就顺着网线来了";

                    vo_20481_0.time = 1562987118;

                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                } else {
                    chara.resist_metal += para5;
                    chara.wood += para1;
                    chara.water += para2;
                    chara.fire += para3;
                    chara.earth += para4;
                    chara.stamina -= count;

                }


            }

            ListVo_65527_0 vo_65527_0 = GameUtil.a65527(chara);

            GameObjectChar.send(new M65527_0(), vo_65527_0);

        } else {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.id == id) {
                    PetShuXing petShuXing = (PetShuXing) petbeibao.petShuXing.get(0);
                    int count = para1 + para2 + para3 + para4 + para5;
                    if ((petShuXing.polar_point == 0 && count3 > 0)
                            || count3 > petShuXing.polar_point
                            || petShuXing.skill > petShuXing.life + para1 || petShuXing.skill > petShuXing.phy_power + para3 || petShuXing.skill > petShuXing.speed + para4 || petShuXing.skill > petShuXing.mag_power + para2) {

                    } else {
                        petShuXing.life += para1;
                        petShuXing.mag_power += para2;
                        petShuXing.phy_power += para3;
                        petShuXing.speed += para4;
                        petShuXing.polar_point -= count;
                        BasicAttributesUtils.petshuxing(petShuXing);

                        List list = new ArrayList();
                        list.add(petbeibao);
                        GameObjectChar.send(new M65507_0(), list);
                    }
                }
            }
        }
    }

    public int cmd() {

        return 8254;

    }

}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C8254_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */