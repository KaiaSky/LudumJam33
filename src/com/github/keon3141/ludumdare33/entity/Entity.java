package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.github.keon3141.ludumdare33.gameloop.World;

public class Entity {

	protected Rectangle rect;
	
	protected ArrayList<Animation> animations;
	protected int currentanimation;
	
	protected float dx;
	protected float dy;
	protected boolean dead = false;
	
	public Entity(float x, float y, ArrayList<Animation> animations)
	{
		this.animations = animations;
		rect = new Rectangle(x, y, this.animations.get(0).getWidth(), this.animations.get(0).getHeight());
		dx = 0;
		dy = 0;
		currentanimation = 0;
	}
	
	public Entity(float x, float y,float width,float height)
	{
		rect = new Rectangle(x, y, width, height);
		dx = 0;
		dy = 0;
		currentanimation = 0;
	}
	
	public void die()
	{
		dead = true;
	}
	
	public void update(float dt, World w)
	{
		setRelativeXY(dt*dx, dt*dy);
		if (dead)
		{
			w.removeEntity(this);
		}
	}
	
	public void pauseUpdate(float dt, World w)
	{
	}
	
	public void draw(Graphics g)
	{
		g.drawAnimation(animations.get(currentanimation), getX(), getY());
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
		return animations.get(currentanimation);
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

	public void addAnimation(Animation animation) {
		this.animations.add(animation);
	}
	
	public int getCurrentAnimation()
	{
		return currentanimation;
	}
	
	public void setCurrentAnimation(int newAnimation)
	{
		currentanimation = newAnimation;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
	
}
