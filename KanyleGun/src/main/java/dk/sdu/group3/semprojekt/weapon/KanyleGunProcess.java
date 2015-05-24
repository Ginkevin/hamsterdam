/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author henrikfrank
 */

@ServiceProvider (service = IGameProcess.class)
public class KanyleGunProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        checkForNewEnemy(world);
        
        for(IEntity e : world.getEntities()){
            if(e instanceof ICharacter) {
                if(((ICharacter) e).getWeapon() instanceof KanyleGun) {
                    KanyleGun w = (KanyleGun) ((ICharacter) e).getWeapon();
                    w.reduceCoolDown(delta);
                    for(Event ev : e.getEvents()) {
                        if(ev.getEvent().equals(SHOOT)){
                            if(w.canShoot()) {
                                world.addEntity(new Kanyle(e.getPosition().getX()+60, e.getPosition().getY(), ((ICharacter) e).getFaceDirection())); 
                                w.shoot();
                            }
                            e.removeEvent(ev);
                        }
                    }                    
                }
            }
        }
    }
    
    private void checkForNewEnemy(World world){
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
    
}
