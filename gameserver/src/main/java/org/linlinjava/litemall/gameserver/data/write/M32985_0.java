package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32985_0;

@org.springframework.stereotype.Service
public class M32985_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_32985_0 object1 = (Vo_32985_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.user_is_multi));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.user_round));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.user_action));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.user_next_action));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.user_para));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.user_next_para));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.pet_is_multi));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.pet_round));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.pet_action));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.pet_next_action));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.pet_para));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.pet_next_para));
    }

    public int cmd() {
        return 32985;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32985_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */