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

    public World(){
            entities = new ArrayList();
    }

    public List<Event> getMoveEvents() {
        return moveEvents;
    }

    public void addMoveEvent(Event e) {
        moveEvents.add(e);
    }
    
    public void clearMoveEvents(){
        moveEvents.clear();
    }

    public void addEntity(IEntity e){
            entities.add(e);
    }

    public List<IEntity> getEntities(){
            return entities;
    }
}
