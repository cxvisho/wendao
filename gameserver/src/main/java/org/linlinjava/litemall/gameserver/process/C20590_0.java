package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_24505_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53569_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61545_0;
import org.linlinjava.litemall.gameserver.data.write.M16383_0;
import org.linlinjava.litemall.gameserver.data.write.M24505_0;
import org.linlinjava.litemall.gameserver.data.write.M53569_0;
import org.linlinjava.litemall.gameserver.data.write.M61545_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.springframework.stereotype.Service;


@Service
public class C20590_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int flag = GameReadTool.readShort(buff);

        String name = GameReadTool.readString(buff);

        int compress = GameReadTool.readShort(buff);

        int orgLength = GameReadTool.readShort(buff);

        String msg = GameReadTool.readString2(buff);

        int cardCount = GameReadTool.readShort(buff);

        int voiceTime = GameReadTool.readInt(buff);

        String token = GameReadTool.readString2(buff);

        String receive_gid = GameReadTool.readString(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;
        Characters characters = GameData.that.characterService.findOneByName(name);
        String data = characters.getData();
        Chara chara1 = (Chara) JSONUtils.parseObject(data, Chara.class);
        Vo_24505_0 vo_24505_0 = GameUtil.a24505(chara1);
        GameObjectChar.send(new M24505_0(), vo_24505_0);
        List<Vo_61545_0> vo_61545_0List = GameUtil.a61545(chara1);
        GameObjectChar.send(new M61545_0(), vo_61545_0List);
        Vo_16383_0 vo_16383_0 = GameUtil.a16383(chara, msg, 9, chara1);
        GameObjectChar.getGameObjectChar();
        GameObjectChar.send(new M16383_0(), vo_16383_0);
        if (GameObjectCharMng.getGameObjectChar(chara1.id) != null) {
            vo_16383_0 = GameUtil.a16383(chara, msg, 9);
            GameObjectCharMng.getGameObjectChar(chara1.id).sendOne(new M16383_0(), vo_16383_0);
            Vo_53569_0 vo_53569_0 = new Vo_53569_0();
            vo_53569_0.gid = receive_gid;
            vo_53569_0.online = 1;
            GameObjectChar.getGameObjectChar();
            GameObjectChar.send(new M53569_0(), vo_53569_0);
        } else {
            Vo_53569_0 vo_53569_0 = new Vo_53569_0();
            vo_53569_0.gid = receive_gid;
            vo_53569_0.online = 0;
            GameObjectChar.getGameObjectChar();
            GameObjectChar.send(new M53569_0(), vo_53569_0);
        }
    }


    public int cmd() {
        return 20590;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C20590_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */