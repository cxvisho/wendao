package org.linlinjava.litemall.gameserver.data.write;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsFenSe;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZao;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMing;
import org.linlinjava.litemall.gameserver.domain.GoodsHuangSe;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;

@org.springframework.stereotype.Service
public class M65525_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(io.netty.buffer.ByteBuf writeBuf, Object object) {
        List<Goods> list = (List) object;
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(list.size()));
        Entry<Object, Object> entry;
        for (int i = 0; i < list.size(); i++) {
            Goods goods = (Goods) list.get(i);
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.pos));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(10));
            Map<Object, Object> map = new java.util.HashMap();
            Entry<Object, Object> objectEntry;
            if (goods.goodsInfo != null) {
                map = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();

                while (it.hasNext()) {
                    objectEntry = (Entry) it.next();
                    if ((objectEntry.getValue().equals(Integer.valueOf(0))) && (objectEntry.getKey().equals("silver_coin"))) {
                        it.remove();
                    }
                    if ((objectEntry.getValue().equals(Integer.valueOf(0))) && (objectEntry.getKey().equals("pot"))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry1 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry1.getKey()) != null) {
                        BuildFields.get((String) objectEntry1.getKey()).write(writeBuf, objectEntry1.getValue());
                    } else
                        System.out.println(objectEntry1.getKey());
                }
            }
            Entry<Object, Object> objectEntry1;
            if (goods.goodsBasics != null) {
                map = UtilObjMapshuxing.GoodsBasics(goods.goodsBasics);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry1 = (Entry) it.next();
                    if (objectEntry1.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry2 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry2.getKey()) != null) {
                        BuildFields.get((String) objectEntry2.getKey()).write(writeBuf, objectEntry2.getValue());
                    } else
                        System.out.println(objectEntry2.getKey());
                }
            }
            Entry<Object, Object> objectEntry2;
            if (goods.goodsLanSe != null) {
                map = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry2 = (Entry) it.next();
                    if (objectEntry2.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry3 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry3.getKey()) != null) {
                        BuildFields.get((String) objectEntry3.getKey()).write(writeBuf, objectEntry3.getValue());
                    } else
                        System.out.println(objectEntry3.getKey());
                }
            }
            Entry<Object, Object> objectEntry3;
            if (goods.goodsFenSe != null) {
                map = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry3 = (Entry) it.next();
                    if (objectEntry3.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry4 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry4.getKey()) != null) {
                        BuildFields.get((String) objectEntry4.getKey()).write(writeBuf, objectEntry4.getValue());
                    } else
                        System.out.println(objectEntry4.getKey());
                }
            }
            Entry<Object, Object> objectEntry4;
            if (goods.goodsHuangSe != null) {
                map = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry4 = (Entry) it.next();
                    if (objectEntry4.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry5 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry5.getKey()) != null) {

                        BuildFields.get((String) objectEntry5.getKey()).write(writeBuf, objectEntry5.getValue());
                    } else
                        System.out.println(objectEntry5.getKey());
                }
            }
            Entry<Object, Object> objectEntry5;
            if (goods.goodsLvSe != null) {
                map = UtilObjMapshuxing.GoodsLvSe(goods.goodsLvSe);
                map.remove("groupNo");
                map.remove("groupType");
                map.remove("speed");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry5 = (Entry) it.next();
                    if (objectEntry5.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry6 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry6.getKey()) != null) {
                        BuildFields.get((String) objectEntry6.getKey()).write(writeBuf, objectEntry6.getValue());
                    } else
                        System.out.println(objectEntry6.getKey());
                }
            }
            Entry<Object, Object> objectEntry6;
            if (goods.goodsGaiZao != null) {
                map = UtilObjMapshuxing.GoodsGaiZao(goods.goodsGaiZao);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry6 = (Entry) it.next();
                    if (objectEntry6.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry7 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry7.getKey()) != null) {
                        BuildFields.get((String) objectEntry7.getKey()).write(writeBuf, objectEntry7.getValue());
                    } else
                        System.out.println(objectEntry7.getKey());
                }
            }
            Entry<Object, Object> objectEntry7;
            if (goods.goodsGaiZaoGongMing != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry7 = (Entry) it.next();
                    if (objectEntry7.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry8 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry8.getKey()) != null) {
                        BuildFields.get((String) objectEntry8.getKey()).write(writeBuf, objectEntry8.getValue());
                    } else
                        System.out.println(objectEntry8.getKey());
                }
            }
            Entry<Object, Object> objectEntry8;
            if (goods.goodsGaiZaoGongMingChengGong != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMingChengGong(goods.goodsGaiZaoGongMingChengGong);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectEntry8 = (Entry) it.next();
                    if (objectEntry8.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry9 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry9.getKey()) != null) {
                        BuildFields.get((String) objectEntry9.getKey()).write(writeBuf, objectEntry9.getValue());
                    } else {
                        System.out.println(objectEntry9.getKey());
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
                    objectEntry8 = (Entry) it.next();
                    if (objectEntry8.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry9 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry9.getKey()) != null) {
                        BuildFields.get((String) objectEntry9.getKey()).write(writeBuf, objectEntry9.getValue());
                    } else {
                        System.out.println(objectEntry9.getKey());
                    }
                }
            }
        }
    }


    public int cmd() {
        return 65525;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M65525_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */