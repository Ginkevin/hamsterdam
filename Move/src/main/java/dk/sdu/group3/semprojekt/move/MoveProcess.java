/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.move;

import dk.sdu.group3.semprojekt.common.data.Entity;
import dk.sdu.group3.semprojekt.common.data.Vector;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

import java.util.List;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGameProcess.class)
public class MoveProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        List<IEntity> entities = world.getEntities();
        entities.stream().forEach(entity -> {
            move(entity,delta);
        });
    }  
    
    public void move(IEntity entity, int delta)
    {
        Vector x0 = entity.getPosition();
        Vector v = entity.getVelocity();
        float t = (float)(delta)/100;
            // x(t) =  x0 + v*delta
        Vector xt = x0.plus(v.times(t));
//            Vector xt = x0.plus(new Vector(0.1,0.1));
        entity.setPosition(xt);
//            System.out.println(xt);
    }
}
