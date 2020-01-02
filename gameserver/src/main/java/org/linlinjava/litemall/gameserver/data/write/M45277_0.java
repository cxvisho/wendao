package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45277_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M45277_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45277_0 object1 = (Vo_45277_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.server_type));
    }

    public int cmd() {
        return 45277;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45277_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */