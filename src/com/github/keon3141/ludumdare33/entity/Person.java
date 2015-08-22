package com.github.keon3141.ludumdare33.entity;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;

public class Person extends Entity {

	public int speed = 10;
	boolean onGround;
	boolean afraid;
	boolean direction; // right true
	float directionTime;
	
	
	public Person(float x, float y, Animation animation)
	{
		super(x, y, animation);
		onGround = true;
		afraid = false;
		direction = InGame.rand.nextBoolean();
		directionTime = InGame.rand.nextInt(300)/10.0f;
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		if(onGround)
		{
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
	}
	
}
