package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7655_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M7655_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_7655_0 object1 = (Vo_7655_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));
    }

    public int cmd() {
        return 7655;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M7655_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */