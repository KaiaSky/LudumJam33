package com.github.keon3141.ludumdare33.gui;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.github.keon3141.ludumdare33.gameloop.World;

public class GUIElement {

	protected Rectangle rect;
	
	protected Animation animation;
	
	public GUIElement(float x, float y, Animation animation)
	{
		this.animation = animation;
		rect = new Rectangle(x, y, this.animation.getWidth(), this.animation.getHeight());
	}
	
	public void update(float dt, World w)
	{
	}
	
	public void draw(Graphics g)
	{
		g.drawAnimation(animation, getX(), getY());
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

	
	public void setX(float newX){
		rect.setCenterX(newX);
	}
	
	public void setY(float newY){
		rect.setCenterY(newY);
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
}
