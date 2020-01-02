package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65017_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M65017_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_65017_0> obj = (List) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(obj.size()));
        for (int i = 0; i < obj.size(); i++) {
            Vo_65017_0 object1 = (Vo_65017_0) obj.get(i);

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.leader));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.weapon_icon));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.pos));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.rank));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.vip_type));


            Map<Object, Object> map = new HashMap();
            map = UtilObjMap.Vo_65017_0(object1);
            map.remove("id");
            map.remove("leader");
            map.remove("weapon_icon");
            map.remove("pos");
            map.remove("rank");
            map.remove("vip_type");
            map.remove("org_icon");
            map.remove("suit_icon");
            map.remove("suit_light_effect");
            map.remove("special_icon");

            Iterator<Entry<Object, Object>> it = map.entrySet().iterator();


            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.org_icon));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_icon));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_light_effect));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.special_icon));
        }


        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));
    }

    public int cmd() {
        return 65017;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65017_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */