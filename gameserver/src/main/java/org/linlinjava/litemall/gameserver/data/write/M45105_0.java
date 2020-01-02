package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45105_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M45105_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45105_0 object1 = (Vo_45105_0) object;
        GameWriteTool.writeString(writeBuf, object1.goodId);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.status));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.endTime));

        Petbeibao list = object1.petbeibao;


        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.petShuXing.size()));
        for (int j = 0; j < list.petShuXing.size(); j++) {
            PetShuXing petShuXing = (PetShuXing) list.petShuXing.get(j);
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(((PetShuXing) list.petShuXing.get(j)).no));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(((PetShuXing) list.petShuXing.get(j)).type1));

            Map<Object, Object> map = new HashMap();
            map = UtilObjMapshuxing.PetShuXing(petShuXing);
            map.remove("no");
            map.remove("type1");


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
        return 45105;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45105_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */