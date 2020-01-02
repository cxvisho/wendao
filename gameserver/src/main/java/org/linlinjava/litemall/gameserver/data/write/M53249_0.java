package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53249_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M53249_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_53249_0 object1 = (Vo_53249_0) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.type));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count));

        GameWriteTool.writeString(writeBuf, object1.name0);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price0));

        GameWriteTool.writeString(writeBuf, object1.name1);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price1));

        GameWriteTool.writeString(writeBuf, object1.name2);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price2));

        GameWriteTool.writeString(writeBuf, object1.name3);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price3));

        GameWriteTool.writeString(writeBuf, object1.name4);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price4));

        GameWriteTool.writeString(writeBuf, object1.name5);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price5));

        GameWriteTool.writeString(writeBuf, object1.name6);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price6));

        GameWriteTool.writeString(writeBuf, object1.name7);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price7));

        GameWriteTool.writeString(writeBuf, object1.name8);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price8));

        GameWriteTool.writeString(writeBuf, object1.name9);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price9));

        GameWriteTool.writeString(writeBuf, object1.name10);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price10));

        GameWriteTool.writeString(writeBuf, object1.name11);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.price11));
    }

    public int cmd() {
        return 53249;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M53249_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */