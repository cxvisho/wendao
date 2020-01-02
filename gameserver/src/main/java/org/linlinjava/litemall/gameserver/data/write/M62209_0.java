package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_62209_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M62209_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_62209_0> object1 = (List) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.size()));
        for (int i = 0; i < object1.size(); i++) {
            GameWriteTool.writeString(writeBuf, ((Vo_62209_0) object1.get(i)).stringformat);
            GameWriteTool.writeString(writeBuf, ((Vo_62209_0) object1.get(i)).title);
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(((Vo_62209_0) object1.get(i)).titled_left_time));
        }
    }


    public int cmd() {
        return 62209;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M62209_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */