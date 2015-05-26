/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.signplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class SignPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/signplatform.png").toExternalForm();
    
    public SignPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(116, 285));
        setAngle(0);
        setPosition(x ,y);
    }   
}
