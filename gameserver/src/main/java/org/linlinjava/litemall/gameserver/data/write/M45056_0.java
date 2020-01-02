package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45056_0;

@org.springframework.stereotype.Service
public class M45056_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45056_0 object1 = (Vo_45056_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.portrait));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.pic_no));

        GameWriteTool.writeString2(writeBuf, object1.content);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.isComplete));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isInCombat));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.playTime));

        GameWriteTool.writeString(writeBuf, object1.task_type);
    }

    public int cmd() {
        return 45056;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45056_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */