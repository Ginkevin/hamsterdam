package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author emilfrisk
 */
public class World {
    private List<IEntity> entities;
    private List<Event> moveEvents = new ArrayList();
    private List<Event> events = new ArrayList();
	
    public World(){
        entities = new ArrayList<IEntity>();
    }
    
    public List<Event> getMoveEvents() {
        return moveEvents;
    }

    public void addMoveEvents(Event e) {
        moveEvents.add(e);
    }
    
    public void removeMoveEvent(Event e){
        moveEvents.remove(e);
    }

    public void add(IEntity e){
        entities.add(e);
    }

    public List<Event> getEvents() {
        return moveEvents;
    }

    public void addEvent(Event e) {
        moveEvents.add(e);
    }
    
    public void removeEvent(Event e){
        moveEvents.remove(e);
    }
    
    public void clearEvents(){
        moveEvents.clear();
    }

    public void addEntity(IEntity e){
        entities.add(e);
    }

    public List<IEntity> getEntities(){
            return entities;
    }
}
