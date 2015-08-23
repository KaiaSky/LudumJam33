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
		this.rect.setCenterX(target.rect.getCenterX());
		this.rect.setCenterY(target.rect.getCenterY());
		this.rect.setSize(LudumJam33Game.WIDTH, LudumJam33Game.HEIGHT);
		this.target = target;
		
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
		if(!target.equals(null))
		{
			dx = 2*(target.rect.getCenterX()-this.rect.getCenterX());
			dy = 2*(target.rect.getCenterY()-this.rect.getCenterY());
		}
		if(this.rect.getMinX() < 0)
		{
			this.rect.setX(0);
		}if(this.rect.getMinY() < 0)
		{
			this.rect.setY(0);
		}if(this.rect.getMaxX() > w.width)
		{
			this.rect.setX(w.width-this.rect.getWidth());
		}if(this.rect.getMaxY() > w.height)
		{
			this.rect.setY(w.height-this.rect.getHeight());
		}
	}

}
