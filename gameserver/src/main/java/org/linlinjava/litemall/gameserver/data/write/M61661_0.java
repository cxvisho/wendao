package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M61661_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61661_0 object1 = (Vo_61661_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.id));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.x));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.y));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.dir));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.weapon_icon));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.type));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.sub_type));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.owner_id));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.leader_id));

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.level));

        GameWriteTool.writeString(writeBuf, object1.title);

        GameWriteTool.writeString(writeBuf, object1.family);

        GameWriteTool.writeString(writeBuf, object1.partyname);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.status));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.special_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.org_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_light_effect));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.guard_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.pet_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.shadow_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.shelter_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.mount_icon));

        GameWriteTool.writeString(writeBuf, object1.alicename);

        GameWriteTool.writeString(writeBuf, object1.gid);

        GameWriteTool.writeString(writeBuf, object1.camp);

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.vip_type));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isHide));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.moveSpeedPercent));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.score));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.opacity));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.masquerade));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.upgradestate));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.upgradetype));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.obstacle));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.light_effect_count));

        for (int i = 0; i < object1.light_effect_count; i++) {
            GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.effect));
        }
    }


    public int cmd() {
        return 61661;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61661_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */