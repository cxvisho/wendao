package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M65531_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<NpcPoint> list = (List) object;

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(1));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.size()));
        for (NpcPoint npcPoint : list) {
            GameWriteTool.writeString(writeBuf, npcPoint.getDoorname());

            GameWriteTool.writeShort(writeBuf, npcPoint.getX());

            GameWriteTool.writeShort(writeBuf, npcPoint.getY());

            GameWriteTool.writeShort(writeBuf, npcPoint.getZ());
        }
    }

    public int cmd() {
        return 65531;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65531_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */