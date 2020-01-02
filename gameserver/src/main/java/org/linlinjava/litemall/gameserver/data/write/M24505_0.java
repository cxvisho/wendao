package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_24505_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;


@Service
public class M24505_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_24505_0 object1 = (Vo_24505_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.update_type));

        GameWriteTool.writeString(writeBuf, object1.groupBuf);

        GameWriteTool.writeString(writeBuf, object1.charBuf);


        Map<Object, Object> map = UtilObjMap.Vo_24505_0(object1);
        map.remove("update_type");
        map.remove("groupBuf");
        map.remove("charBuf");

        Iterator<Entry<Object, Object>> it = map.entrySet().iterator();


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
        return 24505;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M24505_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */