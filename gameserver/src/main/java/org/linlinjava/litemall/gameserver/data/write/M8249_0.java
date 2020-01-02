package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8249_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M8249_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_8249_0 object1 = (Vo_8249_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.start_range));
    }

    public int cmd() {
        return 8249;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M8249_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */