package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_2;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C8272_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int no = GameReadTool.readByte(buff);

        String name = GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;
        int id = 0;
        for (int i = 0; i < chara.pets.size(); i++) {
            if (((Petbeibao) chara.pets.get(i)).no == no) {
                id = ((Petbeibao) chara.pets.get(i)).id;
                ((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).str = name;
            }
        }
        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
        vo_8165_0.msg = "宠物名字修改成功。";
        vo_8165_0.active = 0;
        Vo_65527_0 vo_65527_35 = new Vo_65527_0();
        List list = new LinkedList();
        list.add(Integer.valueOf(id));
        list.add(name);
        GameObjectChar.send(new M65527_2(), list);
    }


    public int cmd() {
        return 8272;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C8272_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */