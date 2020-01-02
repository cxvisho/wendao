package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import org.json.JSONObject;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.service.base.BaseAccountsService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_61537_0;
import org.linlinjava.litemall.gameserver.data.write.M61537_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.netty.ServerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class C12290_0 implements GameHandler {
    private static final Logger logger = LoggerFactory.getLogger(C12290_0.class);


    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        String account = GameReadTool.readString(buff);
           /* JSONObject jo = new JSONObject(account);
            String o = (String) jo.get("account");*/
        String user = account.substring(6);
        int auth_key = GameReadTool.readInt(buff);

        int seed = GameReadTool.readInt(buff);

        int emulator = GameReadTool.readByte(buff);

        int sight_scope = GameReadTool.readByte(buff);

        String version = GameReadTool.readString(buff);

        String clientid = GameReadTool.readString(buff);

        int netStatus = GameReadTool.readShort(buff);

        int adult = GameReadTool.readByte(buff);

        String signature = GameReadTool.readString(buff);

        String clientname = GameReadTool.readString(buff);

        int redfinger = GameReadTool.readByte(buff);

        Accounts accounts = GameData.that.baseAccountsService.findOneByToken(user);
        java.util.List<Characters> charactersList = GameData.that.characterService.findByAccountId(accounts.getId());
        ListVo_61537_0 listvo_61537_0 = C8284_0.listjiaose(charactersList);


        ByteBuf write = new M61537_0().write(listvo_61537_0);
        ctx.writeAndFlush(write);


        GameObjectChar gameSession = new GameObjectChar(accounts.getId().intValue(), ctx);
        Attribute<GameObjectChar> attr = ctx.channel().attr(ServerHandler.akey);
        attr.set(gameSession);
    }

    public int cmd() {
        return 12290;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C12290_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */