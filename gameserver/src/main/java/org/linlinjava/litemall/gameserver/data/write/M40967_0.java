package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M40967_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<CreepsStore> list = (List) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(1));
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.size()));
        for (int i = 0; i < list.size(); i++) {
            GameWriteTool.writeString(writeBuf, ((CreepsStore) list.get(i)).getName());
            GameWriteTool.writeInt(writeBuf, ((CreepsStore) list.get(i)).getPrice());
            GameWriteTool.writeString(writeBuf, "cash");
        }
    }

    public int cmd() {
        return 40967;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M40967_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */