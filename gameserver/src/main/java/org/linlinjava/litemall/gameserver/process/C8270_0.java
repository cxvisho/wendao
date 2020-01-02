package org.linlinjava.litemall.gameserver.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.service.base.BasePetService;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40991_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;

@org.springframework.stereotype.Service
public class C8270_0 implements org.linlinjava.litemall.gameserver.GameHandler {
    public void process(io.netty.channel.ChannelHandlerContext ctx, io.netty.buffer.ByteBuf buff) {
        int no = org.linlinjava.litemall.gameserver.data.GameReadTool.readByte(buff);

        int pos = org.linlinjava.litemall.gameserver.data.GameReadTool.readByte(buff);

        String para = org.linlinjava.litemall.gameserver.data.GameReadTool.readString(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;


        if ("inset".equals(para)) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (pos == ((Goods) chara.backpack.get(i)).pos) {
                    Goods goods = (Goods) chara.backpack.get(i);

                    for (int j = 0; j < chara.pets.size(); j++) {
                        int weizhi = 12;
                        if (((Petbeibao) chara.pets.get(j)).no == no) {
                            for (int k = 0; k < ((Petbeibao) chara.pets.get(j)).petShuXing.size(); k++) {
                                if (((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(k)).str.equals(goods.goodsInfo.str)) {
                                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                                    vo_8165_0.msg = "不可重复打入！";
                                    vo_8165_0.active = 0;
                                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                                    return;
                                }
                            }
                            weizhi = weizhi(weizhi, ((Petbeibao) chara.pets.get(j)).petShuXing);

                            PetShuXing petShuXing = new PetShuXing();
                            petShuXing.no = weizhi;
                            petShuXing.type1 = 2;
                            petShuXing.skill = goods.goodsInfo.skill;
                            petShuXing.str = goods.goodsInfo.str;
                            petShuXing.accurate = goods.goodsLanSe.accurate;
                            petShuXing.wiz = goods.goodsLanSe.wiz;
                            petShuXing.parry = goods.goodsLanSe.parry;
                            petShuXing.def = goods.goodsLanSe.def;
                            petShuXing.dex = goods.goodsLanSe.dex;
                            petShuXing.mana = goods.goodsLanSe.mana;
                            petShuXing.silver_coin = 8000;
                            ((Petbeibao) chara.pets.get(j)).petShuXing.add(petShuXing);
                            List list = new ArrayList();
                            list.add(chara.pets.get(j));
                            GameObjectChar.send(new M65507_0(), list);

                            Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                            vo_8165_0.msg = "打入妖石成功";
                            vo_8165_0.active = 0;
                            GameObjectChar.send(new M8165_0(), vo_8165_0);
                            org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0 vo_9129_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0();
                            vo_9129_0.notify = 12000;
                            vo_9129_0.para = "383174";
                            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M9129_0(), vo_9129_0);
                        }
                    }


                    goods.goodsInfo.owner_id -= 1;
                    if (goods.goodsInfo.owner_id == 0) {
                        List<Goods> listbeibao = new ArrayList();
                        Goods goods1 = new Goods();
                        goods1.goodsBasics = null;
                        goods1.goodsInfo = null;
                        goods1.goodsLanSe = null;
                        goods1.pos = goods.pos;
                        listbeibao.add(goods1);
                        chara.backpack.remove(goods);
                        GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65525_0(), listbeibao);
                    }
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M65525_0(), chara.backpack);
                }
            }
        }


        if ("".equals(para)) {
            for (int i = 0; i < chara.backpack.size(); i++) {
                if (pos == ((Goods) chara.backpack.get(i)).pos) {
                    Goods goods = (Goods) chara.backpack.get(i);
                    if (((Goods) chara.backpack.get(i)).goodsInfo.str == "风灵丸") {
                        GameUtil.removemunber(chara, "风灵丸", 1);
                        for (int j = 0; j < chara.pets.size(); j++) {
                            if (((Petbeibao) chara.pets.get(j)).no != no) {
                            }
                        }
                    }


                    for (int j = 0; j < chara.pets.size(); j++) {
                        if (((Petbeibao) chara.pets.get(j)).no == no) {
                            List list = new ArrayList();
                            list.add(chara.pets.get(j));
                            GameObjectChar.send(new M65507_0(), list);
                            boolean isfagong = ((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(0)).rank > ((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(0)).pet_mag_shape;
                            GameUtil.dujineng(1, ((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(0)).metal, ((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(0)).skill, isfagong, ((Petbeibao) chara.pets.get(j)).id, chara);
                            org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0 vo_12023_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0();
                            vo_12023_0.owner_id = chara.id;
                            vo_12023_0.id = ((Petbeibao) chara.pets.get(j)).id;
                            vo_12023_0.god_book_skill_name = goods.goodsInfo.str;
                            vo_12023_0.god_book_skill_level = ((int) (chara.level * 1.6D));
                            vo_12023_0.god_book_skill_power = 6000;
                            vo_12023_0.god_book_skill_disabled = 0;
                            ((Petbeibao) chara.pets.get(j)).tianshu.add(vo_12023_0);
                            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M12023_0(), ((Petbeibao) chara.pets.get(j)).tianshu);


                            org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0 vo_20481_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0();
                            vo_20481_0.msg = ("恭喜，你的宠物#Y" + ((PetShuXing) ((Petbeibao) chara.pets.get(j)).petShuXing.get(0)).str + "#n领悟了新的天书技能");
                            vo_20481_0.time = ((int) (System.currentTimeMillis() / 1000L));
                            GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M20481_0(), vo_20481_0);
                            GameUtil.removemunber(chara, goods.goodsInfo.str, 1);
                        }
                    }
                }
            }
        }


        if ("mag".equals(para)) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(((PetShuXing) petbeibao.petShuXing.get(0)).str);
                    int[] ints = org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils.upgradePet(true, pet.getMagAttack().intValue(), ((PetShuXing) petbeibao.petShuXing.get(0)).raw_name, ((PetShuXing) petbeibao.petShuXing.get(0)).life_add_temp);
                    if (((PetShuXing) petbeibao.petShuXing.get(0)).raw_name < ints[0]) {
                        ((PetShuXing) petbeibao.petShuXing.get(0)).pet_life_shape_temp += ints[1];
                        ((PetShuXing) petbeibao.petShuXing.get(0)).rank += ints[1];
                        ((PetShuXing) petbeibao.petShuXing.get(0)).life_add_temp = 0;
                        ((PetShuXing) petbeibao.petShuXing.get(0)).raw_name = ints[0];
                        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                        vo_8165_0.msg = "恭喜强化成功！";
                        vo_8165_0.active = 0;
                        GameObjectChar.send(new M8165_0(), vo_8165_0);
                    } else {
                        ((PetShuXing) petbeibao.petShuXing.get(0)).life_add_temp = ints[2];
                        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                        vo_8165_0.msg = "成长完成度增加了！";
                        vo_8165_0.active = 0;
                        GameObjectChar.send(new M8165_0(), vo_8165_0);
                    }
                    GameUtil.removemunber(chara, "宠物强化丹", 1);
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing((PetShuXing) petbeibao.petShuXing.get(0));
                    list.add(petbeibao);


                    GameObjectChar.send(new M65507_0(), list);
                }
            }
        }
        if ("phy".equals(para)) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(((PetShuXing) petbeibao.petShuXing.get(0)).str);
                    int[] ints = org.linlinjava.litemall.gameserver.data.game.PetAttributesUtils.upgradePet(false, pet.getPhyAttack().intValue(), ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_level, ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_rate);


                    if (((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_level < ints[0]) {
                        ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_add += ints[1];
                        ((PetShuXing) petbeibao.petShuXing.get(0)).pet_mag_shape += ints[1];
                        ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_rate = 0;
                        ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_level = ints[0];
                        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                        vo_8165_0.msg = "恭喜强化成功！";
                        vo_8165_0.active = 0;
                        GameObjectChar.send(new M8165_0(), vo_8165_0);
                    } else {
                        ((PetShuXing) petbeibao.petShuXing.get(0)).mag_rebuild_rate = ints[2];
                        Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                        vo_8165_0.msg = "成长完成度增加了！";
                        vo_8165_0.active = 0;
                        GameObjectChar.send(new M8165_0(), vo_8165_0);
                    }
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing((PetShuXing) petbeibao.petShuXing.get(0));
                    list.add(petbeibao);

                    GameObjectChar.send(new M65507_0(), list);
                    GameUtil.removemunber(chara, "宠物强化丹", 1);
                }
            }
        }


        if ("reset".equals(para)) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(((PetShuXing) petbeibao.petShuXing.get(0)).str);

                    PetShuXing shuXing = (PetShuXing) petbeibao.petShuXing.get(0);
                    shuXing.penetrate = 2;
                    shuXing.skill = 1;
                    shuXing.pot = 0;
                    shuXing.resist_poison = 258;
                    shuXing.mana_effect = (pet.getLife().intValue() - 40 - subtraction());
                    shuXing.attack_effect = (pet.getMana().intValue() - 40 - subtraction());
                    shuXing.mag_effect = (pet.getPhyAttack().intValue() - 40 - subtraction());
                    shuXing.phy_absorb = (pet.getMagAttack().intValue() - 40 - subtraction());
                    shuXing.phy_effect = (pet.getSpeed().intValue() - 40 - subtraction());
                    shuXing.pet_mana_shape = (shuXing.mana_effect + 40);
                    shuXing.pet_speed_shape = (shuXing.attack_effect + 40);
                    shuXing.pet_phy_shape = (shuXing.phy_effect + 40);
                    shuXing.pet_mag_shape = (shuXing.mag_effect + 40);
                    shuXing.rank = (shuXing.phy_absorb + 40);
                    shuXing.phy_power = 1;
                    shuXing.mag_power = 1;
                    shuXing.life = 1;
                    shuXing.speed = 1;
                    shuXing.polar_point = 4;
                    shuXing.resist_point = (shuXing.pet_mana_shape + shuXing.pet_speed_shape + shuXing.pet_phy_shape + shuXing.pet_mag_shape + shuXing.rank);
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing((PetShuXing) petbeibao.petShuXing.get(0));
                    shuXing.max_life = shuXing.def;
                    shuXing.max_mana = shuXing.dex;
                    list.add(petbeibao);


                    boolean isfagong = shuXing.rank > shuXing.pet_mag_shape;

                    List<JiNeng> jiNengList = new ArrayList();
                    List<JSONObject> nomelSkills = org.linlinjava.litemall.gameserver.data.game.PetAndHelpSkillUtils.getNomelSkills(1, shuXing.metal, 100, isfagong);
                    for (int j = 0; j < nomelSkills.size(); j++) {
                        JiNeng jiNeng = new JiNeng();
                        JSONObject jsonObject = (JSONObject) nomelSkills.get(j);
                        jiNeng.id = petbeibao.id;
                        jiNeng.skill_no = Integer.parseInt((String) jsonObject.get("skillNo"));
                        jiNeng.skill_attrib = 0;
                        jiNeng.skill_level = 0;
                        jiNeng.level_improved = 0;
                        jiNeng.skill_mana_cost = 0;
                        jiNeng.skill_nimbus = 42949672;
                        jiNeng.skill_disabled = 0;
                        jiNeng.range = 0;
                        jiNeng.max_range = 0;
                        jiNengList.add(jiNeng);
                    }
                    List<org.linlinjava.litemall.gameserver.data.vo.Vo_32747_0> vo_32747_0List = GameUtil.a32747(jiNengList);
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M32747_0(), vo_32747_0List);


                    GameObjectChar.send(new M65507_0(), list);
                    Vo_40991_0 vo_40991_0 = new Vo_40991_0();
                    vo_40991_0.result = 0;
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40991_0(), vo_40991_0);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("洗练成功，宠物#Y" + pet.getName() + "(野生)#n已洗炼成为1级#Y" + pet.getName() + "(宝宝)#n");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                    GameUtil.removemunber(chara, "超级归元露", 1);
                }
            }
        }


        if ("refine".equals(para)) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(((PetShuXing) petbeibao.petShuXing.get(0)).str);
                    PetShuXing shuXing = (PetShuXing) petbeibao.petShuXing.get(0);


                    shuXing.pet_mana_shape_temp = (pet.getLife().intValue() - subtraction() - shuXing.mana_effect - 40);

                    shuXing.pet_speed_shape_temp = (pet.getMana().intValue() - subtraction() - shuXing.attack_effect - 40);


                    shuXing.pet_phy_shape_temp = (pet.getSpeed().intValue() - subtraction() - shuXing.phy_effect - 40);

                    shuXing.pet_mag_shape_temp = (pet.getPhyAttack().intValue() - subtraction() - shuXing.mag_effect - 40);

                    shuXing.evolve_degree = (pet.getMagAttack().intValue() - subtraction() - shuXing.phy_absorb - 40);


                    if (shuXing.mana_effect + 40 == pet.getLife().intValue()) {
                        shuXing.pet_mana_shape_temp = 0;
                    }
                    if (shuXing.attack_effect + 40 == pet.getMana().intValue()) {
                        shuXing.pet_speed_shape_temp = 0;
                    }
                    if (shuXing.phy_absorb + 40 == pet.getMagAttack().intValue()) {
                        shuXing.evolve_degree = 0;
                    }
                    if (shuXing.mag_effect + 40 == pet.getPhyAttack().intValue()) {
                        shuXing.pet_mag_shape_temp = 0;
                    }
                    if (shuXing.phy_effect + 40 == pet.getSpeed().intValue()) {
                        shuXing.pet_phy_shape_temp = 0;
                    }
                    List list = new ArrayList();
                    BasicAttributesUtils.petshuxing((PetShuXing) petbeibao.petShuXing.get(0));

                    list.add(petbeibao);

                    GameObjectChar.send(new M65507_0(), list);
                    Vo_40991_0 vo_40991_0 = new Vo_40991_0();
                    vo_40991_0.result = 0;
                    GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M40991_0(), vo_40991_0);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("你的#Y" + pet.getName() + "#n经过洗炼，基础成长已重新生成。");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                    GameUtil.removemunber(chara, "超级归元露", 1);
                }
            }
        }


        if (57 == pos) {
        }
    }


    public int cmd() {
        return 8270;
    }

    public int subtraction() {
        Random r = new Random();

        return r.nextInt(10);
    }

    public int weizhi(int weizhi, List<PetShuXing> shuXings) {
        for (int i = 0; i < shuXings.size(); i++) {
            if (((PetShuXing) shuXings.get(i)).no == weizhi) {
                weizhi++;
                weizhi(weizhi, shuXings);
            }
        }
        return weizhi;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C8270_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */