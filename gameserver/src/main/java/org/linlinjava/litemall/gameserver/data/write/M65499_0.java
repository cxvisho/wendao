package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.db.domain.StoreGoods;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;


@Service
public class M65499_0
        extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<StoreGoods> list = (List) object;
        GameWriteTool.writeString(writeBuf, "");

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(0));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.size()));

        for (int i = 0; i < list.size(); i++) {
            GameWriteTool.writeString(writeBuf, ((StoreGoods) list.get(i)).getName());

            GameWriteTool.writeString(writeBuf, ((StoreGoods) list.get(i)).getBarcode());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getForSale());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getShowPos());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getRpos());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getSaleQuota());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getRecommend());

            GameWriteTool.writeInt(writeBuf, ((StoreGoods) list.get(i)).getCoin());

            GameWriteTool.writeByte(writeBuf, ((StoreGoods) list.get(i)).getDiscount());

            GameWriteTool.writeInt(writeBuf, ((StoreGoods) list.get(i)).getDiscount());

            GameWriteTool.writeByte(writeBuf, ((StoreGoods) list.get(i)).getType());

            GameWriteTool.writeShort(writeBuf, ((StoreGoods) list.get(i)).getQuotaLimit());

            GameWriteTool.writeByte(writeBuf, ((StoreGoods) list.get(i)).getMustVip());

            GameWriteTool.writeByte(writeBuf, ((StoreGoods) list.get(i)).getIsGift());

            GameWriteTool.writeByte(writeBuf, ((StoreGoods) list.get(i)).getFollowPetType());
        }
    }

    public int cmd() {
        return 65499;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65499_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */