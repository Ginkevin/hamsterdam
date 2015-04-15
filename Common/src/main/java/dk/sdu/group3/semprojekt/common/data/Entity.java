package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;

public abstract class Entity implements IEntity {
    private Vector position;
    private Vector velocity;
    private String sprite;
    private ShapeEnum shape;
    
    public Vector getPosition(){
        return position;
    }
    
    public void setPosition(float x, float y){
        position.setVector(x, y);
    }
    
    public Vector getVelocity(){
        return velocity;
    }
    
    public void setVelocity(float x, float y){
        velocity.setVector(x, y);
    }
    
    public String getSprite(){
        return sprite;
    }
    
    public void setSprite(String path){
        sprite = path;
    }
    
    public ShapeEnum getShape(){
        return shape;
    }
    
    public void setShape(ShapeEnum shape){
        this.shape = shape;
    }
}
