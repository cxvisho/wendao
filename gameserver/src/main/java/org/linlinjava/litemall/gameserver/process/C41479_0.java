package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;
import org.linlinjava.litemall.gameserver.data.write.M41480_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;


@Service
public class C41479_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        Date date = new Date(chara.updatetime);
        boolean isnow = GameUtil.isNow(date);
        if ((!isnow) && (chara.online_time != 0L)) {
            chara.online_time = 0L;
            for (int i = 0; i < chara.shenmiliwu.size(); i++) {
                ((Vo_41480_0) chara.shenmiliwu.get(i)).online_time = 0;
                ((Vo_41480_0) chara.shenmiliwu.get(i)).name = "";
                ((Vo_41480_0) chara.shenmiliwu.get(i)).brate = 0;
            }
        }
        List<Vo_41480_0> list = new LinkedList();
        for (int i = 0; i < chara.shenmiliwu.size(); i++) {
            Vo_41480_0 vo_41480_0 = new Vo_41480_0();
            vo_41480_0.online_time = ((int) (chara.online_time / 1000L + (System.currentTimeMillis() - chara.uptime) / 1000L));
            vo_41480_0.time = ((Vo_41480_0) chara.shenmiliwu.get(i)).time;
            vo_41480_0.name = ((Vo_41480_0) chara.shenmiliwu.get(i)).name;
            vo_41480_0.index = ((Vo_41480_0) chara.shenmiliwu.get(i)).index;
            vo_41480_0.brate = ((Vo_41480_0) chara.shenmiliwu.get(i)).brate;
            list.add(vo_41480_0);
        }
        GameObjectChar.send(new M41480_0(), list);
    }

    public int cmd() {
        return 41479;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C41479_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */