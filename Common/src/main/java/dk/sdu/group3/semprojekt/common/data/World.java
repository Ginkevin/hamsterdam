package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author emilfrisk
 */
public class World {
	private List<IEntity> entities;
	private BulletFactory bf;
	
	public World(){
		entities = new ArrayList<IEntity>();
	}

	public void add(IEntity e){
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
