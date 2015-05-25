/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.trafficlightplatform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author Henrik
 */
public class TrafficLightPlatform extends Platform{
    private final String url = this.getClass().getClassLoader().getResource("images/trafficlightplatform.png").toExternalForm();
    
    public TrafficLightPlatform(float x, float y){
        //Entity
        setVelocity(0,0);
        setSprite(url);
        setShape(new Rectangle(117, 157));
        setAngle(0);
        setPosition(x ,y);
    }   
}
