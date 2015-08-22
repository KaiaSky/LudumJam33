package com.github.keon3141.ludumdare33.gameloop;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.entity.Entity;

public class World {
	
	ArrayList<Entity> entityList;
	int width;
	int height;
	
	int floorLevel;
	
	//ArrayList<>
	
	public World(int width, int height)
	{
		entityList = new ArrayList<Entity>();
		this.width=width;
		this.height=height;
	}
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
	}
	
	public void update(float dt)
	{
		for(int i = 0; i<entityList.size(); i++)
		{
			entityList.get(i).update(dt, this);
		}
	}
	
	public void draw(Graphics g)
	{
		for(int i = 0; i<entityList.size(); i++)
		{
			entityList.get(i).draw(g);
		}
	}
}
