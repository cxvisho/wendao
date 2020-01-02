package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;

@org.springframework.stereotype.Service
public class M20480_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_20480_0 object1 = (Vo_20480_0) object;
        GameWriteTool.writeString2(writeBuf, object1.msg);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.time));
    }

    public int cmd() {
        return 20480;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M20480_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */