package dk.sdu.group3.semprojekt.common.data;

public class Weapon extends Entity {
    private BulletFactory bulletFactory;
    private int ammo;
    private int range;
    private int cooldown;
    
    public BulletFactory getBulletFactory(){
        return bulletFactory;
    }
    
    public void setBulletFactory(BulletFactory b){
        bulletFactory = b;
    }
    
    public int getAmmo(){
        return ammo;
    }
    
    public void setAmmo(int ammo){
        this.ammo = ammo;
    }
    
    public int getRange(){
        return range;
    }
    
    public void setRange(int range){
        this.range = range;
    }
    
    public int getCooldown(){
        return cooldown;
    }
    
    public void setCooldown(int cd){
        cooldown = cd;
    }
}
