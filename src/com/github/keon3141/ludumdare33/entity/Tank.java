package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Tank extends Entity implements GoodGuys{

	float weaponcooldown = 5;
	float currentCooldown = 5;
	float targetingDistance = 500;
	boolean readytofire = true;
	boolean hasInit = false;
	Entity target;
	
	public Tank(float x, float y) {
		super(x, y, AnimHelper.tank);
		health = 7;
		maxhealth = 7;
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
		
		if(readytofire )
		{
			float dist = (float) (Math.pow((this.getRect().getCenterX()-target.getRect().getCenterX()),2) +  Math.pow((this.getRect().getCenterY()-target.getRect().getCenterY()),2));
			if(targetingDistance*targetingDistance>dist)
			{
				float angle = (float) Math.atan2(this.getRect().getCenterY()-target.getRect().getCenterY(), this.getRect().getCenterX()-target.getRect().getCenterX());
				w.addEntity(new Missile(this.getRect().getCenterX(),this.getRect().getCenterY(), angle));
				readytofire = false;
			}
		}else{
			currentCooldown -= dt;
			if(currentCooldown < 0)
			{
				currentCooldown = weaponcooldown;
				readytofire = true;
			}
		}
	}

}
