/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.bullet;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.EventEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

/**
 *
 * @author henrikfrank
 */
public class BulletProcess implements IGameProcess{

	Bullet b;
	Weapon w;

    @Override
    public void process(int delta, World world) {
     	world.getEntities().stream().forEach((e)->{
		if (e instanceof Bullet){
			b = (Bullet) e;
		}
		if (e instanceof ICharacter){
			w = ((ICharacter)e).getWeapon();
		}
	});

	world.getEvents().stream().forEach((e)->{
		if (e.getEvent() == EventEnum.SHOOT){
			Bullet nb = new Bullet();
			nb.setDamage(b.getDamage());
			nb.setSprite(b.getSprite());
			nb.setPosition(w.getPosition().getX()+10, w.getPosition().getY()+10);
			nb.setAngle(w.getAngle());
			nb.setVelocity(10, 10);
			world.addEntity(nb);
		}
	});
    }
    
}
