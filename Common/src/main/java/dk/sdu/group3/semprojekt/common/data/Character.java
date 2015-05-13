/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;

/**
 *
 * @author mads_000
 */
public class Character extends Entity implements ICharacter{
    private int hp;
    private Weapon weapon;
    private CharacterEnum type;
    private Boolean falling;
  
    
    public void setHP(int hp){
        this.hp = hp;
    }
    
    public int getHP(){
        return hp;
    }
    
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    public Weapon getWeapon(){
        return weapon;
    }
    
    public void setCharacterEnum(CharacterEnum type){
        this.type = type;
    }
    
    public CharacterEnum getCharacterEnum(){
        return type;
    }
       public Boolean getFalling() {
        return falling;
    }

    public void setFalling(Boolean falling) {
        this.falling = falling;
    }
}
