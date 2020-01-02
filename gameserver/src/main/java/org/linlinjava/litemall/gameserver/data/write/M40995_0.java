package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40995_0;

@org.springframework.stereotype.Service
public class M40995_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40995_0 object1 = (Vo_40995_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.flag));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.money));

        GameWriteTool.writeString(writeBuf, object1.surlus);

        GameWriteTool.writeString(writeBuf, object1.overflow);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.amount));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.choice));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.prize));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.leftCount));
    }

    public int cmd() {
        return 40995;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M40995_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */