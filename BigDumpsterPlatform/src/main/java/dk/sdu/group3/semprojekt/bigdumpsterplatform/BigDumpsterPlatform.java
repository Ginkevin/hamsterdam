/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.bigdumpsterplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class BigDumpsterPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/bigdumpsterplatform.png").toExternalForm();
    
    public BigDumpsterPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(115, 133));
        setAngle(0);
        setPosition(x ,y);
    }
}
