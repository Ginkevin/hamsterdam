package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;

/**
 * @author emilfrisk
 */
public class WeaponPlugin implements IGamePlugin {

	Weapon w;
	
	@Override
	public void start(World world) {
		w = new Weapon();
		w.setAmmo(90);
		w.setCooldown(10);
		w.setRange(100);
		w.setBulletFactory(world.getBulletFactory());
		world.add(w);
	}

	@Override
	public void stop(World world) {
		world.getEntities().remove(w);
	}
}
