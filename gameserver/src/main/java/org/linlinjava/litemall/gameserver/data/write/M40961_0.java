package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40961_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M40961_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40961_0 object1 = (Vo_40961_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count));

        GameWriteTool.writeString(writeBuf, object1.id);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.type));

        GameWriteTool.writeString(writeBuf, object1.sender);

        GameWriteTool.writeString(writeBuf, object1.title);

        GameWriteTool.writeString2(writeBuf, object1.msg);

        GameWriteTool.writeString2(writeBuf, object1.attachment);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.create_time));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.expired_time));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.status));
    }

    public int cmd() {
        return 40961;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M40961_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */