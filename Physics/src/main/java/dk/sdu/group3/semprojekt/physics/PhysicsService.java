package dk.sdu.group3.semprojekt.physics;

import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
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
//        List<IEntity> entities = world.getEntities();
//        entities.stream().filter(e -> e instanceof ICharacter).forEach(entity -> {
//
//            Optional<Event> event = entity.getEvents().stream().filter(e -> e instanceof HitEvent).findFirst();
//            event.ifPresent(e->entity.setVelocity(0,0));
//            if(!event.isPresent()){
//                Vector v0 = entity.getVelocity();
//                float t = (float) (delta) / 100;
//                Vector a = new Vector(0, 0.1f);
//                // x(t) =  x0 + v*delta
//                Vector vt = v0.plus(a.times(t));
//                entity.setVelocity(vt);
//                System.out.println(t);
//            }
//
//        });
    }


}
