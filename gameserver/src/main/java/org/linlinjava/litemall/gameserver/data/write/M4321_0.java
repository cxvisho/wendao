package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4321_0;

@org.springframework.stereotype.Service
public class M4321_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_4321_0 object1 = (Vo_4321_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.flag));

        GameWriteTool.writeString(writeBuf, object1.dist);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.time));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.a));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.b));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.c));
    }

    public int cmd() {
        return 4321;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M4321_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */