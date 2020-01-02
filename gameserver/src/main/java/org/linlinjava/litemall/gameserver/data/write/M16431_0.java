package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16431_0;

@org.springframework.stereotype.Service
public class M16431_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_16431_0 object1 = (Vo_16431_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.x));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.y));
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(1));
    }

    public int cmd() {
        return 16431;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M16431_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */