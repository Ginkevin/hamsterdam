package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 * @author emilfrisk
 */

@ServiceProvider (service = IGamePlugin.class)
public class KanyleGunPlugin implements IGamePlugin {
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;
        
        world.getEntities().stream().forEach((e)->{
            if (e instanceof ICharacter){
                ICharacter c = (ICharacter) e;
                if (c.getCharacterEnum() == CharacterEnum.ENEMY){
                    if(!(c.getWeapon() instanceof KanyleGun))
                        c.setWeapon(new KanyleGun());
                }
            }	
        });
    }

    public static void stop() {
        for(IGamePlugin p : world.getPlugins()){
            if(p instanceof KanyleGunPlugin){
                world.removePlugin(p);
            }
        }
        for(IEntity e : world.getEntities()){
            if(e instanceof ICharacter){
                ICharacter c = (ICharacter) e;
                if(c.getWeapon() instanceof KanyleGun)
                    c.setWeapon(new Weapon());
            }
        }
    }
}
