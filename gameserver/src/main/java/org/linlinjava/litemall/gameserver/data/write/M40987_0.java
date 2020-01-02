package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40987_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M40987_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40987_0 object1 = (Vo_40987_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.petId));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.count));
    }

    public int cmd() {
        return 40987;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M40987_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */