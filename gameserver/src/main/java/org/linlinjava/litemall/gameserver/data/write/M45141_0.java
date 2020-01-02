package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45141_0;

@org.springframework.stereotype.Service
public class M45141_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45141_0 object1 = (Vo_45141_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.round));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.animate_done));
    }

    public int cmd() {
        return 45141;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45141_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */