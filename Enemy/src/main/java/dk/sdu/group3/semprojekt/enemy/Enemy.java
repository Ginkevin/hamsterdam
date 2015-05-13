package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;

public class Enemy extends Character{
    private String url = this.getClass().getClassLoader().getResource("images/enemy_fw.png").toExternalForm();
    
    public Enemy(){
        //Entity
        setPosition(200,50);
        setVelocity(0,0);
        setSprite(url);
        setShape(new Circle(40));
        setAngle(0);
        
        //Character
        setHP(1);
        setWeapon(new Weapon());
        setCharacterEnum(CharacterEnum.ENEMY);
    }
}
