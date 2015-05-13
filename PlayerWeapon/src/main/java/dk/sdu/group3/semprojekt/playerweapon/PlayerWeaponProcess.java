/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SHOOT;
import static dk.sdu.group3.semprojekt.common.data.EventEnum.SPACE;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author E
 */
@ServiceProvider(service = IGameProcess.class)
public class PlayerWeaponProcess implements IGameProcess {
	@Override
	public void process(int delta, World world) {
		for (IEntity e : world.getEntities()) {
			if (e instanceof ICharacter) {
				if (((ICharacter) e).getWeapon() instanceof PlayerWeapon) {
					for (Event ev : e.getEvents()) {
						if (ev.getEvent() == SHOOT) {
							System.out.println("SKYD2");
							Joint j = new Joint();
							j.setPosition(e.getPosition().getX()+10, e.getPosition().getY());
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
