package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZao;
import org.linlinjava.litemall.gameserver.domain.GoodsGaiZaoGongMing;
import org.linlinjava.litemall.gameserver.domain.GoodsLanSe;

@org.springframework.stereotype.Service
public class M32775_0 extends org.linlinjava.litemall.gameserver.netty.BaseWrite {
    protected void writeO(ByteBuf writeBuf, Object object) {
        Goods goods = (Goods) object;
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.pos));
        GameWriteTool.writeByte(writeBuf, Integer.valueOf(3));
        GameWriteTool.writeShort(writeBuf, Integer.valueOf(10));
        Map<Object, Object> map = new java.util.HashMap();
        if (goods.goodsInfo != null) {
            map = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsInfo.groupType));
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else
                    System.out.println(entry.getKey());
            }
        }
        Entry<Object, Object> entry;
        if (goods.goodsBasics != null) {
            map = UtilObjMapshuxing.GoodsBasics(goods.goodsBasics);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsBasics.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                entry = (Entry) ((Iterator) it).next();
                if (entry.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
                }
            }
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> objectObjectEntry : map.entrySet()) {
                if (BuildFields.data.get((String) objectObjectEntry.getKey()) != null) {
                    BuildFields.get((String) objectObjectEntry.getKey()).write(writeBuf, objectObjectEntry.getValue());
                } else
                    System.out.println(objectObjectEntry.getKey());
            }
        }
        Entry<Object, Object> objectObjectEntry;
        if (goods.goodsLanSe != null) {
            map = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLanSe.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                objectObjectEntry = (Entry) ((Iterator) it).next();
                if (objectObjectEntry.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
                }
            }
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> objectObjectEntry1 : map.entrySet()) {
                if (BuildFields.data.get((String) objectObjectEntry1.getKey()) != null) {
                    BuildFields.get((String) objectObjectEntry1.getKey()).write(writeBuf, objectObjectEntry1.getValue());
                } else {
                    System.out.println(objectObjectEntry1.getKey());
                }
            }
        }


        Entry<Object, Object> objectObjectEntry1;


        if (goods.goodsGaiZao != null) {
            map = UtilObjMapshuxing.GoodsGaiZao(goods.goodsGaiZao);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZao.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                objectObjectEntry1 = (Entry) ((Iterator) it).next();
                if (objectObjectEntry1.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
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
        if (goods.goodsGaiZaoGongMing != null) {
            map = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMing.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                objectObjectEntry2 = (Entry) ((Iterator) it).next();
                if (objectObjectEntry2.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
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
        if (goods.goodsGaiZaoGongMingChengGong != null) {
            map = UtilObjMapshuxing.GoodsGaiZaoGongMingChengGong(goods.goodsGaiZaoGongMingChengGong);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsGaiZaoGongMingChengGong.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                objectObjectEntry3 = (Entry) ((Iterator) it).next();
                if (objectObjectEntry3.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
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
        if (goods.goodsLvSeGongMing != null) {
            map = UtilObjMapshuxing.GoodsLvSeGongMing(goods.goodsLvSeGongMing);
            map.remove("groupNo");
            map.remove("groupType");

            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSeGongMing.groupNo));
            GameWriteTool.writeByte(writeBuf, Integer.valueOf(goods.goodsLvSeGongMing.groupType));
            Object it = map.entrySet().iterator();
            while (((Iterator) it).hasNext()) {
                objectObjectEntry4 = (Entry) ((Iterator) it).next();
                if (objectObjectEntry4.getValue().equals(Integer.valueOf(0))) {
                    ((Iterator) it).remove();
                }
            }
            GameWriteTool.writeShort(writeBuf, Integer.valueOf(map.size()));
            for (Entry<Object, Object> objectObjectEntry5 : map.entrySet()) {
                if (BuildFields.data.get((String) objectObjectEntry5.getKey()) != null) {
                    BuildFields.get((String) objectObjectEntry5.getKey()).write(writeBuf, objectObjectEntry5.getValue());
                } else {
                    System.out.println(objectObjectEntry5.getKey());
                }
            }
        }
    }

    public int cmd() {
        return 32775;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\write\M32775_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */