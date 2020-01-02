package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36889_0;

@org.springframework.stereotype.Service
public class M36889_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_36889_0 object1 = (Vo_36889_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.count));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.auto_select));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.multi_index));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.action));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.para));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.multi_count));
    }

    public int cmd() {
        return 36889;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M36889_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */