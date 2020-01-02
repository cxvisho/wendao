package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M41480_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_41480_0> object1 = (List) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(((Vo_41480_0) object1.get(0)).online_time));
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.size()));
        for (int i = 0; i < object1.size(); i++) {
            Vo_41480_0 object2 = (Vo_41480_0) object1.get(i);
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object2.index));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object2.time));

            GameWriteTool.writeString(writeBuf, object2.name);

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object2.brate));
        }
    }

    public int cmd() {
        return 41480;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M41480_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */