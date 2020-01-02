package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.db.domain.GroceriesShop;
import org.linlinjava.litemall.db.domain.MedicineShop;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M65503_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List object1 = (List) object;
        if ((object1.get(0) instanceof MedicineShop)) {
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(15907));
        } else {
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(15908));
        }

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(1));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(100));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(6));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.size()));

        for (int i = 0; i < object1.size(); i++) {
            if ((object1.get(i) instanceof MedicineShop)) {
                MedicineShop obj = (MedicineShop) object1.get(i);
                GameWriteTool.writeShort(writeBuf, obj.getGoodsNo());

                GameWriteTool.writeInt(writeBuf, obj.getPayType());

                GameWriteTool.writeShort(writeBuf, obj.getItemcount());

                GameWriteTool.writeString(writeBuf, obj.getName());

                GameWriteTool.writeInt(writeBuf, obj.getValue());

                GameWriteTool.writeShort(writeBuf, obj.getLevel());

                GameWriteTool.writeByte(writeBuf, obj.getType());
            } else {
                GroceriesShop obj = (GroceriesShop) object1.get(i);
                GameWriteTool.writeShort(writeBuf, obj.getGoodsNo());

                GameWriteTool.writeInt(writeBuf, obj.getPayType());

                GameWriteTool.writeShort(writeBuf, obj.getItemcount());

                GameWriteTool.writeString(writeBuf, obj.getName());

                GameWriteTool.writeInt(writeBuf, obj.getValue());

                GameWriteTool.writeShort(writeBuf, obj.getLevel());

                GameWriteTool.writeByte(writeBuf, obj.getType());
            }
        }


        GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));
    }

    public int cmd() {
        return 65503;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65503_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */