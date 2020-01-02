package org.linlinjava.litemall.gameserver.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.linlinjava.litemall.db.domain.RenwuMonster;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
import org.linlinjava.litemall.gameserver.domain.Chara;

public class GameShuaGuai {
    public int shuaXingzhuangtai = 0;
    public long shuaXingTime = System.currentTimeMillis();
    public List<Vo_65529_0> shuaXing = new java.util.LinkedList();
    public static final List<Integer> list = new ArrayList(java.util.Arrays.asList(new Integer[]{Integer.valueOf(1111111111), Integer.valueOf(222222222), Integer.valueOf(333333333), Integer.valueOf(444444444), Integer.valueOf(555555555), Integer.valueOf(66666666), Integer.valueOf(777777777), Integer.valueOf(888888888)}));
    public static List<Vo_65529_0> dengdaishuaXing = new java.util.LinkedList();

    public static void sendshuaguai(GameShuaGuai gameShuaGuai) {
        for (int i = 0; i < dengdaishuaXing.size(); i++) {
            GameObjectCharMng.sendAllmap(new org.linlinjava.litemall.gameserver.data.write.M65529_0(), dengdaishuaXing.get(i), ((Vo_65529_0) dengdaishuaXing.get(i)).mapid);
            List<GameObjectChar> sessionList = GameObjectCharMng.getGameObjectCharList();
            for (int j = 0; j < sessionList.size(); j++) {
                if (((GameObjectChar) sessionList.get(j)).gameMap.id == ((Vo_65529_0) dengdaishuaXing.get(i)).mapid) {
                    List<GameObjectChar> sessionList1 = ((GameObjectChar) sessionList.get(j)).gameMap.getSessionList();
                    if (sessionList1.size() > 0) {
                        Random random = new Random();
                        GameObjectChar gameSession = (GameObjectChar) sessionList1.get(random.nextInt(sessionList1.size()));
                        String xuanzhongname = "";
                        if ((gameSession.gameTeam != null) && (gameSession.gameTeam.duiwu != null)) {
                            ((Vo_65529_0) dengdaishuaXing.get(i)).wanjiaid = ((Chara) gameSession.gameTeam.duiwu.get(0)).id;
                            gameSession = GameObjectCharMng.getGameObjectChar(((Chara) gameSession.gameTeam.duiwu.get(0)).id);
                        } else {
                            ((Vo_65529_0) dengdaishuaXing.get(i)).wanjiaid = gameSession.chara.id;
                        }
                        gameShuaGuai.shuaXingzhuangtai = 2;
                        gameShuaGuai.shuaXingTime = System.currentTimeMillis();
                        String msg = "#R恭喜#n#Y" + xuanzhongname + "#n，我乃#R" + ((Vo_65529_0) dengdaishuaXing.get(i)).name + "（" + ((Vo_65529_0) dengdaishuaXing.get(i)).level + "级）#n。遵天命，今特邀你在#Z轩辕坟三层|轩辕坟三层(42,45)::" + ((Vo_65529_0) dengdaishuaXing.get(i)).name + "|1线|$0#Z处挑战。我只等你3分钟，请速来挑战。如果你挑战成功，将会获得丰厚的奖励。";
                        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = msg;
                        vo_20480_0.time = ((int) (System.currentTimeMillis() / 1000L));
                        GameObjectChar.sendduiwu(new org.linlinjava.litemall.gameserver.data.write.M20480_0(), vo_20480_0, gameSession.chara.id);


                        org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0 vo_8165_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0();
                        vo_8165_0.msg = ("#R恭喜#n，你队伍已被#Y" + ((Vo_65529_0) dengdaishuaXing.get(i)).name + "#n选中，请速前往挑战。");
                        vo_8165_0.active = 0;
                        GameObjectChar.sendduiwu(new org.linlinjava.litemall.gameserver.data.write.M8165_0(), vo_8165_0, gameSession.chara.id);


                        String msglost = "染项很遗憾，" + ((Vo_65529_0) dengdaishuaXing.get(i)).name + "(" + ((Vo_65529_0) dengdaishuaXing.get(i)).level + "级)已邀请到玩家进行挑战,不过您的幸运值有了大幅增加,下次会优先挑选您的,诚请各位道友下一时段前往挑战。";
                        vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = msglost;
                        vo_20480_0.time = ((int) (System.currentTimeMillis() / 1000L));
                        gameSession.gameMap.sendNoMeduiwu(new org.linlinjava.litemall.gameserver.data.write.M20480_0(), vo_20480_0, gameSession);

                        org.linlinjava.litemall.gameserver.data.vo.Vo_40961_0 vo_40961_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_40961_0();
                        vo_40961_0.count = 1;
                        vo_40961_0.id = gameSession.characters.getGid();
                        vo_40961_0.type = 0;
                        vo_40961_0.sender = "";
                        vo_40961_0.title = ("挑战" + ((Vo_65529_0) dengdaishuaXing.get(i)).name);
                        vo_40961_0.msg = msg;
                        vo_40961_0.attachment = "";
                        vo_40961_0.create_time = ((int) (System.currentTimeMillis() / 1000L));
                        vo_40961_0.expired_time = ((int) (System.currentTimeMillis() / 1000L) + 1000000);
                        vo_40961_0.status = 0;
                        gameSession.gameMap.sendNoMeyoujian(new org.linlinjava.litemall.gameserver.data.write.M40961_0(), vo_40961_0, gameSession);
                        break;
                    }
                }
            }
        }

        gameShuaGuai.shuaXing.addAll(dengdaishuaXing);
        dengdaishuaXing = new java.util.LinkedList();
    }

    public static void sendYaoYan(GameShuaGuai gameShuaGuai) {
        List<Integer> lists = new ArrayList(java.util.Arrays.asList(new Integer[]{Integer.valueOf(1111111111), Integer.valueOf(222222222), Integer.valueOf(333333333), Integer.valueOf(444444444), Integer.valueOf(555555555), Integer.valueOf(66666666), Integer.valueOf(777777777), Integer.valueOf(888888888)}));
        gameShuaGuai.shuaXingzhuangtai = 1;
        gameShuaGuai.shuaXingTime = System.currentTimeMillis();
        List list = new ArrayList();
        for (int i = 0; i < gameShuaGuai.shuaXing.size(); i++) {
            list.add(Integer.valueOf(((Vo_65529_0) gameShuaGuai.shuaXing.get(i)).id));
        }

        lists.removeAll(list);

        for (int i = 0; i < lists.size(); i++) {
            Random random = new Random();
            String name = getName();
            int level = chenchenglevel(((Integer) lists.get(i)).intValue());
            Vo_65529_0 vo_65529_0 = new Vo_65529_0();
            vo_65529_0.id = ((Integer) lists.get(i)).intValue();
            vo_65529_0.name = name;
            vo_65529_0.level = level;
            vo_65529_0.type = 2;
            vo_65529_0.leixing = (random.nextInt(5) + 1);
            List<RenwuMonster> renwuMonsters = GameData.that.baseRenwuMonsterService.findByType(Integer.valueOf(7));
            RenwuMonster renwuMonster = (RenwuMonster) renwuMonsters.get(random.nextInt(renwuMonsters.size()));
            org.linlinjava.litemall.db.domain.Map map = GameData.that.baseMapService.findOneByName(renwuMonster.getMapName());
            vo_65529_0.mapid = map.getMapId().intValue();
            vo_65529_0.x = renwuMonster.getX().intValue();
            vo_65529_0.y = renwuMonster.getY().intValue();
            List<ZhuangbeiInfo> infoList = GameData.that.baseZhuangbeiInfoService.findByAttrib(Integer.valueOf(level / 10 * 10));
            for (ZhuangbeiInfo zhuangbeiInfo : infoList) {
                if ((zhuangbeiInfo.getAmount().intValue() == 1) && (zhuangbeiInfo.getMetal().intValue() == vo_65529_0.leixing)) {
                    vo_65529_0.weapon_icon = zhuangbeiInfo.getType().intValue();
                }
            }
            vo_65529_0.dir = 1;
            int sex = random.nextInt(1) + 1;
            vo_65529_0.icon = waiguan(vo_65529_0.leixing, sex);
            int[] suit = org.linlinjava.litemall.gameserver.data.game.SuitEffectUtils.suit(sex - 1, level, vo_65529_0.leixing, random.nextInt(5) + 1);
            vo_65529_0.org_icon = vo_65529_0.icon;
            vo_65529_0.suit_icon = suit[0];
            vo_65529_0.suit_light_effect = suit[1];
            vo_65529_0.portrait = vo_65529_0.icon;
            dengdaishuaXing.add(vo_65529_0);


            org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0 vo_16383_5 = new org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0();
            vo_16383_5.channel = 6;
            vo_16383_5.id = 0;
            vo_16383_5.name = "";
            vo_16383_5.msg = ("听闻#Y" + name + "#n#R（" + level + "级）#n将在#R三分钟后#n下凡云游到#Z" + renwuMonster.getMapName() + "|14线#Z，期间星君将挑选幸运的道友进行指点，各位道友快去该地图等候吧！");
            vo_16383_5.time = ((int) (System.currentTimeMillis() / 1000L));
            vo_16383_5.privilege = 0;
            vo_16383_5.server_name = "3周年14线";
            vo_16383_5.show_extra = 1;
            vo_16383_5.compress = 0;
            vo_16383_5.orgLength = 65535;
            vo_16383_5.cardCount = 0;
            vo_16383_5.voiceTime = 0;
            vo_16383_5.token = "";
            vo_16383_5.checksum = 0;
            GameObjectCharMng.sendAll(new org.linlinjava.litemall.gameserver.data.write.M16383_0(), vo_16383_5);
        }
    }

    public static String getName() {
        Random seriesRandom = new Random();
        String[] dx = {"地魁星", "地煞星", "地勇星", "地杰星", "地雄星", "地威星", "地英星", "地奇星", "地猛星", "地文星", "地正星", "地辟星", "地阖星", "地强星", "地暗星", "地辅星", "地会星", "地佐星", "地佑星", "地灵星", "地兽星", "地微星", "地慧星", "地暴星", "地默星", "地猖星", "地狂星", "地飞星", "地走星", "地巧星", "地明星", "地进星", "地退星", "地满星", "地遂星", "地周星", "地隐星", "地异星", "地理星", "地俊星", "地乐星", "地捷星", "地速星", "地镇星", "地羁星", "地魔星", "地妖星", "地幽星", "地伏星", "地僻星", "地空星", "地孤星", "地全星", "地短星", "地角星", "地囚星", "地藏星", "地平星", "地损星", "地奴星", "地察星", "地恶星", "地魂星", "地数星", "地阴星", "地刑星", "地壮星", "地劣星", "地健星", "地贼星", "地戚星", "地狗星"};


        String[] tx = {"天猛星", "天威星", "天英星", "天贵星", "天富星", "天满星", "天孤星", "天伤星", "天立星", "天捷星", "天暗星", "天祐星", "天空星", "天速星", "天异星", "天杀星", "天微星", "天究星", "天退星", "天寿星", "天剑星", "天平星", "天罪星", "天损星"};


        if (seriesRandom.nextBoolean()) {
            return dx[seriesRandom.nextInt(dx.length)];
        }
        return tx[seriesRandom.nextInt(tx.length)];
    }

    public static int chenchenglevel(int id) {
        int[] level = {50, 60, 70, 80, 90, 100, 110, 120};
        int dengji = 0;
        for (int i = 0; i < list.size(); i++) {
            if (id == ((Integer) list.get(i)).intValue()) {
                dengji = level[i];
            }
        }
        Random random = new Random();
        return dengji + random.nextInt(10);
    }

    public static int waiguan(int menpai, int sex) {
        int waiguan = 0;
        if ((menpai == 1) && (sex == 1)) {
            waiguan = 6001;
        }
        if ((menpai == 2) && (sex == 1)) {
            waiguan = 7002;
        }
        if ((menpai == 3) && (sex == 1)) {
            waiguan = 7003;
        }
        if ((menpai == 4) && (sex == 1)) {
            waiguan = 6004;
        }
        if ((menpai == 5) && (sex == 1)) {
            waiguan = 6005;
        }
        if ((menpai == 1) && (sex == 2)) {
            waiguan = 7001;
        }
        if ((menpai == 2) && (sex == 2)) {
            waiguan = 6002;
        }
        if ((menpai == 3) && (sex == 2)) {
            waiguan = 6003;
        }
        if ((menpai == 4) && (sex == 2)) {
            waiguan = 7004;
        }
        if ((menpai == 5) && (sex == 2)) {
            waiguan = 7005;
        }
        return waiguan;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\game\GameShuaGuai.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */