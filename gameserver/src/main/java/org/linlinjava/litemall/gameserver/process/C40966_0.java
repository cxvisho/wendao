package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.service.base.BaseCreepsStoreService;
import org.linlinjava.litemall.db.service.base.BasePetService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20481_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;
import org.linlinjava.litemall.gameserver.data.write.M20481_0;
import org.linlinjava.litemall.gameserver.data.write.M40964_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M65527_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C40966_0 implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int type = GameReadTool.readByte(buff);

        String name = GameReadTool.readString(buff);

        int amount = GameReadTool.readShort(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (1 == type) {
            CreepsStore creepsStore = GameData.that.baseCreepsStoreService.findOneByName(name);
            Integer price = creepsStore.getPrice();


            Pet pet = GameData.that.basePetService.findOneByName(name);
            Petbeibao petbeibao = new Petbeibao();
            petbeibao.petCreate(pet, chara, 20);
            ((PetShuXing) petbeibao.petShuXing.get(0)).penetrate = 1;
            PetShuXing shuXing = (PetShuXing) petbeibao.petShuXing.get(0);
            chara.pets.add(petbeibao);


            shuXing.skill = pet.getLevelReq().intValue();
            shuXing.attrib = pet.getLevelReq().intValue();
            int polar_point = shuXing.skill * 4;
            int addpoint = subtraction(polar_point - shuXing.skill * 3);
            polar_point -= addpoint;
            shuXing.life = (shuXing.skill + addpoint);
            addpoint = subtraction(polar_point);
            polar_point -= addpoint;
            shuXing.mag_power = (shuXing.skill + addpoint);
            addpoint = subtraction(polar_point);
            polar_point -= addpoint;
            shuXing.phy_power = (shuXing.skill + addpoint);
            addpoint = subtraction(polar_point);
            polar_point -= addpoint;
            shuXing.speed = (shuXing.skill + addpoint);


            shuXing.polar_point = 0;
            List list = new ArrayList();
            BasicAttributesUtils.petshuxing(shuXing);
            shuXing.max_life = shuXing.def;
            shuXing.max_mana = shuXing.dex;
            list.add(petbeibao);

            GameObjectChar.send(new M65507_0(), list);
            chara.balance -= price.intValue();
            ListVo_65527_0 listVo_65527_0 = GameUtil.a65527(chara);
            GameObjectChar.send(new M65527_0(), listVo_65527_0);
            Vo_40964_0 vo_40964_0 = new Vo_40964_0();
            vo_40964_0.type = 2;
            vo_40964_0.name = name;
            vo_40964_0.param = String.valueOf(pet.getIcon());
            vo_40964_0.rightNow = 0;
            GameObjectChar.send(new M40964_0(), vo_40964_0);
            Vo_20481_0 vo_20481_0 = new Vo_20481_0();
            vo_20481_0.msg = ("你购买了一只#Y" + name + "（野生）#n。");
            vo_20481_0.time = 1562987118;
            GameObjectChar.send(new M20481_0(), vo_20481_0);
            boolean isfagong = ((PetShuXing) petbeibao.petShuXing.get(0)).rank > ((PetShuXing) petbeibao.petShuXing.get(0)).pet_mag_shape;
            GameUtil.dujineng(1, ((PetShuXing) petbeibao.petShuXing.get(0)).metal, ((PetShuXing) petbeibao.petShuXing.get(0)).skill, isfagong, petbeibao.id, chara);
        }
    }

    public int cmd() {
        return 40966;
    }

    public int subtraction(int i) {
        Random r = new Random();

        return r.nextInt(i);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C40966_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */