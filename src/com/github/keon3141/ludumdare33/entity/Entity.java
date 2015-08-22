package com.github.keon3141.ludumdare33.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Entity {

	private Rectangle rect;
	
	private Animation animation;
	
	private float dx;
	private float dy;
	
	public Entity(float x, float y, Animation animation)
	{
		this.animation = animation;
		rect = new Rectangle(x, y, this.animation.getWidth(), this.animation.getHeight());
		dx = 0;
		dy = 0;
	}
	
	public void update(float dt)
	{
		setRelativeXY(dt*dx, dt*dy);
	}
	
	public void draw(Graphics g)
	{
		g.drawAnimation(animation, getX(), getY());
	}
	
	public void setRelativeXY(float dx,float dy){
		rect.setX(rect.getX()+dx);
		rect.setY(rect.getY()+dy);
	}
	
	public float getX(){ // Left
		return rect.getX();
	}
	
	public float getY(){ // Top
		return rect.getY();
	}

	public Animation getAnimation() {
		return animation;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}
	
	public void setX(float newX){
		rect.setCenterX(newX);
	}
	
	public void setY(float newY){
		rect.setCenterY(newY);
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
	
}
