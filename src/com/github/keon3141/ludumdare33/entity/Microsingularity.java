package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class Microsingularity extends Entity{

	float lifetime = 5f;
	
	public Microsingularity(float x, float y) {
		super(x, y, AnimHelper.microsingularity);
		this.rect.setCenterX(x);
		this.rect.setCenterY(y);
		SoundHelper.microsingularity.play();
	}
	
	public void update(float dt, World w)
	{
		ArrayList<Entity> el = w.getEntityList();
		for(int i = 0; i < el.size(); i++)
		{
			Entity e = el.get(i);
			if(e instanceof GoodGuys)
			{
				float dist = (float) (Math.pow(this.rect.getCenterX()-e.rect.getCenterX(), 2)+Math.pow(this.rect.getCenterY()-e.rect.getCenterY(),2));
				float accel = 1600*1600*100.0f/dist;
				float angle = (float) Math.atan2(this.rect.getCenterY()-e.rect.getCenterY(),this.rect.getCenterX()-e.rect.getCenterX());
				e.dx += dt* Math.cos(angle)*accel;
				e.dy += dt* Math.sin(angle)*accel;
				
				if(e instanceof Person)
				{
					((Person)e).onGround = false;
				}
				if(e instanceof Tank)
				{
					((Tank)e).onGround = false;
				}
				
				if(e.rect.intersects(rect))
				{
					e.die();
				}
			}
		}
		lifetime -= dt;
		if( lifetime < 0)
		{
			this.die();
		}
	}
	
	
	
}
