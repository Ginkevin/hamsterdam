package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.data.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.ShapeEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;

public class Enemy extends Character{
    private String url = this.getClass().getClassLoader().getResource("images/LuderHamster.png").toExternalForm();
    
    public Enemy(){
        //Entity
        setPosition(200,0);
        setVelocity(0,0);
        setSprite(url);
        setShape(ShapeEnum.CIRCLE);
        setAngle(0);
        setRadius(50);
        
        //Character
        setHP(1);
        setWeapon(new Weapon());
        setCharacterEnum(CharacterEnum.ENEMY);
    }
}
