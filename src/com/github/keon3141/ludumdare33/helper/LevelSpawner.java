package com.github.keon3141.ludumdare33.helper;

import java.util.HashMap;
import java.util.Iterator;

import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.entity.Person;
import com.github.keon3141.ludumdare33.entity.Tank;
import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;

public class LevelSpawner extends Entity{

	float time;
	int level;
	World w;
	HashMap<Float, Entity> entityReleaseTimes;
	
	int[] peopleStart = {10,20,30,40,50,60,70};
	int[] peopleRandom = {5,10,15,20,25,30,35};
	int[] peopleLater = {5,10,15,20,25,30,35};
	
	int[] tankStart = {0,1,1,2,3,4,5};
	int[] tankRandom ={1,1,1,2,3,5,10};
	int[] tankLater = {0,0,1,2,3,4,5};
	
	
	public LevelSpawner(World w)
	{
		super(-1000,-1000,1,1);
		
		this.w = w;
		entityReleaseTimes = new HashMap<Float, Entity>();
		
		PlayerDataStorage.updateLevels();
		level = PlayerDataStorage.level;
		int people = peopleStart[level] + InGame.rand.nextInt(peopleRandom[level]);
		for(int i = 0; i<people; i++)
		{
			w.addEntity(new Person(InGame.rand.nextInt(w.width),w.getFloorLevel()-AnimHelper.person.get(0).getHeight()));
		}
		for(int i = 0; i<peopleLater[level]; i++)
		{
			entityReleaseTimes.put(InGame.rand.nextFloat()*30, new Person(InGame.rand.nextInt(2)*(w.width-AnimHelper.person.get(0).getWidth()),w.getFloorLevel()-AnimHelper.person.get(0).getHeight()));
		}
		
		
		int tanks = tankStart[level] + InGame.rand.nextInt(tankRandom[level]);
		for(int i = 0; i<tanks; i++)
		{
			w.addEntity(new Tank(InGame.rand.nextInt(w.width),w.getFloorLevel()-AnimHelper.tank.get(0).getHeight()));
		}
		for(int i = 0; i<tankLater[level]; i++)
		{
			entityReleaseTimes.put(InGame.rand.nextFloat()*30, new Tank(InGame.rand.nextInt(2)*(w.width-AnimHelper.person.get(0).getWidth()),w.getFloorLevel()-AnimHelper.person.get(0).getHeight()));
		}
	}
	
	public void draw(Graphics g)
	{
		return;
	}
	
	public void update(float dt, World w)
	{
		time += dt;
		Iterator<Float> keys = entityReleaseTimes.keySet().iterator();
		while(keys.hasNext())
		{
			float t = keys.next();
			if (t < time)
			{
				w.addEntity(entityReleaseTimes.get(t));
				keys.remove();
			}
		}
	}
	
}
