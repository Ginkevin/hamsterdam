package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;

import static dk.sdu.group3.semprojekt.common.data.EventEnum.*;

@ServiceProvider (service = IGameProcess.class)
public class EnemyService implements IGameProcess{
    private final float thrust = 0.1f;

    @Override
    public void process(int delta, World world) {
       	List<IEntity> entities = world.getEntities();

        entities.stream().filter(entity -> entity instanceof Enemy).forEach(entity -> {
            for (Event e : world.getEvents()) {
                if (e.getEvent() == S) {
                    //DUCK
                    world.removeEvent(e);
                }
                if (e.getEvent() == D) {
                    float x = (float) Math.cos(90) * thrust;
                    float y = (float) Math.sin(90) * thrust;
                    ;
                    entity.setVelocity(x, y);
                    world.removeEvent(e);

                }
                if (e.getEvent() == A) {
                    float x = (float) Math.cos(180) * thrust;
                    float y = (float) Math.sin(180) * thrust;
                    ;
                    entity.setVelocity(x, y);
                    world.removeEvent(e);
                }
                if (e.getEvent() == SPACE) {
                    //JUMP
                    world.removeEvent(e);
                }
                if (e.getEvent() == CTRL) {
                    Event event = new Event(SHOOT);
                    world.addEvent(event);
                    world.removeEvent(e);
                }
            }
        });
    }

}
