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
    private final float thrust = 0.1f;

    @Override
    public void process(int delta, List<IEntity> entities) {
        for(IEntity entity : entities){
            if(entity instanceof Player){
                for(Event e : entity.getEvents()) {
                    if(e.event == S){
                        //DUCK
                    }
                    if(e.event == D){
                        float x= (float)Math.cos(90)*thrust;
                        float y = (float)Math.sin(90)*thrust;;
                        entity.setVelocity(x, y);
                    }
                    if(e.event == A){
                        float x= (float)Math.cos(180)*thrust;
                        float y = (float)Math.sin(180)*thrust;;
                        entity.setVelocity(x, y);
                    }                   
                    if(e.event == SPACE){
                        //JUMP
                    }                    
                    if(e.event == CTRL){
                        Event event = new Event();
                        event.event = SHOOT;
                        entity.addEvent(event);
                    }
                }
            }
        }
    }

}
