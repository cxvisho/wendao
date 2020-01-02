package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.db.domain.PackModification;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4197_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.data.write.M41505_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C53712_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String name = org.linlinjava.litemall.gameserver.data.GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        PackModification packModification = GameData.that.basePackModificationService.findOneByAlias(name);
        chara.extra_life -= packModification.getGoodsPrice().intValue();
        org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);


        for (int i = 0; i < chara.backpack.size(); i++) {
            if (((Goods) chara.backpack.get(i)).pos == 37) {
                Goods goods = (Goods) chara.backpack.get(i);
                chara.backpack.remove(chara.backpack.get(i));
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.store_type = "follow_pet_store";
                vo_61677_0.npcID = 0;
                vo_61677_0.list = chara.genchong;
                vo_61677_0.count = chara.genchong.size();
                GameObjectChar.send(new M61677_0(), vo_61677_0);
            }
        }

        Vo_4197_0 vo_4197_0 = new Vo_4197_0();
        vo_4197_0.id = 0;
        GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M4197_0(), vo_4197_0);
        GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M12285_1(), Integer.valueOf(chara.genchong_icon));
        Goods goods = new Goods();
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.value = 2097924;
        goods.goodsInfo.quality = "金色";
        goods.goodsInfo.alias = name;
        goods.pos = packModification.getPosition().intValue();
        goods.goodsInfo.food_num = 0;
        goods.goodsInfo.master = chara.sex;
        goods.goodsInfo.recognize_recognized = 2;
        goods.goodsInfo.type = Integer.valueOf(packModification.getType()).intValue();
        goods.goodsInfo.total_score = 24;
        goods.goodsInfo.damage_sel_rate = 1842075;
        goods.goodsInfo.str = packModification.getStr();
        goods.goodsInfo.metal = chara.menpai;
        goods.goodsInfo.attrib = 0;
        goods.goodsInfo.durability = 8;
        goods.goodsInfo.rebuild_level = 0;
        goods.goodsInfo.auto_fight = ("5d65f0216e9552d52c521d59" + packModification.getPosition());
        chara.genchong.add(goods);

        chara.genchong_icon = Integer.valueOf(packModification.getFasionType()).intValue();

        Vo_65529_0 vo_65529_0 = new Vo_65529_0();
        vo_65529_0.id = Integer.valueOf(packModification.getFasionType()).intValue();
        vo_65529_0.x = chara.x;
        vo_65529_0.y = chara.y;
        vo_65529_0.dir = 5;
        vo_65529_0.icon = Integer.valueOf(packModification.getFasionType()).intValue();
        vo_65529_0.type = 32768;
        vo_65529_0.sub_type = 2;
        vo_65529_0.owner_id = chara.id;
        vo_65529_0.name = packModification.getStr();
        vo_65529_0.org_icon = Integer.valueOf(packModification.getFasionType()).intValue();
        vo_65529_0.portrait = Integer.valueOf(packModification.getFasionType()).intValue();
        GameObjectChar.getGameObjectChar().gameMap.send(new org.linlinjava.litemall.gameserver.data.write.M65529_0(), vo_65529_0);


        Vo_61677_0 vo_61677_0 = new Vo_61677_0();
        vo_61677_0.store_type = "follow_pet_store";
        vo_61677_0.npcID = 0;
        vo_61677_0.list = chara.genchong;
        vo_61677_0.count = chara.genchong.size();
        GameObjectChar.send(new M61677_0(), vo_61677_0);


        Vo_61677_0 vo_61677_12 = new Vo_61677_0();
        vo_61677_12.store_type = "follow_pet_store";
        vo_61677_12.npcID = 0;
        vo_61677_12.count = 1;
        vo_61677_12.isGoon = 0;
        vo_61677_12.pos = packModification.getPosition().intValue();
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M61677_01(), vo_61677_12);


        goods = new Goods();
        goods.goodsInfo.owner_id = 1;
        goods.goodsInfo.value = 3844;
        goods.goodsInfo.quality = "金色";
        goods.goodsInfo.alias = packModification.getStr();
        goods.pos = 37;
        goods.goodsInfo.food_num = 0;
        goods.goodsInfo.merge_rate = 0;
        goods.goodsInfo.master = 0;
        goods.goodsInfo.recognize_recognized = 2;
        goods.goodsInfo.type = Integer.valueOf(packModification.getType()).intValue();
        goods.goodsInfo.total_score = 24;
        goods.goodsInfo.damage_sel_rate = 809382;
        goods.goodsInfo.str = packModification.getStr();
        goods.goodsInfo.metal = 0;
        goods.goodsInfo.durability = 8;
        goods.goodsInfo.attrib = 0;
        goods.goodsInfo.rebuild_level = 0;
        goods.goodsInfo.auto_fight = ("5d65f0216e9552d52c521d59" + packModification.getPosition());
        chara.backpack.add(goods);
        List<Goods> list = new ArrayList();
        list.add(goods);
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65525_0(), list);


        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "购买成功。";
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20481_0(), vo_20481_0);

        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M61671_0(), vo_61671_0);
        Vo_41505_0 vo_41505_0 = new Vo_41505_0();
        vo_41505_0.type = "view_follow_pet";
        GameObjectChar.send(new M41505_0(), vo_41505_0);
    }


    public int cmd() {
        return 53712;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53712_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */