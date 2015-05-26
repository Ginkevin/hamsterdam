
package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider (service = IGamePlugin.class)
public class EnemyPlugin implements IGamePlugin{ 
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;

        world.addEntity(new Enemy());
    }

    public static void stop() {
        for(IGamePlugin p : world.getPlugins()){
            if(p instanceof EnemyPlugin){
                world.removePlugin(p);
            }
        }
        
        for(IEntity entity: world.getEntities()){
            if(entity instanceof Enemy){
                entity.setIsDestroyed(true);
            }
        }
    }    
}
