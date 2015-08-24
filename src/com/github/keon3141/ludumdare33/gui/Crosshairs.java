package com.github.keon3141.ludumdare33.gui;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Crosshairs extends GUIElement{

	public Crosshairs(float x, float y) {
		super(x, y, AnimHelper.crosshairs);
	}

	public void update(float dt, World w)
	{
		this.rect.setCenterX(w.input.getMouseX());
		this.rect.setCenterY(w.input.getMouseY());
	}
	
}
