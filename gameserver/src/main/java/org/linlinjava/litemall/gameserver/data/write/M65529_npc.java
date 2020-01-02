package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M65529_npc
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Npc npc = (Npc) object;

        GameWriteTool.writeInt(writeBuf, npc.getId());

        GameWriteTool.writeShort(writeBuf, npc.getX());

        GameWriteTool.writeShort(writeBuf, npc.getY());

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(7));

        GameWriteTool.writeInt(writeBuf, npc.getIcon());

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(4));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeString(writeBuf, npc.getName());

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, npc.getIcon());

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));
    }

    public int cmd() {
        return 65529;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65529_npc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */