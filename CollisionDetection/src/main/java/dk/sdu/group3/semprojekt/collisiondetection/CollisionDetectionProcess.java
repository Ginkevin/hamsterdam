/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group3.semprojekt.collisiondetection;

import dk.sdu.group3.semprojekt.common.data.Circle;
import static dk.sdu.group3.semprojekt.common.enums.EventEnum.HIT;
import dk.sdu.group3.semprojekt.common.data.HitEvent;
import dk.sdu.group3.semprojekt.common.data.Rectangle;
import dk.sdu.group3.semprojekt.common.data.World;
import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.spi.IGameProcess;
import static dk.sdu.group3.semprojekt.common.enums.ShapeEnum.CIRCLE;
import static dk.sdu.group3.semprojekt.common.enums.ShapeEnum.RECTANGLE;
import static java.lang.Math.abs;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Deothan
 */

@ServiceProvider (service = IGameProcess.class)
public class CollisionDetectionProcess implements IGameProcess{
    private static int count = 0;
    @Override
    public void process(int delta, World world) {
        for(IEntity e : world.getEntities()){
            for(IEntity source : world.getEntities()){
                if(!e.equals(source) ){
                    if(e.getShape().getShape().equals(CIRCLE) && source.getShape().getShape().equals(CIRCLE) && testCircleCircle(e, source)){
                        e.addEvent(new HitEvent(HIT, source));
                    }

                    if(e.getShape().getShape().equals(CIRCLE) && source.getShape().getShape().equals(RECTANGLE) && testCircleRectangle(e, source)){
                        e.addEvent(new HitEvent(HIT, source));
                    }
                    
                    if(e.getShape().getShape().equals(RECTANGLE) && source.getShape().getShape().equals(CIRCLE) && testCircleRectangle(e, source)){
                        e.addEvent(new HitEvent(HIT, source));
                    }
                    
                    if(e.getShape().getShape().equals(RECTANGLE) && source.getShape().getShape().equals(RECTANGLE) && testRectangleRectangle(e, source)){
                        e.addEvent(new HitEvent(HIT, source));
                    }
                }
            }
        }
    }
    
    private boolean testRectangleRectangle(IEntity current, IEntity source){
        Rectangle rectangle1 = (Rectangle) current.getShape();
        Rectangle rectangle2 = (Rectangle) source.getShape();
        
        float top1 = current.getPosition().getY()+rectangle1.getHeight()/2;
        float bot1 = current.getPosition().getY()-rectangle1.getHeight()/2;
        float left1 = current.getPosition().getX()-rectangle1.getWidth()/2;
        float right1 = current.getPosition().getX()+rectangle1.getWidth()/2;
        
        float top2 = source.getPosition().getY()+rectangle2.getHeight()/2;
        float bot2 = source.getPosition().getY()-rectangle2.getHeight()/2;
        float left2 = source.getPosition().getX()-rectangle2.getWidth()/2;
        float right2 = source.getPosition().getX()+rectangle2.getWidth()/2;
        
        if((bot1 < top2) && (top1 > bot2) && (left1 < right2) && (right1 > left2)){
            return true;
        }       

        return false;
    }
    
    private boolean testCircleCircle(IEntity current, IEntity source) {
        float x = current.getPosition().getX() - source.getPosition().getX();
        float y = current.getPosition().getY() - source.getPosition().getY();
        double distance = Math.sqrt((x * x) + (y * y));
        
        Circle c1 = (Circle) current.getShape();
        Circle c2 = (Circle) source.getShape();

        float radiusCurrent = c1.getRadius();
        float radiusSource = c2.getRadius();            

        boolean isCollision = distance <= radiusCurrent + radiusSource;
        
        return isCollision;
    }
    
    private boolean testCircleRectangle(IEntity current, IEntity source){
        Circle circle = setCircle(current, source); 
        Rectangle rectangle = setRectangle(current, source);

        float circleDistanceX = abs(current.getPosition().getX() - source.getPosition().getX());
        float circleDistanceY = abs(current.getPosition().getY() - source.getPosition().getY());

        if (circleDistanceX > (rectangle.getWidth()/2 + circle.getRadius())) 
            return false; 

        if (circleDistanceY > (rectangle.getHeight()/2 + circle.getRadius()))
            return false; 

        if (circleDistanceX <= (rectangle.getWidth()/2)) 
            return true; 
    
        if (circleDistanceY <= (rectangle.getHeight()/2)) 
            return true; 

        float cornerDistance_sq = (circleDistanceX - rectangle.getWidth()/2)*(circleDistanceX - rectangle.getWidth()/2) + 
                                  (circleDistanceY - rectangle.getHeight()/2)*(circleDistanceY - rectangle.getHeight()/2);

        return (cornerDistance_sq <= (circle.getRadius()*circle.getRadius()));
    }
    
    private Circle setCircle(IEntity current, IEntity source){
        Circle circle;
        
        if(current.getShape().getShape().equals(CIRCLE))
           circle = (Circle) current.getShape();

        else if(source.getShape().getShape().equals(CIRCLE))
           circle = (Circle) source.getShape();
        
        else{
            System.out.println("Shape not found!");
            circle = null;
        }
        
        return circle;
    }
    
    private Rectangle setRectangle(IEntity current, IEntity source){
        Rectangle rectangle;
        
        if(current.getShape().getShape().equals(RECTANGLE))
           rectangle = (Rectangle) current.getShape();

        else if(source.getShape().getShape().equals(RECTANGLE))
           rectangle = (Rectangle) source.getShape();  
        
        else{
            System.out.println("Shape not found!");
            rectangle = null;
        }
        
        return rectangle;
    }
}
