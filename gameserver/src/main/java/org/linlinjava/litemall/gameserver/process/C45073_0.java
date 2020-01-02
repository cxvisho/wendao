package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.linlinjava.litemall.db.service.base.BaseCharactersService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45072_0;
import org.linlinjava.litemall.gameserver.data.write.M45072_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.springframework.stereotype.Service;


@Service
public class C45073_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int gender = GameReadTool.readByte(buff);

        String arr = getRandomJianHan();
        Vo_45072_0 vo_45072_0 = new Vo_45072_0();
        vo_45072_0.new_name = getRandomJianHan();
        ByteBuf write = new M45072_0().write(vo_45072_0);
        ctx.writeAndFlush(write);
    }

    public int cmd() {
        return 45073;
    }

    public String getRandomJianHan() {
        Random random = new Random();
        int len = random.nextInt(2) + 3;
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;

            int hightPos = 176 + Math.abs(random.nextInt(39));
            int lowPos = 161 + Math.abs(random.nextInt(93));
            byte[] b = new byte[2];
            b[0] = new Integer(hightPos).byteValue();
            b[1] = new Integer(lowPos).byteValue();
            try {
                str = new String(b, "GBK");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret = ret + str;
        }
        if (GameData.that.baseCharactersService.findOneByName(ret) != null) {
            getRandomJianHan();
        }
        return ret;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C45073_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */