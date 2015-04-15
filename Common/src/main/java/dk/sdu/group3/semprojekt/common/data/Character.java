/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

/**
 *
 * @author mads_000
 */
public class Character extends Entity{
    private int hp;
    private Weapon weapon;
    private CharacterEnum type;
    
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
}
