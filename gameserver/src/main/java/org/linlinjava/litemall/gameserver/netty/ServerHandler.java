package org.linlinjava.litemall.gameserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("serverHandler")
@ChannelHandler.Sharable
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
    public static final AttributeKey<GameObjectChar> akey = AttributeKey.newInstance("session");
    @Autowired
    private java.util.List<GameHandler> gameHandlers;

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }


    public void channelInactive(ChannelHandlerContext ctx)
            throws Exception {
        super.channelInactive(ctx);
        Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        if (attr == null) {
            return;
        }
        GameObjectChar session = (GameObjectChar) attr.get();
        if ((session == null) || (session.chara == null)) {
            return;
        }
        GameObjectCharMng.remove(session);
    }


    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        Attribute<GameObjectChar> attr = ctx.channel().attr(akey);
        GameObjectChar session = null;
        if ((attr != null) && (attr.get() != null)) {
            session = (GameObjectChar) attr.get();
            GameObjectChar.GAMEOBJECTCHAR_THREAD_LOCAL.set(session);
        }
        ByteBuf buff = (ByteBuf) msg;
        GameReadTool.readInt(buff);
        GameReadTool.readShort(buff);
        int cmd = GameReadTool.readShort(buff);
        for (GameHandler waitLine : this.gameHandlers) {
            if (cmd == waitLine.cmd()) {
                if (session != null) {
                    if (session.lock()) {
                        try {
                            waitLine.process(ctx, buff);
                        } finally {
                            session.unlock();
                        }
                    }
                } else {
                    waitLine.process(ctx, buff);
                    break;
                }
            }
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (!cause.toString().contains("java.io.IOException")) {
            log.error("exceptionCaught", cause);
        }
        ctx.close();
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\netty\ServerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */