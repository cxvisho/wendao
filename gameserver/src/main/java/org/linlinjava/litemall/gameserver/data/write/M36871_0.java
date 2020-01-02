package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36871_0;

@org.springframework.stereotype.Service
public class M36871_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_36871_0 object1 = (Vo_36871_0) object;
        GameWriteTool.writeString(writeBuf, object1.msg_type);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.level));

        GameWriteTool.writeString(writeBuf, object1.gid);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeString(writeBuf, object1.party);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.friend_score));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.setting_flag));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.char_status));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.vip));

        GameWriteTool.writeString(writeBuf, object1.serverId);

        GameWriteTool.writeString(writeBuf, object1.account);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.polar));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isInThereFrend));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.ringScore));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.comeback_flag));
    }

    public int cmd() {
        return 36871;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M36871_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */