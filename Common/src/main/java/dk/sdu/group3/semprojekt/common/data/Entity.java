package dk.sdu.group3.semprojekt.common.data;

import dk.sdu.group3.semprojekt.common.interfaces.IEntity;
import java.util.ArrayList;
import java.util.List;
import playn.core.ImageLayer;

public abstract class Entity implements IEntity {

	private Vector position;
	private Vector velocity;
	private String sprite;
	private float angle;
	private ShapeEnum shape;
	private List<Event> events = new ArrayList();
	private ImageLayer view;
	private float scale;

	@Override
	public Vector getPosition() {
		return position;
	}

	@Override
	public void setPosition(float x, float y) {
		position.setVector(x, y);
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
	public String getSprite() {
		return sprite;
	}

	@Override
	public void setSprite(String path) {
		sprite = path;
	}

	@Override
	public ShapeEnum getShape() {
		return shape;
	}

	@Override
	public void setShape(ShapeEnum shape) {
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
