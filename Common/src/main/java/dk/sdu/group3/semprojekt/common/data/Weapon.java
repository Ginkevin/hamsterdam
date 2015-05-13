package dk.sdu.group3.semprojekt.common.data;

public class Weapon extends Entity {
    private int ammo;
    private int range;
    private int cooldown, current;
    private boolean canShoot;

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cd) {
        cooldown = cd;
    }

    public void reduceCoolDown(int i){
        current -= i;
        
        if(current < 0){
            canShoot = true;
            current = cooldown;
        }  
    }

    public boolean canShoot(){
	    return canShoot;
    }

    public void shoot(){
	    canShoot = false;
    }
}
