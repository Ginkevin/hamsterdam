/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IShape;
import dk.sdu.group3.semprojekt.common.enums.ShapeEnum;
import static dk.sdu.group3.semprojekt.common.enums.ShapeEnum.CIRCLE;

/**
 *
 * @author Deothan
 */
public class Circle implements IShape{
    private ShapeEnum shape = CIRCLE;
    private float radius;
    
    public Circle(float r){
       radius = r; 
    }
    
    @Override
    public ShapeEnum getShape() {
        return shape;
    }    

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
