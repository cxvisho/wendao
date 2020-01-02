package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32896_0;

@org.springframework.stereotype.Service
public class M32896_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_32896_0 object1 = (Vo_32896_0) object;
        GameWriteTool.writeString(writeBuf, object1.alias0);

        GameWriteTool.writeString(writeBuf, object1.alias1);

        GameWriteTool.writeString(writeBuf, object1.alias2);

        GameWriteTool.writeString(writeBuf, object1.alias3);

        GameWriteTool.writeString(writeBuf, object1.alias4);

        GameWriteTool.writeString(writeBuf, object1.alias5);

        GameWriteTool.writeString(writeBuf, object1.alias6);
    }

    public int cmd() {
        return 32896;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32896_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */