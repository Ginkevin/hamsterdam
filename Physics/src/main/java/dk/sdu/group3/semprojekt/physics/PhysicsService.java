package dk.sdu.group3.semprojekt.physics;

import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;

@ServiceProvider(service = IGameProcess.class)
public class PhysicsService implements IGameProcess {
    @Override
    public void process(int delta, World world) {
        List<IEntity> entities = world.getEntities();
        entities.stream().filter(e -> e instanceof ICharacter).forEach(entity -> {  
                Vector gravity = new Vector(0, 1);
                entity.setVelocity(entity.getVelocity().plus(gravity));
        });
    }
}

