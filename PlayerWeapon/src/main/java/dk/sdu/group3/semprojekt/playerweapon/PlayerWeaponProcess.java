/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

/**
 *
 * @author E
 */
public class PlayerWeaponProcess implements IGameProcess {
	@Override
	public void process(int delta, World world) {
		for (IEntity e : world.getEntities()) {
			if (e instanceof ICharacter) {
				if (((ICharacter) e).getWeapon() instanceof PlayerWeapon) {
					for (Event ev : e.getEvents()) {
						if (ev.getEvent() == SHOOT) {
							Joint j = new Joint();
							j.setPosition(e.getPosition().getX(), e.getPosition().getY());
							j.setAngle(e.getAngle());
							j.setVelocity(10, 10);
							world.addEntity(j);
							e.removeEvent(ev);
						}
					}
				}
			}
		}
	}
}
