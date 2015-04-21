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
	private BulletFactory bf;
	
	public World(){
		entities = new ArrayList<IEntity>();
	}

	public void add(IEntity e){
		entities.add(e);
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

	public void setBulletFactory(BulletFactory bf){
		this.bf = bf;
	}

	public BulletFactory getBulletFactory(){
		return bf;
	}
}
