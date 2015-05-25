/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.smalldumpsterplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class SmallDumpsterPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/smalldumpsterplatform.png").toExternalForm();
    
    public SmallDumpsterPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(115, 83));
        setAngle(0);
        setPosition(x ,y);
    }   
}
