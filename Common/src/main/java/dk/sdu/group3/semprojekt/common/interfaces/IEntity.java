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
import playn.core.ImageLayer;

/**
 *
 * @author mads_000
 */
public interface IEntity {
    public Vector getPosition();
    public void setPosition(float x, float y);
    public void setPosition(Vector position);
    public Vector getVelocity();
    public void setVelocity(float x, float y);
    public void setVelocity(Vector velocity);
    public String getSprite();
    public void setSprite(String path);
    public ShapeEnum getShape();
    public void setShape(ShapeEnum shape);
    public float getAngle();
    public void setAngle(float angle);
    public List<Event> getEvents();
    public void addEvent(Event e);
    public void removeEvent(Event e);
    public ImageLayer getView();
    public void setView(ImageLayer view);
    public float getScale();
    public void setScale(float scale);
    public int getRadius();
    public void setRadius(int i);
}
