/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.interfaces;

import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import dk.sdu.group3.semprojekt.common.enums.FaceDirection;
import java.util.List;
import playn.core.ImageLayer;

/**
 *
 * @author mads_000
 */
public interface ICharacter {
    int getHP();
    void setHP(int hp);
    Weapon getWeapon();
    void setWeapon(Weapon weapon);
    CharacterEnum getCharacterEnum();
    void setCharacterEnum(CharacterEnum type);
    Boolean getFalling();
    void setFalling(Boolean b);
    List<String> getPathsFW();
    void setPathsFW(List<String> paths);
    List<ImageLayer> getViewsFW();
    void setViewsFW(List<ImageLayer> views);
    List<String> getPathsBW();
    void setPathsBW(List<String> paths);
    List<ImageLayer> getViewsBW();
    void setViewsBW(List<ImageLayer> views);
    FaceDirection getFaceDirection();
    void setFaceDirection(FaceDirection fd);
}
