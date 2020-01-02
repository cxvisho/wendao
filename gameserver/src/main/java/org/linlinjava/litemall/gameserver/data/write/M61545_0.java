package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61545_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M61545_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_61545_0> vo_61545_0List = (List) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_61545_0List.size()));
        for (Vo_61545_0 object1 : vo_61545_0List) {
            GameWriteTool.writeString(writeBuf, object1.groupBuf);

            GameWriteTool.writeString(writeBuf, object1.charBuf);

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.blocked));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.online));

            GameWriteTool.writeString(writeBuf, object1.server_name1);

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.insider_level));

            Map<Object, Object> map = UtilObjMap.Vo_61545_0(object1);
            map.remove("groupBuf");
            map.remove("charBuf");
            map.remove("blocked");
            map.remove("online");
            map.remove("server_name1");
            map.remove("insider_level");


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
    }


    public int cmd() {
        return 61545;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61545_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */