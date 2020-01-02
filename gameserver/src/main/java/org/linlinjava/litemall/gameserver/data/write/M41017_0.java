package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M41017_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(4));

        GameWriteTool.writeString(writeBuf, "xiux");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");
    }

    public int cmd() {
        return 41017;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M41017_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */