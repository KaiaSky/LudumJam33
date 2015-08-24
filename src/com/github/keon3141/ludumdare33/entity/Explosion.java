package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Circle;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class Explosion extends Entity{

	public float lifetime = 0.25f;
	public Circle scareRadius;
	public int damage;
	private boolean unexploded = true;
	
	public Explosion(float xCenter, float yCenter, int damage) {
		super(xCenter, xCenter, AnimHelper.explosion);
		getRect().setCenterX(xCenter);
		getRect().setCenterY(yCenter);
		scareRadius = new Circle(getRect().getCenterX(), getRect().getCenterY(), getRect().getWidth()*2);
		this.damage = damage;
		health = 1000;
		maxhealth = 1000;
		SoundHelper.plasmaimpact.play();
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		health = 1000;
		maxhealth = 1000;
		if(unexploded)
		{
			unexploded = false;
			ArrayList<Entity> l = w.getEntityList();
			for(int i = 0; i < l.size(); i++)
			{
				Entity e = l.get(i);
				if(e instanceof GoodGuys)
				{
					if(e.getRect().intersects(this.getRect()))
					{
						e.takeDamage(damage);
					}
					if(e instanceof Person && e.getRect().intersects(this.scareRadius))
					{
						((Person)e).fear();
						((Person)e).direction = this.getRect().getCenterX()<e.getRect().getCenterX();
					}
				}
			}
		}
		
		lifetime -= dt;
		if(lifetime < 0)
		{	
			this.die();
		}
	}

}
