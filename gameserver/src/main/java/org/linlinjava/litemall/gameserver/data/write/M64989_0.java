package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;

@org.springframework.stereotype.Service
public class M64989_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_64989_0 object1 = (Vo_64989_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.hid));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.a));


        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.list.size()));

        for (int i = 0; i < object1.list.size(); i++) {
            GameWriteTool.writeInt(writeBuf, (Integer) object1.list.get(i));
        }
        for (int i = 0; i < object1.missList.size(); i++) {
            GameWriteTool.writeShort(writeBuf, (Integer) object1.missList.get(i));
        }
    }

    public int cmd() {
        return 64989;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M64989_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */