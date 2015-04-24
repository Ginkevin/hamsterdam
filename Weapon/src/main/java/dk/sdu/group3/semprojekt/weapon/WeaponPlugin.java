package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 * @author emilfrisk
 */

@ServiceProvider (service = IGamePlugin.class)
public class WeaponPlugin implements IGamePlugin {

	Weapon w;
	
	@Override
	public void start(World world) {
		world.getEntities().stream().forEach((e)->{
			if (e instanceof ICharacter){
				ICharacter c = (ICharacter) e;
				if (c.getCharacterEnum() == CharacterEnum.PLAYER){
					c.setWeapon(createWeapon());
				}
			}
		});
	}

	@Override
	public void stop(World world) {
		world.getEntities().remove(w);
	}

	public Weapon createWeapon(){
		w = new Weapon();
		w.setAmmo(90);
		w.setCooldown(10);
		w.setRange(100);
		return w;
	}
}
