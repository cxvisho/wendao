package org.linlinjava.litemall.gameserver.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.C12490_0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GameObjectCharMng {
    private static final Logger log = LoggerFactory.getLogger(GameObjectCharMng.class);
    private static final List<GameObjectChar> gameObjectCharList = new java.util.concurrent.CopyOnWriteArrayList();

    public static void add(GameObjectChar gameObjectChar) {
        if (gameObjectCharList.contains(gameObjectChar)) {
            for (GameObjectChar gameSession : gameObjectCharList) {
                if (gameObjectChar.chara.id == gameSession.chara.id) {
                    gameSession.ctx.disconnect();
                    gameObjectChar.gameTeam = gameSession.gameTeam;
                    gameObjectCharList.remove(gameSession);
                }
            }
        }
        gameObjectCharList.add(gameObjectChar);
    }

    public static void sendAll(BaseWrite baseWrite, Object obj) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            GameObjectChar session = (GameObjectChar) gameObjectCharList.get(i);
            ByteBuf write = baseWrite.write(obj);
            session.ctx.writeAndFlush(write);
        }
    }

    public static List<GameObjectChar> getGameObjectCharList() {
        return gameObjectCharList;
    }

    public static void sendAllmap(BaseWrite baseWrite, Object obj, int mapid) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            GameObjectChar gameObjectChar = (GameObjectChar) gameObjectCharList.get(i);
            if (gameObjectChar.gameMap.id == mapid) {
                ByteBuf write = baseWrite.write(obj);
                gameObjectChar.ctx.writeAndFlush(write);
            }
        }
    }

    public static void sendAllmapname(BaseWrite baseWrite, Object obj, String mapname) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            GameObjectChar gameObjectChar = (GameObjectChar) gameObjectCharList.get(i);
            if (gameObjectChar.gameMap.name.equals(mapname)) {
                ByteBuf write = baseWrite.write(obj);
                gameObjectChar.ctx.writeAndFlush(write);
            }
        }
    }

    public static final GameObjectChar getGameObjectChar(int id) {
        for (GameObjectChar gameObjectChar : gameObjectCharList) {
            if (gameObjectChar.chara.id == id) {
                return gameObjectChar;
            }
        }
        return null;
    }

    public static final List<GameObjectChar> getAll() {
        return gameObjectCharList;
    }

    public static void remove(GameObjectChar gameObjectChar) {
        gameObjectChar.chara.updatetime = System.currentTimeMillis();
        save(gameObjectChar);
    }

    public static void save(GameObjectChar gameObjectChar) {
        String data = gameObjectChar.characters.getData();
        Chara chara111 = JSONUtils.parseObject(data, Chara.class);
        if (chara111.level > gameObjectChar.chara.level) {
            log.error("人物等级{old}", chara111.name, chara111.level);
            log.error("人物等级{new}", gameObjectChar.chara.name, gameObjectChar.chara.level);
            log.error("人物队伍信息", gameObjectChar.gameTeam.toString());
            throw new RuntimeException("角色等级回档！！！");
        }
        gameObjectChar.characters.setData(org.linlinjava.litemall.db.util.JSONUtils.toJSONString(gameObjectChar.chara));
        GameData.that.baseCharactersService.updateById(gameObjectChar.characters);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\game\GameObjectCharMng.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */