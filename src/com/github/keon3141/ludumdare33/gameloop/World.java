package com.github.keon3141.ludumdare33.gameloop;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.gui.GUIElement;

public class World {
	
	ArrayList<Entity> entityList;
	ArrayList<GUIElement> guiList;
	int width;
	int height;
	public Input input;
	int floorLevel;
	
	//ArrayList<>
	
	public World(int width, int height, Input input)
	{
		entityList = new ArrayList<Entity>();
		guiList = new ArrayList<GUIElement>();
		this.width=width;
		this.height=height;
		this.input = input;
	}
	
	public void addGui(GUIElement g)
	{
		guiList.add(g);
	}
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
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
		for(int i = 0; i<entityList.size(); i++)
		{
			entityList.get(i).update(dt, this);
		}
		for(int i = 0; i<guiList.size(); i++)
		{
			guiList.get(i).update(dt, this);
		}
	}
	
	public void draw(Graphics g)
	{
		for(int i = 0; i<entityList.size(); i++)
		{
			entityList.get(i).draw(g);
		}
		for(int i = 0; i<guiList.size(); i++)
		{
			guiList.get(i).draw(g);
		}
	}
}
