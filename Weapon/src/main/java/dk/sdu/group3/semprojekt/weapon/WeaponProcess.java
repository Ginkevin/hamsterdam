package dk.sdu.group3.semprojekt.weapon; 
import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.EventEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;

/**
 * @author emilfrisk
 */
public class WeaponProcess  implements IGameProcess {

	@Override
	public void process(int delta, World world) {
		world.getEvents().stream().forEach((e)->{
			if (e.getEvent() == EventEnum.SHOOT){
				world.getEntities().forEach((w)->{
					if (w instanceof Weapon){
						// SHOOT
						Weapon weapon = (Weapon) w;
						Bullet b = weapon.getBulletFactory().createBullet();
						b.setPosition(weapon.getPosition().getX()+10, weapon.getPosition().getY()+10);
						b.setVelocity(10, 10);
						b.setAngle(weapon.getAngle());
					}
				});
			}
		});
	}
}
