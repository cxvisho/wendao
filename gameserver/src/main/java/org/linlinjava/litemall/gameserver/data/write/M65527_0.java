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
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65527_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M65527_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        ListVo_65527_0 listVo_65527_0 = (ListVo_65527_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(listVo_65527_0.id));
        Vo_65527_0 vo = listVo_65527_0.vo_65527_0;
        Map<Object, Object> map = new HashMap();
        map = UtilObjMap.Vo_65527_0(vo);
        Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
        Entry<Object, Object> entry;
        while (it.hasNext()) {
            entry = (Entry) it.next();
            if ((entry.getValue() instanceof Integer) ?
                    (!entry.getValue().equals(Integer.valueOf(0))) || (entry.getKey().equals("balance")) || (entry.getKey().equals("gender")) ||
                            (entry.getKey().equals("resist_metal")) || (entry.getKey().equals("wood")) || (entry.getKey().equals("water")) || (entry.getKey().equals("fire")) || (entry.getKey().equals("earth")) || (entry.getKey().equals("stamina")) || (entry.getKey().equals("marriage_book_id")) :


                    !entry.getValue().equals("")) {
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
    }


    public int cmd() {
        return 65527;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65527_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */