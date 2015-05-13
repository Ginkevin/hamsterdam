/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Event;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.SHOOT;
import dk.sdu.group3.semprojekt.common.data.Weapon;

/**
 *
 * @author mads_000
 */
public class Player extends Character{
    private String url = this.getClass().getClassLoader().getResource("images/player.png").toExternalForm();
    
    public Player(){
        //Entity
        setPosition(340, 50);
        setVelocity(0, 0);
        setSprite(url);
        setShape(new Circle(40));
        setAngle(0);
        
        //Character
        setHP(1);
        setWeapon(new Weapon());
        setCharacterEnum(CharacterEnum.PLAYER);   
    }
}
