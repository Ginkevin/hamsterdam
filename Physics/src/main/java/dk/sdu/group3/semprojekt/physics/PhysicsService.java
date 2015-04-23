package dk.sdu.group3.semprojekt.physics;

import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;

@ServiceProvider (service = IGameProcess.class)
public class PhysicsService implements IGameProcess{

    @Override
    public void process(int delta, World world) {
       	List<IEntity> entities = world.getEntities();
        entities.stream().forEach(entity -> {
            Vector x0 = entity.getPosition();
            Vector v = entity.getVelocity();
            float t = (float)(delta)/100;
            // x(t) =  x0 + v*delta
            Vector xt = x0.plus(v.times(t));
            entity.setVelocity(xt);
        });
    }


}
