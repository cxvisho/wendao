package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;

@org.springframework.stereotype.Service
public class M65505_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_65505_0 object1 = (Vo_65505_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.map_id));

        GameWriteTool.writeString(writeBuf, object1.map_name);

        GameWriteTool.writeString(writeBuf, object1.map_show_name);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.x));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.y));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.map_index));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.compact_map_index));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.floor_index));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.wall_index));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_safe_zone));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_task_walk));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.enter_effect_index));
    }

    public int cmd() {
        return 65505;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65505_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */