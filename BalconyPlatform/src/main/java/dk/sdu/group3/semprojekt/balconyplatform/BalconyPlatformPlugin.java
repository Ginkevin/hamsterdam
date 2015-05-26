/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.balconyplatform;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Henrik
 */

@ServiceProvider(service = IGamePlugin.class)
public class BalconyPlatformPlugin implements IGamePlugin{
    private static World world;

    @Override
    public void start(World world) {
        this.world = world;
        
        world.addEntity(new BalconyPlatform(445, 155));
    }

    public static void stop() {
        for(IEntity e : world.getEntities()){
            if(e instanceof BalconyPlatform){
                e.setIsDestroyed(true); 
            }
        }
    }
}