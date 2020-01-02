package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53411_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.write.M53411_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameMap;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C53412_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int petId = GameReadTool.readInt(buff);

        int isHide = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        List list = new LinkedList();
        list.add(Integer.valueOf(petId));
        list.add(Integer.valueOf(isHide));
        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65527_4(), list);

        if (isHide == 1) {
            chara.zuowaiguan = 0;
            chara.zuoqiwaiguan = 0;
        }
        if (isHide == 0) {
            for (int i = 0; i < chara.pets.size(); i++) {
                if (petId == ((Petbeibao) chara.pets.get(i)).id) {
                    chara.zuoqiwaiguan = (((PetShuXing) ((Petbeibao) chara.pets.get(i)).petShuXing.get(0)).type + 1000);
                    chara.zuowaiguan = typeMounts(chara.zuoqiwaiguan, chara.menpai, chara.sex - 1);
                }
            }
        }
        Vo_53411_0 vo_53411_0 = new Vo_53411_0();
        vo_53411_0.petId = petId;
        vo_53411_0.isHide = isHide;
        GameObjectChar.send(new M53411_0(), vo_53411_0);


        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectChar.getGameObjectChar().gameMap.send(new M61661_0(), vo_61661_0);
    }


    public int cmd() {
        return 53412;
    }


    private static int typeMounts(int type, int polar, int sex) {
        if (type == 31025) {
            int[][] type_31025 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31025[sex][(polar - 1)];
        }
        if (type == 31010) {
            int[][] type_31010 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31010[sex][(polar - 1)];
        }
        if (type == 31011) {
            int[][] type_31011 = {{760021, 770022, 770023, 760024, 760025, 760020}, {770021, 760022, 760023, 770024, 770025, 770020}};
            return type_31011[sex][(polar - 1)];
        }
        if (type == 31013) {
            int[][] type_31013 = {{760021, 770022, 770023, 760024, 760025, 760020}, {770021, 760022, 760023, 770024, 770025, 770020}};
            return type_31013[sex][(polar - 1)];
        }
        if (type == 31029) {
            int[][] type_31029 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31029[sex][(polar - 1)];
        }
        if (type == 31026) {
            int[][] type_31026 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31026[sex][(polar - 1)];
        }
        if (type == 31001) {
            int[][] type_31001 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31001[sex][(polar - 1)];
        }
        if (type == 31019) {
            int[][] type_31019 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31019[sex][(polar - 1)];
        }
        if (type == 31003) {
            int[][] type_31003 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31003[sex][(polar - 1)];
        }
        if (type == 31020) {
            int[][] type_31020 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31020[sex][(polar - 1)];
        }
        if (type == 31021) {
            int[][] type_31021 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31021[sex][(polar - 1)];
        }
        if (type == 31006) {
            int[][] type_31006 = {{760011, 770012, 770013, 760014, 760015, 760010}, {770011, 760012, 760013, 770014, 770015, 770010}};
            return type_31006[sex][(polar - 1)];
        }
        if (type == 31023) {
            int[][] type_31023 = {{760031, 770032, 770033, 760034, 760035, 760030}, {770021, 760022, 760023, 770024, 770025, 770030}};
            return type_31023[sex][(polar - 1)];
        }

        return 0;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C53412_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */