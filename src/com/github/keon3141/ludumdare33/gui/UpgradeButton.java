package com.github.keon3141.ludumdare33.gui;

import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;

public class UpgradeButton extends GUIElement{

	int id;
	int prereq;
	boolean bought = false;
	boolean active = false;
	boolean hovered = false;
	public boolean clicking = false;
	public float clickedTime = .1f;
	public float currentTime = .1f;
	public int cost;
	
	TechTree parent;

	
	public UpgradeButton(float x, float y, int id, TechTree parent, int cost) {
		super(x, y, AnimHelper.upgradebutton);
		this.id = id;
		this.prereq = -1;
		this.parent = parent;
		this.cost = cost;
		bought = PlayerDataStorage.upgradesBought[id];
	}
	
	public UpgradeButton(float x, float y, int id, TechTree parent, int cost, int prereq) {
		super(x, y, AnimHelper.upgradebutton);
		this.id = id;
		this.prereq = prereq;
		this.parent = parent;
		this.cost = cost;
		bought = PlayerDataStorage.upgradesBought[id];
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setFont(parent.fontTitle);
		
		String name = parent.names.get(new Integer(id));
		g.setColor(new Color(255,255,255));
		g.drawString(name, this.rect.getCenterX()-parent.fontTitle.getWidth(name)/2.0f, this.rect.getCenterY()-parent.fontTitle.getHeight(name)/2.0f);
	}
	
	public void update(float dt, World w)
	{
		Input in = w.input;
		if(this.bought)
		{
			this.setCurrentAnimation(3);
		}
		else if(this.prereq==-1 || this.parent.buttons.get(this.prereq).bought)
		{
			if(this.rect.contains(in.getMouseX(), in.getMouseY()))
			{
				hovered = true;
			}else{
				hovered = false;
			}
			if(active)
			{
				this.setCurrentAnimation(2);
			}
			else if(hovered && !active)
			{
				this.setCurrentAnimation(1);
			}else if (! hovered && ! active)
			{
				this.setCurrentAnimation(0);
			}
		}
		else{
			this.setCurrentAnimation(4);
		}
	}

	public void purchase() {
		if(PlayerDataStorage.humanCaptives>=cost && (this.prereq==-1 || this.parent.buttons.get(this.prereq).bought))
		{
			System.out.println(PlayerDataStorage.humanCaptives);
			System.out.println(cost);
			bought = true;
			PlayerDataStorage.humanCaptives -= cost;
			PlayerDataStorage.upgradesBought[id] = true;
			parent.addUpgrade(id);
		}
	}

}
