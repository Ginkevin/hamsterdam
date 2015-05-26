/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.weapon;

import dk.sdu.group3.semprojekt.common.data.Weapon;

/**
 *
 * @author mads_000
 */
public class KanyleGun extends Weapon{
    public KanyleGun(){
        setAmmo(100);
        setCooldown(5000);
        setRange(10);
    }
}
