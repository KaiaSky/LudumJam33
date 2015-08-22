package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class PlasmaBomb extends Entity{

	public static float SPEED = 300;
	
	public PlasmaBomb(float newx, float newy, Animation newAnim,  float targetX, float targetY) {
		super(newx, newy, newAnim);
		float dxtemp = (targetX-newx);
		float dytemp = (targetY-newy);
		dx = (float) (dxtemp*SPEED/Math.sqrt(dxtemp*dxtemp+dytemp*dytemp));
		dy = (float) (dytemp*SPEED/Math.sqrt(dxtemp*dxtemp+dytemp*dytemp));
	}
	
	public PlasmaBomb(float newx, float newy,float targetX, float targetY) {
		super(newx, newy, AnimHelper.getAnimation("res/img/plasmabolt.png"));
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
			if(e instanceof Person)
			{
				if(e.rect.intersects(this.rect))
				{
					l.remove(this);
					//w.addEntity(e)
				}
			}
		}
	}

}
