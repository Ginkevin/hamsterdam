package dk.sdu.group3.semprojekt.common.data;

public class Vector {
    float x, y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }
    
    public void setVector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public float getY(){
        return y;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public void setY(float y){
        this.y = y;
    }
    public Vector plus( Vector v){
        return new Vector(this.x+v.x,this.y+v.y);
    }
    public Vector times( float v){
        return new Vector(this.x*v,this.y*v);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
