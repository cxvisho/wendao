package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.Map.Entry;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C4288_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String select = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        boolean haschenhao = false;
        for (Entry<String, String> entry : chara.chenghao.entrySet()) {
            if (((String) entry.getKey()).equals(select)) {
                chara.chenhao = ((String) entry.getValue());
                haschenhao = true;
            }
        }
        if (!haschenhao) {
            chara.chenhao = "";
        }
        ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
        GameObjectChar.send(new M65527_0(), listVo_65527_0);

        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);
    }

    public int cmd() {
        return 4288;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4288_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */