package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45128_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M45128_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45128_0 object1 = (Vo_45128_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(1));


        Map<Object, Object> map = new HashMap();
        map = UtilObjMap.Vo_45128_0(object1);
        map.remove("no");
        map.remove("type1");
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.no));
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.type1));
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
        for (Entry<Object, Object> entry : map.entrySet()) {
            if (BuildFields.data.get((String) entry.getKey()) != null) {
                BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
            } else {
                System.out.println(entry.getKey());
            }
        }
    }

    public int cmd() {
        return 45128;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45128_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */