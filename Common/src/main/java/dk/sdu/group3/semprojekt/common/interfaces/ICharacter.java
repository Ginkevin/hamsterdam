/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.interfaces;

import dk.sdu.group3.semprojekt.common.data.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;

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
}
