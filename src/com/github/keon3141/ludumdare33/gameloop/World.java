package com.github.keon3141.ludumdare33.gameloop;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.entity.Camera;
import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.gui.GUIElement;

public class World {
	
	ArrayList<Entity> entityList;
	ArrayList<GUIElement> guiList;
	public int width;
	public int height;
	public Input input;
	public boolean active = true;
	int floorLevel;
	Camera c;
	
	//ArrayList<>
	
	public World(int width, int height, int floor, Input input)
	{
		entityList = new ArrayList<Entity>();
		guiList = new ArrayList<GUIElement>();
		this.width=width;
		this.height=height;
		this.input = input;
		this.floorLevel = floor;
		c = new Camera(0,0);
	}
	
	public int getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(int floorLevel) {
		this.floorLevel = floorLevel;
	}

	public Camera getC() {
		return c;
	}

	public void setC(Camera c) {
		this.c = c;
	}

	public void addGui(GUIElement g)
	{
		guiList.add(g);
	}
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
	}
	
	public void removeGUI(GUIElement g)
	{
		guiList.remove(g);
	}
	
	public void removeEntity(Entity e)
	{
		entityList.remove(e);
	}
	
	public ArrayList<Entity> getEntityList()
	{
		return entityList;
	}
	
	public ArrayList<GUIElement> getGUIList()
	{
		return guiList;
	}
	
	public void update(float dt)
	{
		if(active)
		{
			c.update(dt, this);
			for(int i = 0; i<entityList.size(); i++)
			{
				entityList.get(i).update(dt, this);
			}
			for(int i = 0; i<guiList.size(); i++)
			{
				guiList.get(i).update(dt, this);
			}
		}else{
			c.update(dt, this);
			for(int i = 0; i<entityList.size(); i++)
			{
				entityList.get(i).pauseUpdate(dt, this);
			}
			for(int i = 0; i<guiList.size(); i++)
			{
				guiList.get(i).pauseUpdate(dt, this);
			}
		}
	}
	
	public void draw(Graphics g)
	{
		c.pushTransform(g);
		for(int i = 0; i<entityList.size(); i++)
		{
			entityList.get(i).draw(g);
		}
		c.popTransform(g);
		for(int i = 0; i<guiList.size(); i++)
		{
			guiList.get(i).draw(g);
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
