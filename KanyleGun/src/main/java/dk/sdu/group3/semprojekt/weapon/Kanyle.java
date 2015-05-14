/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author mads_000
 */
public class Kanyle extends Bullet{    
    public Kanyle(float x, float y){
        //Entity
        setPosition(x, y);
        setVelocity(1.5f, 0);
        setSprite(this.getClass().getClassLoader().getResource("images/Syringe.png").toExternalForm());
        setShape(new Rectangle(20, 5));

        //Bullet
        setDamage(1);
    }
}
