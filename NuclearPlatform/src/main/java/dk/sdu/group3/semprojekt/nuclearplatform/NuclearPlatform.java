/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.nuclearplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class NuclearPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/nuclearplatform.png").toExternalForm();
    
    public NuclearPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(115, 183));
        setAngle(0);
        setPosition(x ,y);
    }
}
