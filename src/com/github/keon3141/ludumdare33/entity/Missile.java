package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Missile extends Entity implements GoodGuys{
	float angle;
	float speed = 200;
	int damage = 10;
	
	public Missile(float x, float y, float angle) {
		super(x, y, AnimHelper.missile);
		this.rect.setCenterX(x);
		this.rect.setCenterY(y);
		this.dx = -(float) (Math.cos(angle)*speed);
		this.dy = -(float) (Math.sin(angle)*speed);
		this.angle = (float) Math.toDegrees(angle) + 180;
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		ArrayList<Entity> l = w.getEntityList();
		for(int i = 0; i < l.size(); i++)
		{
			Entity e = l.get(i);
			if(e instanceof PlayerStuff)
			{
				if(e.getRect().intersects(this.getRect()))
				{
					e.takeDamage(damage);
					this.die();
				}
			}
		}
	}
	
	public void draw(Graphics g)
	{
		g.pushTransform();
		g.rotate(rect.getCenterX(),rect.getCenterY(),angle);
		super.draw(g);
		g.popTransform();
	}
	
	

}
