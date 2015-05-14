package dk.sdu.group3.semprojekt.enemy;

import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import java.util.ArrayList;

public class Enemy extends Character{
    public Enemy(){
        ArrayList<String> pathsFW = new ArrayList();
        pathsFW.add(this.getClass().getClassLoader().getResource("images/enemy_fw.png").toExternalForm());
        
        ArrayList<String> pathsBW = new ArrayList();
        pathsBW.add(this.getClass().getClassLoader().getResource("images/enemy_bw.png").toExternalForm());
        
        //Entity
        setPosition(100,50);
        setVelocity(0,0);
        setSprite(this.getClass().getClassLoader().getResource("images/enemy_fw.png").toExternalForm());
        setShape(new Circle(45));
        setAngle(0);
        
        //Character
        setHP(1);
        setWeapon(new Weapon());
        setCharacterEnum(CharacterEnum.ENEMY);
        setFalling(true);
        setPathsFW(pathsFW);
        setPathsBW(pathsBW);
    }
}
