/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.enums.FaceDirection;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import java.util.List;
import playn.core.ImageLayer;

/**
 *
 * @author mads_000
 */
public class Character extends Entity implements ICharacter{
    private int hp;
    private Weapon weapon;
    private CharacterEnum type;
    private Boolean falling;
    private List<String> pathsFW;
    private List<ImageLayer> viewsFW;
    private List<String> pathsBW;
    private List<ImageLayer> viewsBW;
    private FaceDirection faceDirection;
    
    @Override
    public List<String> getPathsFW(){
        return pathsFW;
    }
    
    @Override
    public void setPathsFW(List<String> paths){
        this.pathsFW = paths;
    }
    
    @Override
    public List<ImageLayer> getViewsFW(){
        return viewsFW;
    }
    
    @Override
    public void setViewsFW(List<ImageLayer> views){
        this.viewsFW = views;
    }
    
    @Override
    public List<String> getPathsBW() {
        return pathsBW;
    }

    @Override
    public void setPathsBW(List<String> paths) {
        this.pathsBW = paths;
    }

    @Override
    public List<ImageLayer> getViewsBW() {
        return viewsBW;
    }

    @Override
    public void setViewsBW(List<ImageLayer> views) {
        this.viewsBW = views;
    }
    
    @Override
    public FaceDirection getFaceDirection(){
        return faceDirection;
    }
    
    @Override
    public void setFaceDirection(FaceDirection fc){
        this.faceDirection = fc;
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
