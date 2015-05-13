package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;

@ServiceProvider (service = IGameProcess.class)
public class EnemyService implements IGameProcess{
    private final float thrust = 0.1f;

    @Override
    public void process(int delta, World world) {
       	List<IEntity> entities = world.getEntities();

        entities.stream().filter(entity -> entity instanceof Enemy).forEach(entity -> {
            for (Event e : entity.getEvents()) {
                switch(e.getEvent()){
                    case LEFT:
                        moveLeft(entity, world, e);
                        break;
                    case RIGHT:
                        moveRight(entity, world, e);
                        break;
                    case JUMP:
                        jump(entity, world, e);
                        break;
                    case CROUCH:
                        crouch(entity, world, e);
                        break;
                }
            }
        });
    }

    private void moveLeft(IEntity entity, World world, Event e) {
        entity.setVelocity(-1, entity.getVelocity().getY());
        world.removeEvent(e);
    }

    private void moveRight(IEntity entity, World world, Event e) {
        
        entity.setVelocity(1, entity.getVelocity().getY());
        world.removeEvent(e);
    }

    private void jump(IEntity entity, World world, Event e) {

    }

    private void crouch(IEntity entity, World world, Event e) {

    }

}
