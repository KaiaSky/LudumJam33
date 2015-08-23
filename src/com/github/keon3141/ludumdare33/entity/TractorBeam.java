package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;

public class TractorBeam extends Entity{

	UFO parent;
	public float tractorForce = PlayerDataStorage.tractorForce;
	
	public TractorBeam(UFO parentship) {
		super(0,0, AnimHelper.beam);
		parent = parentship;
		health = 1000;
		maxhealth = 1000;
	}
	
	public void update(float dt, World w)
	{
		health = 1000;
		maxhealth = 1000;
		this.getRect().setCenterX(parent.getRect().getCenterX());
		this.getRect().setY(parent.getRect().getMaxY());
		ArrayList<Entity> l = w.getEntityList();
		for(int i = 0; i < l.size(); i++)
		{
			Entity e = l.get(i);
			if(e instanceof Person)
			{
				if(e.getRect().intersects(this.getRect()))
				{
					((Person)e).onGround=false;
					((Person)e).afraid=true;
					e.dy -= dt*tractorForce;
					e.dy -= dt*e.dy * .1;
					e.dx += dt*tractorForce/10 *(this.getRect().getCenterX()-e.getRect().getCenterX());
					e.dx -= dt*e.dx * 2;
				}
			}
		}
	}


	
	
	
}
