/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.EventEnum;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;

/**
 *
 * @author Deothan
 */
public class HitEvent extends Event{
    private IEntity source;
    
    public HitEvent(EventEnum e, IEntity source) {
        super(e);
        this.source = source;
    }
    
    public IEntity getSource() {
        return source;
    }
}
