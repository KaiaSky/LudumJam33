package com.github.keon3141.ludumdare33.entity;



import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;
import com.github.keon3141.ludumdare33.helper.RectangleHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class UFO extends Entity implements PlayerStuff{
	
	float DRAG = 1f;
	float THRUST = PlayerDataStorage.thrustPower;
	TractorBeam beam;
	public int captives = 0;
	public boolean initialized = false;
	
	public UFO(float newx, float newy) {
		super(newx, newy,AnimHelper.ufo);
		
		health = PlayerDataStorage.hullIntegrity;
		maxhealth = PlayerDataStorage.hullIntegrity;
	}
	
	public void die()
	{
		SoundHelper.ufo.stop();
		super.die();
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		
		if(!initialized)
		{
			initialized = true;
			SoundHelper.ufo.loop();
		}
		
		Input in = w.input;
		boolean keysdown = false;
		if (in.isKeyDown(in.KEY_W)||in.isKeyDown(in.KEY_UP))
		{
			keysdown = true;
			dy -= THRUST*dt;
		}
		if (in.isKeyDown(in.KEY_A)||in.isKeyDown(in.KEY_LEFT))
		{
			keysdown = true;
			dx -= THRUST*dt;
		}
		if (in.isKeyDown(in.KEY_S)||in.isKeyDown(in.KEY_DOWN))
		{
			keysdown = true;
			dy += THRUST*dt;
		}
		if (in.isKeyDown(in.KEY_D)||in.isKeyDown(in.KEY_RIGHT))
		{
			keysdown = true;
			dx += THRUST*dt;
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
		if(in.isMousePressed(in.MOUSE_LEFT_BUTTON))
		{
			w.addEntity(new PlasmaBomb(this.getX()+this.animations.get(currentanimation).getWidth()/2, this.getY()+this.animations.get(currentanimation).getHeight(), in.getMouseX()+w.getC().getX(), in.getMouseY()+w.getC().getY()));
		}
		if(in.isKeyDown(in.KEY_SPACE) && beam == null)
		{
			beam = new TractorBeam(this);
			w.addEntity(beam);
		}
		else if(!in.isKeyDown(in.KEY_SPACE) && beam != null)
		{
			beam.die();
			w.removeEntity(beam);
			beam = null;
		}
		
		ArrayList<Entity> l = w.getEntityList();
		for(int i = 0; i < l.size(); i++)
		{
			Entity e = l.get(i);
			if(e instanceof Person && !((Person)e).onGround)
			{                   
				if(RectangleHelper.contains(this.getRect(), e.getRect()))
				{
					System.out.print("DIE");
					e.die(); //rip
					captives += 1;
				}
			}
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
		}if(this.getRect().getMaxY()+75 > w.getFloorLevel())
		{
			dy-=THRUST*2* (this.getRect().getMaxY()+75- w.getFloorLevel())/35*dt;
		}
		
		if(dx>150)
		{
			this.currentanimation=1;
		}else if(dx<-150)
		{
			this.currentanimation=2;
		}else
		{
			this.currentanimation=0;
		}
	}

}
