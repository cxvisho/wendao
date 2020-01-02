package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M12023_1
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_12023_0 object1 = (Vo_12023_0) object;

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.owner_id));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));
    }


    public int cmd() {
        return 12023;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M12023_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */