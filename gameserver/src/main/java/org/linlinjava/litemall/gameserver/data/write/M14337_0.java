package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_14337_0;

@org.springframework.stereotype.Service
public class M14337_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_14337_0 object1 = (Vo_14337_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.type));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.life_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.max_life_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.mana_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.max_mana_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.phy_power_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.mag_power_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.speed_plus));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.def_plus));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.free));
    }

    public int cmd() {
        return 14337;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M14337_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */