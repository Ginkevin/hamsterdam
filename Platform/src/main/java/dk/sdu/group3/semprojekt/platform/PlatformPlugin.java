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
    
    List<Platform> listOfPlatforms;
    private final String url = this.getClass().getClassLoader().getResource("images/platform.png").toExternalForm();
    
    @Override
    public void start(World world) {
        listOfPlatforms = new ArrayList();
        for (int i = 0; i < 6; i++) {
            listOfPlatforms.add(new Platform());
            listOfPlatforms.get(i).setSprite(url);
        }
        
        listOfPlatforms.get(0).setPosition(35, 480);
        listOfPlatforms.get(1).setPosition(104, 250);
        listOfPlatforms.get(2).setPosition(391, 325);
        listOfPlatforms.get(3).setPosition(650, 475);
        listOfPlatforms.get(4).setPosition(581, 325);
        listOfPlatforms.get(5).setPosition(581, 176);
        
        listOfPlatforms.stream().forEach((p) -> {
            world.addEntity(p);
        });
        
    }

    @Override
    public void stop(World world) {
        listOfPlatforms.stream().forEach((p) -> {
            world.getEntities().remove(p);
        });
    }
    
}
