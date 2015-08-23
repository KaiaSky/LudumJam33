package com.github.keon3141.ludumdare33.gui;

import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.entity.UFO;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Healthbar extends GUIElement{

	int maxHealth;
	int health;
	float full = 1f;
	UFO target;
	public boolean dead = false;
	
	public Healthbar(float x, float y, UFO target) {
		super(x, y, AnimHelper.healthbar);
		this.target = target;
	}
	
	public void update(float dt, World w)
	{
		maxHealth = target.maxhealth;
		health = target.health;
		full = 1.0f*health/maxHealth;
		if(health<=0)
		{
			dead = true;
		}
	}
	
	public void draw(Graphics g)
	{
		g.drawAnimation(animations.get(0), this.getX(), getY());
		g.setClip((int)this.getX(), (int)getY(), (int)(animations.get(1).getWidth()*full), (int)(animations.get(1).getHeight()));
		g.drawAnimation(animations.get(1), this.getX(), getY());
		g.clearClip();
	}

}
