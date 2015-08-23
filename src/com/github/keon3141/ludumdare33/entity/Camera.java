package com.github.keon3141.ludumdare33.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.github.keon3141.ludumdare33.gameloop.LudumJam33Game;
import com.github.keon3141.ludumdare33.gameloop.World;

public class Camera extends Entity{

	private Entity target;
	
	public Camera(Entity target) {
		super(target.getX(), target.getY(), null);
		this.getRect().setCenterX(target.getRect().getCenterX());
		this.getRect().setCenterY(target.getRect().getCenterY());
		this.getRect().setSize(LudumJam33Game.WIDTH, LudumJam33Game.HEIGHT);
		this.target = target;
		health = 1000;
		maxhealth = 1000;
		
	}
	
	public Camera(float x, float y) {
		super(x,y,LudumJam33Game.WIDTH, LudumJam33Game.HEIGHT);
		
	}
	
	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

	public void draw(Graphics g)
	{
		return;
	}
	
	public void pushTransform(Graphics g)
	{
		g.pushTransform();
		g.translate(-this.getX(), -this.getY());
	}
	
	public void popTransform(Graphics g)
	{
		g.popTransform();
	}
	
	public void update(float dt, World w)
	{
		
		super.update(dt, w);
		
		health = 1000;
		maxhealth = 1000;
		if(target!=null)
		{
			dx = 2*(target.getRect().getCenterX()-this.getRect().getCenterX());
			dy = 2*(target.getRect().getCenterY()-this.getRect().getCenterY());
		}
		if(this.getRect().getMinX() < 0)
		{
			this.getRect().setX(0);
		}if(this.getRect().getMinY() < 0)
		{
			this.getRect().setY(0);
		}if(this.getRect().getMaxX() > w.width)
		{
			this.getRect().setX(w.width-this.getRect().getWidth());
		}if(this.getRect().getMaxY() > w.height)
		{
			this.getRect().setY(w.height-this.getRect().getHeight());
		}
	}

}
