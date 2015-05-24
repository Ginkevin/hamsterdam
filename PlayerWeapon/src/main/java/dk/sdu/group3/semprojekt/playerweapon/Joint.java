/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Rectangle;
import dk.sdu.group3.semprojekt.common.enums.FaceDirection;
import static dk.sdu.group3.semprojekt.common.enums.FaceDirection.LEFT;
import static dk.sdu.group3.semprojekt.common.enums.FaceDirection.RIGHT;

/**
 *
 * @author E
 */
public class Joint extends Bullet {
    private String url = this.getClass().getClassLoader().getResource("images/joint.png").toExternalForm();

    public Joint(float x, float y, FaceDirection direction) {
        if(direction.equals(LEFT)){
            //Entity
            setPosition(x, y);
            setVelocity(-4f, 0);
            setSprite(url);
            setShape(new Rectangle(20, 5));
        }
        else if(direction.equals(RIGHT)){
            //Entity
            setPosition(x+120, y);
            setVelocity(4f, 0);
            setSprite(url);
            setShape(new Rectangle(20, 5));
        }

        //Bullet
        setDamage(1);
    }
}
