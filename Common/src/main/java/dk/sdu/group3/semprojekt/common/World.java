package dk.sdu.group3.semprojekt.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author emilfrisk
 */
public class World {
	public List<Entity> entities;
	
	public World(){
		entities = new ArrayList<Entity>();
	}
}
