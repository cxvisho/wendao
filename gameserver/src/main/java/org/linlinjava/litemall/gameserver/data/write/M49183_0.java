package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49183;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49183_0;

@org.springframework.stereotype.Service
public class M49183_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49183_0 object1 = (Vo_49183_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.totalPage));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.cur_page));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.vo_49183s.size()));

        for (int i = 0; i < object1.vo_49183s.size(); i++) {
            Vo_49183 vo_49183 = (Vo_49183) object1.vo_49183s.get(i);

            GameWriteTool.writeString(writeBuf, vo_49183.name);

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_49183.is_my_goods));

            GameWriteTool.writeString(writeBuf, vo_49183.id);

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_49183.price));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_49183.status));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_49183.startTime));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_49183.endTime));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_49183.level));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_49183.unidentified));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_49183.amount));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_49183.req_level));

            GameWriteTool.writeString(writeBuf, vo_49183.extra);

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_49183.item_polar));
        }


        GameWriteTool.writeString(writeBuf, object1.path_str);

        GameWriteTool.writeString(writeBuf, object1.select_gid);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.sell_stage));

        GameWriteTool.writeString(writeBuf, object1.sort_key);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_descending));
    }

    public int cmd() {
        return 49183;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M49183_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */