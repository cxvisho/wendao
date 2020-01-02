package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M61671_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61671_0 object1 = (Vo_61671_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.count));
        for (int i = 0; i < object1.count; i++) {
            GameWriteTool.writeByte(writeBuf, (Integer) object1.list.get(i));
        }
    }

    public int cmd() {
        return 61671;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61671_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */