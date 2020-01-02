package org.linlinjava.litemall.gameserver.data.write;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49153_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZao;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMing;
import org.linlinjava.litemall.gameserver.domain.GoodsHuangSe;

@org.springframework.stereotype.Service
public class M49153_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(io.netty.buffer.ByteBuf writeBuf, Object object) {
        Vo_49153_0 object1 = (Vo_49153_0) object;
        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.level));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.special_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.weapon_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_icon));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.suit_effect));

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.power));

        GameWriteTool.writeString(writeBuf, object1.partyName);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.fashionIcon));

        GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.upgradetype));

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.upgradelevel));


        List<Goods> list = object1.backpack;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(list.size()));
        Entry<Object, Object> entry;
        for (int i = 0; i < list.size(); i++) {
            Goods goods = (Goods) list.get(i);
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(goods.pos));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(10));
            Map<Object, Object> map = new java.util.HashMap();
            Entry<Object, Object> objectObjectEntry;
            if (goods.goodsInfo != null) {
                map = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();

                while (it.hasNext()) {
                    objectObjectEntry = (Entry) it.next();
                    if ((objectObjectEntry.getValue().equals(Integer.valueOf(0))) && (objectObjectEntry.getKey().equals("silver_coin"))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry1 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry1.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry1.getKey()).write(writeBuf, objectObjectEntry1.getValue());
                    } else
                        System.out.println(objectObjectEntry1.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry1;
            if (goods.goodsBasics != null) {
                map = UtilObjMapshuxing.GoodsBasics(goods.goodsBasics);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry1 = (Entry) it.next();
                    if (objectObjectEntry1.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry2 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry2.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry2.getKey()).write(writeBuf, objectObjectEntry2.getValue());
                    } else
                        System.out.println(objectObjectEntry2.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry2;
            if (goods.goodsLanSe != null) {
                map = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry2 = (Entry) it.next();
                    if (objectObjectEntry2.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry3 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry3.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry3.getKey()).write(writeBuf, objectObjectEntry3.getValue());
                    } else
                        System.out.println(objectObjectEntry3.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry3;
            if (goods.goodsFenSe != null) {
                map = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry3 = (Entry) it.next();
                    if (objectObjectEntry3.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry4 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry4.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry4.getKey()).write(writeBuf, objectObjectEntry4.getValue());
                    } else
                        System.out.println(objectObjectEntry4.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry4;
            if (goods.goodsHuangSe != null) {
                map = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry4 = (Entry) it.next();
                    if (objectObjectEntry4.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry.getKey()) != null) {
                        BuildFields.get((String) objectEntry.getKey()).write(writeBuf, objectEntry.getValue());
                    } else
                        System.out.println(objectEntry.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry5;
            if (goods.goodsLvSe != null) {
                map = UtilObjMapshuxing.GoodsLvSe(goods.goodsLvSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry5 = (Entry) it.next();
                    if (objectObjectEntry5.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry6 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry6.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry6.getKey()).write(writeBuf, objectObjectEntry6.getValue());
                    } else
                        System.out.println(objectObjectEntry6.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry6;
            if (goods.goodsGaiZao != null) {
                map = UtilObjMapshuxing.GoodsGaiZao(goods.goodsGaiZao);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry6 = (Entry) it.next();
                    if (objectObjectEntry6.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry7 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry7.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry7.getKey()).write(writeBuf, objectObjectEntry7.getValue());
                    } else
                        System.out.println(objectObjectEntry7.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry7;
            if (goods.goodsGaiZaoGongMing != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry7 = (Entry) it.next();
                    if (objectObjectEntry7.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry8 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry8.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry8.getKey()).write(writeBuf, objectObjectEntry8.getValue());
                    } else
                        System.out.println(objectObjectEntry8.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry8;
            if (goods.goodsGaiZaoGongMingChengGong != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMingChengGong(goods.goodsGaiZaoGongMingChengGong);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry8 = (Entry) it.next();
                    if (objectObjectEntry8.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry9 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry9.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry9.getKey()).write(writeBuf, objectObjectEntry9.getValue());
                    } else {
                        System.out.println(objectObjectEntry9.getKey());
                    }
                }
            }
            if (goods.goodsLvSeGongMing != null) {
                map = UtilObjMapshuxing.GoodsLvSeGongMing(goods.goodsLvSeGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSeGongMing.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSeGongMing.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry8 = (Entry) it.next();
                    if (objectObjectEntry8.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry9 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry9.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry9.getKey()).write(writeBuf, objectObjectEntry9.getValue());
                    } else {
                        System.out.println(objectObjectEntry9.getKey());
                    }
                }
            }
        }
    }


    public int cmd() {
        return 49153;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M49153_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */