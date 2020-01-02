package org.linlinjava.litemall.gameserver.data;

import java.util.HashMap;
import java.util.Map;

import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.Duiyuan;
import org.linlinjava.litemall.gameserver.domain.EquipInformation;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsBasics;
import org.linlinjava.litemall.gameserver.domain.GoodsFenSe;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZao;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMing;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMingChengGong;
import org.linlinjava.litemall.gameserver.domain.GoodsHuangSe;
import org.linlinjava.litemall.gameserver.domain.GoodsInfo;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;
import org.linlinjava.litemall.gameserver.domain.GoodsLvSe;
import org.linlinjava.litemall.gameserver.domain.GoodsLvSeGongMing;
import org.linlinjava.litemall.gameserver.domain.JiNeng;
import org.linlinjava.litemall.gameserver.domain.LieBiao;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.domain.ShouHuShuXing;
import org.linlinjava.litemall.gameserver.domain.ShuXingUtil;
import org.linlinjava.litemall.gameserver.domain.ZbAttribute;

public class UtilObjMapshuxing {
    public static Map<Object, Object> Chara(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        Chara obj1 = (Chara) obj;
        objectObjectHashMap.put("cangku", obj1.cangku);
        objectObjectHashMap.put("shizhuang", obj1.shizhuang);
        objectObjectHashMap.put("texiao", obj1.texiao);
        objectObjectHashMap.put("genchong", obj1.genchong);
        objectObjectHashMap.put("backpack", obj1.backpack);
        objectObjectHashMap.put("zbAttribute", obj1.zbAttribute);
        objectObjectHashMap.put("pets", obj1.pets);
        objectObjectHashMap.put("listshouhu", obj1.listshouhu);
        objectObjectHashMap.put("jiNengList", obj1.jiNengList);
        objectObjectHashMap.put("shenmiliwu", obj1.shenmiliwu);
        objectObjectHashMap.put("id", Integer.valueOf(obj1.id));
        objectObjectHashMap.put("x", Integer.valueOf(obj1.x));
        objectObjectHashMap.put("y", Integer.valueOf(obj1.y));
        objectObjectHashMap.put("mapid", Integer.valueOf(obj1.mapid));
        objectObjectHashMap.put("mapName", obj1.mapName);
        objectObjectHashMap.put("level", Integer.valueOf(obj1.level));
        objectObjectHashMap.put("name", obj1.name);
        objectObjectHashMap.put("chenhao", obj1.chenhao);
        objectObjectHashMap.put("menpai", Integer.valueOf(obj1.menpai));
        objectObjectHashMap.put("tizhi", Integer.valueOf(obj1.tizhi));
        objectObjectHashMap.put("lingli", Integer.valueOf(obj1.lingli));
        objectObjectHashMap.put("exp", Long.valueOf(obj1.exp));
        objectObjectHashMap.put("sex", Integer.valueOf(obj1.sex));
        objectObjectHashMap.put("line", Integer.valueOf(obj1.line));
        objectObjectHashMap.put("uuid", obj1.uuid);
        objectObjectHashMap.put("waiguan", Integer.valueOf(obj1.waiguan));
        objectObjectHashMap.put("current_task", obj1.current_task);
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("pot", Integer.valueOf(obj1.pot));
        objectObjectHashMap.put("resist_poison", Integer.valueOf(obj1.resist_poison));
        objectObjectHashMap.put("extra_mana", Integer.valueOf(obj1.extra_mana));
        objectObjectHashMap.put("have_coin_pwd", Integer.valueOf(obj1.have_coin_pwd));
        objectObjectHashMap.put("use_skill_d", Integer.valueOf(obj1.use_skill_d));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("polar_point", Integer.valueOf(obj1.polar_point));
        objectObjectHashMap.put("stamina", Integer.valueOf(obj1.stamina));
        objectObjectHashMap.put("max_life", Integer.valueOf(obj1.max_life));
        objectObjectHashMap.put("max_mana", Integer.valueOf(obj1.max_mana));
        objectObjectHashMap.put("use_money_type", Integer.valueOf(obj1.use_money_type));
        objectObjectHashMap.put("shadow_self", Integer.valueOf(obj1.shadow_self));
        objectObjectHashMap.put("weapon_icon", Integer.valueOf(obj1.weapon_icon));
        objectObjectHashMap.put("gold_coin", Integer.valueOf(obj1.gold_coin));
        objectObjectHashMap.put("extra_life", Integer.valueOf(obj1.extra_life));
        objectObjectHashMap.put("balance", Integer.valueOf(obj1.balance));
        objectObjectHashMap.put("jishou_coin", Integer.valueOf(obj1.jishou_coin));
        objectObjectHashMap.put("lock_exp", Integer.valueOf(obj1.lock_exp));
        objectObjectHashMap.put("chongwuchanzhanId", Integer.valueOf(obj1.chongwuchanzhanId));
        objectObjectHashMap.put("cash", Integer.valueOf(obj1.cash));
        objectObjectHashMap.put("uptime", Long.valueOf(obj1.uptime));
        objectObjectHashMap.put("updatetime", Long.valueOf(obj1.updatetime));
        objectObjectHashMap.put("online_time", Long.valueOf(obj1.online_time));
        objectObjectHashMap.put("signDays", Integer.valueOf(obj1.signDays));
        objectObjectHashMap.put("isCanSgin", Integer.valueOf(obj1.isCanSgin));
        objectObjectHashMap.put("gender", Integer.valueOf(obj1.gender));
        objectObjectHashMap.put("canzhanshouhunumber", Integer.valueOf(obj1.canzhanshouhunumber));
        objectObjectHashMap.put("zuoqiwaiguan", Integer.valueOf(obj1.zuoqiwaiguan));
        objectObjectHashMap.put("zuoqiId", Integer.valueOf(obj1.zuoqiId));
        objectObjectHashMap.put("yidongsudu", Integer.valueOf(obj1.yidongsudu));
        objectObjectHashMap.put("zuowaiguan", Integer.valueOf(obj1.zuowaiguan));
        objectObjectHashMap.put("special_icon", Integer.valueOf(obj1.special_icon));
        objectObjectHashMap.put("texiao_icon", Integer.valueOf(obj1.texiao_icon));
        objectObjectHashMap.put("genchong_icon", Integer.valueOf(obj1.genchong_icon));
        objectObjectHashMap.put("vipType", Integer.valueOf(obj1.vipType));
        objectObjectHashMap.put("isGet", Integer.valueOf(obj1.isGet));
        objectObjectHashMap.put("vipTime", Integer.valueOf(obj1.vipTime));
        objectObjectHashMap.put("vipTimeShengYu", Integer.valueOf(obj1.vipTimeShengYu));
        objectObjectHashMap.put("suit_icon", Integer.valueOf(obj1.suit_icon));
        objectObjectHashMap.put("suit_light_effect", Integer.valueOf(obj1.suit_light_effect));
        objectObjectHashMap.put("wuxingBalance", Integer.valueOf(obj1.wuxingBalance));
        objectObjectHashMap.put("enable_double_points", Integer.valueOf(obj1.enable_double_points));
        objectObjectHashMap.put("enable_shenmu_points", Integer.valueOf(obj1.enable_shenmu_points));
        objectObjectHashMap.put("extra_skill", Integer.valueOf(obj1.extra_skill));
        objectObjectHashMap.put("chushi_ex", Integer.valueOf(obj1.chushi_ex));
        objectObjectHashMap.put("fetch_nice", Integer.valueOf(obj1.fetch_nice));
        objectObjectHashMap.put("shuadaochongfeng_san", Integer.valueOf(obj1.shuadaochongfeng_san));
        objectObjectHashMap.put("xinshoulibao", obj1.xinshoulibao);
        objectObjectHashMap.put("npcshuadao", obj1.npcshuadao);
        objectObjectHashMap.put("shuadao", Integer.valueOf(obj1.shuadao));
        objectObjectHashMap.put("chubao", Integer.valueOf(obj1.chubao));
        objectObjectHashMap.put("npcchubao", obj1.npcchubao);
        objectObjectHashMap.put("baibangmang", Integer.valueOf(obj1.baibangmang));
        objectObjectHashMap.put("shimencishu", Integer.valueOf(obj1.shimencishu));
        objectObjectHashMap.put("npcName", obj1.npcName);
        objectObjectHashMap.put("fabaorenwu", Integer.valueOf(obj1.fabaorenwu));
        objectObjectHashMap.put("xiuxingcishu", Integer.valueOf(obj1.xiuxingcishu));
        objectObjectHashMap.put("xiuxingNpcname", obj1.xiuxingNpcname);
        objectObjectHashMap.put("autofight_select", Integer.valueOf(obj1.autofight_select));
        objectObjectHashMap.put("autofight_skillaction", Integer.valueOf(obj1.autofight_skillaction));
        objectObjectHashMap.put("autofight_skillno", Integer.valueOf(obj1.autofight_skillno));
        objectObjectHashMap.put("friend", Integer.valueOf(obj1.friend));
        objectObjectHashMap.put("owner_name", Integer.valueOf(obj1.owner_name));
        objectObjectHashMap.put("chenghao", obj1.chenghao);
        return objectObjectHashMap;
    }


    public static Map<Object, Object> Duiyuan(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        Duiyuan obj1 = (Duiyuan) obj;
        objectObjectHashMap.put("org_icon", Integer.valueOf(obj1.org_icon));
        objectObjectHashMap.put("iid_str", obj1.iid_str);
        objectObjectHashMap.put("skill", Integer.valueOf(obj1.skill));
        objectObjectHashMap.put("str", obj1.str);
        objectObjectHashMap.put("master", Integer.valueOf(obj1.master));
        objectObjectHashMap.put("metal", Integer.valueOf(obj1.metal));
        objectObjectHashMap.put("req_str", obj1.req_str);
        objectObjectHashMap.put("passive_mode", Integer.valueOf(obj1.passive_mode));
        objectObjectHashMap.put("party_contrib", obj1.party_contrib);
        objectObjectHashMap.put("mapteamMembersCount", Integer.valueOf(obj1.mapteamMembersCount));
        objectObjectHashMap.put("mapcomeback_flag", Integer.valueOf(obj1.mapcomeback_flag));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> EquipInformation(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        EquipInformation obj1 = (EquipInformation) obj;
        objectObjectHashMap.put("GroupNo", Integer.valueOf(obj1.GroupNo));
        objectObjectHashMap.put("GroupType", Integer.valueOf(obj1.GroupType));
        objectObjectHashMap.put("dunwu_times", Integer.valueOf(obj1.dunwu_times));
        objectObjectHashMap.put("attrib", Integer.valueOf(obj1.attrib));
        objectObjectHashMap.put("gift", Integer.valueOf(obj1.gift));
        objectObjectHashMap.put("total_score", Integer.valueOf(obj1.total_score));
        objectObjectHashMap.put("nick", Integer.valueOf(obj1.nick));
        objectObjectHashMap.put("power", Integer.valueOf(obj1.power));
        objectObjectHashMap.put("wrestle_score", Integer.valueOf(obj1.wrestle_score));
        objectObjectHashMap.put("skill", Integer.valueOf(obj1.skill));
        objectObjectHashMap.put("store_exp", Integer.valueOf(obj1.store_exp));
        objectObjectHashMap.put("metal", Integer.valueOf(obj1.metal));
        objectObjectHashMap.put("amount", Integer.valueOf(obj1.amount));
        objectObjectHashMap.put("type", Integer.valueOf(obj1.type));
        objectObjectHashMap.put("rebuild_level", Integer.valueOf(obj1.rebuild_level));
        objectObjectHashMap.put("color", Integer.valueOf(obj1.color));
        objectObjectHashMap.put("str", obj1.str);
        objectObjectHashMap.put("auto_fight", obj1.auto_fight);
        objectObjectHashMap.put("suit_degree", obj1.suit_degree);
        objectObjectHashMap.put("party_stage_party_name", Integer.valueOf(obj1.party_stage_party_name));
        objectObjectHashMap.put("mailing_item_times", Integer.valueOf(obj1.mailing_item_times));
        objectObjectHashMap.put("quality", obj1.quality);
        objectObjectHashMap.put("damage_sel_rate", Integer.valueOf(obj1.damage_sel_rate));
        objectObjectHashMap.put("recognize_recognized", Integer.valueOf(obj1.recognize_recognized));
        objectObjectHashMap.put("suit_enabled", Integer.valueOf(obj1.suit_enabled));
        objectObjectHashMap.put("degree_32", Integer.valueOf(obj1.degree_32));
        objectObjectHashMap.put("master", Integer.valueOf(obj1.master));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> Goods(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        Goods obj1 = (Goods) obj;
        objectObjectHashMap.put("pos", Integer.valueOf(obj1.pos));
        objectObjectHashMap.put("goodsInfo", obj1.goodsInfo);
        objectObjectHashMap.put("goodsBasics", obj1.goodsBasics);
        objectObjectHashMap.put("goodsLanSe", obj1.goodsLanSe);
        objectObjectHashMap.put("goodsFenSe", obj1.goodsFenSe);
        objectObjectHashMap.put("goodsHuangSe", obj1.goodsHuangSe);
        objectObjectHashMap.put("goodsLvSe", obj1.goodsLvSe);
        objectObjectHashMap.put("goodsGaiZao", obj1.goodsGaiZao);
        objectObjectHashMap.put("goodsGaiZaoGongMing", obj1.goodsGaiZaoGongMing);
        objectObjectHashMap.put("goodsGaiZaoGongMingChengGong", obj1.goodsGaiZaoGongMingChengGong);
        objectObjectHashMap.put("goodsLvSeGongMing", obj1.goodsLvSeGongMing);
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsBasics(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsBasics obj1 = (GoodsBasics) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("max_life", Integer.valueOf(obj1.max_life));
        objectObjectHashMap.put("max_mana", Integer.valueOf(obj1.max_mana));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsFenSe(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsFenSe obj1 = (GoodsFenSe) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("skill_low_cost", Integer.valueOf(obj1.skill_low_cost));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("all_polar", Integer.valueOf(obj1.all_polar));
        objectObjectHashMap.put("all_resist_polar", Integer.valueOf(obj1.all_resist_polar));
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("release_forgotten", Integer.valueOf(obj1.release_forgotten));
        objectObjectHashMap.put("ignore_all_resist_except", Integer.valueOf(obj1.ignore_all_resist_except));
        objectObjectHashMap.put("stunt", Integer.valueOf(obj1.stunt));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("all_skill", Integer.valueOf(obj1.all_skill));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("all_resist_except", Integer.valueOf(obj1.all_resist_except));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsGaiZao(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsGaiZao obj1 = (GoodsGaiZao) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("all_polar", Integer.valueOf(obj1.all_polar));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsGaiZaoGongMing(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsGaiZaoGongMing obj1 = (GoodsGaiZaoGongMing) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("super_excluse_wood", Integer.valueOf(obj1.super_excluse_wood));
        objectObjectHashMap.put("super_excluse_water", Integer.valueOf(obj1.super_excluse_water));
        objectObjectHashMap.put("super_excluse_fire", Integer.valueOf(obj1.super_excluse_fire));
        objectObjectHashMap.put("super_excluse_earth", Integer.valueOf(obj1.super_excluse_earth));
        objectObjectHashMap.put("B_skill_low_cost", Integer.valueOf(obj1.B_skill_low_cost));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("tao_ex", Integer.valueOf(obj1.tao_ex));
        objectObjectHashMap.put("release_confusion", Integer.valueOf(obj1.release_confusion));
        objectObjectHashMap.put("release_sleep", Integer.valueOf(obj1.release_sleep));
        objectObjectHashMap.put("release_frozen", Integer.valueOf(obj1.release_frozen));
        objectObjectHashMap.put("release_poison", Integer.valueOf(obj1.release_poison));
        objectObjectHashMap.put("C_skill_low_cost", Integer.valueOf(obj1.C_skill_low_cost));
        objectObjectHashMap.put("D_skill_low_cost", Integer.valueOf(obj1.D_skill_low_cost));
        objectObjectHashMap.put("super_poison", Integer.valueOf(obj1.super_poison));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsGaiZaoGongMingChengGong(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsGaiZaoGongMingChengGong obj1 = (GoodsGaiZaoGongMingChengGong) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("color", Integer.valueOf(obj1.color));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("super_excluse_wood", Integer.valueOf(obj1.super_excluse_wood));
        objectObjectHashMap.put("super_excluse_water", Integer.valueOf(obj1.super_excluse_water));
        objectObjectHashMap.put("super_excluse_fire", Integer.valueOf(obj1.super_excluse_fire));
        objectObjectHashMap.put("super_excluse_earth", Integer.valueOf(obj1.super_excluse_earth));
        objectObjectHashMap.put("B_skill_low_cost", Integer.valueOf(obj1.B_skill_low_cost));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("tao_ex", Integer.valueOf(obj1.tao_ex));
        objectObjectHashMap.put("release_confusion", Integer.valueOf(obj1.release_confusion));
        objectObjectHashMap.put("release_sleep", Integer.valueOf(obj1.release_sleep));
        objectObjectHashMap.put("release_frozen", Integer.valueOf(obj1.release_frozen));
        objectObjectHashMap.put("release_poison", Integer.valueOf(obj1.release_poison));
        objectObjectHashMap.put("C_skill_low_cost", Integer.valueOf(obj1.C_skill_low_cost));
        objectObjectHashMap.put("D_skill_low_cost", Integer.valueOf(obj1.D_skill_low_cost));
        objectObjectHashMap.put("super_poison", Integer.valueOf(obj1.super_poison));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsHuangSe(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsHuangSe obj1 = (GoodsHuangSe) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("skill_low_cost", Integer.valueOf(obj1.skill_low_cost));
        objectObjectHashMap.put("all_polar", Integer.valueOf(obj1.all_polar));
        objectObjectHashMap.put("all_resist_polar", Integer.valueOf(obj1.all_resist_polar));
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("release_forgotten", Integer.valueOf(obj1.release_forgotten));
        objectObjectHashMap.put("ignore_all_resist_except", Integer.valueOf(obj1.ignore_all_resist_except));
        objectObjectHashMap.put("stunt", Integer.valueOf(obj1.stunt));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("all_skill", Integer.valueOf(obj1.all_skill));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("all_resist_except", Integer.valueOf(obj1.all_resist_except));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsInfo(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsInfo obj1 = (GoodsInfo) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("value", Integer.valueOf(obj1.value));
        objectObjectHashMap.put("total_score", Integer.valueOf(obj1.total_score));
        objectObjectHashMap.put("type", Integer.valueOf(obj1.type));
        objectObjectHashMap.put("rebuild_level", Integer.valueOf(obj1.rebuild_level));
        objectObjectHashMap.put("str", obj1.str);
        objectObjectHashMap.put("auto_fight", obj1.auto_fight);
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("quality", obj1.quality);
        objectObjectHashMap.put("damage_sel_rate", Integer.valueOf(obj1.damage_sel_rate));
        objectObjectHashMap.put("recognize_recognized", Integer.valueOf(obj1.recognize_recognized));
        objectObjectHashMap.put("owner_id", Integer.valueOf(obj1.owner_id));
        objectObjectHashMap.put("dunwu_times", Integer.valueOf(obj1.dunwu_times));
        objectObjectHashMap.put("attrib", Integer.valueOf(obj1.attrib));
        objectObjectHashMap.put("gift", Integer.valueOf(obj1.gift));
        objectObjectHashMap.put("nick", Integer.valueOf(obj1.nick));
        objectObjectHashMap.put("power", Integer.valueOf(obj1.power));
        objectObjectHashMap.put("wrestlescore", Integer.valueOf(obj1.wrestlescore));
        objectObjectHashMap.put("skill", Integer.valueOf(obj1.skill));
        objectObjectHashMap.put("store_exp", Integer.valueOf(obj1.store_exp));
        objectObjectHashMap.put("metal", Integer.valueOf(obj1.metal));
        objectObjectHashMap.put("amount", Integer.valueOf(obj1.amount));
        objectObjectHashMap.put("color", Integer.valueOf(obj1.color));
        objectObjectHashMap.put("suit_degree", Integer.valueOf(obj1.suit_degree));
        objectObjectHashMap.put("party_stage_party_name", Integer.valueOf(obj1.party_stage_party_name));
        objectObjectHashMap.put("mailing_item_times", Integer.valueOf(obj1.mailing_item_times));
        objectObjectHashMap.put("suit_enabled", Integer.valueOf(obj1.suit_enabled));
        objectObjectHashMap.put("degree_32", Integer.valueOf(obj1.degree_32));
        objectObjectHashMap.put("master", Integer.valueOf(obj1.master));
        objectObjectHashMap.put("transform_cool_ti", Integer.valueOf(obj1.transform_cool_ti));
        objectObjectHashMap.put("silver_coin", Integer.valueOf(obj1.silver_coin));
        objectObjectHashMap.put("diandqk_frozen_round", Integer.valueOf(obj1.diandqk_frozen_round));
        objectObjectHashMap.put("shuadao_ziqihongmeng", Integer.valueOf(obj1.shuadao_ziqihongmeng));
        objectObjectHashMap.put("durability", Integer.valueOf(obj1.durability));
        objectObjectHashMap.put("add_pet_exp", Integer.valueOf(obj1.add_pet_exp));
        objectObjectHashMap.put("alias", obj1.alias);
        objectObjectHashMap.put("food_num", Integer.valueOf(obj1.food_num));
        objectObjectHashMap.put("merge_rate", Integer.valueOf(obj1.merge_rate));
        objectObjectHashMap.put("fasion_type", Integer.valueOf(obj1.fasion_type));
        objectObjectHashMap.put("pet_upgraded", Integer.valueOf(obj1.pet_upgraded));
        objectObjectHashMap.put("couple", Integer.valueOf(obj1.couple));
        objectObjectHashMap.put("shape", Integer.valueOf(obj1.shape));
        objectObjectHashMap.put("pot", Integer.valueOf(obj1.pot));
        objectObjectHashMap.put("resist_poison", Integer.valueOf(obj1.resist_poison));
        objectObjectHashMap.put("phy_rebuild_level", obj1.phy_rebuild_level);
        objectObjectHashMap.put("max_durability", Integer.valueOf(obj1.max_durability));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsLanSe(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsLanSe obj1 = (GoodsLanSe) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("skill_low_cost", Integer.valueOf(obj1.skill_low_cost));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("all_polar", Integer.valueOf(obj1.all_polar));
        objectObjectHashMap.put("all_resist_polar", Integer.valueOf(obj1.all_resist_polar));
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("release_forgotten", Integer.valueOf(obj1.release_forgotten));
        objectObjectHashMap.put("ignore_all_resist_except", Integer.valueOf(obj1.ignore_all_resist_except));
        objectObjectHashMap.put("stunt", Integer.valueOf(obj1.stunt));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("all_skill", Integer.valueOf(obj1.all_skill));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("all_resist_except", Integer.valueOf(obj1.all_resist_except));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("ignore_resist_wood", Integer.valueOf(obj1.ignore_resist_wood));
        objectObjectHashMap.put("ignore_resist_water", Integer.valueOf(obj1.ignore_resist_water));
        objectObjectHashMap.put("ignore_resist_fire", Integer.valueOf(obj1.ignore_resist_fire));
        objectObjectHashMap.put("ignore_resist_earth", Integer.valueOf(obj1.ignore_resist_earth));
        objectObjectHashMap.put("ignore_resist_forgotten", Integer.valueOf(obj1.ignore_resist_forgotten));
        objectObjectHashMap.put("ignore_resist_frozen", Integer.valueOf(obj1.ignore_resist_frozen));
        objectObjectHashMap.put("ignore_resist_sleep", Integer.valueOf(obj1.ignore_resist_sleep));
        objectObjectHashMap.put("ignore_resist_confusion", Integer.valueOf(obj1.ignore_resist_confusion));
        objectObjectHashMap.put("super_excluse_metal", Integer.valueOf(obj1.super_excluse_metal));
        objectObjectHashMap.put("ignore_resist_poison", Integer.valueOf(obj1.ignore_resist_poison));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsLvSe(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsLvSe obj1 = (GoodsLvSe) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("super_excluse_wood", Integer.valueOf(obj1.super_excluse_wood));
        objectObjectHashMap.put("super_excluse_water", Integer.valueOf(obj1.super_excluse_water));
        objectObjectHashMap.put("super_excluse_fire", Integer.valueOf(obj1.super_excluse_fire));
        objectObjectHashMap.put("super_excluse_earth", Integer.valueOf(obj1.super_excluse_earth));
        objectObjectHashMap.put("B_skill_low_cost", Integer.valueOf(obj1.B_skill_low_cost));
        objectObjectHashMap.put("enhanced_wood", Integer.valueOf(obj1.enhanced_wood));
        objectObjectHashMap.put("enhanced_water", Integer.valueOf(obj1.enhanced_water));
        objectObjectHashMap.put("enhanced_fire", Integer.valueOf(obj1.enhanced_fire));
        objectObjectHashMap.put("enhanced_earth", Integer.valueOf(obj1.enhanced_earth));
        objectObjectHashMap.put("mag_dodge", Integer.valueOf(obj1.mag_dodge));
        objectObjectHashMap.put("ignore_mag_dodge", Integer.valueOf(obj1.ignore_mag_dodge));
        objectObjectHashMap.put("jinguang_zhaxian_counter_att_rate", Integer.valueOf(obj1.jinguang_zhaxian_counter_att_rate));
        objectObjectHashMap.put("C_skill_low_cost", Integer.valueOf(obj1.C_skill_low_cost));
        objectObjectHashMap.put("D_skill_low_cost", Integer.valueOf(obj1.D_skill_low_cost));
        objectObjectHashMap.put("super_poison", Integer.valueOf(obj1.super_poison));
        objectObjectHashMap.put("ignore_resist_wood", Integer.valueOf(obj1.ignore_resist_wood));
        objectObjectHashMap.put("ignore_resist_water", Integer.valueOf(obj1.ignore_resist_water));
        objectObjectHashMap.put("ignore_resist_fire", Integer.valueOf(obj1.ignore_resist_fire));
        objectObjectHashMap.put("ignore_resist_earth", Integer.valueOf(obj1.ignore_resist_earth));
        objectObjectHashMap.put("ignore_resist_forgotten", Integer.valueOf(obj1.ignore_resist_forgotten));
        objectObjectHashMap.put("release_forgotten", Integer.valueOf(obj1.release_forgotten));
        objectObjectHashMap.put("ignore_all_resist_except", Integer.valueOf(obj1.ignore_all_resist_except));
        objectObjectHashMap.put("super_confusion", Integer.valueOf(obj1.super_confusion));
        objectObjectHashMap.put("super_sleep", Integer.valueOf(obj1.super_sleep));
        objectObjectHashMap.put("enhanced_metal", Integer.valueOf(obj1.enhanced_metal));
        objectObjectHashMap.put("super_forgotten", Integer.valueOf(obj1.super_forgotten));
        objectObjectHashMap.put("super_frozen", Integer.valueOf(obj1.super_frozen));
        objectObjectHashMap.put("ignore_resist_frozen", Integer.valueOf(obj1.ignore_resist_frozen));
        objectObjectHashMap.put("ignore_resist_sleep", Integer.valueOf(obj1.ignore_resist_sleep));
        objectObjectHashMap.put("ignore_resist_confusion", Integer.valueOf(obj1.ignore_resist_confusion));
        objectObjectHashMap.put("super_excluse_metal", Integer.valueOf(obj1.super_excluse_metal));
        objectObjectHashMap.put("ignore_resist_poison", Integer.valueOf(obj1.ignore_resist_poison));
        objectObjectHashMap.put("tao_ex", Integer.valueOf(obj1.tao_ex));
        objectObjectHashMap.put("release_confusion", Integer.valueOf(obj1.release_confusion));
        objectObjectHashMap.put("release_sleep", Integer.valueOf(obj1.release_sleep));
        objectObjectHashMap.put("release_frozen", Integer.valueOf(obj1.release_frozen));
        objectObjectHashMap.put("release_poison", Integer.valueOf(obj1.release_poison));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> GoodsLvSeGongMing(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        GoodsLvSeGongMing obj1 = (GoodsLvSeGongMing) obj;
        objectObjectHashMap.put("groupNo", Integer.valueOf(obj1.groupNo));
        objectObjectHashMap.put("groupType", Integer.valueOf(obj1.groupType));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> JiNeng(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        JiNeng obj1 = (JiNeng) obj;
        objectObjectHashMap.put("id", Integer.valueOf(obj1.id));
        objectObjectHashMap.put("skill_no", Integer.valueOf(obj1.skill_no));
        objectObjectHashMap.put("skill_attrib", Integer.valueOf(obj1.skill_attrib));
        objectObjectHashMap.put("skill_attrib1", Integer.valueOf(obj1.skill_attrib1));
        objectObjectHashMap.put("skill_level", Integer.valueOf(obj1.skill_level));
        objectObjectHashMap.put("level_improved", Integer.valueOf(obj1.level_improved));
        objectObjectHashMap.put("skill_mana_cost", Integer.valueOf(obj1.skill_mana_cost));
        objectObjectHashMap.put("skill_nimbus", Integer.valueOf(obj1.skill_nimbus));
        objectObjectHashMap.put("skill_disabled", Integer.valueOf(obj1.skill_disabled));
        objectObjectHashMap.put("range", Integer.valueOf(obj1.range));
        objectObjectHashMap.put("max_range", Integer.valueOf(obj1.max_range));
        objectObjectHashMap.put("count1", Integer.valueOf(obj1.count1));
        objectObjectHashMap.put("s1", obj1.s1);
        objectObjectHashMap.put("s2", Integer.valueOf(obj1.s2));
        objectObjectHashMap.put("isTempSkill", Integer.valueOf(obj1.isTempSkill));
        objectObjectHashMap.put("skillRound", Integer.valueOf(obj1.skillRound));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> LieBiao(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        LieBiao obj1 = (LieBiao) obj;
        objectObjectHashMap.put("ask_type", obj1.ask_type);
        objectObjectHashMap.put("peer_name", obj1.peer_name);
        objectObjectHashMap.put("duiyuanList", obj1.duiyuanList);
        return objectObjectHashMap;
    }


    public static Map<Object, Object> Petbeibao(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        Petbeibao obj1 = (Petbeibao) obj;
        objectObjectHashMap.put("no", Integer.valueOf(obj1.no));
        objectObjectHashMap.put("id", Integer.valueOf(obj1.id));
        objectObjectHashMap.put("petShuXing", obj1.petShuXing);
        objectObjectHashMap.put("tianshu", obj1.tianshu);
        objectObjectHashMap.put("autofight_select", Integer.valueOf(obj1.autofight_select));
        objectObjectHashMap.put("autofight_skillaction", Integer.valueOf(obj1.autofight_skillaction));
        objectObjectHashMap.put("autofight_skillno", Integer.valueOf(obj1.autofight_skillno));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> PetShuXing(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        PetShuXing obj1 = (PetShuXing) obj;
        objectObjectHashMap.put("no", Integer.valueOf(obj1.no));
        objectObjectHashMap.put("type1", Integer.valueOf(obj1.type1));
        objectObjectHashMap.put("str", obj1.str);
        objectObjectHashMap.put("max_life", Integer.valueOf(obj1.max_life));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("max_mana", Integer.valueOf(obj1.max_mana));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("skill", Integer.valueOf(obj1.skill));
        objectObjectHashMap.put("penetrate", Integer.valueOf(obj1.penetrate));
        objectObjectHashMap.put("polar_point", Integer.valueOf(obj1.polar_point));
        objectObjectHashMap.put("metal", Integer.valueOf(obj1.metal));
        objectObjectHashMap.put("stamina", Integer.valueOf(obj1.stamina));
        objectObjectHashMap.put("type", Integer.valueOf(obj1.type));
        objectObjectHashMap.put("durability", Integer.valueOf(obj1.durability));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("shape", Integer.valueOf(obj1.shape));
        objectObjectHashMap.put("pot", Integer.valueOf(obj1.pot));
        objectObjectHashMap.put("loyalty", Integer.valueOf(obj1.loyalty));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("martial", Integer.valueOf(obj1.martial));
        objectObjectHashMap.put("resist_point", Integer.valueOf(obj1.resist_point));
        objectObjectHashMap.put("intimacy", Integer.valueOf(obj1.intimacy));
        objectObjectHashMap.put("last_mon_martial", Integer.valueOf(obj1.last_mon_martial));
        objectObjectHashMap.put("mon_tao_rank", Integer.valueOf(obj1.mon_tao_rank));
        objectObjectHashMap.put("double_hit", Integer.valueOf(obj1.double_hit));
        objectObjectHashMap.put("resist_poison", Integer.valueOf(obj1.resist_poison));
        objectObjectHashMap.put("passive_mode", Integer.valueOf(obj1.passive_mode));
        objectObjectHashMap.put("pet_mana_shape", Integer.valueOf(obj1.pet_mana_shape));
        objectObjectHashMap.put("pet_speed_shape", Integer.valueOf(obj1.pet_speed_shape));
        objectObjectHashMap.put("pet_phy_shape", Integer.valueOf(obj1.pet_phy_shape));
        objectObjectHashMap.put("pet_mag_shape", Integer.valueOf(obj1.pet_mag_shape));
        objectObjectHashMap.put("rank", Integer.valueOf(obj1.rank));
        objectObjectHashMap.put("pet_upgraded", Integer.valueOf(obj1.pet_upgraded));
        objectObjectHashMap.put("party_stage_party_name", Integer.valueOf(obj1.party_stage_party_name));
        objectObjectHashMap.put("left_time_to_delete", Integer.valueOf(obj1.left_time_to_delete));
        objectObjectHashMap.put("extra_mana", Integer.valueOf(obj1.extra_mana));
        objectObjectHashMap.put("have_coin_pwd", Integer.valueOf(obj1.have_coin_pwd));
        objectObjectHashMap.put("mag_rebuild_level", Integer.valueOf(obj1.mag_rebuild_level));
        objectObjectHashMap.put("raw_name", Integer.valueOf(obj1.raw_name));
        objectObjectHashMap.put("suit_light_effect", Integer.valueOf(obj1.suit_light_effect));
        objectObjectHashMap.put("mag_rebuild_rate", Integer.valueOf(obj1.mag_rebuild_rate));
        objectObjectHashMap.put("life_add_temp", Integer.valueOf(obj1.life_add_temp));
        objectObjectHashMap.put("mag_rebuild_add", Integer.valueOf(obj1.mag_rebuild_add));
        objectObjectHashMap.put("pet_life_shape_temp", Integer.valueOf(obj1.pet_life_shape_temp));
        objectObjectHashMap.put("pet_mana_shape_temp", Integer.valueOf(obj1.pet_mana_shape_temp));
        objectObjectHashMap.put("pet_speed_shape_temp", Integer.valueOf(obj1.pet_speed_shape_temp));
        objectObjectHashMap.put("pet_phy_shape_temp", Integer.valueOf(obj1.pet_phy_shape_temp));
        objectObjectHashMap.put("pet_mag_shape_temp", Integer.valueOf(obj1.pet_mag_shape_temp));
        objectObjectHashMap.put("evolve_degree", Integer.valueOf(obj1.evolve_degree));
        objectObjectHashMap.put("mana_add_temp", Integer.valueOf(obj1.mana_add_temp));
        objectObjectHashMap.put("phy_power_add_temp", Integer.valueOf(obj1.phy_power_add_temp));
        objectObjectHashMap.put("def_add_temp", Integer.valueOf(obj1.def_add_temp));
        objectObjectHashMap.put("mag_power_add_temp", Integer.valueOf(obj1.mag_power_add_temp));
        objectObjectHashMap.put("speed_add_temp", Integer.valueOf(obj1.speed_add_temp));
        objectObjectHashMap.put("shuadaojiji_rulvling", Integer.valueOf(obj1.shuadaojiji_rulvling));
        objectObjectHashMap.put("recognize_recognized", Integer.valueOf(obj1.recognize_recognized));
        objectObjectHashMap.put("attrib", Integer.valueOf(obj1.attrib));
        objectObjectHashMap.put("enchant_nimbus", Integer.valueOf(obj1.enchant_nimbus));
        objectObjectHashMap.put("max_enchant_nimbus", Integer.valueOf(obj1.max_enchant_nimbus));
        objectObjectHashMap.put("card_type", Integer.valueOf(obj1.card_type));
        objectObjectHashMap.put("eclosion_nimbus", Integer.valueOf(obj1.eclosion_nimbus));
        objectObjectHashMap.put("max_eclosion_nimbus", Integer.valueOf(obj1.max_eclosion_nimbus));
        objectObjectHashMap.put("status_all_resist_except_add", Integer.valueOf(obj1.status_all_resist_except_add));
        objectObjectHashMap.put("status_yanchuan_shenjiao", Integer.valueOf(obj1.status_yanchuan_shenjiao));
        objectObjectHashMap.put("insider_level", obj1.insider_level);
        objectObjectHashMap.put("mana_effect", Integer.valueOf(obj1.mana_effect));
        objectObjectHashMap.put("attack_effect", Integer.valueOf(obj1.attack_effect));
        objectObjectHashMap.put("phy_effect", Integer.valueOf(obj1.phy_effect));
        objectObjectHashMap.put("mag_effect", Integer.valueOf(obj1.mag_effect));
        objectObjectHashMap.put("phy_absorb", Integer.valueOf(obj1.phy_absorb));
        objectObjectHashMap.put("extra_mana_effect", Integer.valueOf(obj1.extra_mana_effect));
        objectObjectHashMap.put("extra_mag_effect", Integer.valueOf(obj1.extra_mag_effect));
        objectObjectHashMap.put("extra_phy_effect", Integer.valueOf(obj1.extra_phy_effect));
        objectObjectHashMap.put("extra_speed_effect", Integer.valueOf(obj1.extra_speed_effect));
        objectObjectHashMap.put("morph_life_times", Integer.valueOf(obj1.morph_life_times));
        objectObjectHashMap.put("morph_mana_times", Integer.valueOf(obj1.morph_mana_times));
        objectObjectHashMap.put("morph_speed_times", Integer.valueOf(obj1.morph_speed_times));
        objectObjectHashMap.put("morph_phy_times", Integer.valueOf(obj1.morph_phy_times));
        objectObjectHashMap.put("morph_mag_times", Integer.valueOf(obj1.morph_mag_times));
        objectObjectHashMap.put("morph_life_stat", Integer.valueOf(obj1.morph_life_stat));
        objectObjectHashMap.put("morph_mana_stat", Integer.valueOf(obj1.morph_mana_stat));
        objectObjectHashMap.put("morph_speed_stat", Integer.valueOf(obj1.morph_speed_stat));
        objectObjectHashMap.put("morph_phy_stat", Integer.valueOf(obj1.morph_phy_stat));
        objectObjectHashMap.put("morph_mag_stat", Integer.valueOf(obj1.morph_mag_stat));
        objectObjectHashMap.put("free_unlock_exp_times", Integer.valueOf(obj1.free_unlock_exp_times));
        objectObjectHashMap.put("mount_attribmove_speed", Integer.valueOf(obj1.mount_attribmove_speed));
        objectObjectHashMap.put("capacity_level", Integer.valueOf(obj1.capacity_level));
        objectObjectHashMap.put("hide_mount", Integer.valueOf(obj1.hide_mount));
        objectObjectHashMap.put("equip_perfect_percent", Integer.valueOf(obj1.equip_perfect_percent));
        objectObjectHashMap.put("deadline", Integer.valueOf(obj1.deadline));
        objectObjectHashMap.put("merge_rate", Integer.valueOf(obj1.merge_rate));
        objectObjectHashMap.put("dunwu_rate", Integer.valueOf(obj1.dunwu_rate));
        objectObjectHashMap.put("pet_anger", Integer.valueOf(obj1.pet_anger));
        objectObjectHashMap.put("status_huanbing_zhiji", Integer.valueOf(obj1.status_huanbing_zhiji));
        objectObjectHashMap.put("gm_attribsmax_life", Integer.valueOf(obj1.gm_attribsmax_life));
        objectObjectHashMap.put("gm_attribsmax_mana", Integer.valueOf(obj1.gm_attribsmax_mana));
        objectObjectHashMap.put("gm_attribsphy_power", Integer.valueOf(obj1.gm_attribsphy_power));
        objectObjectHashMap.put("gm_attribsmag_power", Integer.valueOf(obj1.gm_attribsmag_power));
        objectObjectHashMap.put("gm_attribsdef", Integer.valueOf(obj1.gm_attribsdef));
        objectObjectHashMap.put("gm_attribsspeed", Integer.valueOf(obj1.gm_attribsspeed));
        objectObjectHashMap.put("limit_use_time", Integer.valueOf(obj1.limit_use_time));
        objectObjectHashMap.put("mag_power_without_intimacy", Integer.valueOf(obj1.mag_power_without_intimacy));
        objectObjectHashMap.put("def_without_intimacy", Integer.valueOf(obj1.def_without_intimacy));
        objectObjectHashMap.put("origin_intimacy", Integer.valueOf(obj1.origin_intimacy));
        objectObjectHashMap.put("douchong_rank", Integer.valueOf(obj1.douchong_rank));
        objectObjectHashMap.put("fasion_id", Integer.valueOf(obj1.fasion_id));
        objectObjectHashMap.put("fasion_visible", Integer.valueOf(obj1.fasion_visible));
        objectObjectHashMap.put("auto_fight", obj1.auto_fight);
        objectObjectHashMap.put("suit_polar", obj1.suit_polar);
        objectObjectHashMap.put("all_polar", Integer.valueOf(obj1.all_polar));
        objectObjectHashMap.put("upgrade_magic", Integer.valueOf(obj1.upgrade_magic));
        objectObjectHashMap.put("upgrade_total", Integer.valueOf(obj1.upgrade_total));
        objectObjectHashMap.put("silver_coin", Integer.valueOf(obj1.silver_coin));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> ShouHu(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        ShouHu obj1 = (ShouHu) obj;
        objectObjectHashMap.put("id", Integer.valueOf(obj1.id));
        objectObjectHashMap.put("listShouHuShuXing", obj1.listShouHuShuXing);
        return objectObjectHashMap;
    }


    public static Map<Object, Object> ShouHuShuXing(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        ShouHuShuXing obj1 = (ShouHuShuXing) obj;
        objectObjectHashMap.put("no", Integer.valueOf(obj1.no));
        objectObjectHashMap.put("type1", Integer.valueOf(obj1.type1));
        objectObjectHashMap.put("str", obj1.str);
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("skill", Integer.valueOf(obj1.skill));
        objectObjectHashMap.put("type", Integer.valueOf(obj1.type));
        objectObjectHashMap.put("shape", Integer.valueOf(obj1.shape));
        objectObjectHashMap.put("nil", Integer.valueOf(obj1.nil));
        objectObjectHashMap.put("penetrate", Integer.valueOf(obj1.penetrate));
        objectObjectHashMap.put("metal", Integer.valueOf(obj1.metal));
        objectObjectHashMap.put("max_degree", Integer.valueOf(obj1.max_degree));
        objectObjectHashMap.put("color", Integer.valueOf(obj1.color));
        objectObjectHashMap.put("exp", Integer.valueOf(obj1.exp));
        objectObjectHashMap.put("store_exp", Integer.valueOf(obj1.store_exp));
        objectObjectHashMap.put("salary", Integer.valueOf(obj1.salary));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("suit_polar", obj1.suit_polar);
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("max_life", Integer.valueOf(obj1.max_life));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        return objectObjectHashMap;
    }


    public static Map<Object, Object> ShuXingUtil(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        ShuXingUtil obj1 = (ShuXingUtil) obj;
        return objectObjectHashMap;
    }


    public static Map<Object, Object> ZbAttribute(Object obj) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        ZbAttribute obj1 = (ZbAttribute) obj;
        objectObjectHashMap.put("id", Integer.valueOf(obj1.id));
        objectObjectHashMap.put("phy_power", Integer.valueOf(obj1.phy_power));
        objectObjectHashMap.put("mag_power", Integer.valueOf(obj1.mag_power));
        objectObjectHashMap.put("speed", Integer.valueOf(obj1.speed));
        objectObjectHashMap.put("life", Integer.valueOf(obj1.life));
        objectObjectHashMap.put("skill_low_cost", Integer.valueOf(obj1.skill_low_cost));
        objectObjectHashMap.put("mstunt_rate", Integer.valueOf(obj1.mstunt_rate));
        objectObjectHashMap.put("wood", Integer.valueOf(obj1.wood));
        objectObjectHashMap.put("water", Integer.valueOf(obj1.water));
        objectObjectHashMap.put("fire", Integer.valueOf(obj1.fire));
        objectObjectHashMap.put("earth", Integer.valueOf(obj1.earth));
        objectObjectHashMap.put("resist_metal", Integer.valueOf(obj1.resist_metal));
        objectObjectHashMap.put("damage_sel", Integer.valueOf(obj1.damage_sel));
        objectObjectHashMap.put("stunt_rate", Integer.valueOf(obj1.stunt_rate));
        objectObjectHashMap.put("double_hit_rate", Integer.valueOf(obj1.double_hit_rate));
        objectObjectHashMap.put("release_forgotten", Integer.valueOf(obj1.release_forgotten));
        objectObjectHashMap.put("ignore_all_resist_except", Integer.valueOf(obj1.ignore_all_resist_except));
        objectObjectHashMap.put("stunt", Integer.valueOf(obj1.stunt));
        objectObjectHashMap.put("def", Integer.valueOf(obj1.def));
        objectObjectHashMap.put("dex", Integer.valueOf(obj1.dex));
        objectObjectHashMap.put("wiz", Integer.valueOf(obj1.wiz));
        objectObjectHashMap.put("family", Integer.valueOf(obj1.family));
        objectObjectHashMap.put("life_recover", Integer.valueOf(obj1.life_recover));
        objectObjectHashMap.put("all_skill", Integer.valueOf(obj1.all_skill));
        objectObjectHashMap.put("portrait", Integer.valueOf(obj1.portrait));
        objectObjectHashMap.put("resist_frozen", Integer.valueOf(obj1.resist_frozen));
        objectObjectHashMap.put("resist_sleep", Integer.valueOf(obj1.resist_sleep));
        objectObjectHashMap.put("resist_forgotten", Integer.valueOf(obj1.resist_forgotten));
        objectObjectHashMap.put("resist_confusion", Integer.valueOf(obj1.resist_confusion));
        objectObjectHashMap.put("longevity", Integer.valueOf(obj1.longevity));
        objectObjectHashMap.put("resist_wood", Integer.valueOf(obj1.resist_wood));
        objectObjectHashMap.put("resist_water", Integer.valueOf(obj1.resist_water));
        objectObjectHashMap.put("resist_fire", Integer.valueOf(obj1.resist_fire));
        objectObjectHashMap.put("resist_earth", Integer.valueOf(obj1.resist_earth));
        objectObjectHashMap.put("exp_to_next_level", Integer.valueOf(obj1.exp_to_next_level));
        objectObjectHashMap.put("all_resist_except", Integer.valueOf(obj1.all_resist_except));
        objectObjectHashMap.put("accurate", Integer.valueOf(obj1.accurate));
        objectObjectHashMap.put("mana", Integer.valueOf(obj1.mana));
        objectObjectHashMap.put("parry", Integer.valueOf(obj1.parry));
        objectObjectHashMap.put("super_excluse_wood", Integer.valueOf(obj1.super_excluse_wood));
        objectObjectHashMap.put("super_excluse_water", Integer.valueOf(obj1.super_excluse_water));
        objectObjectHashMap.put("super_excluse_fire", Integer.valueOf(obj1.super_excluse_fire));
        objectObjectHashMap.put("super_excluse_earth", Integer.valueOf(obj1.super_excluse_earth));
        objectObjectHashMap.put("B_skill_low_cost", Integer.valueOf(obj1.B_skill_low_cost));
        objectObjectHashMap.put("enhanced_wood", Integer.valueOf(obj1.enhanced_wood));
        objectObjectHashMap.put("enhanced_water", Integer.valueOf(obj1.enhanced_water));
        objectObjectHashMap.put("enhanced_fire", Integer.valueOf(obj1.enhanced_fire));
        objectObjectHashMap.put("enhanced_earth", Integer.valueOf(obj1.enhanced_earth));
        objectObjectHashMap.put("mag_dodge", Integer.valueOf(obj1.mag_dodge));
        objectObjectHashMap.put("ignore_mag_dodge", Integer.valueOf(obj1.ignore_mag_dodge));
        objectObjectHashMap.put("jinguang_zhaxian_counter_att_rate", Integer.valueOf(obj1.jinguang_zhaxian_counter_att_rate));
        objectObjectHashMap.put("C_skill_low_cost", Integer.valueOf(obj1.C_skill_low_cost));
        objectObjectHashMap.put("D_skill_low_cost", Integer.valueOf(obj1.D_skill_low_cost));
        objectObjectHashMap.put("super_poison", Integer.valueOf(obj1.super_poison));
        objectObjectHashMap.put("ignore_resist_wood", Integer.valueOf(obj1.ignore_resist_wood));
        objectObjectHashMap.put("ignore_resist_water", Integer.valueOf(obj1.ignore_resist_water));
        objectObjectHashMap.put("ignore_resist_fire", Integer.valueOf(obj1.ignore_resist_fire));
        objectObjectHashMap.put("ignore_resist_earth", Integer.valueOf(obj1.ignore_resist_earth));
        objectObjectHashMap.put("ignore_resist_forgotten", Integer.valueOf(obj1.ignore_resist_forgotten));
        objectObjectHashMap.put("super_confusion", Integer.valueOf(obj1.super_confusion));
        objectObjectHashMap.put("super_sleep", Integer.valueOf(obj1.super_sleep));
        objectObjectHashMap.put("enhanced_metal", Integer.valueOf(obj1.enhanced_metal));
        objectObjectHashMap.put("super_forgotten", Integer.valueOf(obj1.super_forgotten));
        objectObjectHashMap.put("super_frozen", Integer.valueOf(obj1.super_frozen));
        objectObjectHashMap.put("ignore_resist_frozen", Integer.valueOf(obj1.ignore_resist_frozen));
        objectObjectHashMap.put("ignore_resist_sleep", Integer.valueOf(obj1.ignore_resist_sleep));
        objectObjectHashMap.put("ignore_resist_confusion", Integer.valueOf(obj1.ignore_resist_confusion));
        objectObjectHashMap.put("super_excluse_metal", Integer.valueOf(obj1.super_excluse_metal));
        objectObjectHashMap.put("ignore_resist_poison", Integer.valueOf(obj1.ignore_resist_poison));
        objectObjectHashMap.put("tao_ex", Integer.valueOf(obj1.tao_ex));
        objectObjectHashMap.put("release_confusion", Integer.valueOf(obj1.release_confusion));
        objectObjectHashMap.put("release_sleep", Integer.valueOf(obj1.release_sleep));
        objectObjectHashMap.put("release_frozen", Integer.valueOf(obj1.release_frozen));
        objectObjectHashMap.put("release_poison", Integer.valueOf(obj1.release_poison));
        return objectObjectHashMap;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\UtilObjMapshuxing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */