package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.service.base.BasePetService;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.data.write.M65507_0;
import org.linlinjava.litemall.gameserver.data.write.M8165_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C32772_0
        implements GameHandler {
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {
        int no = GameReadTool.readByte(buff);

        int is_set = GameReadTool.readByte(buff);

        Chara chara = GameObjectChar.getGameObjectChar().chara;

        if (is_set == 1) {
            for (int i = 0; i < chara.pets.size(); i++) {
                Petbeibao petbeibao = (Petbeibao) chara.pets.get(i);
                if (petbeibao.no == no) {
                    Pet pet = GameData.that.basePetService.findOneByName(((PetShuXing) petbeibao.petShuXing.get(0)).str);
                    PetShuXing shuXing = (PetShuXing) petbeibao.petShuXing.get(0);
                    shuXing.pet_mana_shape += shuXing.pet_mana_shape_temp;
                    shuXing.pet_speed_shape += shuXing.pet_speed_shape_temp;
                    shuXing.pet_phy_shape += shuXing.pet_phy_shape_temp;
                    shuXing.pet_mag_shape += shuXing.pet_mag_shape_temp;
                    shuXing.rank += shuXing.evolve_degree;

                    shuXing.mana_effect += shuXing.pet_mana_shape_temp;
                    shuXing.attack_effect += shuXing.pet_speed_shape_temp;
                    shuXing.mag_effect += shuXing.pet_mag_shape_temp;
                    shuXing.phy_absorb += shuXing.evolve_degree;
                    shuXing.phy_effect += shuXing.pet_phy_shape_temp;


                    shuXing.pet_mana_shape_temp = 0;

                    shuXing.pet_speed_shape_temp = 0;

                    shuXing.pet_phy_shape_temp = 0;

                    shuXing.pet_mag_shape_temp = 0;

                    shuXing.evolve_degree = 0;


                    List list = new ArrayList();

                    BasicAttributesUtils.petshuxing((PetShuXing) petbeibao.petShuXing.get(0));
                    shuXing.max_life = shuXing.def;
                    shuXing.max_mana = shuXing.dex;
                    list.add(petbeibao);
                    GameObjectChar.send(new M65507_0(), list);
                    Vo_8165_0 vo_8165_0 = new Vo_8165_0();
                    vo_8165_0.msg = ("你的#Y" + pet.getName() + "#n经过洗炼，基础成长已重新生成。");
                    vo_8165_0.active = 0;
                    GameObjectChar.send(new M8165_0(), vo_8165_0);
                }
            }
        }
    }


    public int cmd() {
        return 32772;
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\process\C32772_0.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */