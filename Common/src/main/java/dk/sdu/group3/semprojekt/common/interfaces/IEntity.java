/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.interfaces;

import dk.sdu.group3.semprojekt.common.data.Event;
import dk.sdu.group3.semprojekt.common.data.ShapeEnum;
import dk.sdu.group3.semprojekt.common.data.Vector;
import java.util.List;

/**
 *
 * @author mads_000
 */
public interface IEntity {
    Vector getPosition();
    void setPosition(float x, float y);
    Vector getVelocity();
    void setVelocity(float x, float y);
    String getSprite();
    void setSprite(String path);
    ShapeEnum getShape();
    void setShape(ShapeEnum shape);
    float getAngle();
    void setAngle(float angle);
    List<Event> getEvents();
    void addEvent(Event e);
    void removeEvent(Event e);
}