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

    Level l;
    private final String url = this.getClass().getClassLoader().getResource("images/background.png").toExternalForm();
    
    @Override
    public void start(World world) {
        l = new Level();
        
        l.setBackground(url);
        
        world.getEntities().stream().filter((e) -> (e instanceof Platform)).forEach((e) -> {
            l.addPlatform((Platform) e);
        });
        
        world.setLevel(l);
        
    }

    @Override
    public void stop(World world) {
        world.setLevel(null);
    }
    
}
