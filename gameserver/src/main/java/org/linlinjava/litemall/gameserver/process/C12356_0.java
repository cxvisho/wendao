package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.db.domain.GroceriesShop;
import org.linlinjava.litemall.db.domain.MedicineShop;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.service.base.BaseGroceriesShopService;
import org.linlinjava.litemall.db.service.base.BaseMedicineShopService;
import org.linlinjava.litemall.db.service.base.BaseStoreInfoService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.write.M20480_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C12356_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int shipper = GameReadTool.readInt(buff);

        int pos = GameReadTool.readShort(buff);

        int amount = GameReadTool.readShort(buff);

        int to_pos = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (shipper == 15908) {
            GroceriesShop groceriesShop = GameData.that.baseGroceriesShopService.findOneByGoodsNo(Integer.valueOf(pos));


            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName(groceriesShop.getName());
            if (pos < 2) {
                GameUtil.huodedaoju(chara, storeInfo, amount);
            } else {
                List<Goods> list = new ArrayList();
                Goods goods = new Goods();
                goods.pos = GameUtil.beibaoweizhi(chara);
                goods.goodsInfo = new GoodsInfo();


                goods.goodsDaoju(storeInfo);
                goods.goodsInfo.degree_32 = 0;
                goods.goodsInfo.skill = 3;
                goods.goodsInfo.owner_id = amount;
                goods.goodsInfo.damage_sel_rate = 400976;
                goods.goodsInfo.silver_coin = 6000;
                goods.goodsInfo.degree_32 = 1;

                goods.goodsLanSe = new GoodsLanSe();
                if (pos == 2) {
                    goods.goodsLanSe.wiz = 270;
                }
                if (pos == 3) {
                    goods.goodsLanSe.accurate = 594;
                }
                if (pos == 4) {
                    goods.goodsLanSe.mana = 392;
                }
                if (pos == 5) {
                    goods.goodsLanSe.def = 900;
                }
                if (pos == 6) {
                    goods.goodsLanSe.parry = 96;
                }
                if (pos == 7) {
                    goods.goodsLanSe.dex = 594;
                }
                GameUtil.addwupin(goods, chara);


                GameObjectChar.send(new M65525_0(), chara.backpack);
            }

            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = ("你购买了" + storeInfo.getName() + "#n");
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = storeInfo.getName();
            vo_40964_0.param = "-1";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            if (chara.lock_exp == 0) {
                chara.balance -= storeInfo.getRebuildLevel().intValue();
            } else {
                chara.use_money_type -= storeInfo.getRebuildLevel().intValue();
            }
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
        }
        if (shipper == 15907) {
            MedicineShop medicineShop = GameData.that.baseMedicineShopService.findOneByGoodsNo(Integer.valueOf(pos));


            StoreInfo storeInfo = GameData.that.baseStoreInfoService.findOneByName(medicineShop.getName());
            GameUtil.huodedaoju(chara, storeInfo, amount);
            Vo_20480_0 vo_20480_0 = new Vo_20480_0();
            vo_20480_0.msg = ("你购买了" + storeInfo.getName() + "#n");
            vo_20480_0.time = 1562593376;
            GameObjectChar.send(new M20480_0(), vo_20480_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 1;
            vo_40964_0.name = storeInfo.getName();
            vo_40964_0.param = "-1";
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);

            if (chara.lock_exp == 0) {
                chara.balance -= storeInfo.getRebuildLevel().intValue();
            } else {
                chara.use_money_type -= storeInfo.getRebuildLevel().intValue();
            }
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
        }
    }


    public int cmd() {
        return 12356;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C12356_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */