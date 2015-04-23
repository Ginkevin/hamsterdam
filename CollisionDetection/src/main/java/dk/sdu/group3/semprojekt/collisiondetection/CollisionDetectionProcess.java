/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.collisiondetection;

import static dk.sdu.group3.semprojekt.common.data.EventEnum.HIT;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGameProcess.class)
public class CollisionDetectionProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        for(IEntity e : world.getEntities()){
            for(IEntity source : world.getEntities()){
                if(!e.equals(source) && testCollision(e, source)){
                    e.addEvent(new HitEvent(HIT, source));
                }
            }
        }
    }
    
    public boolean testCollision(IEntity current, IEntity source) {
        float x = current.getPosition().getX() - source.getPosition().getX();
        float y = current.getPosition().getY() - source.getPosition().getY();
        double distance = Math.sqrt((x * x) + (y * y));

        int radiusCurrent = current.getRadius();
        int radiusSource = source.getRadius();            

        boolean isCollision = distance <= radiusCurrent + radiusSource;

        return isCollision;
    }  
}
