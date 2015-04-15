package dk.sdu.group3.semprojekt.common;

import playn.core.ImageLayer;

/**
 * @author emilfrisk
 */
public class Entity {
	ImageLayer view;
	Position position;
	float rotation, scale;
	String spritePath;

	public ImageLayer getView() {
		return view;
	}

	public void setView(ImageLayer view) {
		this.view = view;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getSpritePath() {
		return spritePath;
	}

	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
}
