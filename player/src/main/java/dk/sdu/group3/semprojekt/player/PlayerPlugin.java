/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.player;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.spi.IGamePlugin;
import org.openide.util.lookup.ServiceProvider;


/**
 *
 * @author mads_000
 */

@ServiceProvider (service = IGamePlugin.class)

public class PlayerPlugin implements IGamePlugin{
    @Override
  public void start(World world) {
        world.add(new Player());
    }

    @Override
    public void stop(World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
