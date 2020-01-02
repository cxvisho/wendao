package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49159_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

@org.springframework.stereotype.Service
public class M49159_0 extends BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49159_0 object1 = (Vo_49159_0) object;
        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.leftTime));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.times));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.leftTimes));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isCanSign));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isCanGetNewPalyerGift));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.firstChargeState));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.cumulativeReward));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.loginGiftState));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.activeCount));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.holidayCount));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isCanReplenishSign));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.chargePointFlag));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.consumePointFlag));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isShowHuiGui));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.canGetZXQYHuoYue));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.canGetZXQYSevenLogin));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isShowZhaohui));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.activeVIPFlag));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.rename_discount_time));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.summerSF2017));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.zaohua));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.welcomeDrawStatue));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.activeLoginStatue));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.xundcf));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.mergeLoginStatus));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.mergeLoginActiveStatus));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.reentryAsktaoRecharge));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.expStoreStatus));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isShowXYFL));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isShowXFSD));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.newServeAddNum));
    }

    public int cmd() {
        return 49159;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M49159_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */