package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M61553_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61553_0 object1 = (Vo_61553_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count));
        for (int i = 0; i < object1.count; i++) {
            GameWriteTool.writeString(writeBuf, object1.task_type);

            GameWriteTool.writeString2(writeBuf, object1.task_desc);

            GameWriteTool.writeString2(writeBuf, object1.task_prompt);

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.refresh));

            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.task_end_time));

            GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.attrib));

            GameWriteTool.writeString2(writeBuf, object1.reward);

            GameWriteTool.writeString(writeBuf, object1.show_name);

            GameWriteTool.writeString(writeBuf, object1.tasktask_extra_para);

            GameWriteTool.writeString(writeBuf, object1.tasktask_state);
        }
    }

    public int cmd() {
        return 61553;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61553_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */