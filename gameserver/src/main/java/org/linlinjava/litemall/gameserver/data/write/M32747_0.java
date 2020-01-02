package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32747_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;


@Service
public class M32747_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_32747_0> obj = (List) object;
        if (obj.size() > 0) {
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(((Vo_32747_0) obj.get(0)).id));
        }

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(obj.size()));
        for (int i = 0; i < obj.size(); i++) {
            Vo_32747_0 object1 = (Vo_32747_0) obj.get(i);

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.skill_no));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.skill_attrib1));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.skill_level));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.level_improved));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.skill_mana_cost));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.skill_nimbus));

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.skill_disabled));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.range));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.max_range));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count1));

            for (int j = 0; j < object1.count1; j++) {
                GameWriteTool.writeString(writeBuf, object1.s1);

                GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.s2));
            }

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isTempSkill));
        }
    }


    public int cmd() {
        return 32747;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32747_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */