/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.signplatform;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Henrik
 */
@ServiceProvider(service = IGamePlugin.class)
public class SignPlatformPlugin implements IGamePlugin{
    List<SignPlatform> listOfPlatforms = new ArrayList();

    @Override
    public void start(World world) {
        listOfPlatforms.add(new SignPlatform(650, 431));
        
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

    @Override
    public void uninstalled(World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}