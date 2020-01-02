package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.domain.ShouHuShuXing;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;


@Service
public class M12016_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<ShouHu> object1 = (List) object;

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.size()));
        for (int i = 0; i < object1.size(); i++) {
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(((ShouHu) object1.get(i)).id));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(((ShouHu) object1.get(i)).listShouHuShuXing.size()));
            for (int j = 0; j < ((ShouHu) object1.get(i)).listShouHuShuXing.size(); j++) {
                ShouHuShuXing shouHuShuXing = (ShouHuShuXing) ((ShouHu) object1.get(i)).listShouHuShuXing.get(j);

                Map<Object, Object> map = new HashMap();
                if (shouHuShuXing != null) {
                    map = UtilObjMapshuxing.ShouHuShuXing(shouHuShuXing);
                    map.remove("no");
                    map.remove("type1");

                    GameWriteTool.writeByte(writeBuf, Integer.valueOf(shouHuShuXing.no));
                    GameWriteTool.writeByte(writeBuf, Integer.valueOf(shouHuShuXing.type1));
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
        }
    }


    public int cmd() {
        return 12016;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M12016_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */