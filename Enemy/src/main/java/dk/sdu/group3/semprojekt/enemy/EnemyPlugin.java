
package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider (service = IGamePlugin.class)
public class EnemyPlugin implements IGamePlugin{ 
    private List<Entity> enemies = new ArrayList();
    
    @Override
    public void start(World world) {
        Enemy e = new Enemy();
        enemies.add(e);
        world.addEntity(e);
    }

    @Override
    public void stop(World world) {
        for(Entity e : enemies){
            e.setIsDestroyed(true);
        }
    }    


    @Override
    public void uninstalled(World world) {
        for(IEntity entity: world.getEntities())
        {
            if(entity instanceof Enemy)
            {
                entity.setIsDestroyed(true);
            }
        }
    }
}
