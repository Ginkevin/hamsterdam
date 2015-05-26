/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.balconyplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class BalconyPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/balconyplatform.png").toExternalForm();
    
    public BalconyPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(202, 19));
        setAngle(0);
        setPosition(x ,y);
    }
    
}
