/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.data.World;
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
public class KanyleProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        for(IEntity e : world.getEntities()){
            if (e instanceof ICharacter){
                if(((ICharacter)e).getWeapon() instanceof KanyleGun){
                    for(Event ev : e.getEvents()){
                        //Skal ændres til den event AI laver
//                        if (ev.getEvent() == SHOOT){
//                            world.addEntity(new Kanyle(e.getPosition().getX()+10, 
//                                                       e.getPosition().getY()+10, 
//                                                       e.getVelocity().getX(), 
//                                                       e.getVelocity().getY()));
//                            e.removeEvent(ev);
//                        }
                    }                    
                }
            }
        }
    }
    
}
