package dk.sdu.group3.semprojekt.physics;

import dk.sdu.group3.semprojekt.common.data.*;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ServiceProvider(service = IGameProcess.class)
public class PhysicsService implements IGameProcess {

    @Override
    public void process(int delta, World world) {
        List<IEntity> entities = world.getEntities();
        entities.stream().filter(e -> e instanceof ICharacter).forEach(entity -> {

            List<Event> events = entity.getEvents();
            Optional<Event> event = events.stream().filter(e -> e instanceof HitEvent).filter(e-> ((HitEvent) e).getSource() instanceof Platform).findFirst();
            event.ifPresent(e -> {
                System.out.println(events);
                entity.getVelocity().setY(0);
                entity.removeEvent(e);
            });
            if(!event.isPresent()){
                gravity(delta, entity);
            }

        });
    }

    private void gravity(int delta, IEntity entity) {
        Vector v0 = entity.getVelocity();
        float t = (float) (delta) / 1000;
        Vector a = new Vector(0, 3f);
        // x(t) =  x0 + v*delta
        Vector vt = v0.plus(a.times(t));
        entity.getVelocity().setY(vt.getY());
    }


}
