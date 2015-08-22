package com.github.keon3141.ludumdare33.gui;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.gameloop.World;

public class Crosshairs extends GUIElement{

	public Crosshairs(float x, float y, Animation animation) {
		super(x, y, animation);
	}

	public void update(float dt, World w)
	{
		this.setX(w.input.getMouseX());
		this.setY(w.input.getMouseY());
	}
	
}
