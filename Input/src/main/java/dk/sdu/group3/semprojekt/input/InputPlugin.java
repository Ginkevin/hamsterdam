/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.input;

import org.openide.util.lookup.ServiceProvider;
import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.A;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.D;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.S;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SPACE;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;
import playn.core.Keyboard;
import playn.core.PlayN;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGamePlugin.class)
public class InputPlugin implements IGamePlugin{
    private World world;
    
    @Override
    public void start(World world) {
        this.world = world;

        PlayN.keyboard().setListener(keyboardListener);
    }
    
    @Override
    public void stop(World world) {
    }
    
    private final Keyboard.Listener keyboardListener = new Keyboard.Listener() {        
        @Override
        public void onKeyDown(Keyboard.Event event) {            
            switch (event.key()) {
                case S:
                    world.addMoveEvent(new Event(S));
                    break;

                case A:
                    world.addMoveEvent(new Event(A)); 
                    break;

                case D:
                    world.addMoveEvent(new Event(D)); 
                    break;

                case SPACE:
                    world.addMoveEvent(new Event(SPACE));
                    break;

                default:
                    break;
            }
        }
        
        @Override
        public void onKeyTyped(Keyboard.TypedEvent te) {
        }

        @Override
        public void onKeyUp(Keyboard.Event event) {
            switch (event.key()) {
                case S:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == S)
                            world.removeEvent(e);
                    }                    
                    break;

                case A:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == A)
                            world.removeEvent(e);
                    }  
                    break;
                case D:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == D)
                            world.removeEvent(e);
                    }  
                    break;

                case SPACE:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == SPACE)
                            world.removeEvent(e);
                    }  
                    break;

                default:
                    break;
            }                
        }
    };
}
