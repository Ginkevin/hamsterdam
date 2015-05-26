/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.platform;

import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.Rectangle;

/**
 *
 * @author mads_000
 */
public class Street extends Platform{
    public Street(){
        setVelocity(0,0);
        setSprite(this.getClass().getClassLoader().getResource("images/Street.png").toExternalForm());
        setShape(new Rectangle(800, 25f));
        setAngle(0);
        setPosition(400, 587.5f);
    }
}
