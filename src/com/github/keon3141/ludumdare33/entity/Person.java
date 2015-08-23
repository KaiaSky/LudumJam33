package com.github.keon3141.ludumdare33.entity;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Person extends Entity implements GoodGuys {

	public int speed = 40;
	boolean onGround;
	boolean afraid;
	boolean direction; // right true
	float directionTime;
	int ethnicity;
	
	
	public Person(float x, float y)
	{
		super(x, y, AnimHelper.person);
		onGround = false;
		afraid = false;
		direction = InGame.rand.nextBoolean();
		directionTime = InGame.rand.nextInt(300)/10.0f;
		ethnicity =InGame.rand.nextInt(4);
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
					this.currentanimation = 0+ethnicity*6;
					this.dx = speed;
				}
				else
				{
					this.currentanimation = 1+ethnicity*6;
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
					this.currentanimation = 2+ethnicity*6;
					this.dx = speed*4;
				}
				else
				{
					this.currentanimation = 3+ethnicity*6;
					this.dx = -speed*4;
				}
			}
			
		}
		else{
			dy += 60*dt;
			if(this.getRect().getMaxY()>w.getFloorLevel())
			{
				onGround = true;
				this.getRect().setY(w.getFloorLevel()-this.getRect().getHeight());
			}
			if(direction)
			{
				this.currentanimation = 4+ethnicity*6;
			}else{
				this.currentanimation = 5+ethnicity*6;
			}
			
		}
		if(this.getRect().getMinX() < 0 || this.getRect().getMaxX() > w.width)
		{
			direction = !direction;
			dx = -dx;
		}
	}
	
}
