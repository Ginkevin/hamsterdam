/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

/**
 *
 * @author henrikfrank
 */
public class BulletFactory {
    
    private String path;
    private int damage;
    
    
    public BulletFactory(String path, int damage){
        this.path = path;
        this.damage = damage;
        
    }
    
    public Bullet createBullet(){
        Bullet b = new Bullet();
        
        b.setDamage(damage);
        b.setSprite(path);
        
        return b;
    }
}
