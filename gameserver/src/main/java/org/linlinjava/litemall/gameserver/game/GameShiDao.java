package org.linlinjava.litemall.gameserver.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.linlinjava.litemall.db.domain.RenwuMonster;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;

public class GameShiDao {
    public int shuaXingzhuangtai = 0;

    public static int statzhuangtai = 0;
    public long shuaXingTime = System.currentTimeMillis();

    public static long statTime = System.currentTimeMillis();

    public static long gonggaoTime = System.currentTimeMillis();

    public List<Vo_65529_0> shidaoyuanmo = new LinkedList();

    public List<Vo_65529_0> dengdaishuaXing = new LinkedList();

    public static void sendyaoyan1(String msg) {
        org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0 vo_16383_5 = new org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0();
        vo_16383_5.channel = 7;
        vo_16383_5.id = 0;
        vo_16383_5.name = "";
        vo_16383_5.msg = msg;
        vo_16383_5.time = ((int) (System.currentTimeMillis() / 1000L));
        vo_16383_5.privilege = 0;
        vo_16383_5.server_name = "";
        vo_16383_5.show_extra = 1;
        vo_16383_5.compress = 0;
        vo_16383_5.orgLength = 65535;
        vo_16383_5.cardCount = 0;
        vo_16383_5.voiceTime = 0;
        vo_16383_5.token = "";
        vo_16383_5.checksum = 0;
        GameObjectCharMng.sendAll(new org.linlinjava.litemall.gameserver.data.write.M16383_0(), vo_16383_5);
    }


    public static void sendYaoYan(GameShiDao gameShiDao, GameMap gameMap) {
        int size = gameMap.sessionList.size() * 5 - gameMap.gameShiDao.shidaoyuanmo.size();


        for (int i = 0; i < size; i++) {
            Random random = new Random();
            String name = "试道元魔";
            Vo_65529_0 vo_65529_0 = new Vo_65529_0();
            vo_65529_0.id = getCard();
            vo_65529_0.name = name;
            vo_65529_0.type = 2;
            vo_65529_0.leixing = (random.nextInt(5) + 1);
            List<RenwuMonster> renwuMonsters = GameData.that.baseRenwuMonsterService.findByType(Integer.valueOf(9));
            RenwuMonster renwuMonster = (RenwuMonster) renwuMonsters.get(random.nextInt(renwuMonsters.size()));
            org.linlinjava.litemall.db.domain.Map map = GameData.that.baseMapService.findOneByName(renwuMonster.getMapName());
            vo_65529_0.mapid = map.getMapId().intValue();
            vo_65529_0.x = renwuMonster.getX().intValue();
            vo_65529_0.y = renwuMonster.getY().intValue();
            vo_65529_0.dir = 1;
            vo_65529_0.icon = 6049;
            vo_65529_0.org_icon = vo_65529_0.icon;
            vo_65529_0.portrait = vo_65529_0.icon;
            gameShiDao.dengdaishuaXing.add(vo_65529_0);
        }
    }


    public static void sendshuaguai(GameShiDao gameShiDao, GameMap gameMap) {
        for (int i = 0; i < gameShiDao.dengdaishuaXing.size(); i++) {
            GameObjectCharMng.sendAllmapname(new org.linlinjava.litemall.gameserver.data.write.M65529_0(), gameShiDao.dengdaishuaXing.get(i), gameMap.name);
        }
        gameShiDao.shidaoyuanmo.addAll(gameShiDao.dengdaishuaXing);
        gameShiDao.dengdaishuaXing = new LinkedList();
    }

    public static int getCard() {
        Random rand = new Random();
        String cardNnumer = "";
        for (int a = 0; a < 9; a++) {
            cardNnumer = cardNnumer + rand.nextInt(10);
        }
        return Integer.parseInt(cardNnumer);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\game\GameShiDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */