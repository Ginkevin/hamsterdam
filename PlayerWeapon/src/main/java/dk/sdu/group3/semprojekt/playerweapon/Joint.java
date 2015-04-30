/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.ShapeEnum;

/**
 *
 * @author E
 */
public class Joint extends Bullet {

	private String url = this.getClass().getClassLoader().getResource("images/Hale.png").toExternalForm();

	public Joint() {
		//Entity
		setPosition(100, 100);
		setVelocity(0, 0);
		setSprite(url);
		setShape(ShapeEnum.SQUARE);
		setAngle(0);
		setRadius(10);

		//Bullet
		setDamage(1);
	}
}
