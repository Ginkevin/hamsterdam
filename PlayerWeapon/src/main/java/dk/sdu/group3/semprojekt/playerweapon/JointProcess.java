/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.playerweapon;

import dk.sdu.group3.semprojekt.common.data.Bullet;
import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.World;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.HIT;
import dk.sdu.group3.semprojekt.common.interfaces.ICharacter;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Deothan
 */

@ServiceProvider(service = IGameProcess.class)
public class JointProcess implements IGameProcess{
    @Override
    public void process(int delta, World world) {
        for(IEntity e : world.getEntities()){
            if(e instanceof Joint){    
                for (Event h : e.getEvents()) {
                    if (h.getEvent() == HIT) {
                        HitEvent source = (HitEvent) h;
                            if (source.getSource() instanceof ICharacter) {
                                    e.setIsDestroyed(true);
                            }
                    }
                }
            }
        } 
    }
}
