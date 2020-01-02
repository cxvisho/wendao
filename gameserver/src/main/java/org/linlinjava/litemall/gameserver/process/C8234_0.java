package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.write.M65525_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


@Service
public class C8234_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int from_pos = GameReadTool.readByte(buff);

        int to_pos = GameReadTool.readByte(buff);
        if (to_pos < 0) {
            to_pos = 129 + to_pos + 127;
        }
        GameObjectChar session = GameObjectChar.getGameObjectChar();
        Chara chara = session.chara;
        List<Goods> list = new ArrayList();
        List<Goods> listbeibao = new ArrayList();
        for (Goods goods : chara.backpack) {
            if (goods.pos == from_pos) {
                goods.pos = to_pos;
                Goods goods1 = new Goods();
                goods1.goodsBasics = null;
                goods1.goodsInfo = null;
                goods1.pos = from_pos;
                listbeibao.add(goods1);
                GameObjectChar.send(new M65525_0(), listbeibao);
                GameObjectChar.send(new M65525_0(), chara.backpack);
            }
        }


        GameUtil.a65511(chara);

        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);
    }

    public int cmd() {
        return 8234;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C8234_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */