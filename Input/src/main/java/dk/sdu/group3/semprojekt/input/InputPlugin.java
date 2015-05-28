/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.input;

import org.openide.util.lookup.ServiceProvider;
import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.A;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.CONTROL;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.D;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.S;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SPACE;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.W;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.E;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import playn.core.Keyboard;
import playn.core.PlayN;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGamePlugin.class)
public class InputPlugin implements IGamePlugin{
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;

        PlayN.keyboard().setListener(keyboardListener);
    }
    
    public static void stop() {
        for(IGamePlugin p : world.getPlugins()){
            if(p instanceof InputPlugin){
                world.removePlugin(p);
            }
        }
        PlayN.keyboard().setListener(null);
    }
    
    private final Keyboard.Listener keyboardListener = new Keyboard.Listener() {        
        @Override
        public void onKeyDown(Keyboard.Event event) {            
            switch (event.key()) {
                case W:
                    world.addMoveEvent(new Event(W));
                    break;
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
                    
                case CONTROL:
                    world.addMoveEvent(new Event(CONTROL));
                    break;
                    
                case E:
                    world.addMoveEvent(new Event(E));
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
		    case W:
			    for (Event e : world.getMoveEvents()){
				    if(e.getEvent() == W)
					    world.removeEvent(e);
			    }
		    break;
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
		for (Event e : world.getMoveEvents()){
			if(e.getEvent() == SPACE)
				world.removeEvent(e);
		}
                    break;
                    
                case CONTROL:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == CONTROL)
                            world.removeEvent(e);
                    }
                    break;
                
                case E:
                    for(Event e : world.getMoveEvents()){
                        if(e.getEvent() == E)
                            world.removeEvent(e);
                    }
                    break;                    

                default:
                    break;
            }                
        }
    };
}
