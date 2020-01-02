package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45240_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M45240_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45240_0 object1 = (Vo_45240_0) object;
        GameWriteTool.writeString(writeBuf, object1.tips);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.down_count));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.only_confirm));

        GameWriteTool.writeString(writeBuf, object1.confirm_type);

        GameWriteTool.writeString(writeBuf, object1.confirmText);

        GameWriteTool.writeString(writeBuf, object1.cancelText);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.show_dlg_mode));

        GameWriteTool.writeString(writeBuf, object1.countDownTips);

        GameWriteTool.writeString2(writeBuf, object1.para_str);
    }

    public int cmd() {
        return 45240;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M45240_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */