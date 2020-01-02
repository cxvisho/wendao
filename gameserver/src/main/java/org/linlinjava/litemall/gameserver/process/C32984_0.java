package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.fight.FightContainer;
import org.linlinjava.litemall.gameserver.fight.FightManager;
import org.linlinjava.litemall.gameserver.fight.FightObject;
import org.linlinjava.litemall.gameserver.fight.FightRequest;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C32984_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int id = GameReadTool.readInt(buff);

        int auto_select = GameReadTool.readByte(buff);

        int multi_index = GameReadTool.readByte(buff);

        int action = GameReadTool.readByte(buff);

        int para = GameReadTool.readInt(buff);

        int multi_count = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        boolean match = false;
        if (chara.id == id) {
            match = true;
        } else {
            Petbeibao pet = null;
            List<Petbeibao> pets = chara.pets;
            for (int j = 0; j < pets.size(); j++) {
                if ((((Petbeibao) pets.get(j)).id == chara.chongwuchanzhanId) && (((Petbeibao) pets.get(j)).id == id)) {
                    pet = (Petbeibao) pets.get(j);
                    break;
                }
            }
            if (pet != null) {
                match = true;
            }
        }
        if (match) {
            FightObject fightObject = FightManager.getFightObject(id);

            if (fightObject != null) {
                fightObject.autofight_skillaction = action;
                fightObject.autofight_select = auto_select;
                fightObject.autofight_skillno = para;
                FightContainer fightContainer = FightManager.getFightContainer();
                if (fightContainer.state.intValue() == 3) {
                    return;
                }

                FightRequest fightRequest = new FightRequest();
                fightRequest.id = id;
                fightRequest.action = action;
                fightRequest.para = para;
                FightManager.generateActionDM(FightManager.getFightContainer(), fightObject, fightRequest);
                FightManager.addRequest(FightManager.getFightContainer(), fightRequest);
            }
        }
    }

    public int cmd() {
        return 32984;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C32984_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */