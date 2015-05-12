package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import dk.sdu.group3.semprojekt.common.interfaces.IShape;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import playn.core.ImageLayer;

public abstract class Entity implements IEntity {
    private Vector position = new Vector(0,0);
    private Vector velocity = new Vector(0,0);
    private String sprite;
    private float angle;
    private IShape shape;
    private CopyOnWriteArrayList<Event> events = new CopyOnWriteArrayList<>();
    private ImageLayer view;
    private float scale = 1.0f;

    @Override
    public void setPosition(float x, float y) {
            position.setVector(x, y);
    }
    
    @Override
    public void setPosition(Vector position) {
            this.position = position;
    }
    
    @Override
    public Vector getPosition() {
            return position;
    }

    @Override
    public Vector getVelocity() {
            return velocity;
    }

    @Override
    public void setVelocity(float x, float y) {
            velocity.setVector(x, y);
    }

    @Override
    public void setVelocity(Vector velocity) {
            this.velocity = velocity;
    }

    @Override
    public String getSprite() {
            return sprite;
    }

    @Override
    public void setSprite(String path) {
            sprite = path;
    }

    @Override
    public IShape getShape() {
            return shape;
    }

    @Override
    public void setShape(IShape shape) {
            this.shape = shape;
    }

    @Override
    public void addEvent(Event e) {
            events.add(e);
    }

    @Override
    public List<Event> getEvents() {
            return events;
    }

    @Override
    public void removeEvent(Event e) {
            events.remove(e);
    }

    @Override
    public float getAngle() {
            return angle;
    }

    @Override
    public void setAngle(float angle) {
            this.angle = angle;
    }

    @Override
    public ImageLayer getView() {
            return view;
    }

    @Override
    public void setView(ImageLayer view) {
            this.view = view;
    }

    @Override
    public float getScale() {
            return scale;
    }

    @Override
    public void setScale(float scale) {
            this.scale = scale;
    }	
}
