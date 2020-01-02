package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.ZbAttribute;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M64991_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        ZbAttribute object1 = (ZbAttribute) object;
        Map<Object, Object> map = new HashMap();
        if (object1 != null) {
            map = UtilObjMapshuxing.ZbAttribute(object1);
            Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
            map.remove("id");
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));


            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }
        }
    }

    public int cmd() {
        return 64991;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M64991_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */