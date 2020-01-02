package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.data.write.M61677_01;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C16502_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int id = GameReadTool.readInt(buff);

        int from_pos = GameReadTool.readShort(buff);

        int to_pos = GameReadTool.readShort(buff);

        int amount = GameReadTool.readShort(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;
        for (int i = 0; i < chara.cangku.size(); i++) {
            if (((Goods) chara.cangku.get(i)).pos == from_pos) {
                Vo_40964_0 vo_40964_0 = new Vo_40964_0();
                vo_40964_0.type = 1;
                vo_40964_0.name = ((Goods) chara.cangku.get(i)).goodsInfo.str;
                vo_40964_0.param = "156482";
                vo_40964_0.rightNow = 2;
                GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40964_0(), vo_40964_0);

                ((Goods) chara.cangku.get(i)).pos = GameUtil.beibaoweizhi(chara);
                GameUtil.addwupin((Goods) chara.cangku.get(i), chara);
                chara.cangku.remove(chara.cangku.get(i));
                GameObjectChar.send(new M65525_0(), chara.backpack);
                Vo_61677_0 vo_61677_0 = new Vo_61677_0();
                vo_61677_0.pos = from_pos;
                GameObjectChar.send(new M61677_01(), vo_61677_0);
            }
        }
    }


    public int cmd() {
        return 16502;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C16502_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */