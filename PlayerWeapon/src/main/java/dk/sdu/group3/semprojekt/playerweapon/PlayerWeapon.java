/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Weapon;

/**
 *
 * @author E
 */
public class PlayerWeapon extends Weapon {
    public PlayerWeapon(){
        setAmmo(100);
        setCooldown(3000);
        setRange(10);
    }
}
