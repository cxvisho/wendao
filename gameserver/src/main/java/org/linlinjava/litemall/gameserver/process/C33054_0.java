package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.service.SaleGoodService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49179_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M49179_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C33054_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String goods_gid = GameReadTool.readString(buff);

        int price = GameReadTool.readInt(buff);

        SaleGood saleGood = GameData.that.saleGoodService.findOneByGoodsId(goods_gid);
        saleGood.setPrice(Integer.valueOf(price));
        GameData.that.saleGoodService.updateById(saleGood);
        Chara chara = GameObjectChar.getGameObjectChar().chara;

        chara.balance -= 20000;
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);

        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = "改价成功";
        vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
        GameObjectChar.send(new M20481_0(), vo_20481_0);
        List<SaleGood> saleGoodList = GameData.that.saleGoodService.findByOwnerUuid(chara.uuid);
        Vo_49179_0 vo_49179_0 = GameUtil.a49179(saleGoodList, chara);
        GameObjectChar.send(new M49179_0(), vo_49179_0);
    }

    public int cmd() {
        return 33054;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C33054_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */