package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class M61663
        extends BaseWrite {
    @Value("${netty.ip}")
    private String ip;

    protected void writeO(ByteBuf writeBuf, Object object) {
        List<GameLine> gameLines = (List) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(gameLines.size()));
        for (GameLine gameLine : gameLines) {
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(gameLine.lineNum));
            GameWriteTool.writeString(writeBuf, gameLine.lineName);
            GameWriteTool.writeString(writeBuf, this.ip);
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(3));
        }
    }

    public int cmd() {
        return 61663;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61663.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */