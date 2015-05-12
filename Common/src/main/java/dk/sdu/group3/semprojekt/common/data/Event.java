/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.EventEnum;

/**
 *
 * @author mads_000
 */
public class Event {
    private EventEnum event;
    
    public Event(EventEnum e){
        event = e;
    }

    public EventEnum getEvent() {
        return event;
    }

    public void setEvent(EventEnum event) {
        this.event = event;
    }
}
