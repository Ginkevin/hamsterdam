package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import playn.core.GroupLayer;

/**
 * @author emilfrisk
 */
public class World {
    private CopyOnWriteArrayList<IEntity> entities;
    private CopyOnWriteArrayList<Event> moveEvents;
    private CopyOnWriteArrayList<Event> events;
    private Level level;
    private GroupLayer rootLayer;
	
    public World(){
        entities = new CopyOnWriteArrayList();
        events = new CopyOnWriteArrayList();
        moveEvents = new CopyOnWriteArrayList();
    }
    
    public List<Event> getMoveEvents() {
        return moveEvents;
    }

    public void addMoveEvent(Event e) {
        moveEvents.add(e);
    }
    
    public void removeMoveEvent(Event e){
        moveEvents.remove(e);
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
    
    public void setLevel(Level level){
        this.level = level;
    }
    
    public Level getLevel(){
        return level;
    }
    
    public void removeEntity(IEntity e)
    {
        entities.remove(e);
    }
    
    public void setRootLayer(GroupLayer gl){
        rootLayer = gl;
    }
    
    public GroupLayer getRootLayer(){
        return rootLayer;
    }
}
