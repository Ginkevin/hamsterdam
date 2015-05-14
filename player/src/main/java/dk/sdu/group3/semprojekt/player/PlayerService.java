/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.A;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.CONTROL;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.D;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.S;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SPACE;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.CharacterEnum.ENEMY;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.DESTROY;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.HIT;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.W;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author mads_000
 */
@ServiceProvider(service = IGameProcess.class)
public class PlayerService implements IGameProcess {
	int jumpCooldown = 1600, currentJumpCooldown = 1600;
	boolean jump = true;

    @Override
    public void process(int delta, World world) {
	  currentJumpCooldown-=delta;
	  if (currentJumpCooldown <= 0){
		  jump = true;
		  currentJumpCooldown = jumpCooldown;
	  }
        for (IEntity entity : world.getEntities()) {
            if (entity instanceof Player) {
                Boolean hitByPlatform = false;
                ICharacter c = (ICharacter) entity;
                if (world.getMoveEvents().isEmpty()) {
                    entity.setVelocity(0, entity.getVelocity().getY());
                }
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
                // if hitCounter == 0(no hit with platforms), entity should fall.
                if (hitByPlatform == false) {
                    c.setFalling(true);
                }
                for (Event h : entity.getEvents()) {
                    if (h.getEvent() == HIT) {
                        HitEvent hit = (HitEvent) h;
                        ICharacter character = (ICharacter) hit.getSource();
                        if (character.getCharacterEnum() == ENEMY) {
                            c.setHP(0);
                        }
                    }
                }
                if (c.getHP() <= 0) {
                    entity.setIsDestroyed(true);
                }
                for (Event e : world.getMoveEvents()) {
			if (e.getEvent() == W){
				if (jump){
				 	entity.setVelocity(entity.getVelocity().getX(), -15);
					jump = false;
				}
			}
                    if (e.getEvent() == S) {
                        //DUCK
                    }
                    if (e.getEvent() == D) {
                        entity.setVelocity(1, entity.getVelocity().getY());
                    }
                    if (e.getEvent() == A) {
                        entity.setVelocity(-1, entity.getVelocity().getY());
                    }
                    if (e.getEvent() == SPACE) {
                        Event event = new Event(SHOOT);
                        entity.addEvent(event);
                    }
                    if (e.getEvent() == CONTROL) {
                    }
                }
            }
        }
    }

    private void jump(int i){
	    
    }
}
