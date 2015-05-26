/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.platform;

import org.openide.util.lookup.ServiceProvider;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;

/**
 *
 * @author henrikfrank
 */

@ServiceProvider (service = IGamePlugin.class)
public class StreetPlugin implements IGamePlugin{
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;
        
        world.addEntity(new Street());
    }

    public static void stop() {
        for(IGamePlugin p : world.getPlugins()){
            if(p instanceof StreetPlugin){
                world.removePlugin(p);
            }
        }
        for(IEntity e : world.getEntities()){
            if(e instanceof Street){
                e.setIsDestroyed(true);
            }
        }
    }
}
