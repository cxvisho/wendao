package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import org.linlinjava.litemall.db.service.base.BaseSaleClassifyGoodService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0;
import org.linlinjava.litemall.gameserver.data.write.M9129_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


@Service
public class C45096_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String key = GameReadTool.readString(buff);

        String eatra = GameReadTool.readString(buff);

        int type = GameReadTool.readByte(buff);

        SaleClassifyGood classifyGood = GameData.that.baseSaleClassifyGoodService.findOneByCompose(key);
        if (classifyGood == null) {
            return;
        }
        Integer price = classifyGood.getPrice();
        String str = classifyGood.getStr();

        Vo_9129_0 vo_9129_0 = new Vo_9129_0();
        vo_9129_0.notify = 45;
        vo_9129_0.para = ("{150:" + (int) (price.intValue() * 1.5D) + ",140:" + (int) (price.intValue() * 1.4D) + ",130:" + (int) (price.intValue() * 1.3D) + ",120:" + (int) (price.intValue() * 1.2D) + ",110:" + price.intValue() * 1.1D + ",100:" + price + ",90:" + (int) (price.intValue() * 0.9D) + ",80:" + (int) (price.intValue() * 0.8D) + ",70:" + (int) (price.intValue() * 0.7D) + ",60:" + (int) (price.intValue() * 0.6D) + ",50:" + (int) (price.intValue() * 0.5D) + ",\"name\":\"" + str + "\"}");
        GameObjectChar.send(new M9129_0(), vo_9129_0);
    }

    public int cmd() {
        return 45096;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C45096_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */