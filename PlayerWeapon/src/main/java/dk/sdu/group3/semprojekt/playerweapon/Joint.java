/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author E
 */
public class Joint extends Bullet {
    private String url = this.getClass().getClassLoader().getResource("images/joint.png").toExternalForm();

    public Joint(float x, float y) {
        //Entity
        setPosition(x, y);
        setVelocity(-1.5f, 0);
        setSprite(url);
        setShape(new Rectangle(20, 5));

        //Bullet
        setDamage(1);
    }
}
