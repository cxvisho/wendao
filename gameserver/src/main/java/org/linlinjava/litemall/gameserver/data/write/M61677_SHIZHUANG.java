package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M61677_SHIZHUANG extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61677_0 object1 = (Vo_61677_0) object;
        GameWriteTool.writeString(writeBuf, object1.store_type);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.npcID));


        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));
    }


    public int cmd() {
        return 61677;
    }

    public boolean weizhi(List<Goods> list, int j) {
        HashMap<Object, Object> map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(Integer.valueOf(((Goods) list.get(i)).pos), Integer.valueOf(((Goods) list.get(i)).pos));
        }
        if (map.get(Integer.valueOf(j)) == null) {
            return true;
        }
        return false;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61677_SHIZHUANG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */