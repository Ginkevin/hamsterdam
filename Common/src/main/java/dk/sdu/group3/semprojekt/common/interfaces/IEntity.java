/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.interfaces;

import dk.sdu.group3.semprojekt.common.data.ShapeEnum;
import dk.sdu.group3.semprojekt.common.data.Vector;

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
}
