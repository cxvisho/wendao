package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12269_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41045_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C53252_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int type = GameReadTool.readByte(buff);

        String name = GameReadTool.readString(buff);
        GameObjectChar session = GameObjectChar.getGameObjectChar();
        Chara chara = session.chara;


        if (type == 1) {
            type = 3;
            int number = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (((Goods) chara.backpack.get(i)).goodsInfo.str.equals("召唤令·十二生肖")) {
                    number += ((Goods) chara.backpack.get(i)).goodsInfo.owner_id;
                }
            }
            if (number < 100) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "召唤令数量不足，无法兑换";
                vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            GameUtil.removemunber(chara, "召唤令·十二生肖", 100);
        } else {
            int number = 0;
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (((Goods) chara.backpack.get(i)).goodsInfo.str.equals("召唤令·上古神兽")) {
                    number += ((Goods) chara.backpack.get(i)).goodsInfo.owner_id;
                }
            }
            if (number < 100) {
                Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                vo_20481_0.msg = "召唤令数量不足，无法兑换";
                vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
                GameObjectChar.send(new M20481_0(), vo_20481_0);
                return;
            }
            type = 4;
            GameUtil.removemunber(chara, "召唤令·上古神兽", 100);
        }
        org.linlinjava.litemall.db.domain.Pet pet = GameData.that.basePetService.findOneByName(name);
        Petbeibao petbeibao = new Petbeibao();
        petbeibao.PetCreate(pet, chara, 0, type);
        List<Petbeibao> list = new java.util.ArrayList();
        chara.pets.add(petbeibao);
        list.add(petbeibao);
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65507_0(), list);

        Vo_12269_0 vo_12269_0 = new Vo_12269_0();

        vo_12269_0.id = petbeibao.id;
        vo_12269_0.owner_id = chara.id;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M12269_0(), vo_12269_0);
        Vo_40964_0 vo_40964_0 = new Vo_40964_0();
        vo_40964_0.type = 2;
        vo_40964_0.name = name;
        vo_40964_0.param = String.valueOf(((PetShuXing) petbeibao.petShuXing.get(0)).type);
        vo_40964_0.rightNow = 0;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40964_0(), vo_40964_0);
        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
        vo_20480_0.msg = ("恭喜你召唤了一只" + name);
        vo_20480_0.time = ((int) (System.currentTimeMillis() / 1000L));
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20480_0(), vo_20480_0);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = ("恭喜你召唤了一只" + name);
        vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
        GameObjectChar.send(new M20481_0(), vo_20481_0);
        Vo_41045_0 vo_41045_0 = new Vo_41045_0();
        vo_41045_0.flag = 3;
        vo_41045_0.id = petbeibao.id;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M41045_0(), vo_41045_0);
    }


    public int cmd() {
        return 53252;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53252_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */