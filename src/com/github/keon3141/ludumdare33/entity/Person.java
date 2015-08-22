package com.github.keon3141.ludumdare33.entity;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Person extends Entity {

	public int speed = 40;
	boolean onGround;
	boolean afraid;
	boolean direction; // right true
	float directionTime;
	
	
	public Person(float x, float y)
	{
		super(x, y, AnimHelper.person);
		onGround = false;
		afraid = false;
		direction = InGame.rand.nextBoolean();
		directionTime = InGame.rand.nextInt(300)/10.0f;
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		if(onGround)
		{
			dy = 0;
			if(!afraid)
			{
				if(direction)
				{
					this.dx = speed;
				}
				else
				{
					this.dx = -speed;
				}
				directionTime-=dt;
				if(directionTime<0)
				{
					direction=!direction;
					directionTime = InGame.rand.nextInt(300)/10.0f;
				}
			}
			else //Afraid
			{
				if(direction)
				{
					this.dx = speed*4;
				}
				else
				{
					this.dx = -speed*4;
				}
			}
			
		}
		else{
			dy += 60*dt;
			if(this.rect.getMaxY()>w.getFloorLevel())
			{
				onGround = true;
				this.rect.setY(w.getFloorLevel()-this.rect.getHeight());
			}
		}
	}
	
}
