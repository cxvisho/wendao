package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_5;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C53706_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int no = GameReadTool.readByte(buff);

        int num = GameReadTool.readShort(buff);

        int flag = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        if (flag == 1) {
            for (int i = 0; i < chara.pets.size(); i++) {
                if (((Petbeibao) chara.pets.get(i)).no == no) {
                    ((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).shape += 2000 * num;
                    GameUtil.removemunber(chara, "超级神兽丹", num);
                    List list = new ArrayList();
                    list.add(chara.pets.get(i));
                    GameObjectChar.send(new M65507_0(), list);
                    List list1 = new LinkedList();
                    list1.add(Integer.valueOf(((Petbeibao) chara.pets.get(i)).id));
                    list1.add(Integer.valueOf(((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).shape));
                    GameObjectChar.send(new M65527_5(), list1);
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = ("增加#R" + 2000 * num + "点#n亲密度。");
                    vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20481_0(), vo_20481_0);
                }
            }
        }
    }

    public int cmd() {
        return 53706;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53706_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */