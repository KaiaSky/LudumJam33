package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class TractorBeam extends Entity{

	UFO parent;
	
	public TractorBeam(UFO parentship) {
		super(0,0, AnimHelper.beam);
		parent = parentship;
	}
	
	public void update(float dt, World w)
	{
		this.rect.setCenterX(parent.rect.getCenterX());
		this.rect.setY(parent.rect.getMaxY());
		ArrayList<Entity> l = w.getEntityList();
		for(int i = 0; i < l.size(); i++)
		{
			Entity e = l.get(i);
			if(e instanceof Person)
			{
				if(e.rect.intersects(this.rect))
				{
					((Person)e).onGround=false;
					((Person)e).afraid=true;
					e.dy -= dt*100;
					e.dy -= dt*e.dy * .1;
					e.dx += dt*10 *(this.rect.getCenterX()-e.rect.getCenterX());
					e.dx -= dt*e.dx * 2;
				}
			}
		}
	}


	
	
	
}
