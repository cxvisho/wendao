/*    */ package org.linlinjava.litemall.gameserver.process;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import org.linlinjava.litemall.gameserver.GameHandler;
/*    */ import org.linlinjava.litemall.gameserver.data.vo.Vo_11713_0;
/*    */ import org.linlinjava.litemall.gameserver.data.vo.Vo_53715_0;
/*    */ import org.linlinjava.litemall.gameserver.data.write.M11713_0;
/*    */ import org.linlinjava.litemall.gameserver.data.write.M53715_0;
/*    */ import org.linlinjava.litemall.gameserver.domain.Chara;
/*    */ import org.linlinjava.litemall.gameserver.fight.FightContainer;
/*    */ import org.linlinjava.litemall.gameserver.fight.FightManager;
/*    */ import org.linlinjava.litemall.gameserver.fight.FightObject;
/*    */ import org.linlinjava.litemall.gameserver.fight.FightRequest;
/*    */ import org.linlinjava.litemall.gameserver.game.GameObjectChar;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class C518_0 implements GameHandler
/*    */ {
/*    */   public void process(ChannelHandlerContext ctx, ByteBuf buff)
/*    */   {
/* 23 */     GameObjectChar session = GameObjectChar.getGameObjectChar();
/* 24 */     Chara chara = session.chara;
/* 25 */     FightRequest fr = new FightRequest();
/* 26 */     fr.id = chara.id;
/* 27 */     fr.action = 7;
/* 28 */     fr.vid = 0;
/*    */     
/* 30 */     FightContainer fightContainer = FightManager.getFightContainer();
/* 31 */     FightManager.addRequest(fightContainer, fr);
/*    */     
/* 33 */     FightObject fightObject = FightManager.getFightObject(fightContainer, chara.id);
/* 34 */     FightObject fightObjectPet = FightManager.getFightObjectPet(fightContainer, fightObject);
/* 35 */     if (fightObjectPet == null) {
/* 36 */       Vo_53715_0 vo_53715_0 = new Vo_53715_0();
/* 37 */       vo_53715_0.attacker_id = chara.id;
/* 38 */       vo_53715_0.victim_id = 0;
/* 39 */       vo_53715_0.action = 7;
/* 40 */       vo_53715_0.no = 0;
/* 41 */       GameObjectChar.send(new M53715_0(), vo_53715_0);
/*    */       
/* 43 */       Vo_11713_0 vo_11713_0 = new Vo_11713_0();
/* 44 */       vo_11713_0.id = chara.id;
/* 45 */       vo_11713_0.show = 0;
/* 46 */       GameObjectChar.send(new M11713_0(), vo_11713_0);
/*    */     }
/*    */   }
/*    */   
/*    */   public int cmd()
/*    */   {
/* 52 */     return 518;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C518_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */