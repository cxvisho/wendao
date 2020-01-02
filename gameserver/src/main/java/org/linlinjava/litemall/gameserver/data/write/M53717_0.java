package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53717_0;

@org.springframework.stereotype.Service
public class M53717_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_53717_0 object1 = (Vo_53717_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.attacker_id));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.victim_id));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.type));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.result));

        GameWriteTool.writeString(writeBuf, object1.itemName);
    }

    public int cmd() {
        return 53717;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M53717_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */