package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_11757_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M11757_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_11757_0 object1 = (Vo_11757_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.list.size()));
        for (Integer integer : object1.list) {
            GameWriteTool.writeInt(writeBuf, integer);
        }
    }


    public int cmd() {
        return 11757;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M11757_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */