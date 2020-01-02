package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.PrintStream;
import java.util.List;

import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.service.base.BaseSaleClassifyGoodService;
import org.linlinjava.litemall.db.service.base.BaseSaleGoodService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12269_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C16582_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int inventoryPos = GameReadTool.readInt(buff);

        int price = GameReadTool.readInt(buff);

        int pos = GameReadTool.readShort(buff);


        int type = GameReadTool.readShort(buff);

        int amount = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        String str = null;
        int coin = price / 100;
        if (coin < 0) {
            return;
        }
        if (price < 0) {
            return;
        }
        if (price > 2000000000) {
            return;
        }
        if (type == 1) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (((Goods) chara.backpack.get(i)).pos == inventoryPos) {
                    Goods goods = (Goods) chara.backpack.get(i);
                    SaleClassifyGood saleClassifyGood = GameData.that.baseSaleClassifyGoodService.findOneByStr(goods.goodsInfo.str);
                    if (goods.goodsInfo.str.contains("超级黑水晶·")) {
                        List<SaleClassifyGood> classifyGoodList = GameData.that.baseSaleClassifyGoodService.findByStr(goods.goodsInfo.str);
                        for (int j = 0; j < classifyGoodList.size(); j++) {
                            if ((Integer.valueOf(((SaleClassifyGood) classifyGoodList.get(j)).getAttrib()).intValue() == goods.goodsInfo.attrib) && (Integer.valueOf(((SaleClassifyGood) classifyGoodList.get(j)).getCname()).intValue() == goods.goodsInfo.add_pet_exp)) {
                                saleClassifyGood = (SaleClassifyGood) classifyGoodList.get(j);
                            }
                        }
                    }
                    if (saleClassifyGood == null) {
                        //System.out.println(goods.goodsInfo.str);
                        return;
                    }
                    SaleGood saleGood = new SaleGood();
                    str = saleClassifyGood.getCompose();
                    if ((saleClassifyGood.getPname().equals("低级首饰")) || (goods.goodsInfo.degree_32 == 1)) {
                        if (coin < 1000) {
                            coin = 1000;
                        }
                        if (goods.goodsInfo.degree_32 == 1) {
                            str = "未鉴定" + saleClassifyGood.getCompose();
                            saleGood.setLevel(Integer.valueOf(256));
                        }
                    } else if (coin < 100000) {
                        coin = 100000;
                    }

                    chara.balance -= coin;
                    org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65527_0(), listVo_65527_0);

                    GameUtil.removemunber(chara, (Goods) chara.backpack.get(i), 1);
                    Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                    vo_20480_0.msg = "摆摊成功";
                    vo_20480_0.time = ((int) System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20480_0(), vo_20480_0);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("花费了摊位费" + coin + "#n文钱#n");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);


                    int time = (int) (System.currentTimeMillis() / 1000L);
                    saleGood.setStartTime(Integer.valueOf(time));
                    saleGood.setEndTime(Integer.valueOf(time - 604800));
                    saleGood.setGoodsId(goods.goodsInfo.auto_fight);
                    saleGood.setName(goods.goodsInfo.str);
                    saleGood.setPrice(Integer.valueOf(price));
                    saleGood.setReqLevel(Integer.valueOf(goods.goodsInfo.attrib));
                    saleGood.setOwnerUuid(chara.uuid);
                    saleGood.setStr(str);
                    saleGood.setIspet(Integer.valueOf(1));
                    saleGood.setGoods(JSONUtils.toJSONString(goods));
                    GameData.that.baseSaleGoodService.add(saleGood);
                }
            }
        }

        if (type == 2) {
            if (coin < 100000) {
                coin = 100000;
            }
            if (chara.balance < coin) {
                return;
            }
            chara.balance -= coin;
            org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            for (int i = 0; i < chara.pets.size(); i++) {
                if (((Petbeibao) chara.pets.get(i)).id == inventoryPos) {
                    Petbeibao pet = (Petbeibao) chara.pets.get(i);
                    SaleClassifyGood saleClassifyGood = GameData.that.baseSaleClassifyGoodService.findOneByStr(((PetShuXing) pet.petShuXing.get(0)).str);
                    if (saleClassifyGood == null) {
                        System.out.println(((PetShuXing) pet.petShuXing.get(0)).type);
                        return;
                    }
                    Vo_12269_0 vo_12269_0 = new Vo_12269_0();
                    vo_12269_0.id = pet.id;
                    vo_12269_0.owner_id = 0;
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M12269_0(), vo_12269_0);

                    str = saleClassifyGood.getCompose();
                    Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                    vo_20480_0.msg = "摆摊成功";
                    vo_20480_0.time = ((int) System.currentTimeMillis() / 1000);
                    GameObjectChar.send(new M20480_0(), vo_20480_0);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("花费了摊位费" + coin + "#n文钱#n");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                    SaleGood saleGood = new SaleGood();
                    int time = (int) (System.currentTimeMillis() / 1000L);
                    saleGood.setStartTime(Integer.valueOf(time));
                    saleGood.setEndTime(Integer.valueOf(time - 604800));
                    saleGood.setGoodsId(((PetShuXing) pet.petShuXing.get(0)).auto_fight);
                    saleGood.setName(saleClassifyGood.getStr());
                    saleGood.setPrice(Integer.valueOf(price));
                    saleGood.setReqLevel(Integer.valueOf(((PetShuXing) pet.petShuXing.get(0)).skill));
                    saleGood.setOwnerUuid(chara.uuid);
                    saleGood.setStr(str);
                    saleGood.setGoods(JSONUtils.toJSONString(pet));
                    saleGood.setIspet(Integer.valueOf(2));
                    GameData.that.baseSaleGoodService.add(saleGood);
                    chara.pets.remove(pet);
                }
            }
        }


        List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByOwnerUuid(chara.uuid);

        org.linlinjava.litemall.gameserver.data.vo.Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M49179_0(), vo_49179_0);
    }

    public int cmd() {
        return 16582;
    }
}
