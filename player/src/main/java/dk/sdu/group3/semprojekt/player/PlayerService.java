/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.A;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.CONTROL;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.CROUCH;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.D;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.JUMP;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.S;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SPACE;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author mads_000
 */

@ServiceProvider (service = IGameProcess.class)
public class PlayerService implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        for(IEntity entity : world.getEntities()){
            if(entity instanceof Player){
                if(world.getMoveEvents().isEmpty()){
                    entity.setVelocity(0, entity.getVelocity().getY());
                }
                for(Event e : world.getMoveEvents()) {
                    if(e.getEvent() == S){
                        //DUCK
                    }
                    if(e.getEvent() == D){
                        entity.setVelocity(1, entity.getVelocity().getY());
                    }
                    if(e.getEvent() == A){
                        entity.setVelocity(-1, entity.getVelocity().getY());
                    }                     
                    if(e.getEvent() == SPACE){
			    Event event = new Event(SHOOT);
			    entity.addEvent(event);
                    }                    
                    if(e.getEvent() == CONTROL){
                        Event event = new Event(SHOOT);
                        world.addEvent(event);
                    }
                }
            }
        }
    }
}
