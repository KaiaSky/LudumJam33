package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class Person extends Entity implements GoodGuys {

	public int speed = 40;
	boolean onGround;
	boolean afraid;
	boolean direction; // right true
	float directionTime;
	int ethnicity;
	float screamTime = 0;
	boolean hasInit = false;
	Entity target;
	
	public boolean mindControlled = false;
	
	
	public Person(float x, float y)
	{
		super(x, y, AnimHelper.person);
		onGround = false;
		afraid = false;
		direction = InGame.rand.nextBoolean();
		directionTime = InGame.rand.nextInt(300)/10.0f;
		ethnicity =InGame.rand.nextInt(4);
	}
	
	public void fear()
	{
		afraid = true;
		screamTime = InGame.rand.nextInt(10)/100.0f;
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		
		if(!hasInit)
		{
			ArrayList<Entity> el = w.getEntityList();
			for (int i = 0; i < el.size(); i++)
			{
				if(el.get(i) instanceof UFO)
				{
					target = el.get(i);
					break;
				}
			}
			hasInit = true;
		}
		
		if(mindControlled && onGround)
		{
			if (Math.abs(target.rect.getCenterX() - this.rect.getCenterX()) < 1)
			{
				this.dx = 0;
			}
			else if (target.rect.getCenterX() > this.rect.getCenterX())
			{
				this.dx = speed*1.5f;
			}else
			{
				this.dx = -speed*1.5f;
			}
		}
		else if(onGround)
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
				this.dy=0;
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
		
		if(afraid&& screamTime>0)
		{
			screamTime -=dt;
			if(screamTime<=0)
			{
				float pitch = 0.7f + InGame.rand.nextInt(6)/10.0f;
				SoundHelper.getScream().play(pitch, 0.3f);
			}
		}
	}
	
}
