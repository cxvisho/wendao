package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.write.M12016_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.domain.ShouHuShuXing;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C4347_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int guard_id = GameReadTool.readInt(buff);

        int cheer = GameReadTool.readByte(buff);
        Chara chara = GameObjectChar.getGameObjectChar().chara;


        for (int i = 0; i < chara.listshouhu.size(); i++) {
            if (guard_id == ((ShouHu) chara.listshouhu.get(i)).id) {
                if (cheer == 1) {
                    if (chara.canzhanshouhunumber == 0) {
                        chara.canzhanshouhunumber += 1;
                        ((ShouHuShuXing) ((ShouHu) chara.listshouhu.get(i)).listShouHuShuXing.get(0)).salary = 5;
                    } else {
                        ((ShouHuShuXing) ((ShouHu) chara.listshouhu.get(i)).listShouHuShuXing.get(0)).salary = chara.canzhanshouhunumber;
                        chara.canzhanshouhunumber += 1;
                    }
                }

                if (cheer == 0) {
                    ((ShouHuShuXing) ((ShouHu) chara.listshouhu.get(i)).listShouHuShuXing.get(0)).salary = 0;
                    chara.canzhanshouhunumber -= 1;
                }
                ((ShouHuShuXing) ((ShouHu) chara.listshouhu.get(i)).listShouHuShuXing.get(0)).nil = cheer;
                List<ShouHu> list = new LinkedList();
                list.add(chara.listshouhu.get(i));
                GameObjectChar.send(new M12016_0(), list);
            }
        }
    }


    public int cmd() {
        return 4347;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C4347_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */