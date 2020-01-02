package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_3;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C41117_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int no = GameReadTool.readByte(buff);

        int num1 = GameReadTool.readShort(buff);

        int num2 = GameReadTool.readShort(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;

        int id = 0;
        int pot = 0;
        int resist_poison = 0;

        for (int i = 0; i < chara.pets.size(); i++) {
            if (((Petbeibao) chara.pets.get(i)).no == no) {
                if ((((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).skill >= chara.level) || (((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).skill >= 120)) {
                    Vo_20481_0 vo_20481_0 = new Vo_20481_0();
                    vo_20481_0.msg = "无法使用";
                    vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
                    GameObjectChar.send(new M20481_0(), vo_20481_0);
                    return;
                }
                id = ((Petbeibao) chara.pets.get(i)).id;
                GameUtil.addpetjingyan((Petbeibao) chara.pets.get(i), num1 * 500000, chara);
                pot = ((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).pot;
                resist_poison = ((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).resist_poison;
                break;
            }
        }
        GameUtil.removemunber(chara, "宠物经验丹", num1);
        Vo_20481_0 vo_20481_0 = new Vo_20481_0();
        vo_20481_0.msg = ("你使用了#R" + num1 + "#n颗宠物经验丹。");
        vo_20481_0.time = 1562987118;
        GameObjectChar.send(new M20481_0(), vo_20481_0);


        List list = new LinkedList();
        list.add(Integer.valueOf(id));
        list.add(Integer.valueOf(pot));
        list.add(Integer.valueOf(resist_poison));
        GameObjectChar.send(new M65527_3(), list);
    }


    public int cmd() {
        return 41117;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C41117_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */