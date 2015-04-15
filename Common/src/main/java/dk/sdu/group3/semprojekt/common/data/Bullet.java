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
public class Bullet extends Entity{
    private int damage;
    
    public int getDamage(){
        return damage;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
}
