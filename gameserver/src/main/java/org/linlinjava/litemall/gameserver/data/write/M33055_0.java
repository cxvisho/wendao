package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_33055_0;

@org.springframework.stereotype.Service
public class M33055_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_33055_0 object1 = (Vo_33055_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.is_enable));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.enable_gold_stall_cash));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.sell_cash_aft_days));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.start_gold_stall_cash));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.enable_appoint));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.enable_autcion));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.close_time));
    }

    public int cmd() {
        return 33055;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M33055_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */