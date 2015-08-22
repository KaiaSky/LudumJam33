package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Circle;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Explosion extends Entity{

	public float lifetime = 0.25f;
	public Circle scareRadius;
	
	public Explosion(float xCenter, float yCenter) {
		super(xCenter, xCenter, AnimHelper.explosion);
		rect.setCenterX(xCenter);
		rect.setCenterY(yCenter);
		scareRadius = new Circle(rect.getCenterX(), rect.getCenterY(), rect.getWidth()*2);
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		lifetime -= dt;
		if(lifetime < 0)
		{	
			this.die();
			ArrayList<Entity> l = w.getEntityList();
			for(int i = 0; i < l.size(); i++)
			{
				Entity e = l.get(i);
				if(e instanceof Person)
				{
					if(e.rect.intersects(this.rect))
					{
						e.die();
					}
					if(e.rect.intersects(this.scareRadius))
					{
						((Person)e).afraid = true;
						((Person)e).direction = this.rect.getCenterX()<e.rect.getCenterX();
					}
				}
			}
		}
	}

}
