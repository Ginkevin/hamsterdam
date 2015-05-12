/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.enums.ShapeEnum;
import dk.sdu.group3.semprojekt.common.interfaces.IShape;
import static dk.sdu.group3.semprojekt.common.enums.ShapeEnum.RECTANGLE;

/**
 *
 * @author Deothan
 */
public class Rectangle implements IShape{
    private ShapeEnum shape = RECTANGLE;
    private float w, h;
    
    public Rectangle(float h, float w){
        this.w = w;
        this.h = h;
    }
    
    @Override
    public ShapeEnum getShape() {
        return shape;
    }    

    public float getWidth() {
        return w;
    }

    public void setWidth(float w) {
        this.w = w;
    }

    public float getHeight() {
        return h;
    }

    public void setHeight(float h) {
        this.h = h;
    }
}
