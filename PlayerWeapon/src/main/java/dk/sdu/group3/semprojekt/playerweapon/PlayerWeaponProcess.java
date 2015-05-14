/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author E
 */
@ServiceProvider(service = IGameProcess.class)
public class PlayerWeaponProcess implements IGameProcess {
    @Override
    public void process(int delta, World world) {
        checkForNewPlayer(world);
        
        for(IEntity e : world.getEntities()) {
            if(e instanceof ICharacter) {
                if(((ICharacter) e).getWeapon() instanceof PlayerWeapon) {
                    PlayerWeapon w = (PlayerWeapon) ((ICharacter) e).getWeapon();
                    w.reduceCoolDown(delta);
                    for(Event ev : e.getEvents()) {
                        if(ev.getEvent() == SHOOT) {
                            if (w.canShoot()) {
                                world.addEntity(new Joint(e.getPosition().getX() - 60, e.getPosition().getY()));
                                w.shoot();
                            }
                            e.removeEvent(ev);
                        }
                    }
                }
            }
        }
    }
    
    private void checkForNewPlayer(World world){
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
}
