package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20467_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M20467_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_20467_0 object1 = (Vo_20467_0) object;
        GameWriteTool.writeString(writeBuf, object1.caption);

        GameWriteTool.writeString(writeBuf, object1.content);

        GameWriteTool.writeString(writeBuf, object1.peer_name);

        GameWriteTool.writeString(writeBuf, object1.ask_type);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(1));
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.org_icon));

        Map<Object, Object> map = UtilObjMap.Vo_20467_0(object1);
        map.remove("caption");
        map.remove("content");
        map.remove("org_icon");

        map.remove("peer_name");
        map.remove("ask_type");
        map.remove("teamMembersCount");

        map.remove("comeback_flag");

        Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
        Entry<Object, Object> entry;
        while (it.hasNext()) {
            entry = (Entry) it.next();
            if ((entry.getValue() instanceof Integer)) {
                if (entry.getValue().equals(Integer.valueOf(0))) {
                    it.remove();
                }
            } else if (entry.getValue() == null) {
                it.remove();
            }
        }

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
        for (Entry<Object, Object> objectEntry : map.entrySet()) {
            if (BuildFields.data.get((String) objectEntry.getKey()) != null) {
                BuildFields.get((String) objectEntry.getKey()).write(writeBuf, objectEntry.getValue());
            } else {
                System.out.println(objectEntry.getKey());
            }
        }


        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.teamMembersCount));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.comeback_flag));
    }

    public int cmd() {
        return 20467;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M20467_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */