package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 * @author emilfrisk
 */

@ServiceProvider (service = IGamePlugin.class)
public class KanyleGunPlugin implements IGamePlugin {
    @Override
    public void start(World world) {
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

    @Override
    public void stop(World world) {
        //ToDo
    }

    @Override
    public void uninstalled(World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
