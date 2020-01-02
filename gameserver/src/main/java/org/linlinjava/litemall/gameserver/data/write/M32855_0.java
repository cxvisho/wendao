package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32855_0;

@org.springframework.stereotype.Service
public class M32855_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_32855_0 object1 = (Vo_32855_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.enable));

        GameWriteTool.writeString(writeBuf, object1.url);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.sellCashAfterDays));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isSellCash));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.recommendPrice));
    }

    public int cmd() {
        return 32855;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32855_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */