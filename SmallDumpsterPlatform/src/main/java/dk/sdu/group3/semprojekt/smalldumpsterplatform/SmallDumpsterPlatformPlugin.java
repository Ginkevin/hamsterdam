/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.smalldumpsterplatform;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Henrik
 */

@ServiceProvider(service = IGamePlugin.class)
public class SmallDumpsterPlatformPlugin implements IGamePlugin{
    private static World world;

    @Override
    public void start(World world) {
        this.world = world;
        
        world.addEntity(new SmallDumpsterPlatform(150, 532));
    }

    public static void stop() {
        for(IEntity e : world.getEntities()){
            if(e instanceof SmallDumpsterPlatform){
                e.setIsDestroyed(true);
            }
        }
    }
}