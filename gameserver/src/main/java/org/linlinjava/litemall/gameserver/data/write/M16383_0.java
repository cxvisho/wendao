package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M16383_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_16383_0 object1 = (Vo_16383_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.channel));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeString2(writeBuf, object1.msg);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.time));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.privilege));

        GameWriteTool.writeString(writeBuf, object1.server_name);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.show_extra));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.compress));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.orgLength));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.cardCount));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.voiceTime));

        GameWriteTool.writeString2(writeBuf, object1.token);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.checksum));


        Map<Object, Object> map = new HashMap();
        map = UtilObjMap.Vo_16383_0(object1);
        map.remove("channel");
        map.remove("id");

        map.remove("name");
        map.remove("msg");
        map.remove("time");
        map.remove("privilege");
        map.remove("server_name");
        map.remove("show_extra");

        map.remove("compress");
        map.remove("cardCount");
        map.remove("orgLength");
        map.remove("voiceTime");
        map.remove("token");
        map.remove("checksum");


        Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
        Entry<Object, Object> entry;
        while (it.hasNext()) {
            entry = (Entry) it.next();
            if (entry.getValue().equals(Integer.valueOf(0))) {
                it.remove();
            }
        }

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
        for (Entry<Object, Object> entry2 : map.entrySet()) {
            if (BuildFields.data.get((String) entry2.getKey()) != null) {
                BuildFields.get((String) entry2.getKey()).write(writeBuf, entry2.getValue());
            } else {
                System.out.println(entry2.getKey());
            }
        }
    }

    public int cmd() {
        return 16383;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M16383_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */