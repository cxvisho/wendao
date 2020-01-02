package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_61537_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61537_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M61537_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        ListVo_61537_0 vo_61537_0 = (ListVo_61537_0) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_61537_0.a));
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(vo_61537_0.count));

        for (Vo_61537_0 vo : vo_61537_0.vo_61537_0) {
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(17));
            BuildFields.get("extra_desc").write(writeBuf, Integer.valueOf(vo.extra_desc));
            BuildFields.get("trading_sell_buy_type").write(writeBuf, Integer.valueOf(vo.trading_sell_buy_type));
            BuildFields.get("trading_state").write(writeBuf, vo.trading_state);
            BuildFields.get("passive_mode").write(writeBuf, Integer.valueOf(vo.passive_mode));
            BuildFields.get("trading_left_time").write(writeBuf, Integer.valueOf(vo.trading_left_time));
            BuildFields.get("trading_buyout_price").write(writeBuf, vo.trading_buyout_price);
            BuildFields.get("trading_price").write(writeBuf, Integer.valueOf(vo.trading_price));
            BuildFields.get("skill").write(writeBuf, Integer.valueOf(vo.skill));
            BuildFields.get("metal").write(writeBuf, Integer.valueOf(vo.metal));
            BuildFields.get("type").write(writeBuf, Integer.valueOf(vo.type));
            BuildFields.get("trading_cg_price_ti").write(writeBuf, Integer.valueOf(vo.trading_cg_price_ti));
            BuildFields.get("str").write(writeBuf, vo.str);
            BuildFields.get("iid_str").write(writeBuf, vo.iid_str);
            BuildFields.get("dan_data/state").write(writeBuf, Integer.valueOf(vo.dan_datastate));
            BuildFields.get("char_online_state").write(writeBuf, Integer.valueOf(vo.char_online_state));
            BuildFields.get("trading_org_price").write(writeBuf, Integer.valueOf(vo.trading_org_price));
            BuildFields.get("trading_appointee_name").write(writeBuf, Integer.valueOf(vo.trading_appointee_name));
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo.last_login_time));
        }
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(vo_61537_0.c));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(vo_61537_0.d));
    }

    public int cmd() {
        return 61537;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61537_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */