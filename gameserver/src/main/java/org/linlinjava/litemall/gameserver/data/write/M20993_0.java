package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20993_0;

@org.springframework.stereotype.Service
public class M20993_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_20993_0 object1 = (Vo_20993_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_startup));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.total_online));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.last_online));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.adult_status));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.switch3));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.switch5));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.second_enable));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.switch7));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.player_age));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_guest));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.small_age));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.young_coin_cost_limit));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.small_age_online));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.young_online));
    }

    public int cmd() {
        return 20993;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M20993_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */