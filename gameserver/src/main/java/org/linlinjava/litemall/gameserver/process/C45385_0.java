package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.linlinjava.litemall.db.domain.Choujiang;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.db.service.base.BasePetService;
import org.linlinjava.litemall.db.service.base.BaseStoreInfoService;
import org.linlinjava.litemall.db.service.base.BaseZhuangbeiInfoService;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.game.LuckDrawUtils;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45382_0;
import org.linlinjava.litemall.gameserver.data.write.M41240_0;
import org.linlinjava.litemall.gameserver.data.write.M45382_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C45385_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int type = org.linlinjava.litemall.gameserver.data.GameReadTool.readByte(buff);


        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (1 == type) {
            chara.shadow_self -= 1;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);


            String[] strings = LuckDrawUtils.luckDraw(false);
            huodechoujiang(strings, chara);
        }


        if (3 == type) {
            for (int i = 0; i < 10; i++) {
                chara.shadow_self -= 1;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);


                String[] strings = LuckDrawUtils.luckDraw(false);
                huodechoujiang(strings, chara);
            }
        }

        if (2 == type) {
            chara.shadow_self -= 10;
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);


            String[] strings = LuckDrawUtils.luckDraw(true);
            huodechoujiang(strings, chara);
        }

        if (4 == type) {
            for (int i = 0; i < 10; i++) {
                chara.shadow_self -= 10;
                ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
                GameObjectChar.send(new M65527_0(), listVo_65527_0);


                String[] strings = LuckDrawUtils.luckDraw(true);
                huodechoujiang(strings, chara);
            }
        }

        Vo_45382_0 vo_45382_0 = new Vo_45382_0();
        vo_45382_0.reward_str = "#I物品|超级绿水晶#r1#I";
        vo_45382_0.level = 3;
        GameObjectChar.send(new M45382_0(), vo_45382_0);

        GameObjectChar.send(new M41240_0(), null);
    }


    public void huodechoujiang(String[] strings, Chara chara) {
        if (strings[1].equals("变异")) {
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 3);
            List<Petbeibao> list = new ArrayList();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);
        }
        if (strings[1].equals("神兽")) {
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 4);
            List<Petbeibao> list = new ArrayList();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            GameObjectChar.send(new M65507_0(), list);
        }
        if (strings[1].equals("精怪")) {
            int jieshu = stageMounts(strings[0]);
            Pet pet = GameData.that.basePetService.findOneByName(strings[0]);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.PetCreate(pet, chara, 0, 2);
            List<Petbeibao> list = new ArrayList();
            chara.pets.add(petbeibao);
            list.add(petbeibao);
            ((PetShuXing) petbeibao.petShuXing.get(0)).enchant_nimbus = 0;
            ((PetShuXing) petbeibao.petShuXing.get(0)).max_enchant_nimbus = 0;
            ((PetShuXing) petbeibao.petShuXing.get(0)).suit_light_effect = 1;
            ((PetShuXing) petbeibao.petShuXing.get(0)).hide_mount = jieshu;
            PetShuXing shuXing = new PetShuXing();
            shuXing.no = 23;
            shuXing.type1 = 2;
            shuXing.accurate = (4 * (jieshu - 1));
            shuXing.mana = (4 * (jieshu - 1));
            shuXing.wiz = (3 * (jieshu - 1));
            shuXing.all_polar = 0;
            shuXing.upgrade_magic = 0;
            shuXing.upgrade_total = 0;
            petbeibao.petShuXing.add(shuXing);
            GameObjectChar.send(new M65507_0(), list);
        }
        if (strings[1].equals("物品")) {
            StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(strings[0]);
            GameUtil.huodedaoju(chara, info, 1);
        }
        if (strings[1].equals("首饰")) {
            ZhuangbeiInfo oneByStr = GameData.that.baseZhuangbeiInfoService.findOneByStr(strings[0]);
            GameUtil.huodezhuangbei(chara, oneByStr, 0, 1);
            strings[0] = "60级首饰";
        }
        ZhuangbeiInfo zhuangbeiInfo;
        if (strings[1].equals("装备")) {
            Random random = new Random();

            int[] eqType = {1, 2, 10, 3};
            int leixing = eqType[random.nextInt(4)];
            String zhuangbname = zhuangbname(chara, leixing);
            List<Hashtable<String, Integer>> hashtables = equipmentLuckDraw(chara.level, leixing);
            if (hashtables.size() > 0) {
                zhuangbeiInfo = GameData.that.baseZhuangbeiInfoService.findOneByStr(zhuangbname);
                for (Hashtable<String, Integer> maps : hashtables) {
                    if (((Integer) maps.get("groupNo")).intValue() == 2) {
                        maps.put("groupType", Integer.valueOf(2));
                        GoodsLanSe gooodsLanSe = (GoodsLanSe) JSONUtils.parseObject(JSONUtils.toJSONString(maps), GoodsLanSe.class);
                        GameUtil.huodezhuangbei(chara, zhuangbeiInfo, 0, 1, gooodsLanSe);
                    }
                }
            }
        }

        Choujiang choujiang = GameData.that.baseChoujiangService.findOneByName(strings[0]);
        if (choujiang == null) {
            System.out.println(strings[0]);
        }
        Vo_45382_0 vo_45382_0 = new Vo_45382_0();
        vo_45382_0.reward_str = choujiang.getDesc();
        vo_45382_0.level = choujiang.getLevel().intValue();
        GameObjectChar.send(new M45382_0(), vo_45382_0);
    }


    public int cmd() {
        return 45385;
    }

    private int stageMounts(String name) {
        int[] mounts_stage = {2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 8, 8};
        String[] mounts_name = {"仙阳剑", "凌岩豹", "幻鹿", "赤焰葫芦", "玉豹", "仙葫芦", "无极熊", "岳麓剑", "古鹿", "北极熊", "筋斗云", "太极熊", "墨麒麟"};
        for (int i = 0; i < mounts_name.length; i++) {
            if (mounts_name[i].equalsIgnoreCase(name)) {
                return mounts_stage[i];
            }
        }
        return 0;
    }


    private List<Hashtable<String, Integer>> equipmentLuckDraw(int eq_attrib, int leixing) {
        if (eq_attrib < 70) {
            eq_attrib = 70;
        } else {
            eq_attrib = eq_attrib / 10 * 10;
        }
        List<Hashtable<String, Integer>> hashtables = org.linlinjava.litemall.gameserver.data.game.ForgingEquipmentUtils.appraisalEquipment(leixing, eq_attrib, 10);

        String[] rareAttributes = {"all_resist_except", "all_resist_polar", "all_polar", "all_skill", "ignore_all_resist_except", "mstunt_rate", "release_forgotten"};
        for (Hashtable<String, Integer> hashtable : hashtables) {
            for (String key : rareAttributes) {
                if (hashtable.contains(key)) {
                    Random random = new Random();

                    String[] replaceAttributes = {"mag_power", "phy_power", "speed", "life"};
                    List<Hashtable<String, Integer>> appraisalList = new ArrayList();
                    Hashtable<String, Integer> key_vlaue_tab = new Hashtable();
                    key_vlaue_tab.put("groupNo", Integer.valueOf(2));
                    key_vlaue_tab.put(replaceAttributes[random.nextInt(4)], Integer.valueOf(eq_attrib / 4));
                    appraisalList.add(key_vlaue_tab);
                    return appraisalList;
                }
            }
        }

        return hashtables;
    }

    public String zhuangbname(Chara chara, int leixing) {
        int eq_attrib = 0;
        if (chara.level < 70) {
            eq_attrib = 70;
        } else {
            eq_attrib = chara.level / 10 * 10;
        }
        List<ZhuangbeiInfo> byAttrib = GameData.that.baseZhuangbeiInfoService.findByAttrib(Integer.valueOf(eq_attrib));
        for (int j = 0; j < byAttrib.size(); j++) {
            if ((leixing == 1) &&
                    (((ZhuangbeiInfo) byAttrib.get(j)).getMetal().intValue() == chara.menpai) && (((ZhuangbeiInfo) byAttrib.get(j)).getAmount().intValue() == leixing)) {
                return ((ZhuangbeiInfo) byAttrib.get(j)).getStr();
            }

            if (((leixing == 2) || (leixing == 3)) &&
                    (((ZhuangbeiInfo) byAttrib.get(j)).getMaster().intValue() == chara.sex) && (((ZhuangbeiInfo) byAttrib.get(j)).getAmount().intValue() == leixing)) {
                return ((ZhuangbeiInfo) byAttrib.get(j)).getStr();
            }

            if ((leixing == 10) &&
                    (((ZhuangbeiInfo) byAttrib.get(j)).getAmount().intValue() == leixing)) {
                return ((ZhuangbeiInfo) byAttrib.get(j)).getStr();
            }
        }

        return "";
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C45385_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */