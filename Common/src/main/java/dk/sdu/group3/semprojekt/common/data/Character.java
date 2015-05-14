/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import java.util.List;

/**
 *
 * @author mads_000
 */
public class Character extends Entity implements ICharacter{
    private int hp;
    private Weapon weapon;
    private CharacterEnum type;
    private Boolean falling;
    private List<String> paths;
    
    @Override
    public List<String> getPaths(){
        return paths;
    }
    
    public void setPaths(List<String> paths){
        this.paths = paths;
    }
    
    @Override
    public void setHP(int hp){
        this.hp = hp;
    }
    
    @Override
    public int getHP(){
        return hp;
    }
    
    @Override
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    @Override
    public Weapon getWeapon(){
        return weapon;
    }
    
    @Override
    public void setCharacterEnum(CharacterEnum type){
        this.type = type;
    }
    
    @Override
    public CharacterEnum getCharacterEnum(){
        return type;
    }
    @Override
       public Boolean getFalling() {
        return falling;
    }

    @Override
    public void setFalling(Boolean falling) {
        this.falling = falling;
    }
}
