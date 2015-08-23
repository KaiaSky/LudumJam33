package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;

public class PlasmaBomb extends Entity implements PlayerStuff{

	public float SPEED = PlayerDataStorage.plasmaSpeed;
	public int damage = PlayerDataStorage.plasmaDamage;
	
	public PlasmaBomb(float newx, float newy,float targetX, float targetY) {
		super(newx, newy, AnimHelper.plasma);
		float dxtemp = (targetX-newx);
		float dytemp = (targetY-newy);
		dx = (float) (dxtemp*SPEED/Math.sqrt(dxtemp*dxtemp+dytemp*dytemp));
		dy = (float) (dytemp*SPEED/Math.sqrt(dxtemp*dxtemp+dytemp*dytemp));
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		ArrayList<Entity> l = w.getEntityList();
		for(int i = 0; i < l.size(); i++)
		{
			Entity e = l.get(i);
			if(e instanceof GoodGuys)
			{
				if(e.getRect().intersects(this.getRect()))
				{
					this.die();
					w.addEntity(new Explosion(getRect().getCenterX(), getRect().getCenterY(), damage));
					return;
				}
			}
		}
		
		if(this.getRect().getMinX() < 0)
		{
			this.die();
		}if(this.getRect().getMinY() < 0)
		{
			this.die();
		}if(this.getRect().getMaxX() > w.width)
		{
			this.die();
		}if(this.getRect().getMaxY() > w.getFloorLevel())
		{
			this.die();
			System.out.println("hitfloor"+this);
			w.addEntity(new Explosion(getRect().getCenterX(), getRect().getCenterY(), damage));
			return;
		}
	}

}
