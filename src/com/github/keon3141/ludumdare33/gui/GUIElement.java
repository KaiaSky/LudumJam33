package com.github.keon3141.ludumdare33.gui;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.github.keon3141.ludumdare33.gameloop.World;

public class GUIElement {

	protected Rectangle rect;
	
	protected ArrayList<Animation> animations;
	protected int currentanimation;
	
	public GUIElement(float x, float y, ArrayList<Animation> animations)
	{
		this.animations = animations;
		rect = new Rectangle(x, y, this.animations.get(0).getWidth(), this.animations.get(0).getHeight());
		currentanimation = 0;
	}
	
	public void update(float dt, World w)
	{
	}
	
	public void pauseUpdate(float dt, World w)
	{
	}
	
	public void draw(Graphics g)
	{
		g.drawAnimation(animations.get(currentanimation), getX(), getY());
	}
	
	public float getX(){ // Left
		return rect.getX();
	}
	
	public float getY(){ // Top
		return rect.getY();
	}

	public Animation getAnimation(int index) {
		return animations.get(index);
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
	
	public void setX(float newX){
		rect.setX(newX);
	}
	
	public void setY(float newY){
		rect.setY(newY);
	}
	
}
