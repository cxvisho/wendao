package org.linlinjava.litemall.gameserver.process;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import jdk.nashorn.internal.parser.JSONParser;

import org.json.JSONObject;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.service.base.BaseAccountsService;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45143_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45555_0;
import org.linlinjava.litemall.gameserver.data.write.M45143_0;
import org.linlinjava.litemall.gameserver.data.write.M45555_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class C45144_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    private static final Logger logger = LoggerFactory.getLogger(C45144_0.class);


    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        logger.error("C45144_0:" + buff.toString());
        String account = GameReadTool.readString(buff);
   /*     JSONObject jo = new JSONObject(account);
        String o = (String) jo.get("account");*/
        String substring = account.substring(6);

        Accounts useraccount = GameData.that.baseAccountsService.findOneByToken(substring);

        logger.info("验证不通过的查询参数:" + account);
        logger.info("验证不通过的查询参数:" + substring);
        if (useraccount == null) {
            logger.info("验证不通过");
            return;

        }
        logger.info("验证不通过的查询参数:" + useraccount.toString());


        Vo_45143_0 vo_45143_0 = new Vo_45143_0();

        vo_45143_0.line_name = "";

        vo_45143_0.expect_time = 1;

        vo_45143_0.reconnet_time = 0;

        vo_45143_0.waitCode = 1;

        vo_45143_0.count = 1;

        vo_45143_0.keep_alive = 1;

        vo_45143_0.need_wait = 0;

        vo_45143_0.indsider_lv = 255;

        vo_45143_0.gold_coin = 0;

        vo_45143_0.status = 0;

        Vo_45555_0 vo_45555_0 = new Vo_45555_0();

        vo_45555_0.type = "normal";

        vo_45555_0.cookie = "2960226";


        ByteBuf write = new M45143_0().write(vo_45143_0);

        ByteBuf write1 = new M45555_0().write(vo_45555_0);

        ctx.writeAndFlush(write);

        ctx.writeAndFlush(write1);

    }


    public int cmd() {

        return 45144;

    }

}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C45144_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */