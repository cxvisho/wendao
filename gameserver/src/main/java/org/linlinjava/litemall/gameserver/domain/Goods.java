package org.linlinjava.litemall.gameserver.domain;

import java.util.UUID;

import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;


public class Goods {
    public int pos = 45;
    public GoodsInfo goodsInfo = new GoodsInfo();
    public GoodsBasics goodsBasics = new GoodsBasics();
    public GoodsLanSe goodsLanSe = new GoodsLanSe();
    public GoodsFenSe goodsFenSe = new GoodsFenSe();
    public GoodsHuangSe goodsHuangSe = new GoodsHuangSe();
    public GoodsLvSe goodsLvSe = new GoodsLvSe();
    public GoodsGaiZao goodsGaiZao = new GoodsGaiZao();
    public GoodsGaiZaoGongMing goodsGaiZaoGongMing = new GoodsGaiZaoGongMing();
    public GoodsGaiZaoGongMingChengGong goodsGaiZaoGongMingChengGong = new GoodsGaiZaoGongMingChengGong();
    public GoodsLvSeGongMing goodsLvSeGongMing = new GoodsLvSeGongMing();

    public void goodsDaoju(StoreInfo info) {
        if (info.getQuality() != null) {
            this.goodsInfo.quality = info.getQuality();
        }
        if (info.getSilverCoin() != null) {
            this.goodsInfo.silver_coin = info.getSilverCoin().intValue();
        }
        if (info.getName().equals("血玲珑")) {
            this.goodsBasics.max_life = 4000000;
            this.goodsInfo.phy_rebuild_level = "剩余血量：4,000,000";
        }
        if (info.getName().equals("法玲珑")) {
            this.goodsBasics.max_mana = 4000000;
            this.goodsInfo.phy_rebuild_level = "剩余法力：4,000,000";
        }
        if (info.getName().equals("中级血玲珑")) {
            this.goodsBasics.max_life = 10000000;
            this.goodsInfo.phy_rebuild_level = "剩余血量：10,000,000";
        }
        if (info.getName().equals("中级法玲珑")) {
            this.goodsBasics.max_mana = 10000000;
            this.goodsInfo.phy_rebuild_level = "剩余法力：10,000,000";
        }
        if (info.getName().equals("火眼金睛")) {
            this.goodsInfo.max_durability = 10;
        }
        this.goodsInfo.type = info.getType().intValue();
        this.goodsInfo.str = info.getName();

        this.goodsInfo.recognize_recognized = 0;
        this.goodsInfo.auto_fight = UUID.randomUUID().toString();
        this.goodsInfo.total_score = info.getTotalScore().intValue();
        this.goodsInfo.rebuild_level = info.getRebuildLevel().intValue();
        this.goodsInfo.value = info.getValue().intValue();
        this.goodsInfo.degree_32 = 1;
    }

    public void goodsCreate(ZhuangbeiInfo info) {
        this.goodsInfo.amount = info.getAmount().intValue();
        this.goodsInfo.auto_fight = UUID.randomUUID().toString();
        this.goodsInfo.master = info.getMaster().intValue();
        this.goodsInfo.type = info.getType().intValue();
        this.goodsInfo.str = info.getStr();
        this.goodsInfo.metal = info.getMetal().intValue();
        this.goodsInfo.quality = info.getQuality();
        this.goodsInfo.attrib = info.getAttrib().intValue();
        this.goodsInfo.total_score = 1;


        this.goodsInfo.rebuild_level = 1500;
        this.goodsInfo.recognize_recognized = 1;
        this.goodsInfo.damage_sel_rate = 1000;
        this.goodsInfo.owner_id = 1;
        this.goodsInfo.dunwu_times = 0;


        this.goodsInfo.gift = 0;

        this.goodsInfo.nick = 0;
        this.goodsInfo.power = 0;
        this.goodsInfo.wrestlescore = 0;
        this.goodsInfo.skill = 0;
        this.goodsInfo.store_exp = 0;
        this.goodsInfo.suit_degree = 0;
        this.goodsInfo.party_stage_party_name = 0;

        this.goodsInfo.mailing_item_times = 0;
        this.goodsInfo.suit_enabled = 0;
        this.goodsInfo.degree_32 = 0;
        this.goodsInfo.value = 8388608;
        this.goodsInfo.color = 0;
        this.goodsBasics.accurate = info.getAccurate().intValue();
        this.goodsBasics.def = info.getDef().intValue();
        this.goodsBasics.dex = info.getDex().intValue();
        this.goodsBasics.mana = info.getMana().intValue();
        this.goodsBasics.parry = info.getParry().intValue();
        this.goodsBasics.wiz = info.getWiz().intValue();
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\domain\Goods.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */