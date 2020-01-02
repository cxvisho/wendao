package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C16504_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int id = GameReadTool.readInt(buff);

        int from_pos = GameReadTool.readShort(buff);

        int to_pos = GameReadTool.readShort(buff);

        int amount = GameReadTool.readShort(buff);

        String container = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.backpack.size(); i++) {
            if (((Goods) chara.backpack.get(i)).pos == from_pos) {
                List<Goods> listbeibao = new ArrayList();
                Goods goods1 = new Goods();
                goods1.goodsBasics = null;
                goods1.goodsInfo = null;
                goods1.goodsLanSe = null;
                goods1.pos = from_pos;
                listbeibao.add(goods1);
                GameUtil.cangkuaddwupin((Goods) chara.backpack.get(i), chara);
                chara.backpack.remove(chara.backpack.get(i));
                GameObjectChar.send(new M65525_0(), listbeibao);
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.list = chara.cangku;
                GameObjectChar.send(new M61677_0(), vo_61677_0);
                break;
            }
        }
    }


    public int cmd() {
        return 16504;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C16504_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */