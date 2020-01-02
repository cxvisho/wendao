package org.linlinjava.litemall.gameserver.data.write;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMing;

@org.springframework.stereotype.Service
public class M61677_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(io.netty.buffer.ByteBuf writeBuf, Object object) {
        Vo_61677_0 object1 = (Vo_61677_0) object;
        GameWriteTool.writeString(writeBuf, object1.store_type);

        GameWriteTool.writeInt(writeBuf, Integer.valueOf(object1.npcID));

        List<Goods> list = object1.list;

        GameWriteTool.writeShort(writeBuf, Integer.valueOf(object1.count));

        Entry<Object, Object> entry;
        for (int j = 0; j < list.size(); j++) {
            Goods goods = (Goods) list.get(j);
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isGoon));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(goods.pos));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(10));
            Map<Object, Object> map = new HashMap();
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
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectEntry1 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectEntry1.getKey()) != null) {
                        BuildFields.get((String) objectEntry1.getKey()).write(writeBuf, objectEntry1.getValue());
                    } else
                        System.out.println(objectEntry1.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry;
            if (goods.goodsBasics != null) {
                map = UtilObjMapshuxing.GoodsBasics(goods.goodsBasics);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry = (Entry) it.next();
                    if (objectObjectEntry.getValue().equals(Integer.valueOf(0))) {
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
            Entry<Object, Object> objectObjectEntry1;
            if (goods.goodsLanSe != null) {
                map = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupType));
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
            if (goods.goodsFenSe != null) {
                map = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsFenSe.groupType));
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
            if (goods.goodsHuangSe != null) {
                map = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsHuangSe.groupType));
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
            if (goods.goodsLvSe != null) {
                map = UtilObjMapshuxing.GoodsLvSe(goods.goodsLvSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSe.groupType));
                Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    objectObjectEntry4 = (Entry) it.next();
                    if (objectObjectEntry4.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry5 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry5.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry5.getKey()).write(writeBuf, objectObjectEntry5.getValue());
                    } else
                        System.out.println(objectObjectEntry5.getKey());
                }
            }
            Entry<Object, Object> objectObjectEntry5;
            if (goods.goodsGaiZao != null) {
                map = UtilObjMapshuxing.GoodsGaiZao(goods.goodsGaiZao);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupType));
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
            if (goods.goodsGaiZaoGongMing != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupType));
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
            if (goods.goodsGaiZaoGongMingChengGong != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMingChengGong(goods.goodsGaiZaoGongMingChengGong);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupNo));
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupType));
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
                    } else {
                        System.out.println(objectObjectEntry8.getKey());
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
                    objectObjectEntry7 = (Entry) it.next();
                    if (objectObjectEntry7.getValue().equals(Integer.valueOf(0))) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
                for (Entry<Object, Object> objectObjectEntry8 : map.entrySet()) {
                    if (BuildFields.data.get((String) objectObjectEntry8.getKey()) != null) {
                        BuildFields.get((String) objectObjectEntry8.getKey()).write(writeBuf, objectObjectEntry8.getValue());
                    } else {
                        System.out.println(objectObjectEntry8.getKey());
                    }
                }
            }
        }
        for (int i = 201; i < 335; i++) {
            if (weizhi(list, i)) {
                GameWriteTool.writeByte(writeBuf, Integer.valueOf(object1.isGoon));
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(i));
                GameWriteTool.writeShort(writeBuf, Integer.valueOf(0));
            }
        }
    }

    public int cmd() {
        return 61677;
    }

    public boolean weizhi(List<Goods> list, int j) {
        HashMap<Object, Object> map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(Integer.valueOf(((Goods) list.get(i)).pos), Integer.valueOf(((Goods) list.get(i)).pos));
        }
        if (map.get(Integer.valueOf(j)) == null) {
            return true;
        }
        return false;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M61677_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */