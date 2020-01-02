package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.service.SaleGoodService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12269_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_33049_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49183;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49183_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.job.SaveCharaTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@org.springframework.stereotype.Service
public class C12490_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    private static final Logger log = LoggerFactory.getLogger(C12490_0.class);

    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String id = GameReadTool.readString(buff);

        String key = GameReadTool.readString(buff);

        String pageStr = GameReadTool.readString(buff);

        int price = GameReadTool.readInt(buff);

        int type = GameReadTool.readByte(buff);

        int amount = GameReadTool.readShort(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        SaleGood saleGood = GameData.that.saleGoodService.findOneByGoodsId(id);

        if (saleGood.getOwnerUuid().equals(chara.uuid)) {
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = "道友,这是你自己出售的商品哦。";
            vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            return;
        }

        if (saleGood.getIspet().intValue() == 1) {
            String goods = saleGood.getGoods();
            Goods goods1 = (Goods) JSONUtils.parseObject(goods, Goods.class);
            List list = new java.util.LinkedList();
            goods1.pos = GameUtil.beibaoweizhi(chara);
            goods1.goodsInfo.owner_id = 1;
            GameUtil.addwupin(goods1, chara);
            Vo_40964_0 vo_40964_9 = new Vo_40964_0();
            vo_40964_9.type = 1;
            vo_40964_9.name = saleGood.getName();
            vo_40964_9.param = "-1";
            vo_40964_9.rightNow = 0;
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40964_0(), vo_40964_9);
        } else {
            String goods = saleGood.getGoods();
            Petbeibao petbeibao = (Petbeibao) JSONUtils.parseObject(goods, Petbeibao.class);
            Vo_12269_0 vo_12269_0 = new Vo_12269_0();
            vo_12269_0.id = petbeibao.id;
            vo_12269_0.owner_id = chara.id;
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M12269_0(), vo_12269_0);
            Vo_40964_0 vo_40964_11 = new Vo_40964_0();
            vo_40964_11.type = 2;
            vo_40964_11.name = "立正";
            vo_40964_11.param = String.valueOf(((PetShuXing) petbeibao.petShuXing.get(0)).type);
            vo_40964_11.rightNow = 0;
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40964_0(), vo_40964_11);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = ("你成功将#R" + saleGood.getName() + "#n购买了");
            vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            List list = new java.util.ArrayList();
            list.add(petbeibao);
            petbeibao.id = GameUtil.getCard(chara);
            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65507_0(), list);
            boolean isfagong = ((PetShuXing) petbeibao.petShuXing.get(0)).rank > ((PetShuXing) petbeibao.petShuXing.get(0)).pet_mag_shape;
            GameUtil.dujineng(1, ((PetShuXing) petbeibao.petShuXing.get(0)).metal, ((PetShuXing) petbeibao.petShuXing.get(0)).skill, isfagong, petbeibao.id, chara);
            chara.pets.add(petbeibao);
            GameData.that.saleGoodService.deleteById(saleGood.getId().intValue());
        }
        Vo_33049_0 vo_33049_0 = new Vo_33049_0();
        vo_33049_0.goods_gid = id;
        vo_33049_0.type = 0;
        vo_33049_0.result = 1;
        vo_33049_0.tips = "";
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M33049_0(), vo_33049_0);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = ("购买了#R" + saleGood.getName() + "#n。");
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new M20481_0(), vo_20481_0);

        chara.balance -= price;
        org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65527_0(), listVo_65527_0);

        GameData.that.saleGoodService.deleteById(saleGood.getId().intValue());

        String[] split = pageStr.split("\\;");
        int pos1 = Integer.parseInt(split[0]);
        int pos2 = Integer.parseInt(split[1]);
        List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByStr(key);
        Vo_49183_0 vo_49183_0 = new Vo_49183_0();
        vo_49183_0.totalPage = (saleGoodList.size() / 3);
        vo_49183_0.cur_page = pos1;
        int weizhi = (pos1 - 1) * 8;
        int size = saleGoodList.size() - (pos1 - 1) * 8;
        if (size > 8) {
            size = 8;
        }
        for (int i = 0; i < size; i++) {
            Vo_49183 vo_49183 = new Vo_49183();
            vo_49183.name = ((SaleGood) saleGoodList.get(i + weizhi)).getName();
            vo_49183.is_my_goods = 0;
            vo_49183.id = ((SaleGood) saleGoodList.get(i + weizhi)).getGoodsId();
            vo_49183.price = ((SaleGood) saleGoodList.get(i + weizhi)).getPrice().intValue();
            vo_49183.status = 2;
            vo_49183.startTime = ((SaleGood) saleGoodList.get(i + weizhi)).getStartTime().intValue();
            vo_49183.endTime = ((SaleGood) saleGoodList.get(i + weizhi)).getEndTime().intValue();
            vo_49183.level = ((SaleGood) saleGoodList.get(i + weizhi)).getLevel().intValue();
            vo_49183.unidentified = (((SaleGood) saleGoodList.get(i + weizhi)).getLevel().intValue() > 0 ? 1 : 0);
            if (((SaleGood) saleGoodList.get(i + weizhi)).getIspet().intValue() == 2) {
                vo_49183.unidentified = 0;
            }
            vo_49183.amount = 1;
            vo_49183.req_level = ((SaleGood) saleGoodList.get(i + weizhi)).getReqLevel().intValue();
            vo_49183.extra = "\"{\"rank\":2,\"enchant\":0,\"mount_type\":0,\"rebuild_level\":1,\"eclosion\":0}\"";
            vo_49183.item_polar = 0;
            vo_49183_0.vo_49183s.add(vo_49183);
        }
        vo_49183_0.path_str = key;
        vo_49183_0.select_gid = "";
        vo_49183_0.sell_stage = 2;
        vo_49183_0.sort_key = "price";
        vo_49183_0.is_descending = 0;
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M49183_0(), vo_49183_0);

        Characters characters = GameData.that.characterService.finOnByGiD(saleGood.getOwnerUuid());
        Chara chara1 = (Chara) JSONUtils.parseObject(characters.getData(), Chara.class);
        GameObjectChar session = org.linlinjava.litemall.gameserver.game.GameObjectCharMng.getGameObjectChar(chara1.id);
        if (session != null) {
            session.chara.jishou_coin += price;
        } else {
            chara1.jishou_coin += price;
            String data = characters.getData();
            Chara chara111 = JSONUtils.parseObject(data, Chara.class);
            if (chara111.level < chara1.level) {
                log.error("人物等级{old}", chara111.name, chara111.level);
                log.error("人物等级{new}", chara.name, chara.level);
                throw new RuntimeException("角色等级回档！！！");
            }
            characters.setData(JSONUtils.toJSONString(chara1));
            GameData.that.characterService.updateById(characters);
        }
    }

    public int cmd() {
        return 12490;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C12490_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */