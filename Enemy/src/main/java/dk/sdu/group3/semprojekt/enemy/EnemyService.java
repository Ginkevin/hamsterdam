package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.HIT;
import static dk.sdu.group3.semprojekt.common.enums.FaceDirection.LEFT;
import static dk.sdu.group3.semprojekt.common.enums.FaceDirection.RIGHT;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;
import playn.core.ImageLayer;

@ServiceProvider(service = IGameProcess.class)
public class EnemyService implements IGameProcess {

    private final float thrust = 0.1f;

    @Override
    public void process(int delta, World world) {
        List<IEntity> entities = world.getEntities();

        entities.stream().filter(entity -> entity instanceof Enemy).forEach(entity -> {
            ICharacter c = (ICharacter) entity;
            Boolean hitByPlatform = false;
            c.setFaceDirection(RIGHT);
            List<ImageLayer> imagesFW = c.getViewsFW();
            List<ImageLayer> imagesBW = c.getViewsBW();
            for (Event k : entity.getEvents()) {
                if (k.getEvent() == HIT) {
                    HitEvent hit = (HitEvent) k;
                    if (hit.getSource() instanceof Platform) {
                        Rectangle rectangle = (Rectangle) hit.getSource().getShape();
                        Platform platform = (Platform) hit.getSource();
                        Circle circle = (Circle) entity.getShape();
                        if (entity.getPosition().getX() > platform.getPosition().getX() - rectangle.getWidth() / 2 && entity.getPosition().getX() < platform.getPosition().getX() + rectangle.getWidth() / 2 && entity.getPosition().getY() - circle.getRadius() < platform.getPosition().getY() + rectangle.getHeight() / 2) {
                            entity.setPosition(entity.getPosition().getX(), (platform.getPosition().getY() - rectangle.getHeight() / 2) - circle.getRadius());
                        }
                        hitByPlatform = true;
                        c.setFalling(false);
                        entity.removeEvent(k);
                    }
                }
            }
            // if hitByPlatform == false(no hit with platforms), entity should fall.
            if (hitByPlatform == false) {
                c.setFalling(true);
            }
            for (Event h : entity.getEvents()) {
                if (h.getEvent() == HIT) {
                    HitEvent source = (HitEvent) h;
                    if (source.getSource() instanceof Bullet) {
                        c.setHP(0);
                    }
                }
            }
            if (c.getHP() <= 0) {
                entity.setIsDestroyed(true);
            }

            for (Event e : entity.getEvents()) {
                switch (e.getEvent()) {
                    case LEFT:
                        moveLeft(entity, world, e);
                        world.getRootLayer().remove(entity.getView());
                        entity.setView(imagesBW.get(0));
                        world.getRootLayer().add(entity.getView());
                        c.setFaceDirection(RIGHT);
                        break;
                    case RIGHT:
                        moveRight(entity, world, e);
                        world.getRootLayer().remove(entity.getView());
                        entity.setView(imagesFW.get(0));
                        world.getRootLayer().add(entity.getView());
                        c.setFaceDirection(LEFT);
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
