/*     */ package org.linlinjava.litemall.gameserver.process;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.linlinjava.litemall.db.domain.Map;
/*     */ import org.linlinjava.litemall.db.domain.RenwuMonster;
/*     */ import org.linlinjava.litemall.db.domain.StoreInfo;
/*     */
/*     */ import org.linlinjava.litemall.gameserver.data.GameReadTool;
/*     */ import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
/*     */ import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
/*     */ import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
/*     */ import org.linlinjava.litemall.gameserver.data.vo.Vo_45063_0;
/*     */ import org.linlinjava.litemall.gameserver.data.write.MSG_NOTIFY_MISC_EX;
/*     */ import org.linlinjava.litemall.gameserver.data.write.M40964_0;
/*     */ import org.linlinjava.litemall.gameserver.data.write.MSG_TASK_PROMPT;
import org.linlinjava.litemall.gameserver.data.write.MSG_UPDATE;
/*     */ import org.linlinjava.litemall.gameserver.domain.Chara;
/*     */ import org.linlinjava.litemall.gameserver.domain.Goods;
/*     */
/*     */ import org.linlinjava.litemall.gameserver.game.GameData;
/*     */ import org.linlinjava.litemall.gameserver.game.GameObjectChar;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class C8236_0 implements org.linlinjava.litemall.gameserver.GameHandler
/*     */ {
/*     */   public void process(ChannelHandlerContext ctx, ByteBuf buff)
/*     */   {
/*  30 */     int pos = GameReadTool.readByte(buff);
/*     */     
/*  32 */     int amount = GameReadTool.readShort(buff);
/*     */     
/*  34 */     if (pos < 0) {
/*  35 */       pos = 129 + pos + 127;
/*     */     }
/*     */     
/*  38 */     Chara chara = GameObjectChar.getGameObjectChar().chara;
/*  39 */     for (int i = 0; i < chara.backpack.size(); i++) {
/*  40 */       if (((Goods)chara.backpack.get(i)).pos == pos) {
/*  41 */         Goods goods = (Goods)chara.backpack.get(i);
/*  42 */         if (goods.goodsInfo.str.equals("??????")) {
/*  43 */           org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0 vo_9129_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_9129_0();
/*  44 */           vo_9129_0.notify = 97;
/*  45 */           vo_9129_0.para = "HornDlg=??????";
/*  46 */           GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M9129_0(), vo_9129_0);
/*     */         }
/*     */         
/*  49 */         if (goods.goodsInfo.str.equals("??????")) {
/*  50 */           chara.extra_mana += 300000;
/*  51 */           if (chara.extra_mana > 90000000) {
/*  52 */             chara.extra_mana = 90000000;
/*     */           }
/*  54 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/*  55 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/*  56 */           GameUtil.removemunber(chara, "??????", 1);
/*     */         }
/*  58 */         if (goods.goodsInfo.str.equals("????????????")) {
/*  59 */           chara.extra_mana += 1500000;
/*  60 */           if (chara.extra_mana > 90000000) {
/*  61 */             chara.extra_mana = 90000000;
/*     */           }
/*  63 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/*  64 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/*  65 */           GameUtil.removemunber(chara, "????????????", 1);
/*     */         }
/*     */         
/*  68 */         if (goods.goodsInfo.str.equals("????????????")) {
/*  69 */           chara.extra_mana += 7500000;
/*  70 */           if (chara.extra_mana > 90000000) {
/*  71 */             chara.extra_mana = 90000000;
/*     */           }
/*  73 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/*  74 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/*  75 */           GameUtil.removemunber(chara, "????????????", 1);
/*     */         }
/*  77 */         if (goods.goodsInfo.str.equals("??????")) {
/*  78 */           chara.have_coin_pwd += 300000;
/*  79 */           if (chara.have_coin_pwd > 90000000) {
/*  80 */             chara.have_coin_pwd = 90000000;
/*     */           }
/*  82 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/*  83 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/*  84 */           GameUtil.removemunber(chara, "??????", 1);
/*     */         }
/*  86 */         if (goods.goodsInfo.str.equals("????????????")) {
/*  87 */           chara.have_coin_pwd += 1500000;
/*  88 */           if (chara.have_coin_pwd > 90000000) {
/*  89 */             chara.have_coin_pwd = 90000000;
/*     */           }
/*  91 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/*  92 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/*  93 */           GameUtil.removemunber(chara, "????????????", 1);
/*     */         }
/*  95 */         if (goods.goodsInfo.str.equals("????????????")) {
/*  96 */           chara.have_coin_pwd += 7500000;
/*  97 */           if (chara.have_coin_pwd > 90000000) {
/*  98 */             chara.have_coin_pwd = 90000000;
/*     */           }
/* 100 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 101 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 102 */           GameUtil.removemunber(chara, "????????????", 1);
/*     */         }
/* 104 */         if (goods.goodsInfo.str.equals("?????????")) {
/* 105 */           chara.use_skill_d += 300;
/* 106 */           if (chara.use_skill_d > 90000000) {
/* 107 */             chara.use_skill_d = 90000000;
/*     */           }
/* 109 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 110 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 111 */           GameUtil.removemunber(chara, "?????????", 1);
/*     */         }
/*     */         
/*     */ 
/* 115 */         if (goods.goodsInfo.str.equals("???????????????")) {
/* 116 */           chara.enable_double_points += 200;
/* 117 */           if (chara.enable_double_points > 12000) {
/* 118 */             chara.enable_double_points = 12000;
/*     */           }
/* 120 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 121 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 122 */           GameUtil.removemunber(chara, "???????????????", 1);
/*     */           
/* 124 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 125 */           vo_20481_0.msg = ("??????????????????#R???????????????#n???????????????#R" + chara.enable_double_points + "??????");
/* 126 */           vo_20481_0.time = 1562987118;
/* 127 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 130 */         if (goods.goodsInfo.str.equals("?????????")) {
/* 131 */           chara.enable_shenmu_points += 1000;
/* 132 */           if (chara.enable_shenmu_points > 8000) {
/* 133 */             chara.enable_shenmu_points = 8000;
/*     */           }
/* 135 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 136 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 137 */           GameUtil.removemunber(chara, "?????????", 1);
/*     */           
/* 139 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 140 */           vo_20481_0.msg = ("??????????????????#R?????????#n???????????????#R" + chara.enable_shenmu_points + "??????");
/* 141 */           vo_20481_0.time = 1562987118;
/* 142 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 145 */         if (goods.goodsInfo.str.equals("????????????")) {
/* 146 */           chara.extra_skill += 200;
/* 147 */           if (chara.extra_skill > 12000) {
/* 148 */             chara.extra_skill = 12000;
/*     */           }
/* 150 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 151 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 152 */           GameUtil.removemunber(chara, "????????????", 1);
/* 153 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 154 */           vo_20481_0.msg = ("??????????????????#R????????????#n???????????????#R" + chara.extra_skill + "??????");
/* 155 */           vo_20481_0.time = 1562987118;
/* 156 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 159 */         if (goods.goodsInfo.str.equals("???????????????")) {
/* 160 */           chara.chushi_ex += 200;
/* 161 */           if (chara.chushi_ex > 4000) {
/* 162 */             chara.chushi_ex = 4000;
/*     */           }
/* 164 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 165 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 166 */           GameUtil.removemunber(chara, "???????????????", 1);
/* 167 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 168 */           vo_20481_0.msg = ("??????????????????#R???????????????#n???????????????#R" + chara.chushi_ex + "??????");
/* 169 */           vo_20481_0.time = 1562987118;
/* 170 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 173 */         if (goods.goodsInfo.str.equals("???????????????")) {
/* 174 */           chara.fetch_nice += 200;
/* 175 */           if (chara.fetch_nice > 4000) {
/* 176 */             chara.fetch_nice = 4000;
/*     */           }
/* 178 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 179 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 180 */           GameUtil.removemunber(chara, "???????????????", 1);
/* 181 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 182 */           vo_20481_0.msg = ("??????????????????#R???????????????#n???????????????#R" + chara.fetch_nice + "??????");
/* 183 */           vo_20481_0.time = 1562987118;
/* 184 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 187 */         if (goods.goodsInfo.str.equals("?????????")) {
/* 188 */           chara.shuadaochongfeng_san += 200;
/* 189 */           if (chara.shuadaochongfeng_san > 12000) {
/* 190 */             chara.shuadaochongfeng_san = 12000;
/*     */           }
/* 192 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 193 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 194 */           GameUtil.removemunber(chara, "?????????", 1);
/* 195 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 196 */           vo_20481_0.msg = ("??????????????????#R?????????#n???????????????#R" + chara.shuadaochongfeng_san + "??????");
/* 197 */           vo_20481_0.time = 1562987118;
/* 198 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/*     */ 
/* 202 */         if (goods.goodsInfo.str.equals("???????????????")) {
/* 203 */           chara.use_skill_d += 2500;
/* 204 */           if (chara.use_skill_d < 0) {
/* 205 */             chara.use_skill_d = 3000000;
/*     */           }
/* 207 */           ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
/* 208 */           GameObjectChar.send(new MSG_UPDATE(), listVo_65527_0);
/* 209 */           GameUtil.removemunber(chara, "???????????????", 1);
/*     */         }
/* 211 */         if (goods.goodsInfo.str.equals("?????????")) {
/* 212 */           String name = callMounts();
/* 213 */           StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(name);
/* 214 */           GameUtil.huodedaoju(chara, info, 1);
/* 215 */           GameUtil.removemunber(chara, "?????????", 1);
/* 216 */           Vo_40964_0 vo_40964_0 = new Vo_40964_0();
/* 217 */           vo_40964_0.type = 1;
/* 218 */           vo_40964_0.name = name;
/* 219 */           vo_40964_0.param = info.getType().toString();
/* 220 */           vo_40964_0.rightNow = 0;
/* 221 */           GameObjectChar.send(new M40964_0(), vo_40964_0);
/* 222 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 223 */           vo_20481_0.msg = ("?????????????????????????????????#R1#n???#R" + name + "#n???");
/* 224 */           vo_20481_0.time = 1562987118;
/* 225 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/*     */         
/* 228 */         if (goods.goodsInfo.str.equals("??????")) {
/* 229 */           String name = callMountstianshu();
/* 230 */           StoreInfo info = GameData.that.baseStoreInfoService.findOneByName(name);
/* 231 */           GameUtil.huodedaoju(chara, info, 1);
/* 232 */           String name1 = callMountstianshu();
/* 233 */           StoreInfo info1 = GameData.that.baseStoreInfoService.findOneByName(name1);
/* 234 */           GameUtil.huodedaoju(chara, info1, 1);
/* 235 */           GameUtil.removemunber(chara, "??????", 1);
/* 236 */           Vo_40964_0 vo_40964_0 = new Vo_40964_0();
/* 237 */           vo_40964_0.type = 1;
/* 238 */           vo_40964_0.name = name;
/* 239 */           vo_40964_0.param = info.getType().toString();
/* 240 */           vo_40964_0.rightNow = 0;
/* 241 */           GameObjectChar.send(new M40964_0(), vo_40964_0);
/* 242 */           vo_40964_0 = new Vo_40964_0();
/* 243 */           vo_40964_0.type = 1;
/* 244 */           vo_40964_0.name = name;
/* 245 */           vo_40964_0.param = info1.getType().toString();
/* 246 */           vo_40964_0.rightNow = 0;
/* 247 */           GameObjectChar.send(new M40964_0(), vo_40964_0);
/* 248 */           Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 249 */           vo_20481_0.msg = "??????????????????";
/* 250 */           vo_20481_0.time = 1562987118;
/* 251 */           GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/*     */         }
/* 253 */         if (goods.goodsInfo.str.equals("???????????????")) {
/* 254 */           if (chara.changbaotu.mapid != 0) {
/* 255 */             Vo_20481_0 vo_20481_0 = new Vo_20481_0();
/* 256 */             vo_20481_0.msg = "????????????????????????";
/* 257 */             vo_20481_0.time = 1562987118;
/* 258 */             GameObjectChar.send(new MSG_NOTIFY_MISC_EX(), vo_20481_0);
/* 259 */             return;
/*     */           }
/* 261 */           Random random = new Random();
/* 262 */           List<RenwuMonster> renwuMonsterServiceAll = GameData.that.baseRenwuMonsterService.findByType(Integer.valueOf(8));
/* 263 */           RenwuMonster renwuMonster = (RenwuMonster)renwuMonsterServiceAll.get(random.nextInt(renwuMonsterServiceAll.size()));
/* 264 */           org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0 vo_61553_0 = new org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0();
/* 265 */           vo_61553_0.count = 1;
/* 266 */           vo_61553_0.task_type = "????????????";
/* 267 */           vo_61553_0.task_desc = "????????????????????????????????????????????????";
/* 268 */           vo_61553_0.task_prompt = ("#??????#Z" + renwuMonster.getMapName() + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")#Z??????");
/* 269 */           vo_61553_0.refresh = 1;
/* 270 */           vo_61553_0.task_end_time = 1567909190;
/* 271 */           vo_61553_0.attrib = 1;
/* 272 */           vo_61553_0.reward = "#I??????|??????#I#I??????|??????#I#I??????|??????#I#I??????|???????????????????????#I#I??????|????????????=F#I";
/* 273 */           vo_61553_0.show_name = "????????????";
/* 274 */           vo_61553_0.tasktask_extra_para = "";
/* 275 */           vo_61553_0.tasktask_state = "1";
/* 276 */           GameObjectChar.getGameObjectChar();GameObjectChar.send(new MSG_TASK_PROMPT(), vo_61553_0);
/* 277 */           Map map = GameData.that.baseMapService.findOneByName(renwuMonster.getMapName());
/* 278 */           chara.changbaotu.mapid = map.getMapId().intValue();
/* 279 */           chara.changbaotu.name = renwuMonster.getMapName();
/* 280 */           chara.changbaotu.x = renwuMonster.getX().intValue();
/* 281 */           chara.changbaotu.y = renwuMonster.getY().intValue();
/* 282 */           Vo_45063_0 vo_45063_0 = new Vo_45063_0();
/* 283 */           vo_45063_0.task_name = ("#??????#Z" + renwuMonster.getMapName() + "|" + renwuMonster.getMapName() + "(" + renwuMonster.getX() + "," + renwuMonster.getY() + ")#Z??????");
/* 284 */           vo_45063_0.check_point = 147761859;
/* 285 */           GameObjectChar.getGameObjectChar();GameObjectChar.send(new org.linlinjava.litemall.gameserver.data.write.M45063_0(), vo_45063_0);
/*     */           
/* 287 */           GameUtil.removemunber(chara, "???????????????", 1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int cmd()
/*     */   {
/* 297 */     return 8236;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String callMounts()
/*     */   {
/* 307 */     String[] mounts_name = { "?????????", "?????????", "?????????", "?????????", "?????????" };
/* 308 */     Random random = new Random();
/* 309 */     int randomInt = random.nextInt(5);
/* 310 */     String name = mounts_name[randomInt];
/* 311 */     return name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String callMountstianshu()
/*     */   {
/* 321 */     String[] mounts_name = { "??????", "??????", "??????", "??????", "??????", "??????", "??????", "?????????", "?????????", "??????", "??????", "??????", "??????", "??????", "??????" };
/* 322 */     Random random = new Random();
/* 323 */     int randomInt = random.nextInt(15);
/* 324 */     String name = mounts_name[randomInt];
/* 325 */     return name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C8236_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */