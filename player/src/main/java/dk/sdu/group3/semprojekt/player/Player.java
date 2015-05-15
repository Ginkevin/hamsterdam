/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.Character;
import dk.sdu.group3.semprojekt.common.data.Circle;
import dk.sdu.group3.semprojekt.common.enums.CharacterEnum;
import dk.sdu.group3.semprojekt.common.data.Weapon;
import java.util.ArrayList;

/**
 *
 * @author mads_000
 */
public class Player extends Character{
    public Player(){
        ArrayList<String> pathsFW = new ArrayList();
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_0.png").toExternalForm());
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_1.png").toExternalForm());
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_2.png").toExternalForm());
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_3.png").toExternalForm());
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_4.png").toExternalForm());
        pathsFW.add(this.getClass().getClassLoader().getResource("images/player_fw_5.png").toExternalForm());
        
        ArrayList<String> pathsBW = new ArrayList();
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_0.png").toExternalForm());
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_1.png").toExternalForm());
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_2.png").toExternalForm());
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_3.png").toExternalForm());
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_4.png").toExternalForm());
        pathsBW.add(this.getClass().getClassLoader().getResource("images/player_bw_5.png").toExternalForm());
        
        //Entity
        setPosition(340, 50);
        setVelocity(0, 0);
        setSprite(this.getClass().getClassLoader().getResource("images/player_fw_0.png").toExternalForm());
        setShape(new Circle(45));
        setAngle(0);
        
        //Character
        setHP(1);
        setWeapon(new Weapon());
        setCharacterEnum(CharacterEnum.PLAYER);  
        setFalling(true);
        setPathsFW(pathsFW);
        setPathsBW(pathsBW);
    }
}
