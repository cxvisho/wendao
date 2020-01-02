package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53267_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M53267_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_53267_0 object1 = (Vo_53267_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count));

        GameWriteTool.writeString(writeBuf, object1.barcode0);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney0));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin0));

        GameWriteTool.writeString(writeBuf, object1.barcode1);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota1));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney1));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin1));

        GameWriteTool.writeString(writeBuf, object1.barcode2);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota2));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney2));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin2));

        GameWriteTool.writeString(writeBuf, object1.barcode3);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota3));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney3));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin3));

        GameWriteTool.writeString(writeBuf, object1.barcode4);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota4));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney4));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin4));

        GameWriteTool.writeString(writeBuf, object1.barcode5);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sale_quota5));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.toMoney5));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.costCoin5));
    }

    public int cmd() {
        return 53267;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M53267_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */