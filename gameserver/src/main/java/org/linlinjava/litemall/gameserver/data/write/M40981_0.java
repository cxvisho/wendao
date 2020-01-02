package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40981_0;

@org.springframework.stereotype.Service
public class M40981_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40981_0 object1 = (Vo_40981_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.start_time));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.end_time));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.icon));

        GameWriteTool.writeString(writeBuf, object1.word);

        GameWriteTool.writeString(writeBuf, object1.gather_style);
    }

    public int cmd() {
        return 40981;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M40981_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */