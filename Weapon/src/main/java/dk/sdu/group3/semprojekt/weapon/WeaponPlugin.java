package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;

/**
 * @author emilfrisk
 */
public class WeaponPlugin implements IGamePlugin {

	Bullet b;
	
	@Override
	public void start(World world) {
		Weapon w = new Weapon();
		w.setAmmo(90);
		w.setCooldown(10);
		w.setRange(100);
		w.setBullet(new Bullet());

		world.getEntities().stream().forEach((e)->{
			if (e instanceof Bullet) b = (Bullet) e;	
		});
		
	}

	@Override
	public void stop(World world) {
	}

}
