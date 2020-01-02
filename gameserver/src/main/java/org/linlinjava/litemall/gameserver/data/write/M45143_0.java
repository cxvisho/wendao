package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45143_0;

@org.springframework.stereotype.Service
public class M45143_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45143_0 object1 = (Vo_45143_0) object;
        GameWriteTool.writeString(writeBuf, object1.line_name);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.expect_time));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.reconnet_time));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.waitCode));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.count));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.keep_alive));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.need_wait));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.indsider_lv));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.gold_coin));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.status));
    }

    public int cmd() {
        return 45143;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45143_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */