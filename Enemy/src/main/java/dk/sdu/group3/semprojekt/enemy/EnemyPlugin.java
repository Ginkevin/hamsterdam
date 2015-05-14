
package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.DESTROY;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider (service = IGamePlugin.class)
public class EnemyPlugin implements IGamePlugin{
    private ArrayList<Entity> list = new ArrayList();
    
    @Override
    public void start(World world) {
        Enemy e = new Enemy();
        list.add(e);
        world.addEntity(e);
    }

    @Override
    public void stop(World world) {
        for(IEntity e : world.getEntities()){
            if(e instanceof Enemy)
                e.addEvent(new Event(DESTROY));
        }
    }    
}
