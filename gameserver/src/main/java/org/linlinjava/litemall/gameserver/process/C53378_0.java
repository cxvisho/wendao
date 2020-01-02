package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53377_0;
import org.linlinjava.litemall.gameserver.data.write.M53377_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C53378_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        Vo_53377_0 vo_53377_0 = new Vo_53377_0();
        vo_53377_0.dsicountMonthPrice = 3000;
        vo_53377_0.dsicountQuaterPrice = 9000;
        vo_53377_0.dsicountYearPrice = 36000;
        vo_53377_0.startTime = 1555016400;
        vo_53377_0.endTime = 1570827599;
        GameObjectChar.send(new M53377_0(), vo_53377_0);

        GameUtil.addVip(chara);
    }


    public int cmd() {
        return 53378;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53378_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */