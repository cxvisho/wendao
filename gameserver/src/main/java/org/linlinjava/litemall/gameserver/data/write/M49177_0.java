package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49177_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M49177_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49177_0 object1 = (Vo_49177_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isPK));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.stageId));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.monsterPoint));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.pkValue));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.totalScore));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.startTime));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.stage1_duration_time));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.stage2_duration_time));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.rank));
    }

    public int cmd() {
        return 49177;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M49177_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */