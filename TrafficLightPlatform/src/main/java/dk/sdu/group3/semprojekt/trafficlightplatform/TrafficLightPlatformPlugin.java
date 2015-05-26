/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.trafficlightplatform;

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
public class TrafficLightPlatformPlugin implements IGamePlugin{
    private static World world;

    @Override
    public void start(World world) {
        this.world = world;
        
        world.addEntity(new TrafficLightPlatform(205, 168));
    }

    public static void stop() {
        for(IGamePlugin p : world.getPlugins()){
            if(p instanceof TrafficLightPlatformPlugin){
                world.removePlugin(p);
            }
        }
        for(IEntity e : world.getEntities()){
            if(e instanceof TrafficLightPlatform){
                e.setIsDestroyed(true); 
            }
        }
    }
}