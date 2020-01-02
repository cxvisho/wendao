package org.linlinjava.litemall.gameserver.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.linlinjava.litemall.db.service.base.BaseMapService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("glllbawsdfawelllll")
@Scope("prototype")
public class GameLine {
    public int lineNum;
    public String lineName;
    private List<GameMap> gameRoomList = new ArrayList();
    private java.util.Map<String, GameMap> gameRoomNameMap = new HashMap();

    public static GameShuaGuai gameShuaGuai = new GameShuaGuai();


    public void init() {
        List<org.linlinjava.litemall.db.domain.Map> all = GameData.that.baseMapService.findAll();
        for (org.linlinjava.litemall.db.domain.Map map : all) {
            GameMap gameMap = (GameMap) GameCore.getBean("gmmmasdfasdfmmmm", GameMap.class);
            gameMap.id = map.getMapId().intValue();
            gameMap.name = map.getName();
            gameMap.x = map.getX().intValue();
            gameMap.y = map.getY().intValue();
            this.gameRoomList.add(gameMap);
            this.gameRoomNameMap.put(gameMap.name, gameMap);
        }
    }

    public static GameMap getGameMapname(int line, String mapidname) {
        GameLine gameLine = GameCore.getGameLine(line);
        for (GameMap gameMap : gameLine.gameRoomList) {
            if (gameMap.name.equals(mapidname)) {
                return gameMap;
            }
        }
        return null;
    }

    public static GameMap getGameMap(int line, int mapid) {
        GameLine gameLine = GameCore.getGameLine(line);
        for (GameMap gameMap : gameLine.gameRoomList) {
            if (gameMap.id == mapid) {
                return gameMap;
            }
        }
        return null;
    }

    public static GameMap getGameMap(int line, String mapName) {
        GameLine gameLine = GameCore.getGameLine(line);
        return (GameMap) gameLine.gameRoomNameMap.get(mapName);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\game\GameLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */