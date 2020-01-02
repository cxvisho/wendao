package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49179;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49179_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M49179_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49179_0 object1 = (Vo_49179_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.dealNum));

        GameWriteTool.writeString(writeBuf, object1.sellCash);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.stallTotalNum));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.record_count_max));

        List<Vo_49179> vo_49179 = object1.vo_49179s;

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_49179.size()));

        for (int i = 0; i < vo_49179.size(); i++) {
            Vo_49179 vo_491791 = (Vo_49179) vo_49179.get(i);

            GameWriteTool.writeString(writeBuf, vo_491791.name);

            GameWriteTool.writeString(writeBuf, vo_491791.id);

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_491791.price));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_491791.pos));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_491791.status));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_491791.startTime));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_491791.endTime));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_491791.level));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_491791.unidentified));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_491791.amount));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_491791.req_level));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_491791.extra));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_491791.item_polar));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_491791.cg_price_count));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_491791.init_price));
        }
    }

    public int cmd() {
        return 49179;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M49179_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */