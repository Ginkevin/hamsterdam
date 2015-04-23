/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.move;

import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGameProcess.class)
public class MoveProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        for(IEntity e : world.getEntities()){
            e.setPosition(e.getPosition().getX() + e.getVelocity().getX(), e.getPosition().getY() + e.getVelocity().getY());
        }        
    }    
}
