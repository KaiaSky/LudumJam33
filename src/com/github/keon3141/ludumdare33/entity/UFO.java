package com.github.keon3141.ludumdare33.entity;



import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.gameloop.World;

public class UFO extends Entity{

	Input in;
	float DRAG = 1f;
	float THRUST = 4f;
	
	public UFO(Animation newAnim, float newx, float newy, Input input) {
		super(newx, newy,newAnim);
		in = input;
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		
		boolean keysdown = false;
		if (in.isKeyDown(in.KEY_W)||in.isKeyDown(in.KEY_UP))
		{
			keysdown = true;
			dy -= THRUST;
		}
		if (in.isKeyDown(in.KEY_A)||in.isKeyDown(in.KEY_LEFT))
		{
			keysdown = true;
			dx -= THRUST;
		}
		if (in.isKeyDown(in.KEY_S)||in.isKeyDown(in.KEY_DOWN))
		{
			keysdown = true;
			dy += THRUST;
		}
		if (in.isKeyDown(in.KEY_D)||in.isKeyDown(in.KEY_RIGHT))
		{
			keysdown = true;
			dx += THRUST;
		}
		if(!(keysdown)) // More drag if no keys pressed
		{
			dx -= dt*dx * DRAG*4;
			dy -= dt*dy * DRAG*4;
		}
		else{
			dx -= dt*dx * DRAG;
			dy -= dt*dy * DRAG;
		}
	}

}
