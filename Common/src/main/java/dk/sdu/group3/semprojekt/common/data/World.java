package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author emilfrisk
 */
public class World {
    private List<IEntity> entities;
    private List<Event> Events = new ArrayList();

    public World(){
            entities = new ArrayList();
    }

    public List<Event> getEvents() {
        return Events;
    }

    public void addEvent(Event e) {
        Events.add(e);
    }
    
    public void removeEvent(Event e){
        Events.remove(e);
    }
    
    public void clearEvents(){
        Events.clear();
    }

    public void addEntity(IEntity e){
            entities.add(e);
    }

    public List<IEntity> getEntities(){
            return entities;
    }
}
