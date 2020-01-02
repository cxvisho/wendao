package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Duiyuan;
import org.linlinjava.litemall.gameserver.domain.LieBiao;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M53741_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<LieBiao> object1 = (List) object;

        if (object1.size() > 0) {
            GameWriteTool.writeString(writeBuf, ((LieBiao) object1.get(0)).ask_type);
        }


        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.size()));

        for (LieBiao lieBiao : object1) {
            GameWriteTool.writeString(writeBuf, lieBiao.peer_name);


            GameWriteTool.writeShort(writeBuf, Integer.valueOf(lieBiao.duiyuanList.size()));
            for (Duiyuan duiyuan : lieBiao.duiyuanList) {
                GameWriteTool.writeInt(writeBuf, Integer.valueOf(duiyuan.org_icon));

                Map<Object, Object> map = UtilObjMapshuxing.Duiyuan(duiyuan);
                map.remove("org_icon");
                map.remove("mapteamMembersCount");
                map.remove("mapcomeback_flag");


                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                Entry<Object, Object> entry;
                while (it.hasNext()) {
                    entry = (Entry) it.next();
                    if ((entry.getValue().equals(Integer.valueOf(0))) || (entry.getKey().equals(""))) {
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


                GameWriteTool.writeByte(writeBuf, Integer.valueOf(duiyuan.mapteamMembersCount));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(duiyuan.mapcomeback_flag));
            }
        }
    }


    public int cmd() {
        return 53741;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M53741_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */