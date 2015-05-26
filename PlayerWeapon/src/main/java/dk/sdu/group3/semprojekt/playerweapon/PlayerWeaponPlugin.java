/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author E
 */
@ServiceProvider(service = IGamePlugin.class)
public class PlayerWeaponPlugin implements IGamePlugin{
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;
        
        world.getEntities().stream().forEach((e)->{
            if (e instanceof ICharacter){
                ICharacter c = (ICharacter) e;
                if (c.getCharacterEnum() == CharacterEnum.PLAYER){
                    if(!(c.getWeapon() instanceof PlayerWeapon))
                        c.setWeapon(new PlayerWeapon());
                }
            }	
        });
    }

    public static void stop() {
        for(IEntity e : world.getEntities()){
            if(e instanceof ICharacter){
                ICharacter c = (ICharacter) e;
                if(c.getWeapon() instanceof PlayerWeapon)
                    c.setWeapon(new Weapon());
            }
        }
    }
}
