/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.level;

import dk.sdu.group3.semprojekt.common.data.Level;
import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author henrikfrank
 */

@ServiceProvider (service = IGamePlugin.class)
public class LevelPlugin implements IGamePlugin{ 
    private static World world;
    
    @Override
    public void start(World world) {
        this.world = world;
        
        Level l = new Level();
        
        l.setBackground(this.getClass().getClassLoader().getResource("images/background.png").toExternalForm());
        
        world.getEntities().stream().filter((e) -> (e instanceof Platform)).forEach((e) -> {
            l.addPlatform((Platform) e);
        });
        
        world.setLevel(l);        
    }

    public static void stop() {
        world.setLevel(null);
    }    
}
