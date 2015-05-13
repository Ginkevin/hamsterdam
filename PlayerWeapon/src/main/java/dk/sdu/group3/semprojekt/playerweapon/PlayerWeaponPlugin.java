/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author E
 */
@ServiceProvider(service = IGamePlugin.class)
public class PlayerWeaponPlugin implements IGamePlugin{
	ICharacter c;	

	@Override
	public void start(World world) {
		world.getEntities().stream().forEach((e)->{
			if (e instanceof ICharacter){
				c = (ICharacter) e;
				if (c.getCharacterEnum() == CharacterEnum.PLAYER){
					c.setWeapon(new PlayerWeapon());
				}
			}	
		});
	}

	@Override
	public void stop(World world) {
		c.setWeapon(null);
	}
}
