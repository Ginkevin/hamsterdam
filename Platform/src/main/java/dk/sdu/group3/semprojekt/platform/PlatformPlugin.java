/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.platform;

import org.openide.util.lookup.ServiceProvider;
import dk.sdu.group3.semprojekt.common.data.Platform;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrikfrank
 */

@ServiceProvider (service = IGamePlugin.class)
public class PlatformPlugin implements IGamePlugin{
    private List<Platform> platforms = new ArrayList();
    
    @Override
    public void start(World world) {
        platforms.add(new EarthPlatform(35f, 480f));
        platforms.add(new EarthPlatform(104f, 250f));
        platforms.add(new EarthPlatform(391f, 325f));
        platforms.add(new EarthPlatform(650f, 475f));
        platforms.add(new EarthPlatform(581f, 325f));
        platforms.add(new EarthPlatform(581f, 176f));
        platforms.add(new Street());
        
        platforms.stream().forEach((p) -> {
            world.addEntity(p);
        });
        
    }

    @Override
    public void stop(World world) {
        platforms.stream().forEach((p) -> {
            world.getEntities().remove(p);
        });
    }
    
}
