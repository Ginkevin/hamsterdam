package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.HIT;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
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
            
            
            int hitCounter = 0;
                for(Event k : entity.getEvents())
                {
                    if(k.getEvent() == HIT)
                    {
                        HitEvent hit = (HitEvent) k;
                        if(hit.getSource() instanceof Platform)
                        {
                            hitCounter++;
                            ICharacter c = (ICharacter) entity;
                            c.setFalling(false);
                            entity.removeEvent(k);
                        }
                    }
                }
                // if hitCounter == 0(no hit with platforms), entity should fall.
                if(hitCounter == 0) 
                {
                    ICharacter c = (ICharacter) entity;
                    c.setFalling(true);
                }
            
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
