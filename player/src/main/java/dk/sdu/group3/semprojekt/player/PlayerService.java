/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.A;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.CTRL;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.D;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.S;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SHOOT;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SPACE;
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
                    entity.setVelocity(0, 0);
                }
                for(Event e : world.getMoveEvents()) {
                    if(e.getEvent() == S){
                        //DUCK
                    }
                    if(e.getEvent() == D){
                        float x= (float)Math.cos(0);
                        float y = (float)Math.sin(0);;
                        entity.setVelocity(x, y);
                    }
                    if(e.getEvent() == A){
                        float x= (float)Math.cos(180);
                        float y = (float)Math.sin(180);;
                        entity.setVelocity(x, y);
                    }                   
                    if(e.getEvent() == SPACE){
                        //JUMP
                    }                    
                    if(e.getEvent() == CTRL){
                        Event event = new Event(SHOOT);
                        world.addEvent(event);
                    }
                }
            }
        }
    }

}
