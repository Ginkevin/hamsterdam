/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.ShapeEnum;

/**
 *
 * @author mads_000
 */
public class Kanyle extends Bullet{
    //Skal ændres til den rigtige sprite, men jeg kan ikke åbne den da jeg ikke har det rigtige program.
    private String url = this.getClass().getClassLoader().getResource("images/Syringe.png").toExternalForm();
    
    public Kanyle(float pX, float pY, float vX, float vY){
        Bullet b = new Bullet();
        //Entity
        b.setPosition(100, 100);
        b.setVelocity(0, 0);
        b.setSprite(url);
        b.setShape(ShapeEnum.SQUARE);
        b.setAngle(0);
        b.setRadius(10);
        
        //Bullet
        b.setDamage(1);
    }
}
